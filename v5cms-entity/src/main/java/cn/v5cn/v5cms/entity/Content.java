package cn.v5cn.v5cms.entity;

import java.util.Date;
import javax.persistence.*;

public class Content {
    @Id
    @Column(name = "contentId")
    private Long contentid;

    /**
     * 所属栏目ID
     */
    @Column(name = "columnId")
    private Long columnid;

    /**
     * 内容标题
     */
    private String cname;

    /**
     * 最后更新的时间
     */
    private Date lastdt;

    /**
     * 是否置顶，1：置顶，0：反之
     */
    private Integer stick;

    /**
     * 置顶序号，只有是置顶状态，才起作用
     */
    @Column(name = "stickNum")
    private Integer sticknum;

    /**
     * 与文章关联的图片
     */
    private String cpics;

    /**
     * 文章中使用的附件，多个使用丢号分割
     */
    private String cattas;

    /**
     * 展示图
     */
    private String dispic;

    /**
     * 作者ID
     */
    @Column(name = "writerId")
    private Long writerid;

    private String author;

    @Column(name = "contentDes")
    private String contentdes;

    @Column(name = "contentKey")
    private String contentkey;

    private Integer outside;

    @Column(name = "outsideURL")
    private String outsideurl;

    @Column(name = "publishDT")
    private String publishdt;

    @Column(name = "siteId")
    private Long siteid;

    private String source;

    @Column(name = "sourceURL")
    private String sourceurl;

    /**
     * 内容状态，2：发布，1：待审核，0：草稿
     */
    private Integer state;

    /**
     * 是否允许评论，1：运行 0：禁止
     */
    @Column(name = "allowComment")
    private Integer allowcomment;

    @Column(name = "titleBold")
    private Integer titlebold;

    @Column(name = "titleColor")
    private String titlecolor;

    @Column(name = "titleItalic")
    private Integer titleitalic;

    /**
     * 发布的内容
     */
    private String cbody;

    /**
     * @return contentId
     */
    public Long getContentid() {
        return contentid;
    }

    /**
     * @param contentid
     */
    public void setContentid(Long contentid) {
        this.contentid = contentid;
    }

    /**
     * 获取所属栏目ID
     *
     * @return columnId - 所属栏目ID
     */
    public Long getColumnid() {
        return columnid;
    }

    /**
     * 设置所属栏目ID
     *
     * @param columnid 所属栏目ID
     */
    public void setColumnid(Long columnid) {
        this.columnid = columnid;
    }

    /**
     * 获取内容标题
     *
     * @return cname - 内容标题
     */
    public String getCname() {
        return cname;
    }

    /**
     * 设置内容标题
     *
     * @param cname 内容标题
     */
    public void setCname(String cname) {
        this.cname = cname;
    }

    /**
     * 获取最后更新的时间
     *
     * @return lastdt - 最后更新的时间
     */
    public Date getLastdt() {
        return lastdt;
    }

    /**
     * 设置最后更新的时间
     *
     * @param lastdt 最后更新的时间
     */
    public void setLastdt(Date lastdt) {
        this.lastdt = lastdt;
    }

    /**
     * 获取是否置顶，1：置顶，0：反之
     *
     * @return stick - 是否置顶，1：置顶，0：反之
     */
    public Integer getStick() {
        return stick;
    }

    /**
     * 设置是否置顶，1：置顶，0：反之
     *
     * @param stick 是否置顶，1：置顶，0：反之
     */
    public void setStick(Integer stick) {
        this.stick = stick;
    }

    /**
     * 获取置顶序号，只有是置顶状态，才起作用
     *
     * @return stickNum - 置顶序号，只有是置顶状态，才起作用
     */
    public Integer getSticknum() {
        return sticknum;
    }

    /**
     * 设置置顶序号，只有是置顶状态，才起作用
     *
     * @param sticknum 置顶序号，只有是置顶状态，才起作用
     */
    public void setSticknum(Integer sticknum) {
        this.sticknum = sticknum;
    }

    /**
     * 获取与文章关联的图片
     *
     * @return cpics - 与文章关联的图片
     */
    public String getCpics() {
        return cpics;
    }

    /**
     * 设置与文章关联的图片
     *
     * @param cpics 与文章关联的图片
     */
    public void setCpics(String cpics) {
        this.cpics = cpics;
    }

    /**
     * 获取文章中使用的附件，多个使用丢号分割
     *
     * @return cattas - 文章中使用的附件，多个使用丢号分割
     */
    public String getCattas() {
        return cattas;
    }

    /**
     * 设置文章中使用的附件，多个使用丢号分割
     *
     * @param cattas 文章中使用的附件，多个使用丢号分割
     */
    public void setCattas(String cattas) {
        this.cattas = cattas;
    }

    /**
     * 获取展示图
     *
     * @return dispic - 展示图
     */
    public String getDispic() {
        return dispic;
    }

    /**
     * 设置展示图
     *
     * @param dispic 展示图
     */
    public void setDispic(String dispic) {
        this.dispic = dispic;
    }

    /**
     * 获取作者ID
     *
     * @return writerId - 作者ID
     */
    public Long getWriterid() {
        return writerid;
    }

    /**
     * 设置作者ID
     *
     * @param writerid 作者ID
     */
    public void setWriterid(Long writerid) {
        this.writerid = writerid;
    }

    /**
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return contentDes
     */
    public String getContentdes() {
        return contentdes;
    }

    /**
     * @param contentdes
     */
    public void setContentdes(String contentdes) {
        this.contentdes = contentdes;
    }

    /**
     * @return contentKey
     */
    public String getContentkey() {
        return contentkey;
    }

    /**
     * @param contentkey
     */
    public void setContentkey(String contentkey) {
        this.contentkey = contentkey;
    }

    /**
     * @return outside
     */
    public Integer getOutside() {
        return outside;
    }

    /**
     * @param outside
     */
    public void setOutside(Integer outside) {
        this.outside = outside;
    }

    /**
     * @return outsideURL
     */
    public String getOutsideurl() {
        return outsideurl;
    }

    /**
     * @param outsideurl
     */
    public void setOutsideurl(String outsideurl) {
        this.outsideurl = outsideurl;
    }

    /**
     * @return publishDT
     */
    public String getPublishdt() {
        return publishdt;
    }

    /**
     * @param publishdt
     */
    public void setPublishdt(String publishdt) {
        this.publishdt = publishdt;
    }

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
     * @return source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return sourceURL
     */
    public String getSourceurl() {
        return sourceurl;
    }

    /**
     * @param sourceurl
     */
    public void setSourceurl(String sourceurl) {
        this.sourceurl = sourceurl;
    }

    /**
     * 获取内容状态，2：发布，1：待审核，0：草稿
     *
     * @return state - 内容状态，2：发布，1：待审核，0：草稿
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置内容状态，2：发布，1：待审核，0：草稿
     *
     * @param state 内容状态，2：发布，1：待审核，0：草稿
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取是否允许评论，1：运行 0：禁止
     *
     * @return allowComment - 是否允许评论，1：运行 0：禁止
     */
    public Integer getAllowcomment() {
        return allowcomment;
    }

    /**
     * 设置是否允许评论，1：运行 0：禁止
     *
     * @param allowcomment 是否允许评论，1：运行 0：禁止
     */
    public void setAllowcomment(Integer allowcomment) {
        this.allowcomment = allowcomment;
    }

    /**
     * @return titleBold
     */
    public Integer getTitlebold() {
        return titlebold;
    }

    /**
     * @param titlebold
     */
    public void setTitlebold(Integer titlebold) {
        this.titlebold = titlebold;
    }

    /**
     * @return titleColor
     */
    public String getTitlecolor() {
        return titlecolor;
    }

    /**
     * @param titlecolor
     */
    public void setTitlecolor(String titlecolor) {
        this.titlecolor = titlecolor;
    }

    /**
     * @return titleItalic
     */
    public Integer getTitleitalic() {
        return titleitalic;
    }

    /**
     * @param titleitalic
     */
    public void setTitleitalic(Integer titleitalic) {
        this.titleitalic = titleitalic;
    }

    /**
     * 获取发布的内容
     *
     * @return cbody - 发布的内容
     */
    public String getCbody() {
        return cbody;
    }

    /**
     * 设置发布的内容
     *
     * @param cbody 发布的内容
     */
    public void setCbody(String cbody) {
        this.cbody = cbody;
    }
}