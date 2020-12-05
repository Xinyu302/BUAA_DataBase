package com.yxy.market1.entity.dto.response.factory;

import com.yxy.market1.entity.dto.response.RedirectResponse;
import com.yxy.market1.entity.dto.response.SimpleResponse;
import org.springframework.stereotype.Component;

import static com.yxy.market1.consts.StatusCode.*;
/**
 * 通用 Json 工厂类
 *
 * @author James
 */
@Component(value = "generalJsonFactory")
public class GeneralJsonFactory implements JsonFactory {

    /**
     * 通用正常响应
     */
    @Override
    public SimpleResponse createSimpleResponse() {
        return new SimpleResponse(RESPONSE_OK, NO_ERROR);
    }

    @Override
    public SimpleResponse createtSimpleErrorResponse() {
        return new SimpleResponse(RESPONSE_OK, WITH_ERROR);
    }

    /**
     * 带参数的统一响应
     * param resultCode 状态码
     *
     * @param hasError 是否需异常
     */
    @Override
    public SimpleResponse createSimpleResponse(int resultCode, boolean hasError) {
        return new SimpleResponse(resultCode, hasError);
    }

    @Override
    public RedirectResponse createRedirectResponse(int resultCode, boolean hasError, String redirectURL) {
        return new RedirectResponse(resultCode, hasError, redirectURL);
    }
}