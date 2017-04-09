package cn.v5cn.v5cms.entity;

import javax.persistence.*;

public class Link {
    @Id
    @Column(name = "linkId")
    private Long linkid;

    /**
     * 连接名称
     */
    @Column(name = "linkName")
    private String linkname;

    /**
     * 连接
     */
    private String link;

    /**
     * 连接图片
     */
    @Column(name = "linkPic")
    private String linkpic;

    /**
     * 打开方式
     */
    @Column(name = "openType")
    private String opentype;

    /**
     * 是否启用。1：启用，2：不启用
     */
    private Integer isstart;

    /**
     * @return linkId
     */
    public Long getLinkid() {
        return linkid;
    }

    /**
     * @param linkid
     */
    public void setLinkid(Long linkid) {
        this.linkid = linkid;
    }

    /**
     * 获取连接名称
     *
     * @return linkName - 连接名称
     */
    public String getLinkname() {
        return linkname;
    }

    /**
     * 设置连接名称
     *
     * @param linkname 连接名称
     */
    public void setLinkname(String linkname) {
        this.linkname = linkname;
    }

    /**
     * 获取连接
     *
     * @return link - 连接
     */
    public String getLink() {
        return link;
    }

    /**
     * 设置连接
     *
     * @param link 连接
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * 获取连接图片
     *
     * @return linkPic - 连接图片
     */
    public String getLinkpic() {
        return linkpic;
    }

    /**
     * 设置连接图片
     *
     * @param linkpic 连接图片
     */
    public void setLinkpic(String linkpic) {
        this.linkpic = linkpic;
    }

    /**
     * 获取打开方式
     *
     * @return openType - 打开方式
     */
    public String getOpentype() {
        return opentype;
    }

    /**
     * 设置打开方式
     *
     * @param opentype 打开方式
     */
    public void setOpentype(String opentype) {
        this.opentype = opentype;
    }

    /**
     * 获取是否启用。1：启用，2：不启用
     *
     * @return isstart - 是否启用。1：启用，2：不启用
     */
    public Integer getIsstart() {
        return isstart;
    }

    /**
     * 设置是否启用。1：启用，2：不启用
     *
     * @param isstart 是否启用。1：启用，2：不启用
     */
    public void setIsstart(Integer isstart) {
        this.isstart = isstart;
    }
}