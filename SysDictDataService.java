package luoxiaojia.modules.sys.service;

import java.util.Map;

import luoxiaojia.common.page.PageData;
import luoxiaojia.common.service.BaseService;
import luoxiaojia.modules.sys.dto.SysDictDataDTO;
import luoxiaojia.modules.sys.entity.SysDictDataEntity;

/**
 * 数据字典
 */
public interface SysDictDataService extends BaseService<SysDictDataEntity> {

    PageData<SysDictDataDTO> page(Map<String, Object> params);

    SysDictDataDTO get(Long id);

    void save(SysDictDataDTO dto);

    void update(SysDictDataDTO dto);

    void delete(Long[] ids);

}