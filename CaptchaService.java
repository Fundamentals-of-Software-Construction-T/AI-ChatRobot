package luoxiaojia.modules.security.service;

import java.io.IOException;

import jakarta.servlet.http.HttpServletResponse;

/**
 * 验证码
 * Copyright (c) 人人开源 All rights reserved.
 * Website: https://www.renren.io
 */
public interface CaptchaService {

    /**
     * 图片验证码
     */
    void create(HttpServletResponse response, String uuid) throws IOException;

    /**
     * 验证码效验
     *
     * @param uuid uuid
     * @param code 验证码
     * @return true：成功 false：失败
     */
    boolean validate(String uuid, String code);
}
