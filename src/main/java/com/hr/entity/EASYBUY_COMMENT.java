package com.hr.entity;

// 留言实体类
public class EASYBUY_COMMENT {
    private int EC_ID; // 留言ID
    private String EC_CONTENT; // 留言内容
    private String EC_CREATE_TIME; // 留言创建时间
    private String EC_REPLY; // 回复内容
    private String EC_REPLY_TIME; // 回复时间
    private String EC_NICK_NAME; // 留言用户昵称

    // 带参构造方法
    public EASYBUY_COMMENT(int eCID, String eCCONTENT, String eCCREATETIME,
                           String eCREPLY, String eCREPLYTIME, String eCNICKNAME) {
        EC_ID = eCID;
        EC_CONTENT = eCCONTENT;
        EC_CREATE_TIME = eCCREATETIME;
        EC_REPLY = eCREPLY;
        EC_REPLY_TIME = eCREPLYTIME;
        EC_NICK_NAME = eCNICKNAME;
    }

    // 无参构造方法
    public EASYBUY_COMMENT() {
    }

    // 获取留言ID
    public int getEC_ID() {
        return EC_ID;
    }

    // 设置留言ID
    public void setEC_ID(int eCID) {
        EC_ID = eCID;
    }

    // 获取留言内容
    public String getEC_CONTENT() {
        return EC_CONTENT;
    }

    // 设置留言内容
    public void setEC_CONTENT(String eCCONTENT) {
        EC_CONTENT = eCCONTENT;
    }

    // 获取留言创建时间
    public String getEC_CREATE_TIME() {
        return EC_CREATE_TIME;
    }

    // 设置留言创建时间
    public void setEC_CREATE_TIME(String eCCREATETIME) {
        EC_CREATE_TIME = eCCREATETIME;
    }

    // 获取回复内容
    public String getEC_REPLY() {
        return EC_REPLY;
    }

    // 设置回复内容
    public void setEC_REPLY(String eCREPLY) {
        EC_REPLY = eCREPLY;
    }

    // 获取回复时间
    public String getEC_REPLY_TIME() {
        return EC_REPLY_TIME;
    }

    // 设置回复时间
    public void setEC_REPLY_TIME(String eCREPLYTIME) {
        EC_REPLY_TIME = eCREPLYTIME;
    }

    // 获取留言用户昵称
    public String getEC_NICK_NAME() {
        return EC_NICK_NAME;
    }

    // 设置留言用户昵称
    public void setEC_NICK_NAME(String eCNICKNAME) {
        EC_NICK_NAME = eCNICKNAME;
    }
}
