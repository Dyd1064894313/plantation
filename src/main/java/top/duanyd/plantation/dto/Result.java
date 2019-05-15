package top.duanyd.plantation.dto;

public class Result<T> {
    //返回code值
    private int code;
    //返回信息
    private String message;
    //返回数据
    private T data;
    //返回分页信息
    private Paging page;
    //返回结果是否成功
    private boolean isSuccess = true;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
        if(code != 0){
            isSuccess = false;
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Paging getPage() {
        return page;
    }

    public void setPage(Paging page) {
        this.page = page;
    }
}
