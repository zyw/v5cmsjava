package cn.v5cn.v5cms.entity;

import javax.persistence.*;

public class Advpos {
    @Id
    @Column(name = "advPosId")
    private Long advposid;

    /**
     * 版位名称
     */
    @Column(name = "advPosName")
    private String advposname;

    /**
     * 状态0:关闭，1:启用
     */
    @Column(name = "advPosState")
    private Integer advposstate;

    /**
     * 描述
     */
    @Column(name = "advPosDes")
    private String advposdes;

    /**
     * @return advPosId
     */
    public Long getAdvposid() {
        return advposid;
    }

    /**
     * @param advposid
     */
    public void setAdvposid(Long advposid) {
        this.advposid = advposid;
    }

    /**
     * 获取版位名称
     *
     * @return advPosName - 版位名称
     */
    public String getAdvposname() {
        return advposname;
    }

    /**
     * 设置版位名称
     *
     * @param advposname 版位名称
     */
    public void setAdvposname(String advposname) {
        this.advposname = advposname;
    }

    /**
     * 获取状态0:关闭，1:启用
     *
     * @return advPosState - 状态0:关闭，1:启用
     */
    public Integer getAdvposstate() {
        return advposstate;
    }

    /**
     * 设置状态0:关闭，1:启用
     *
     * @param advposstate 状态0:关闭，1:启用
     */
    public void setAdvposstate(Integer advposstate) {
        this.advposstate = advposstate;
    }

    /**
     * 获取描述
     *
     * @return advPosDes - 描述
     */
    public String getAdvposdes() {
        return advposdes;
    }

    /**
     * 设置描述
     *
     * @param advposdes 描述
     */
    public void setAdvposdes(String advposdes) {
        this.advposdes = advposdes;
    }
}