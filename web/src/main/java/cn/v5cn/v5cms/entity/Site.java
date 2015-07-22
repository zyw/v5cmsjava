package cn.v5cn.v5cms.entity;

import cn.v5cn.v5cms.util.annotation.Ignore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ZYW on 2014/6/30.
 */
@Entity
@Table
public class Site implements Serializable {

    private Long siteId;
    @NotEmpty
    private String siteName;
    @NotEmpty
    private String domain;
    @NotEmpty
    private String protocol;
    private String siteDeputyTitle;
    private String siteKey;
    private String siteDescribed;
    private Date createDate;
    private String siteicp;
    private String siteStatisticCode;
    private String siteFooterInfo;
    private int isclosesite;
    private String themeName;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
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

    @Ignore
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
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

    @Override
    public String toString() {
        return "Site{" +
                "siteId=" + siteId +
                ", siteName='" + siteName + '\'' +
                ", siteDeputyTitle='" + siteDeputyTitle + '\'' +
                ", siteKey='" + siteKey + '\'' +
                ", siteDescribed='" + siteDescribed + '\'' +
                ", createDate=" + createDate +
                ", siteicp='" + siteicp + '\'' +
                ", siteStatisticCode='" + siteStatisticCode + '\'' +
                ", siteFooterInfo='" + siteFooterInfo + '\'' +
                ", isclosesite=" + isclosesite +
                ", themeName='" + themeName + '\'' +
                '}';
    }
}
