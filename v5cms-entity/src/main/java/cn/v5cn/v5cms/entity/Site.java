package cn.v5cn.v5cms.entity;

import javax.persistence.*;

public class Site {
    @Id
    @Column(name = "siteId")
    private Long siteid;

    /**
     * 网站标题
     */
    @Column(name = "siteName")
    private String sitename;

    /**
     * 网站域名，必须唯一
     */
    private String domain;

    /**
     * 访问协议，http://或者https://
     */
    private String protocol;

    /**
     * 网站副标题
     */
    @Column(name = "siteDeputyTitle")
    private String sitedeputytitle;

    /**
     * 网站关键字
     */
    @Column(name = "siteKey")
    private String sitekey;

    /**
     * 网站描述
     */
    @Column(name = "siteDescribed")
    private String sitedescribed;

    /**
     * 创建时间
     */
    @Column(name = "createDate")
    private String createdate;

    /**
     * 网站备案号
     */
    private String siteicp;

    /**
     * 统计代码
     */
    @Column(name = "siteStatisticCode")
    private String sitestatisticcode;

    /**
     * 网站底部信息
     */
    @Column(name = "siteFooterInfo")
    private String sitefooterinfo;

    /**
     * 网站是否关闭 1关闭    0 开启
     */
    private Integer isclosesite;

    /**
     * 使用的网站主题名称
     */
    @Column(name = "themeName")
    private String themename;

    /**
     * 角色ID
     */
    @Transient
    private Long roleId;

    /**
     * @return siteId
     */
    public Long getSiteid() {
        return siteid;
    }

    /**
     * @param siteid
     */
    public void setSiteid(Long siteid) {
        this.siteid = siteid;
    }

    /**
     * 获取网站标题
     *
     * @return siteName - 网站标题
     */
    public String getSitename() {
        return sitename;
    }

    /**
     * 设置网站标题
     *
     * @param sitename 网站标题
     */
    public void setSitename(String sitename) {
        this.sitename = sitename;
    }

    /**
     * 获取网站域名，必须唯一
     *
     * @return domain - 网站域名，必须唯一
     */
    public String getDomain() {
        return domain;
    }

    /**
     * 设置网站域名，必须唯一
     *
     * @param domain 网站域名，必须唯一
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * 获取访问协议，http://或者https://
     *
     * @return protocol - 访问协议，http://或者https://
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * 设置访问协议，http://或者https://
     *
     * @param protocol 访问协议，http://或者https://
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * 获取网站副标题
     *
     * @return siteDeputyTitle - 网站副标题
     */
    public String getSitedeputytitle() {
        return sitedeputytitle;
    }

    /**
     * 设置网站副标题
     *
     * @param sitedeputytitle 网站副标题
     */
    public void setSitedeputytitle(String sitedeputytitle) {
        this.sitedeputytitle = sitedeputytitle;
    }

    /**
     * 获取网站关键字
     *
     * @return siteKey - 网站关键字
     */
    public String getSitekey() {
        return sitekey;
    }

    /**
     * 设置网站关键字
     *
     * @param sitekey 网站关键字
     */
    public void setSitekey(String sitekey) {
        this.sitekey = sitekey;
    }

    /**
     * 获取网站描述
     *
     * @return siteDescribed - 网站描述
     */
    public String getSitedescribed() {
        return sitedescribed;
    }

    /**
     * 设置网站描述
     *
     * @param sitedescribed 网站描述
     */
    public void setSitedescribed(String sitedescribed) {
        this.sitedescribed = sitedescribed;
    }

    /**
     * 获取创建时间
     *
     * @return createDate - 创建时间
     */
    public String getCreatedate() {
        return createdate;
    }

    /**
     * 设置创建时间
     *
     * @param createdate 创建时间
     */
    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取网站备案号
     *
     * @return siteicp - 网站备案号
     */
    public String getSiteicp() {
        return siteicp;
    }

    /**
     * 设置网站备案号
     *
     * @param siteicp 网站备案号
     */
    public void setSiteicp(String siteicp) {
        this.siteicp = siteicp;
    }

    /**
     * 获取统计代码
     *
     * @return siteStatisticCode - 统计代码
     */
    public String getSitestatisticcode() {
        return sitestatisticcode;
    }

    /**
     * 设置统计代码
     *
     * @param sitestatisticcode 统计代码
     */
    public void setSitestatisticcode(String sitestatisticcode) {
        this.sitestatisticcode = sitestatisticcode;
    }

    /**
     * 获取网站底部信息
     *
     * @return siteFooterInfo - 网站底部信息
     */
    public String getSitefooterinfo() {
        return sitefooterinfo;
    }

    /**
     * 设置网站底部信息
     *
     * @param sitefooterinfo 网站底部信息
     */
    public void setSitefooterinfo(String sitefooterinfo) {
        this.sitefooterinfo = sitefooterinfo;
    }

    /**
     * 获取网站是否关闭 1关闭    0 开启
     *
     * @return isclosesite - 网站是否关闭 1关闭    0 开启
     */
    public Integer getIsclosesite() {
        return isclosesite;
    }

    /**
     * 设置网站是否关闭 1关闭    0 开启
     *
     * @param isclosesite 网站是否关闭 1关闭    0 开启
     */
    public void setIsclosesite(Integer isclosesite) {
        this.isclosesite = isclosesite;
    }

    /**
     * 获取使用的网站主题名称
     *
     * @return themeName - 使用的网站主题名称
     */
    public String getThemename() {
        return themename;
    }

    /**
     * 设置使用的网站主题名称
     *
     * @param themename 使用的网站主题名称
     */
    public void setThemename(String themename) {
        this.themename = themename;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "Site{" +
                "siteid=" + siteid +
                ", sitename='" + sitename + '\'' +
                ", domain='" + domain + '\'' +
                ", protocol='" + protocol + '\'' +
                ", sitedeputytitle='" + sitedeputytitle + '\'' +
                ", sitekey='" + sitekey + '\'' +
                ", sitedescribed='" + sitedescribed + '\'' +
                ", createdate='" + createdate + '\'' +
                ", siteicp='" + siteicp + '\'' +
                ", sitestatisticcode='" + sitestatisticcode + '\'' +
                ", sitefooterinfo='" + sitefooterinfo + '\'' +
                ", isclosesite=" + isclosesite +
                ", themename='" + themename + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}