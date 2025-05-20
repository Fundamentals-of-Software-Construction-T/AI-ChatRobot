package luoxiaojia.modules.model.service;

import java.util.List;

import luoxiaojia.modules.model.dto.ModelProviderDTO;
import luoxiaojia.modules.model.entity.ModelProviderEntity;

public interface ModelProviderService {

    // List<String> getModelNames(String modelType, String modelName);

    List<ModelProviderDTO> getListByModelType(String modelType);

    ModelProviderDTO add(ModelProviderEntity modelProviderEntity);

    ModelProviderDTO edit(ModelProviderEntity modelProviderEntity);

    void delete();

    List<ModelProviderDTO> getList(String modelType, String provideCode);
}
