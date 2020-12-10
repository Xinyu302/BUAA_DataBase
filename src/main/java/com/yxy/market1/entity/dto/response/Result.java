package com.yxy.market1.entity.dto.response;

public class Result {
    private Integer status;

    private String message;

    public Result(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public static Result failure(String message) {
        return new Result(500, message);
    }

    public static Result success() {
        return new Result(200, "Succeed");
    }
}
