package cn.v5cn.v5cms.entity;

import java.util.Date;
import javax.persistence.*;

public class Adv {
    @Id
    @Column(name = "advId")
    private Long advid;

    /**
     * 广告名称
     */
    @Column(name = "advName")
    private String advname;

    /**
     * 广告类型1:图片，2：Flash，3：文字，4：代码
     */
    @Column(name = "advType")
    private Integer advtype;

    /**
     * 广告版位ID
     */
    @Column(name = "advPosId")
    private Long advposid;

    /**
     * 广告代码
     */
    @Column(name = "advCode")
    private String advcode;

    /**
     * 广告开始时间
     */
    @Column(name = "advStartTime")
    private Date advstarttime;

    /**
     * 广告结束时间
     */
    @Column(name = "advEndTime")
    private Date advendtime;

    /**
     * 创建时间
     */
    @Column(name = "createDate")
    private Date createdate;

    /**
     * 广告类型信息JSON字符串
     */
    @Column(name = "advTypeInfo")
    private String advtypeinfo;

    /**
     * 广告状态1：启用，0：关闭
     */
    @Column(name = "startUsing")
    private Integer startusing;

    /**
     * @return advId
     */
    public Long getAdvid() {
        return advid;
    }

    /**
     * @param advid
     */
    public void setAdvid(Long advid) {
        this.advid = advid;
    }

    /**
     * 获取广告名称
     *
     * @return advName - 广告名称
     */
    public String getAdvname() {
        return advname;
    }

    /**
     * 设置广告名称
     *
     * @param advname 广告名称
     */
    public void setAdvname(String advname) {
        this.advname = advname;
    }

    /**
     * 获取广告类型1:图片，2：Flash，3：文字，4：代码
     *
     * @return advType - 广告类型1:图片，2：Flash，3：文字，4：代码
     */
    public Integer getAdvtype() {
        return advtype;
    }

    /**
     * 设置广告类型1:图片，2：Flash，3：文字，4：代码
     *
     * @param advtype 广告类型1:图片，2：Flash，3：文字，4：代码
     */
    public void setAdvtype(Integer advtype) {
        this.advtype = advtype;
    }

    /**
     * 获取广告版位ID
     *
     * @return advPosId - 广告版位ID
     */
    public Long getAdvposid() {
        return advposid;
    }

    /**
     * 设置广告版位ID
     *
     * @param advposid 广告版位ID
     */
    public void setAdvposid(Long advposid) {
        this.advposid = advposid;
    }

    /**
     * 获取广告代码
     *
     * @return advCode - 广告代码
     */
    public String getAdvcode() {
        return advcode;
    }

    /**
     * 设置广告代码
     *
     * @param advcode 广告代码
     */
    public void setAdvcode(String advcode) {
        this.advcode = advcode;
    }

    /**
     * 获取广告开始时间
     *
     * @return advStartTime - 广告开始时间
     */
    public Date getAdvstarttime() {
        return advstarttime;
    }

    /**
     * 设置广告开始时间
     *
     * @param advstarttime 广告开始时间
     */
    public void setAdvstarttime(Date advstarttime) {
        this.advstarttime = advstarttime;
    }

    /**
     * 获取广告结束时间
     *
     * @return advEndTime - 广告结束时间
     */
    public Date getAdvendtime() {
        return advendtime;
    }

    /**
     * 设置广告结束时间
     *
     * @param advendtime 广告结束时间
     */
    public void setAdvendtime(Date advendtime) {
        this.advendtime = advendtime;
    }

    /**
     * 获取创建时间
     *
     * @return createDate - 创建时间
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置创建时间
     *
     * @param createdate 创建时间
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取广告类型信息JSON字符串
     *
     * @return advTypeInfo - 广告类型信息JSON字符串
     */
    public String getAdvtypeinfo() {
        return advtypeinfo;
    }

    /**
     * 设置广告类型信息JSON字符串
     *
     * @param advtypeinfo 广告类型信息JSON字符串
     */
    public void setAdvtypeinfo(String advtypeinfo) {
        this.advtypeinfo = advtypeinfo;
    }

    /**
     * 获取广告状态1：启用，0：关闭
     *
     * @return startUsing - 广告状态1：启用，0：关闭
     */
    public Integer getStartusing() {
        return startusing;
    }

    /**
     * 设置广告状态1：启用，0：关闭
     *
     * @param startusing 广告状态1：启用，0：关闭
     */
    public void setStartusing(Integer startusing) {
        this.startusing = startusing;
    }
}