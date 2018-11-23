package com.example.directories.model;

public class JsonResult {

    private boolean IsSuccess;

    private String Msg;

    private Object Content;

    public boolean getIsSuccess() {
        return IsSuccess;
    }

    public void setSuccess(boolean success) {
        IsSuccess = success;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public Object getContent() {
        return Content;
    }

    public void setContent(Object content) {
        Content = content;
    }
}
