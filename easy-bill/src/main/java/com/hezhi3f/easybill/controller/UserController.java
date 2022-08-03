package com.hezhi3f.easybill.controller;

import com.hezhi3f.easybill.entity.user.UserPO;
import com.hezhi3f.easybill.exception.BillException;
import com.hezhi3f.easybill.exception.ExceptionType;
import com.hezhi3f.easybill.result.Result;
import com.hezhi3f.easybill.result.builder.ResultBuilder;
import com.hezhi3f.easybill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @GetMapping("/get")
    public Result<UserPO> getUserInfo(@RequestHeader String token) {
        UserPO user = userService.getUserByToken(token)
                .orElseThrow(() -> new BillException(ExceptionType.USER_NOT_EXIST));

        return ResultBuilder.success(user).build();
    }


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
}
