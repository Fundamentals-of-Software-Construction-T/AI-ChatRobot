package luoxiaojia.modules.model.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import lombok.AllArgsConstructor;
import luoxiaojia.common.service.impl.BaseServiceImpl;
import luoxiaojia.common.utils.ConvertUtils;
import luoxiaojia.modules.model.dao.ModelProviderDao;
import luoxiaojia.modules.model.dto.ModelProviderDTO;
import luoxiaojia.modules.model.entity.ModelProviderEntity;
import luoxiaojia.modules.model.service.ModelProviderService;

@Service
@AllArgsConstructor
public class ModelProviderServiceImpl extends BaseServiceImpl<ModelProviderDao, ModelProviderEntity>
        implements ModelProviderService {

    private final ModelProviderDao modelProviderDao;

    @Override
    public List<ModelProviderDTO> getListByModelType(String modelType) {

        QueryWrapper<ModelProviderEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("model_type", StringUtils.isBlank(modelType) ? "" : modelType);
        List<ModelProviderEntity> providerEntities = modelProviderDao.selectList(queryWrapper);
        return ConvertUtils.sourceToTarget(providerEntities, ModelProviderDTO.class);
    }

    @Override
    public ModelProviderDTO add(ModelProviderEntity modelProviderEntity) {
        return null;
    }

    @Override
    public ModelProviderDTO edit(ModelProviderEntity modelProviderEntity) {
        return null;
    }

    @Override
    public void delete() {

    }

    @Override
    public List<ModelProviderDTO> getList(String modelType, String providerCode) {
        QueryWrapper<ModelProviderEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("model_type", StringUtils.isBlank(modelType) ? "" : modelType);
        queryWrapper.eq("provider_code", StringUtils.isBlank(providerCode) ? "" : providerCode);
        List<ModelProviderEntity> providerEntities = modelProviderDao.selectList(queryWrapper);
        return ConvertUtils.sourceToTarget(providerEntities, ModelProviderDTO.class);
    }
}
