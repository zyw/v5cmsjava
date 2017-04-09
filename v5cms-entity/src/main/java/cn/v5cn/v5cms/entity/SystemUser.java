package cn.v5cn.v5cms.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "system_user")
public class SystemUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loginname;

    private String password;

    private String salt;

    private String name;

    private String email;

    /**
     * 1:男，0:女
     */
    private Integer sex;

    /**
     * 移动电话
     */
    private String mobilephone;

    /**
     * 登录次数
     */
    @Column(name = "loginCount")
    private Integer logincount;

    /**
     * 最后登录时间
     */
    @Column(name = "lastLoginTime")
    private Date lastlogintime;

    /**
     * 头像
     */
    @Column(name = "originalPic")
    private String originalpic;

    /**
     * #1 不在线 2.封号状态 
     */
    private Integer available;

    /**
     * 创建时间
     */
    @Column(name = "createAt")
    private Date createat;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return loginname
     */
    public String getLoginname() {
        return loginname;
    }

    /**
     * @param loginname
     */
    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取1:男，0:女
     *
     * @return sex - 1:男，0:女
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置1:男，0:女
     *
     * @param sex 1:男，0:女
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取移动电话
     *
     * @return mobilephone - 移动电话
     */
    public String getMobilephone() {
        return mobilephone;
    }

    /**
     * 设置移动电话
     *
     * @param mobilephone 移动电话
     */
    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    /**
     * 获取登录次数
     *
     * @return loginCount - 登录次数
     */
    public Integer getLogincount() {
        return logincount;
    }

    /**
     * 设置登录次数
     *
     * @param logincount 登录次数
     */
    public void setLogincount(Integer logincount) {
        this.logincount = logincount;
    }

    /**
     * 获取最后登录时间
     *
     * @return lastLoginTime - 最后登录时间
     */
    public Date getLastlogintime() {
        return lastlogintime;
    }

    /**
     * 设置最后登录时间
     *
     * @param lastlogintime 最后登录时间
     */
    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    /**
     * 获取头像
     *
     * @return originalPic - 头像
     */
    public String getOriginalpic() {
        return originalpic;
    }

    /**
     * 设置头像
     *
     * @param originalpic 头像
     */
    public void setOriginalpic(String originalpic) {
        this.originalpic = originalpic;
    }

    /**
     * 获取#1 不在线 2.封号状态 
     *
     * @return available - #1 不在线 2.封号状态 
     */
    public Integer getAvailable() {
        return available;
    }

    /**
     * 设置#1 不在线 2.封号状态 
     *
     * @param available #1 不在线 2.封号状态 
     */
    public void setAvailable(Integer available) {
        this.available = available;
    }

    /**
     * 获取创建时间
     *
     * @return createAt - 创建时间
     */
    public Date getCreateat() {
        return createat;
    }

    /**
     * 设置创建时间
     *
     * @param createat 创建时间
     */
    public void setCreateat(Date createat) {
        this.createat = createat;
    }
}