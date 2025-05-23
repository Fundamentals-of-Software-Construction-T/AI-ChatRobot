package luoxiaojia.modules.agent.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import luoxiaojia.common.dao.BaseDao;
import luoxiaojia.modules.agent.entity.AgentEntity;

@Mapper
public interface AgentDao extends BaseDao<AgentEntity> {
    /**
     * 获取智能体的设备数量
     * 
     * @param agentId 智能体ID
     * @return 设备数量
     */
    Integer getDeviceCountByAgentId(@Param("agentId") String agentId);
}