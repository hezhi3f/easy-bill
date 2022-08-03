package com.hezhi3f.easybill.entity.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends UserPO{
    private String version;
}
