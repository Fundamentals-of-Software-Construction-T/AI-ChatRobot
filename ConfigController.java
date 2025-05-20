package luoxiaojia.modules.config.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import luoxiaojia.common.constant.Constant;
import luoxiaojia.common.exception.RenException;
import luoxiaojia.common.utils.Result;
import luoxiaojia.common.validator.ValidatorUtils;
import luoxiaojia.modules.config.dto.AgentModelsDTO;
import luoxiaojia.modules.config.service.ConfigService;
import luoxiaojia.modules.sys.dto.ConfigSecretDTO;
import luoxiaojia.modules.sys.service.SysParamsService;

/**
 * luoxiaojia-server 配置获取
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("config")
@Tag(name = "参数管理")
@AllArgsConstructor
public class ConfigController {
    private final ConfigService configService;
    private final SysParamsService sysParamsService;

    @PostMapping("server-base")
    @Operation(summary = "获取配置")
    public Result<Object> getConfig(@RequestBody ConfigSecretDTO dto) {
        // 效验数据
        ValidatorUtils.validateEntity(dto);
        checkSecret(dto.getSecret());
        Object config = configService.getConfig(true);
        return new Result<Object>().ok(config);
    }

    @PostMapping("agent-models")
    @Operation(summary = "获取智能体模型")
    public Result<Object> getAgentModels(@RequestBody AgentModelsDTO dto) {
        // 效验数据
        ValidatorUtils.validateEntity(dto);
        checkSecret(dto.getSecret());
        Object models = configService.getAgentModels(dto.getMacAddress(), dto.getSelectedModule());
        return new Result<Object>().ok(models);
    }

    private void checkSecret(String secret) {
        String secretParam = sysParamsService.getValue(Constant.SERVER_SECRET, true);
        // 验证密钥
        if (StringUtils.isBlank(secret) || !secret.equals(secretParam)) {
            throw new RenException("密钥错误");
        }
    }
}
