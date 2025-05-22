package luoxiaojia.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import luoxiaojia.common.dao.BaseDao;
import luoxiaojia.modules.sys.dto.SysDictDataDTO;
import luoxiaojia.modules.sys.entity.DictData;
import luoxiaojia.modules.sys.entity.SysDictDataEntity;

/**
 * 字典数据
 */
@Mapper
public interface SysDictDataDao extends BaseDao<SysDictDataEntity> {

    /**
     * 字典数据列表
     */
    List<DictData> getDictDataList();

    List<SysDictDataDTO> getDataByTypeCode(String dictType);
}
