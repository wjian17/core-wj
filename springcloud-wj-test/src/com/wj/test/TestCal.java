package com.pactera.action;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.bussprocess.context.Context;
import org.apache.commons.bussprocess.action.BPAction;

import org.apache.commons.bussprocess.exception.BPException;

/**
 * ParameterEditForLimit.java<br>
 * EAP 交易步骤扩展<br>
 * Extends class EAPAction<br>
 * Created on 2019年08月03日09时46分38秒<br>
 *
 * @author 12743<br>
 *
 * @eap:name 免密额度参数单独处理
 * @eap:states 0=正常;-1=异常;
 * @eap:document
 */
public class ParameterEditForLimit extends BPAction {

    private String paramCode1 = null;

    /* 交易处理流程操作单元的执行入口 */
    public String execute(Context context) throws BPException {
        String paramCodeStr = (String) context.getValue(paramCode1);
        String paramValue = (String) context.get("paramValue");
        Pattern pat = Pattern.compile("^[1-9]\\d{0,11}(\\.\\d\\d)$");
        Matcher matcher = pat.matcher(paramValue);
        if (!matcher.find()) {//正则校验输入参数值
            context.setValue("errorMsg","限额参数错误格式为#.00");
            return "-3";
        }
        if ("SINGLE_LIMIT".equals(paramCodeStr)) {
            // 单笔支付限额
            BigDecimal totalLimit = (BigDecimal) context.getValue("TOTAL_LIMIT");
            BigDecimal freeAmt = (BigDecimal) context.getValue("FREE_PASSWORD_AMT");

            BigDecimal singleLimitParam = new BigDecimal(paramValue);
            if(singleLimitParam.compareTo(totalLimit)>0){
                context.setValue("errorMsg","日累计免密限额不可超过"+totalLimit+"元");
                return "-1";
            }else if(singleLimitParam.compareTo(freeAmt)<0){
                context.setValue("errorMsg","日累计免密限额不可小于"+freeAmt+"元");
                return "-1";
            }else{
                return "0";
            }
        } else if ("TOTAL_LIMIT".equals(paramCodeStr)) {
            // 日累计支付限额
            BigDecimal singleLimit = (BigDecimal) context.getValue("SINGLE_LIMIT");
            BigDecimal totalFreeAmt = (BigDecimal) context.getValue("DAY_TOTAL_FREE_PWD_AMT");

            BigDecimal totalLimitParam = new BigDecimal(paramValue);
            if(totalLimitParam.compareTo(singleLimit)<0){
                context.setValue("errorMsg","日累计免密限额不可小于"+singleLimit+"元");
                return "-1";
            }else if(totalLimitParam.compareTo(totalFreeAmt)<0){
                context.setValue("errorMsg","日累计免密限额不可小于"+totalFreeAmt+"元");
                return "-1";
            }else{
                return "0";
            }
        } else if ("FREE_PASSWORD_AMT".equals(paramCodeStr)) {
            // 单笔免密限额

            BigDecimal singleLimit = (BigDecimal) context.getValue("SINGLE_LIMIT");
            BigDecimal totalFreeAmt = (BigDecimal) context.getValue("DAY_TOTAL_FREE_PWD_AMT");

            BigDecimal freeAmtParam = new BigDecimal(paramValue);
            if(freeAmtParam.compareTo(singleLimit)>0){
                context.setValue("errorMsg","日累计免密限额不可超过"+singleLimit+"元");
                return "-1";
            }else if(freeAmtParam.compareTo(totalFreeAmt)>0){
                context.setValue("errorMsg","日累计免密限额不可超过"+totalFreeAmt+"元");
                return "-1";
            }else{
                return "0";
            }
        } else if ("DAY_TOTAL_FREE_PWD_AMT".equals(paramCodeStr)) {
            // 日累计免密限额
            BigDecimal totalLimit = (BigDecimal) context.getValue("TOTAL_LIMIT");
            BigDecimal freeAmt = (BigDecimal) context.getValue("FREE_PASSWORD_AMT");

            BigDecimal totalFreeAmtParam = new BigDecimal(paramValue);
            if(totalFreeAmtParam.compareTo(freeAmt)<0){
                context.setValue("errorMsg","日累计免密限额不可小于"+freeAmt+"元");
                return "-1";
            }else if(totalFreeAmtParam.compareTo(totalLimit)>0){
                context.setValue("errorMsg","日累计免密限额不可超过"+totalLimit+"元");
                return "-1";
            }else{
                return "0";
            }
        }
        return "-2";
    }

    /**
     * @eap:name paramCode
     * @eap:mustSet false
     * @eap:valueList
     * @eap:editorClass
     */
    public void setParamCode1(String paramCode1) {
        this.paramCode1 = paramCode1;
    }
}
