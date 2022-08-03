package com.hezhi3f.easybill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hezhi3f.easybill.dao.UserMapper;
import com.hezhi3f.easybill.entity.user.UserPO;
import com.hezhi3f.easybill.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPO> implements UserService {
    @Override
    public Optional<UserPO> getUserByToken(String token) {
        int id = token.length();
        UserPO user = this.getById(id);
        return Optional.of(user);
    }
}
