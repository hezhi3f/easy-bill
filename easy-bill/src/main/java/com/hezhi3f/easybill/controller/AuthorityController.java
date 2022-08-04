package com.hezhi3f.easybill.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hezhi3f.easybill.entity.user.UserDTO;
import com.hezhi3f.easybill.entity.user.UserPO;
import com.hezhi3f.easybill.exception.BillException;
import com.hezhi3f.easybill.exception.ExceptionType;
import com.hezhi3f.easybill.result.Result;
import com.hezhi3f.easybill.service.UserService;
import com.hezhi3f.easybill.util.ResultUtils;
import com.hezhi3f.easybill.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthorityController {
    private final UserService userService;

    @PostMapping("/register")
    public Result<Void> register(@RequestBody UserPO user) {
        boolean save = userService.save(user);
        if (!save) {
            throw new RuntimeException("注册失败");
        }

        return ResultUtils.success();
    }

    @PostMapping("/login")
    public Result<String> login(@RequestBody UserDTO userDTO) {
        QueryWrapper<UserPO> wrapper = Wrappers.<UserPO>query()
                .eq("username", userDTO.getUsername())
                .eq("password", userDTO.getPassword());

        UserPO userPO = userService.getOne(wrapper);

        if (userPO == null) {
            throw new BillException(ExceptionType.USERNAME_OR_PASSWORD_ERROR);
        }

        // TODO 生成token，并存储
        String token = TokenUtils.getToken(userDTO);

        return ResultUtils.success(token);
    }

    @Autowired
    public AuthorityController(UserService userService) {
        this.userService = userService;
    }

}
