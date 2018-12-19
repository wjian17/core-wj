package com.knowledge.accumulation.utils.constant;

/**
 * Created by wj on 2017/9/4.
 */
public class ManAlgEnum {

    public enum FaceEnum{

        AIBEE("AIBEE", "aibeeFaceRecognitionServiceImpl"),
        BD("BD", "bdFaceRecognitionServiceImpl"),
        GRG("GRG", "grgFaceRecognitionServiceImpl"),
        AUTHENMETRIC("AUTHENMETRIC", "authenmetricFaceRecognitionServiceImpl");

        /**
         * 厂商简写
         */
        private String manCode;
        /**
         * 服务实现
         */
        private String serviceImpl;

        FaceEnum(String manCode, String serviceImpl){
            this.manCode = manCode;
            this.serviceImpl = serviceImpl;
        }

        public static String getServiceImpl(String manCode){
            for(FaceEnum faceEnum : FaceEnum.values()){
                if(manCode.equals(faceEnum.getManCode())){
                    return faceEnum.getServiceImpl();
                }
            }
            return null;
        }

        public String getManCode() {
            return manCode;
        }

        public String getServiceImpl() {
            return serviceImpl;
        }
    }

    public enum FingerveinEnum{

        GRG("GRG", "grgFingerveinRecognitionServiceImpl");

        /**
         * 厂商简写
         */
        private String manCode;
        /**
         * 服务实现
         */
        private String serviceImpl;

        FingerveinEnum(String manCode, String serviceImpl){
            this.manCode = manCode;
            this.serviceImpl = serviceImpl;
        }

        public static String getServiceImpl(String manCode){
            for(FingerveinEnum fingerveinEnum : FingerveinEnum.values()){
                if(manCode.equals(fingerveinEnum.getManCode())){
                    return fingerveinEnum.getServiceImpl();
                }
            }
            return null;
        }

        public String getManCode() {
            return manCode;
        }

        public String getServiceImpl() {
            return serviceImpl;
        }
    }

    public enum VoiceprintEnum{
        IFLYTEC("IFLYTEC", "iflytecVoiceprintRecognitionServiceImpl");

        /**
         * 厂商简写
         */
        private String manCode;
        /**
         * 服务实现
         */
        private String serviceImpl;

        VoiceprintEnum(String manCode, String serviceImpl){
            this.manCode = manCode;
            this.serviceImpl = serviceImpl;
        }

        public static String getServiceImpl(String manCode){
            for(VoiceprintEnum voiceprintEnum : VoiceprintEnum.values()){
                if(manCode.equals(voiceprintEnum.getManCode())){
                    return voiceprintEnum.getServiceImpl();
                }
            }
            return null;
        }

        public String getManCode() {
            return manCode;
        }

        public String getServiceImpl() {
            return serviceImpl;
        }
    }

    public enum VoiceEnum{
        IFLYTEC("IFLYTEC", "iflytecVoiceRecognitionServiceImpl");

        /**
         * 厂商简写
         */
        private String manCode;
        /**
         * 服务实现
         */
        private String serviceImpl;

        VoiceEnum(String manCode, String serviceImpl){
            this.manCode = manCode;
            this.serviceImpl = serviceImpl;
        }

        public static String getServiceImpl(String manCode){
            for(VoiceEnum voiceEnum : VoiceEnum.values()){
                if(manCode.equals(voiceEnum.getManCode())){
                    return voiceEnum.getServiceImpl();
                }
            }
            return null;
        }

        public String getManCode() {
            return manCode;
        }

        public String getServiceImpl() {
            return serviceImpl;
        }
    }

    public enum FingerprintEnum{

        ZKTECO("ZKTECO", "zktecoFingerprintRecognitionServiceImpl");

        /**
         * 厂商简写
         */
        private String manCode;
        /**
         * 服务实现
         */
        private String serviceImpl;

        FingerprintEnum(String manCode, String serviceImpl){
            this.manCode = manCode;
            this.serviceImpl = serviceImpl;
        }

        public static String getServiceImpl(String manCode){
            for(FingerprintEnum fingerprintEnum : FingerprintEnum.values()){
                if(manCode.equals(fingerprintEnum.getManCode())){
                    return fingerprintEnum.getServiceImpl();
                }
            }
            return null;
        }

        public String getManCode() {
            return manCode;
        }

        public String getServiceImpl() {
            return serviceImpl;
        }
    }

    public enum IrisEnum{

        IRISKING("IRISKING", "iriskingIrsiRecognitionServiceImpl");

        /**
         * 厂商简写
         */
        private String manCode;
        /**
         * 服务实现
         */
        private String serviceImpl;

        IrisEnum(String manCode, String serviceImpl){
            this.manCode = manCode;
            this.serviceImpl = serviceImpl;
        }

        public static String getServiceImpl(String manCode){
            for(IrisEnum irisEnum : IrisEnum.values()){
                if(manCode.equals(irisEnum.getManCode())){
                    return irisEnum.getServiceImpl();
                }
            }
            return null;
        }

        public String getManCode() {
            return manCode;
        }

        public String getServiceImpl() {
            return serviceImpl;
        }
    }


}
