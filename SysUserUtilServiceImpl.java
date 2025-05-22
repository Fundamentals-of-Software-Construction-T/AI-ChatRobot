package luoxiaojia.modules.sys.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import luoxiaojia.common.redis.RedisKeys;
import luoxiaojia.common.redis.RedisUtils;
import luoxiaojia.common.service.impl.BaseServiceImpl;
import luoxiaojia.modules.sys.dao.SysUserDao;
import luoxiaojia.modules.sys.entity.SysUserEntity;
import luoxiaojia.modules.sys.service.SysUserUtilService;

import java.util.function.Consumer;

@Service
@AllArgsConstructor
public class SysUserUtilServiceImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserUtilService {

    private RedisUtils redisUtils;

    @Override
    public void assignUsername(Long userId, Consumer<String> setter) {
        String userIdKey = RedisKeys.getUserIdKey(userId);
        String username = redisUtils.get(userIdKey).toString();
        if(username != null){
            setter.accept(username);
        }else {
            SysUserEntity entity = baseDao.selectById(userId);
            if (entity != null) {
                username = entity.getUsername();
                redisUtils.set(userIdKey,username,10);
                setter.accept(username);
            }
        }
    }
}
