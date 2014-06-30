package cn.v5cn.v5cms.entity;

import java.io.Serializable;

/**
 * Created by ZYW on 2014/6/30.
 */
public class Site implements Serializable {
    private int tbId;
    private String siteName;
    private String siteDeputyTitle;
    private String siteKey;
    private String siteDescribed;
    private String createDate;
    private String siteicp;
    private String siteStatisticCode;
    private String siteFooterInfo;
    private int isclosesite;
    private String themeName;

    public int getTbId() {
        return tbId;
    }

    public void setTbId(int tbId) {
        this.tbId = tbId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteDeputyTitle() {
        return siteDeputyTitle;
    }

    public void setSiteDeputyTitle(String siteDeputyTitle) {
        this.siteDeputyTitle = siteDeputyTitle;
    }

    public String getSiteKey() {
        return siteKey;
    }

    public void setSiteKey(String siteKey) {
        this.siteKey = siteKey;
    }

    public String getSiteDescribed() {
        return siteDescribed;
    }

    public void setSiteDescribed(String siteDescribed) {
        this.siteDescribed = siteDescribed;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getSiteicp() {
        return siteicp;
    }

    public void setSiteicp(String siteicp) {
        this.siteicp = siteicp;
    }

    public String getSiteStatisticCode() {
        return siteStatisticCode;
    }

    public void setSiteStatisticCode(String siteStatisticCode) {
        this.siteStatisticCode = siteStatisticCode;
    }

    public String getSiteFooterInfo() {
        return siteFooterInfo;
    }

    public void setSiteFooterInfo(String siteFooterInfo) {
        this.siteFooterInfo = siteFooterInfo;
    }

    public int getIsclosesite() {
        return isclosesite;
    }

    public void setIsclosesite(int isclosesite) {
        this.isclosesite = isclosesite;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }
}
