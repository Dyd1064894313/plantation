package top.duanyd.plantation.enums;

public enum ResultEnum {
    SUCCESS(0, "成功"),
    SYSTEM_ERROR(999, "系统错误！")
    ;
    private int code;
    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
