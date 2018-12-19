package com.knowledge.accumulation.utils.constant;

/**
 * Created by wj on 2017/6/5.
 */
public enum SenceEnum {

    FACE_REGISTER_BD("3", "百度人脸注册"),
    FACE_VERIFY_BD("4", "百度人脸识别"),
    FACE_MATCH_BD("11", "百度人脸比对(1:1)"),
    FACE_IDENTIFY_BD("12", "百度人脸比对(1:N)"),
    FACE_DELETE_BD("15", "百度人脸删除"),
    VOICE_RECOGNIZTION("5", "语音识别");


    /**
     * 场景号
     */
    private String sence;
    /**
     * 场景说明
     */
    private String comment;

    SenceEnum(String sence, String comment){
        this.sence = sence;
        this.comment = comment;
    }

    public static SenceEnum get(String sence) {
        for (SenceEnum s : SenceEnum.values()) {
            if (s.getSence().equals(sence)) {
                return s;
            }
        }
        return null;
    }

    public String getSence() {
        return sence;
    }

    public void setSence(String sence) {
        this.sence = sence;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
