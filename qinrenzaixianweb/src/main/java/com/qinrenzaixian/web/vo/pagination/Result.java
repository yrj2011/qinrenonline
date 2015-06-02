
package com.qinrenzaixian.web.vo.pagination;

/**
 * 
 * @author yangrenjiang
 * @version v 0.1 2012-1-30 下午01:09:47
 */
public class Result {
    protected int status = 0;
    protected String errorCode;
    protected String errorInfo;
    
    public Result failure() {
        status = 500;
        return this;
    }
    
    public Result failure(int status) {
        this.status = status;
        return this;
    }
    
    public void error(String errorCode, String errorInfo) {
        failure();
        this.errorCode = errorCode;
        this.errorInfo = errorInfo;
    }
    
    public void error(String errorCode) {
        failure();
        this.errorCode = "";
        this.errorInfo = "";
    }
    
    public boolean success() {
        return status == 0 ? true : false;
    }

    /**
     * Getter method for property <tt>errorCode</tt>.
     * 
     * @return property value of errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Setter method for property <tt>errorCode</tt>.
     * 
     * @param errorCode value to be assigned to property errorCode
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Getter method for property <tt>errorInfo</tt>.
     * 
     * @return property value of errorInfo
     */
    public String getErrorInfo() {
        return errorInfo;
    }

    /**
     * Setter method for property <tt>errorInfo</tt>.
     * 
     * @param errorInfo value to be assigned to property errorInfo
     */
    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    /**
     * Getter method for property <tt>status</tt>.
     * 
     * @return property value of status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Setter method for property <tt>status</tt>.
     * 
     * @param status value to be assigned to property status
     */
    public void setStatus(int status) {
        this.status = status;
    }
    
}
