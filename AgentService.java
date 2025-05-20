package luoxiaojia.modules.agent.service;

import java.util.List;
import java.util.Map;

import luoxiaojia.common.page.PageData;
import luoxiaojia.common.service.BaseService;
import luoxiaojia.modules.agent.dto.AgentDTO;
import luoxiaojia.modules.agent.entity.AgentEntity;

public interface AgentService extends BaseService<AgentEntity> {

    /**
     * 管理员获取所有智能体列表（分页）
     */
    PageData<AgentEntity> adminAgentList(Map<String, Object> params);

    /**
     * 获取智能体详情
     */
    AgentEntity getAgentById(String id);

    /**
     * 删除这个用户的所有
     * 
     * @param userId
     */
    void deleteAgentByUserId(Long userId);

    /**
     * 获取用户智能体列表
     * 
     * @param userId
     * @return
     */
    List<AgentDTO> getUserAgents(Long userId);

    /**
     * 获取智能体的设备数量
     * 
     * @param agentId 智能体ID
     * @return 设备数量
     */
    Integer getDeviceCountByAgentId(String agentId);
}