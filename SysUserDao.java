package luoxiaojia.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import luoxiaojia.common.dao.BaseDao;
import luoxiaojia.modules.sys.entity.SysUserEntity;

/**
 * 系统用户
 */
@Mapper
public interface SysUserDao extends BaseDao<SysUserEntity> {

}