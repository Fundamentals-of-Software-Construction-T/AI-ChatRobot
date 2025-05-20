package luoxiaojia.modules.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import luoxiaojia.common.dao.BaseDao;
import luoxiaojia.modules.model.entity.ModelProviderEntity;

@Mapper
public interface ModelProviderDao extends BaseDao<ModelProviderEntity> {

    List<String> getFieldList(@Param("modelType") String modelType, @Param("providerCode") String providerCode);
}
