package com.hr.entity;

// ����ʵ����
public class EASYBUY_COMMENT {
    private int EC_ID; // ����ID
    private String EC_CONTENT; // ��������
    private String EC_CREATE_TIME; // ���Դ���ʱ��
    private String EC_REPLY; // �ظ�����
    private String EC_REPLY_TIME; // �ظ�ʱ��
    private String EC_NICK_NAME; // �����û��ǳ�

    // ���ι��췽��
    public EASYBUY_COMMENT(int eCID, String eCCONTENT, String eCCREATETIME,
                           String eCREPLY, String eCREPLYTIME, String eCNICKNAME) {
        EC_ID = eCID;
        EC_CONTENT = eCCONTENT;
        EC_CREATE_TIME = eCCREATETIME;
        EC_REPLY = eCREPLY;
        EC_REPLY_TIME = eCREPLYTIME;
        EC_NICK_NAME = eCNICKNAME;
    }

    // �޲ι��췽��
    public EASYBUY_COMMENT() {
    }

    // ��ȡ����ID
    public int getEC_ID() {
        return EC_ID;
    }

    // ��������ID
    public void setEC_ID(int eCID) {
        EC_ID = eCID;
    }

    // ��ȡ��������
    public String getEC_CONTENT() {
        return EC_CONTENT;
    }

    // ������������
    public void setEC_CONTENT(String eCCONTENT) {
        EC_CONTENT = eCCONTENT;
    }

    // ��ȡ���Դ���ʱ��
    public String getEC_CREATE_TIME() {
        return EC_CREATE_TIME;
    }

    // �������Դ���ʱ��
    public void setEC_CREATE_TIME(String eCCREATETIME) {
        EC_CREATE_TIME = eCCREATETIME;
    }

    // ��ȡ�ظ�����
    public String getEC_REPLY() {
        return EC_REPLY;
    }

    // ���ûظ�����
    public void setEC_REPLY(String eCREPLY) {
        EC_REPLY = eCREPLY;
    }

    // ��ȡ�ظ�ʱ��
    public String getEC_REPLY_TIME() {
        return EC_REPLY_TIME;
    }

    // ���ûظ�ʱ��
    public void setEC_REPLY_TIME(String eCREPLYTIME) {
        EC_REPLY_TIME = eCREPLYTIME;
    }

    // ��ȡ�����û��ǳ�
    public String getEC_NICK_NAME() {
        return EC_NICK_NAME;
    }

    // ���������û��ǳ�
    public void setEC_NICK_NAME(String eCNICKNAME) {
        EC_NICK_NAME = eCNICKNAME;
    }
}
