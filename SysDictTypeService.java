package luoxiaojia.modules.sys.service;

import java.util.List;
import java.util.Map;

import luoxiaojia.common.page.PageData;
import luoxiaojia.common.service.BaseService;
import luoxiaojia.modules.sys.dto.SysDictTypeDTO;
import luoxiaojia.modules.sys.entity.DictType;
import luoxiaojia.modules.sys.entity.SysDictTypeEntity;

/**
 * 数据字典
 */
public interface SysDictTypeService extends BaseService<SysDictTypeEntity> {

    PageData<SysDictTypeDTO> page(Map<String, Object> params);

    SysDictTypeDTO get(Long id);

    void save(SysDictTypeDTO dto);

    void update(SysDictTypeDTO dto);

    void delete(Long[] ids);

    List<DictType> getAllList();

    List<DictType> getDictTypeList();
}