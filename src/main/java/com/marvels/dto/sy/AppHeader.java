package com.marvels.dto.sy;

public class AppHeader {
	private String security;
    private String tokenCode;
    private String challengeCode;
    private String mobileCode;
    private String signData;
    private String deviceSN;
    private String originData;
    public String getSecurity() {
        return security;
    }
    public void setSecurity(String security) {
        this.security = security;
    }
    public String getTokenCode() {
        return tokenCode;
    }
    public void setTokenCode(String tokenCode) {
        this.tokenCode = tokenCode;
    }
    public String getChallengeCode() {
        return challengeCode;
    }
    public void setChallengeCode(String challengeCode) {
        this.challengeCode = challengeCode;
    }
    public String getMobileCode() {
        return mobileCode;
    }
    public void setMobileCode(String mobileCode) {
        this.mobileCode = mobileCode;
    }
    public String getSignData() {
        return signData;
    }
    public void setSignData(String signData) {
        this.signData = signData;
    }
    public String getDeviceSN() {
        return deviceSN;
    }
    public void setDeviceSN(String deviceSN) {
        this.deviceSN = deviceSN;
    }
    public String getOriginData() {
        return originData;
    }
    public void setOriginData(String originData) {
        this.originData = originData;
    }
}
