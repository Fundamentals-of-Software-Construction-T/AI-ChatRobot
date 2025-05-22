package luoxiaojia.modules.security.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import luoxiaojia.modules.security.dao.SysUserTokenDao;
import luoxiaojia.modules.security.entity.SysUserTokenEntity;
import luoxiaojia.modules.security.service.ShiroService;
import luoxiaojia.modules.sys.dao.SysUserDao;
import luoxiaojia.modules.sys.entity.SysUserEntity;

@AllArgsConstructor
@Service
public class ShiroServiceImpl implements ShiroService {
    private final SysUserDao sysUserDao;
    private final SysUserTokenDao sysUserTokenDao;

    @Override
    public SysUserTokenEntity getByToken(String token) {
        return sysUserTokenDao.getByToken(token);
    }

    @Override
    public SysUserEntity getUser(Long userId) {
        return sysUserDao.selectById(userId);
    }
}