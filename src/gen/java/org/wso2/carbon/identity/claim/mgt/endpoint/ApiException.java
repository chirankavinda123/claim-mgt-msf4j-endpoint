package org.wso2.carbon.identity.claim.mgt.endpoint;

public class ApiException extends Exception{
    private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
