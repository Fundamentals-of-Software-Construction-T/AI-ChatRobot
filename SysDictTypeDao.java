package luoxiaojia.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import luoxiaojia.common.dao.BaseDao;
import luoxiaojia.modules.sys.entity.DictType;
import luoxiaojia.modules.sys.entity.SysDictTypeEntity;

/**
 * 字典类型
 */
@Mapper
public interface SysDictTypeDao extends BaseDao<SysDictTypeEntity> {

    /**
     * 字典类型列表
     */
    List<DictType> getDictTypeList();

}
