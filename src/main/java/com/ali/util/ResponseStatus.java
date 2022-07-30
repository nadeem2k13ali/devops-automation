package com.ali.demo.util;

import lombok.Data;

/**
 * Created by Lenovo on 2/25/2022.
 */

@Data
public class ResponseStatus {
    private int code;
    private String msg;
    private Object data;



    public ResponseStatus() {
    }

    public ResponseStatus(int code,String msg) {
        this.msg = msg;
        this.code = code;
    }
}
