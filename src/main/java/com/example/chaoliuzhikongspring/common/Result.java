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
    public static <T> Result<T> error(String message) {
        Result result = new Result("400", "error", message);
        return result;
    }
}
