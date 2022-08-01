package com.hezhi3f.easybill.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hezhi3f.easybill.entity.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<UserPO> {
}
