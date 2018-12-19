package com.knowledge.accumulation.utils.constant;

/**
 * Created by wj on 2017/6/7.
 */
public class SystemConstant {

    public static final int ENABLE = 1;  // 未删除

    public static final int DISABLE = 0; // 已删除

    public static final int AUDIT_TO = 2;  // 提交黑名单-审核中
    public static final int AUDIT_BACK= 3;  // 黑名单回退-审核中
    public static final int BLACKLIST = 1; // 黑名单
    public static final int NORMAL = 4; // 正常状态

    public static final int IS_DEFAULT_IMAGE = 1; // 默认使用特征
    public static final int IS_NOT_DEFAULT_IMAGE = 0; // 非默认使用特征

    /**
     * 性别
     */
    public enum Sex{

        MALE(1, "男"),
        FAMALE(2, "女");

        private final int SEX;
        private final String desc;

        Sex(int sex, String desc){
            this.SEX = sex;
            this.desc = desc;
        }

        public int getType() {
            return this.SEX;
        }

        public static Sex getSex(int type) {
            for (Sex e : Sex.values()) {
                if (e.getType() == type) {
                    return e;
                }
            }
            return null;
        }
    }

    /**
     * 照片类型
     */
    public enum ImageType{

        SCENE_IMG(1, "现场留存照片"),
        CHIP_IMG(2, "芯片照片"),
        HD_IMG(3, "公安部高清照片");

        public final int imageType;
        public final String desc;

        ImageType(int imageType, String desc){
            this.imageType = imageType;
            this.desc = desc;
        }

        private int getType() {
            return this.imageType;
        }

        public static ImageType getImageType(int type) {
            for (ImageType e : ImageType.values()) {
                if (e.getType() == type) {
                    return e;
                }
            }
            return null;
        }
    }

    /**
     * 民族
     */
    public enum Minority{

        HAN_ZU("1", "汉族"),
        ZHUANG_ZU("2", "壮族"),
        MAN_ZU("3", "满族"),
        HUI_ZU("4", "回族"),
        MIAO_ZU("5", "苗族"),
        WEI_WU_ER_ZU("6", "维吾尔族"),
        TU_JIA_ZU("7", "土家族"),
        YI_ZU("8", "彝族"),
        MENG_GU_ZU("9", "蒙古族"),
        ZANG_ZU("10", "藏族"),
        BU_YI_ZU("11", "布依族"),
        DONG_ZU("12", "侗族"),
        YAO_ZU("13", "瑶族"),
        CHAO_XIAN_ZU("14", "朝鲜族"),
        BAI_ZU("15", "白族"),
        HA_NI_ZU("16", "哈尼族"),
        HA_SA_KE_ZU("17", "哈萨克族"),
        LI_ZU("18", "黎族"),
        DAI_ZU("19", "傣族"),
        SHE_ZU("20", "畲族"),
        LI_SU_ZU("21", "傈僳族"),
        GE_LAO_ZU("22", "仡佬族"),
        DONG_XIANG_ZU("23", "东乡族"),
        GAO_SHAN_ZU("24", "高山族"),
        LA_HU_ZU("25", "拉祜族"),
        SHUI_ZU("26", "水族"),
        WA_ZU("27", "佤族"),
        NA_XI_ZU("28", "纳西族"),
        QIANG_ZU("29", "羌族"),
        TU_ZU("30", "土族"),
        MU_LAO_ZU("31", "仫佬族"),
        XI_BO_ZU("32", "锡伯族"),
        KE_ER_KE_ZI_ZU("33", "柯尔克孜族"),
        DA_WO_ERZU("34", "达斡尔族"),
        JING_PO_ZU("35", "景颇族"),
        MAO_NAN_ZU("36", "毛南族"),
        SA_LA_ZU("37", "撒拉族"),
        BU_LANG_ZU("38", "布朗族"),
        TA_JI_KE_ZU("39", "塔吉克族"),
        A_CHANG_ZU("40", "阿昌族"),
        PU_MI_ZU("41", "普米族"),
        E_WEN_KE_ZU("42", "鄂温克族"),
        NU_ZU("43", "怒族"),
        JING_ZU("44", "京族"),
        JI_NUO_ZU("45", "基诺族"),
        DE_ANG_ZU("46", "德昂族"),
        BAO_AN_ZU("47", "保安族"),
        E_LUO_SI_ZU("48", "俄罗斯族"),
        YU_GU_ZU("49", "裕固族"),
        WU_ZI_BIE_KE_ZU("50", "乌孜别克族"),
        MEN_BA_ZU("51", "门巴族"),
        E_LUN_CHUN_ZU("52", "鄂伦春族"),
        DU_LONG_ZU("53", "独龙族"),
        TA_TA_ER_ZU("54", "塔塔尔族"),
        HE_ZHE_ZU("55", "赫哲族"),
        LUO_BA_ZU("56", "珞巴族"),
        NOT_SURE("99", "不确定");

        public final String code;
        public final String name;

        Minority(String code, String name){
            this.code = code;
            this.name = name;
        }

        private String getCode() {
            return this.code;
        }

        public static Minority getMinority(String type) {
            for (Minority e : Minority.values()) {
                if (e.getCode() == type) {
                    return e;
                }
            }
            return null;
        }
    }

    /**
     * 证件类型
     */
    public enum CtfType{

        SHEN_FEN_ZHENG("1", "身份证"),
        LIN_SHI_SHEN_FEN_ZHENG("2", "临时身份证"),
        HU_KOU_BU("3", "户口簿"),
        JUN_GUAN_ZHENG("4", "军官证"),
        WU_JING_ZHENG("5", "武警证"),
        SHI_BING_ZHENG("6", "士兵证"),
        WEN_ZHI_GAN_BU_ZHENG("7", "文职干部证"),
        WAI_GUO_HU_ZHAO("8", "外国护照"),
        XIANG_GANG_TONG_XING_ZHENG("9", "香港通行证"),
        AO_MEN_TONG_XING_ZHENG("10", "澳门通行证"),
        TAI_WAN_TONG_XING_ZHENG_HUO_YOU_XIAO_LV_XING_ZHENG_JIAN("11", "台湾通行证或有效旅行证件"),
        JUN_GUAN_TUI_XIU_ZHENG("12", "军官退休证"),
        ZHONG_GUO_HU_ZHAO("13", "中国护照"),
        WAI_GUO_REN_YONG_JIU_JU_LIU_ZHENG("14", "外国人永久居留证"),
        JUN_SHI_XUE_YUAN_ZHENG("15", "军事学员证"),
        LI_XIU_GAN_BU_RONG_YU_ZHENG("16", "离休干部荣誉证"),
        BIAN_MIN_CHU_RU_JING_TONG_XING_ZHENG("17", "边民出入境通行证"),
        CUN_MIN_WEI_YUAN_HUI_ZHENG_MING("18", "村民委员会证明"),
        XUE_SHENG_ZHENG("19", "学生证"),
        OTHERS("20", "其他");

        public final String code;
        public final String name;

        CtfType(String code, String name){
            this.code = code;
            this.name = name;
        }

        private String getCode() {
            return this.code;
        }

        public static CtfType getCtfType(String type) {
            for (CtfType e : CtfType.values()) {
                if (e.getCode() == type) {
                    return e;
                }
            }
            return null;
        }
    }

    public enum Services{
        BIO_REST("biometrics-rest", "REST API服务", true),
        BIO_WS("biometrics-webservice", "WebService API服务", true),
        BIO_SOCKET("biometrics-socket", "Socket API服务", true),
        BIO_TIME("biometrics-time", "Boot页面", false),
        BIO_BD_FACE("biometrics-bd-face", "百度人脸服务", true),
        BIO_GRG_FACE("biometrics-grg-face", "广电人脸服务", true),
        BIO_GRG_FINGERVEIN("biometrics-grg-fingervein", "广电指静脉服务", true),
        BIO_AUTH_FACE("biometrics-authenmetric-face", "中科奥森人脸服务", true),
        BIO_IFYTEC_VOICEPRINT("biometrics-iflytec-voiceprint", "科大讯飞声纹服务", true),
        BIO_IFYTEC_VOICE("biometrics-iflytec-voice", "科大讯飞语音服务", true),
        BIO_ZKTECT_FINGERPRINT("biometrics-zkteco-fingerprint", "中控智慧指纹服务", true),
        BIO_YITU_FACE("biometrics-yitu-face", "依图人脸服务", true),
        BIO_IRISKING_IRIS("biometrics-irisking-iris", "中科虹霸虹膜服务", true),
        BIO_FILE_SERVER("biometrics-file-server", "文件服务", true),
        BIO_MPS_NETCARD("biometrics-mps-netcard", "公安一所网证", true),
        BIO_AIBEE_FACE("biometrics-aibee-face", "爱笔人脸服务", true),
        BIO_GATEWAY("biometrics-gateway", "网关服务", false),
        BIO_METRICS_ADMIN("biometrics-metrics-admin", "Boot Admin监控服务", false),
        BIO_DASHBOARD("biometrics-dashboard", "Dashboard监控服务", false),
        BIO_TURBINE("biometrics-turbine", "Turbine监控服务", false);

        public final String serviceName;
        public final String serviceDesc;
        public final boolean isMonitor;

        Services(String serviceName, String serviceDesc, boolean isMonitor){
            this.serviceName = serviceName;
            this.serviceDesc = serviceDesc;
            this.isMonitor = isMonitor;
        }

        private String getServiceName() {
            return this.serviceName;
        }

        public static Services getService(String serviceName) {
            for (Services e : Services.values()) {
                if (e.getServiceName().equals(serviceName)) {
                    return e;
                }
            }
            return null;
        }
    }

}
