package com.android.bytemarket.common;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 状态码 消息 数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServerResponse {

    private  int code;
    private String msg;
    private  Object data;

    private ServerResponse(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    @JsonIgnore
    public boolean isSuccess(){
        return this.code == ResponseCode.SUCCESS.getCode();
    }

    public static ServerResponse ofSuccess(){
        return new ServerResponse(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getDesc());
    }

    public static ServerResponse ofSuccess(Object o){
        return new ServerResponse(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getDesc(),o);
    }

    public static ServerResponse ofSuccess(int code,String msg,Object o){
        return new ServerResponse(code,msg,o);
    }

    public static ServerResponse ofError(int code,String msg,Object o){
        return new ServerResponse(code,msg,o);
    }

    public static ServerResponse ofSuccess(String msg){
        return new ServerResponse(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static ServerResponse ofSuccess(String msg,Object o){
        return new ServerResponse(ResponseCode.SUCCESS.getCode(),msg,o);
    }

    public static ServerResponse ofError(){
        return new ServerResponse(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }

    public static ServerResponse ofError(String msg){
        return new ServerResponse(ResponseCode.ERROR.getCode(),msg);
    }

    public static ServerResponse ofError(Object o){
        return new ServerResponse(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc(),o);
    }

    public static ServerResponse ofError(String msg,Object o){
        return new ServerResponse(ResponseCode.ERROR.getCode(),msg,o);
    }

}
