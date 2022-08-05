package com.hezhi3f.easybill.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hezhi3f.easybill.entity.user.UserDTO;
import com.hezhi3f.easybill.entity.user.UserPO;
import com.hezhi3f.easybill.exception.BillException;
import com.hezhi3f.easybill.exception.ExceptionEnum;
import com.hezhi3f.easybill.result.Result;
import com.hezhi3f.easybill.service.RedisService;
import com.hezhi3f.easybill.service.UserService;
import com.hezhi3f.easybill.service.MailService;
import com.hezhi3f.easybill.util.ResultUtils;
import com.hezhi3f.easybill.util.TokenUtils;
import com.hezhi3f.easybill.util.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.Date;
import java.util.Objects;


@RestController
@RequestMapping("/auth")
public class AuthorityController {
    private final UserService userService;
    @Autowired
    private MailService mailService;
    @Autowired
    private RedisService redisService;

    @PostMapping("/verify")
    public void mail(@RequestBody UserDTO userDTO) throws MessagingException {
        String code = CodeUtils.code6();
        String email = userDTO.getEmail();
        mailService.sendVerifyMessage(email, code);
        redisService.set("VERIFY_EMAIL:" + email, code, 60 * 10);
    }

    @PostMapping("/register")
    public Result<Void> register(@RequestBody UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        String email = userDTO.getEmail();
        String checkcode = userDTO.getCheckcode();
        if (username == null || password == null || email == null || checkcode == null) {
            throw new BillException(ExceptionEnum.REQUEST_PARAM_INCOMPLETE);
        }

        checkColumnExistsAndThrow("username", username, ExceptionEnum.USERNAME_ALREADY_EXISTS);
        checkColumnExistsAndThrow("email", email, ExceptionEnum.EMAIL_ALREADY_EXISTS);

        String checkcodeRedis = redisService.get("VERIFY_EMAIL:" + email);
        if (!Objects.equals(checkcode, checkcodeRedis)) {
            throw new BillException(ExceptionEnum.CHECK_CODE_INCORRECT);
        }

        userDTO.setGmtCreated(new Date());

        boolean save = userService.save(userDTO);
        if (!save) {
            throw new BillException(ExceptionEnum.DATABASES_EXCEPTION);
        }

        return ResultUtils.success();
    }

    private void checkColumnExistsAndThrow(String column, String value, ExceptionEnum e) {
        long count = userService.count(Wrappers.<UserPO>query().eq(column, value));
        if (count != 0) {
            throw new BillException(e);
        }
    }

    @PostMapping("/login")
    public Result<String> login(@RequestBody UserDTO userDTO) {
        QueryWrapper<UserPO> wrapper = Wrappers.<UserPO>query()
                .eq("username", userDTO.getUsername())
                .eq("password", userDTO.getPassword());

        UserPO userPO = userService.getOne(wrapper);

        if (userPO == null) {
            throw new BillException(ExceptionEnum.USERNAME_OR_PASSWORD_ERROR);
        }

        userPO.setSecret(CodeUtils.uuid());
        userPO.setGmtModified(new Date());
        userService.updateById(userPO);

        String token = TokenUtils.getToken(userPO);

        // todo
        return null;
    }

    @Autowired
    public AuthorityController(UserService userService) {
        this.userService = userService;
    }
}
