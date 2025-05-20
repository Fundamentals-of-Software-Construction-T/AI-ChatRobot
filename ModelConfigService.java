package luoxiaojia.modules.model.service;

import java.util.List;

import luoxiaojia.common.page.PageData;
import luoxiaojia.common.service.BaseService;
import luoxiaojia.modules.model.dto.ModelBasicInfoDTO;
import luoxiaojia.modules.model.dto.ModelConfigBodyDTO;
import luoxiaojia.modules.model.dto.ModelConfigDTO;
import luoxiaojia.modules.model.entity.ModelConfigEntity;

public interface ModelConfigService extends BaseService<ModelConfigEntity> {

    List<ModelBasicInfoDTO> getModelCodeList(String modelType, String modelName);

    PageData<ModelConfigDTO> getPageList(String modelType, String modelName, String page, String limit);

    ModelConfigDTO add(String modelType, String provideCode, ModelConfigBodyDTO modelConfigBodyDTO);

    ModelConfigDTO edit(String modelType, String provideCode, String id, ModelConfigBodyDTO modelConfigBodyDTO);

    void delete(String id);

    /**
     * 根据ID获取模型名称
     * 
     * @param id 模型ID
     * @return 模型名称
     */
    String getModelNameById(String id);

    /**
     * 根据ID获取模型配置
     * 
     * @param id      模型ID
     * @param isCache 是否缓存
     * @return 模型配置实体
     */
    ModelConfigEntity getModelById(String id, boolean isCache);

    /**
     * 设置默认模型
     * 
     * @param modelType 模型类型
     * @param isDefault 是否默认
     */
    void setDefaultModel(String modelType, int isDefault);
}
