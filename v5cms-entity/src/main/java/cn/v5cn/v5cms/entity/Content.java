package cn.v5cn.v5cms.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ZYW on 2014/11/19.
 */
@Entity
@Table(name = "content")
public class Content implements Serializable {
    private Long contentId;
    private String cname;           //内容标题
    private String cbody;           //发布的内容
    private Integer outside;        //是否是外链，1：是，0：不是
    private String outsideURL;      //外链地址
    private String titleColor;      //标题颜色
    private Integer titleBold;      //是否加粗
    private Integer titleItalic;    //是否斜体
    private String contentKey;      //关键字
    private String contentDes;      //摘要
    private Date lastdt;            //最后更新的时间
    private Long writerId;          //提交者ID
    private String author;          //作者
    private String source;          //内容来源
    private String sourceURL;       //来源地址
    private Integer stick;          //是否置顶，1：置顶，2：反之
    private Integer stickNum;       //置顶序号，只有是置顶状态，才起作用
    private String publishDT;         //原内容发布日期
    private Integer state;          //内容状态，2：发布，1：待审核，0：草稿
    private Integer allowComment;   //是否允许评论，1：运行 0：禁止
    private String cpics;           //与文章关联的图片，多个使用逗号分割
    private String cattas;          //文章中使用的附件，多个使用丢号分割
    private String dispic;          //展示图
    private Long siteId;            //站点Id

    private Column column;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCbody() {
        return cbody;
    }

    public void setCbody(String cbody) {
        this.cbody = cbody;
    }

    public Integer getOutside() {
        return outside;
    }

    public void setOutside(Integer outside) {
        this.outside = outside;
    }

    public String getOutsideURL() {
        return outsideURL;
    }

    public void setOutsideURL(String outsideURL) {
        this.outsideURL = outsideURL;
    }

    public String getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    public Integer getTitleBold() {
        return titleBold;
    }

    public void setTitleBold(Integer titleBold) {
        this.titleBold = titleBold;
    }

    public Integer getTitleItalic() {
        return titleItalic;
    }

    public void setTitleItalic(Integer titleItalic) {
        this.titleItalic = titleItalic;
    }

    public String getContentKey() {
        return contentKey;
    }

    public void setContentKey(String contentKey) {
        this.contentKey = contentKey;
    }

    public String getContentDes() {
        return contentDes;
    }

    public void setContentDes(String contentDes) {
        this.contentDes = contentDes;
    }

    public Date getLastdt() {
        return lastdt;
    }

    public void setLastdt(Date lastdt) {
        this.lastdt = lastdt;
    }

    public Long getWriterId() {
        return writerId;
    }

    public void setWriterId(Long writerId) {
        this.writerId = writerId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceURL() {
        return sourceURL;
    }

    public void setSourceURL(String sourceURL) {
        this.sourceURL = sourceURL;
    }

    public Integer getStick() {
        return stick;
    }

    public void setStick(Integer stick) {
        this.stick = stick;
    }

    public Integer getStickNum() {
        return stickNum;
    }

    public void setStickNum(Integer stickNum) {
        this.stickNum = stickNum;
    }

    public String getPublishDT() {
        return publishDT;
    }

    public void setPublishDT(String publishDT) {
        this.publishDT = publishDT;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getAllowComment() {
        return allowComment;
    }

    public void setAllowComment(Integer allowComment) {
        this.allowComment = allowComment;
    }

    public String getCpics() {
        return cpics;
    }

    public void setCpics(String cpics) {
        this.cpics = cpics;
    }

    public String getCattas() {
        return cattas;
    }

    public void setCattas(String cattas) {
        this.cattas = cattas;
    }

    public String getDispic() {
        return dispic;
    }

    public void setDispic(String dispic) {
        this.dispic = dispic;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    @ManyToOne
    @JoinColumn(name = "columnId")
    public Column getColumn() {
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "Content{" +
                "contentId=" + contentId +
                ", cname='" + cname + '\'' +
                ", cbody='" + cbody + '\'' +
                ", outside=" + outside +
                ", outsideURL='" + outsideURL + '\'' +
                ", titleColor='" + titleColor + '\'' +
                ", titleBold=" + titleBold +
                ", titleItalic=" + titleItalic +
                ", contentKey='" + contentKey + '\'' +
                ", contentDes='" + contentDes + '\'' +
                ", lastdt=" + lastdt +
                ", writerId=" + writerId +
                ", author='" + author + '\'' +
                ", source='" + source + '\'' +
                ", sourceURL='" + sourceURL + '\'' +
                ", stick=" + stick +
                ", stickNum=" + stickNum +
                ", publishDT='" + publishDT + '\'' +
                ", state=" + state +
                ", allowComment=" + allowComment +
                ", cpics='" + cpics + '\'' +
                ", cattas='" + cattas + '\'' +
                ", dispic='" + dispic + '\'' +
                ", siteId=" + siteId +
                ", column=" + column +
                '}';
    }
}
