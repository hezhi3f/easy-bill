package com.hezhi3f.easybill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hezhi3f.easybill.entity.UserPO;

import java.util.Optional;

public interface UserService extends IService<UserPO> {

    Optional<UserPO> getUserByToken(String token);
}
