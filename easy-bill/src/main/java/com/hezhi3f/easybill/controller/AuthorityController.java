package com.hezhi3f.easybill.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hezhi3f.easybill.entity.User;
import com.hezhi3f.easybill.exception.BillException;
import com.hezhi3f.easybill.exception.ExceptionType;
import com.hezhi3f.easybill.result.Result;
import com.hezhi3f.easybill.service.UserService;
import com.hezhi3f.easybill.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AuthorityController {
    private final UserService userService;

    @PostMapping("/register")
    public Result<Void> register(@RequestBody User user) {
        boolean save = userService.save(user);
        if (!save) {
            throw new RuntimeException("注册失败");
        }

        return ResultUtils.success();
    }
    @PostMapping("/login")
    public Result<String> login(@RequestBody User user) {
        QueryWrapper<User> wrapper = Wrappers.<User>query()
                .eq("username", user.getUsername())
                .eq("password", user.getPassword());

        User loginUser = userService.getOne(wrapper);

        if (loginUser == null) {
            throw new BillException(ExceptionType.USERNAME_OR_PASSWORD_ERROR);
        }

        // TODO 生成token，并存储

        return ResultUtils.success();
    }



    @Autowired
    public AuthorityController(UserService userService) {
        this.userService = userService;
    }

}
