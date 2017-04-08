package cn.v5cn.v5cms.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ZXF-PC1 on 2015/7/22.
 */
@Entity
@Table
public class Link implements Serializable {
    private Long linkId;
    private String linkName;        //连接名称
    private String link;            //连接
    private String linkPic;         //连接图片
    private String openType;        //打开方式
    private Integer isstart;        //是否启用，1：启用，0：不启用

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getLinkId() {
        return linkId;
    }

    public void setLinkId(Long linkId) {
        this.linkId = linkId;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLinkPic() {
        return linkPic;
    }

    public void setLinkPic(String linkPic) {
        this.linkPic = linkPic;
    }

    public String getOpenType() {
        return openType;
    }

    public void setOpenType(String openType) {
        this.openType = openType;
    }

    public Integer getIsstart() {
        return isstart;
    }

    public void setIsstart(Integer isstart) {
        this.isstart = isstart;
    }

    @Override
    public String toString() {
        return "Link{" +
                "linkId=" + linkId +
                ", linkName='" + linkName + '\'' +
                ", link='" + link + '\'' +
                ", linkPic='" + linkPic + '\'' +
                ", openType='" + openType + '\'' +
                ", isstart=" + isstart +
                '}';
    }
}
