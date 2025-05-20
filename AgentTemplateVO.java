package luoxiaojia.modules.agent.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import luoxiaojia.modules.agent.entity.AgentTemplateEntity;

@Data
@EqualsAndHashCode(callSuper = true)
public class AgentTemplateVO extends AgentTemplateEntity {
    // 角色音色
    private String ttsModelName;

    // 角色模型
    private String llmModelName;
}
