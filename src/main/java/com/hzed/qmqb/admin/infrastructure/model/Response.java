package com.hzed.qmqb.admin.infrastructure.model;

import com.hzed.qmqb.admin.infrastructure.enums.BizCodeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guichang
 */
@Data
@NoArgsConstructor
public class Response<T> {
    private String code;

    private String message;
    private String messageCN;

    private T data;

    public Response(String errorCode, String message) {
        this.code = errorCode;
        this.message = message;
    }

    public Response(String errorCode, String message, T data) {
        this.code = errorCode;
        this.message = message;
        this.data = data;
    }

    public Response(String errorCode, String message, String messageCN, T data) {
        this.code = errorCode;
        this.message = message;
        this.messageCN = messageCN;
        this.data = data;
    }

    public static <T> Response getSuccessResponse(T data) {
        return new Response(BizCodeEnum.SUCCESS.getCode(), BizCodeEnum.SUCCESS.getMessage(), data);
    }

    public static <T> Response getSuccessResponse(T data, String message) {
        return new Response(BizCodeEnum.SUCCESS.getCode(), message, data);
    }

    public static Response getSuccessResponse() {
        return getSuccessResponse(null);
    }

    public static Response getFailResponse() {
        Response response = new Response(BizCodeEnum.UNKNOWN_EXCEPTION.getCode(), BizCodeEnum.UNKNOWN_EXCEPTION.getMessage());
        return response;
    }

    public static Response getFailResponse(String errorMsg) {
        Response response = new Response(BizCodeEnum.UNKNOWN_EXCEPTION.getCode(), errorMsg);
        return response;
    }

    public static <T> Response getFailResponse(T data,String errorCode,String errorMsg) {

        return new Response(errorCode, errorMsg, data);
    }

}
