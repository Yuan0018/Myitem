package com.example.chaoliuzhikongspring.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private String code;
    private String message;
    private T data;

//    成功响应
    public static <T> Result<T> success() {
        Result result = new Result("200", "success", null);
        return result;
    }
    public static <T> Result<T> success(String code, String message, T data) {
        Result result = new Result(code, message, data);
        return result;
    }
//    成功响应带数据
    public static <T> Result<T> success(T data) {
        Result result = new Result("200", "success", data);
        return result;
    }
//      响应失败
    public static <T> Result<T> error() {
        Result result = new Result("400", "error", null);
        return result;
    }
//    响应失败带数据
    public static <T> Result<T> error(T data) {
        Result result = new Result("400", "error", data);
        return result;
    }
//    响应失败自定义
    public static <T> Result<T> error(String code, String message, T data) {
        Result result = new Result(code, message, data);
        return result;
    }
}
