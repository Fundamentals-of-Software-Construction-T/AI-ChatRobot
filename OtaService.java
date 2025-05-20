package luoxiaojia.modules.device.service;

import java.util.Map;

import luoxiaojia.common.page.PageData;
import luoxiaojia.common.service.BaseService;
import luoxiaojia.modules.device.entity.OtaEntity;

/**
 * OTA固件管理
 */
public interface OtaService extends BaseService<OtaEntity> {
    PageData<OtaEntity> page(Map<String, Object> params);

    boolean save(OtaEntity entity);

    void update(OtaEntity entity);

    void delete(String[] ids);
}