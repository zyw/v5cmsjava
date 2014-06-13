package cn.v5cn.v5cms.entity;

import java.io.Serializable;

/**
 * Created by ZYW on 2014/6/9.
 */
public class Manager implements Serializable {
    private int tbId;
    private String managerLoginname;
    private String managerPassword;
    private String managerName;
    private String managerEmail;
    private String managerIP;
    private int loginCount;
    private String mobilephone;
    private String lastLoginTime;
    private String originalPic;

    public int getTbId() {
        return tbId;
    }

    public void setTbId(int tbId) {
        this.tbId = tbId;
    }

    public String getManagerLoginname() {
        return managerLoginname;
    }

    public void setManagerLoginname(String managerLoginname) {
        this.managerLoginname = managerLoginname;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public String getManagerIP() {
        return managerIP;
    }

    public void setManagerIP(String managerIP) {
        this.managerIP = managerIP;
    }

    public int getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(int loginCount) {
        this.loginCount = loginCount;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getOriginalPic() {
        return originalPic;
    }

    public void setOriginalPic(String originalPic) {
        this.originalPic = originalPic;
    }
}
