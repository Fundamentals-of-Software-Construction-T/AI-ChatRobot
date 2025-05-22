package luoxiaojia.modules.security.service;

import luoxiaojia.modules.security.entity.SysUserTokenEntity;
import luoxiaojia.modules.sys.entity.SysUserEntity;

/**
 * shiro相关接口
 * Copyright (c) 人人开源 All rights reserved.
 * Website: https://www.renren.io
 */
public interface ShiroService {

    SysUserTokenEntity getByToken(String token);

    /**
     * 根据用户ID，查询用户
     *
     * @param userId
     */
    SysUserEntity getUser(Long userId);

}
