package top.duanyd.plantation.utils;

import top.duanyd.plantation.dto.Paging;
import top.duanyd.plantation.dto.Result;
import top.duanyd.plantation.enums.ResultEnum;

public class ResultUtil {

    public static <T> Result<T> success(){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        return result;
    }

    public static <T> Result<T> success(T data){
        Result<T> result = new Result<T>();
        result.setCode(0);
        result.setMessage("success");
        result.setData(data);
        return result;
    }
    public static <T> Result<T> success(T data, Paging page){
        Result<T> result = new Result<T>();
        result.setCode(0);
        result.setMessage("success");
        result.setData(data);
        result.setPage(page);
        return result;
    }

    public static <T> Result<T> fail(int code, String message){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> fail(ResultEnum resultEnum){
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());
        return result;
    }
}
