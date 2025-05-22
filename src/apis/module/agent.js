import { getServiceUrl } from '../api';
import RequestService from '../httpRequest';


export default {
    addAgent(agentName, callback) {
        RequestService.sendRequest()
            .url(`${getServiceUrl()}/agent`)
            .method('POST')
            .data({ agentName: agentName })
            .success((res) => {
                RequestService.clearRequestTime();
                callback(res);
            })
            .fail(() => {
                RequestService.reAjaxFun(() => {
                    this.addAgent(agentName, callback);
                });
            }).send();
    },
    getDeviceConfig(deviceId, callback) {
        RequestService.sendRequest()
            .url(`${getServiceUrl()}/agent/${deviceId}`)
            .method('GET')
            .success((res) => {
                RequestService.clearRequestTime();
                callback(res);
            })
            .fail((err) => {
                console.error('获取配置失败:', err);
                RequestService.reAjaxFun(() => {
                    this.getDeviceConfig(deviceId, callback);
                });
            }).send();
    },
    updateAgentConfig(agentId, configData, callback) {
        RequestService.sendRequest()
            .url(`${getServiceUrl()}/agent/${agentId}`)
            .method('PUT')
            .data(configData)
            .success((res) => {
                RequestService.clearRequestTime();
                callback(res);
            })
            .fail(() => {
                RequestService.reAjaxFun(() => {
                    this.updateAgentConfig(agentId, configData, callback);
                });
            }).send();
    },
}
