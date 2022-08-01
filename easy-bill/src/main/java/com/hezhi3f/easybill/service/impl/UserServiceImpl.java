package com.hezhi3f.easybill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hezhi3f.easybill.dao.UserMapper;
import com.hezhi3f.easybill.entity.User;
import com.hezhi3f.easybill.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
