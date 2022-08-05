package com.hezhi3f.easybill.controller;

import com.hezhi3f.easybill.entity.user.UserDTO;
import com.hezhi3f.easybill.exception.BillException;
import com.hezhi3f.easybill.exception.ExceptionEnum;
import com.hezhi3f.easybill.result.Result;
import com.hezhi3f.easybill.service.UserService;
import com.hezhi3f.easybill.util.ResultUtils;
import com.hezhi3f.easybill.util.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @PostMapping("/update")
    private Result<Void> update(@RequestBody UserDTO userDTO) {
        userDTO.setGmtModified(new Date());
        if (userDTO.getPassword() != null) {
            userDTO.setSecret(CodeUtils.uuid());
        }

        boolean update = userService.updateById(userDTO);
        if (update) {
            return ResultUtils.success();
        }

        throw new BillException(ExceptionEnum.SHOULD_NOT_OCCUR_ERROR);
    }


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
}
