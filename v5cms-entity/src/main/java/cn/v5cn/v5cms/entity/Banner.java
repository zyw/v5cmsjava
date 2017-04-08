package cn.v5cn.v5cms.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zyw on 15/7/26.
 */
@Table
@Entity
public class Banner implements Serializable {

    private Long bannerId;
    private String bannerName;          //banner名称
    private String bannerPic;           //banner图片
    private String bannerLink;          //banner跳转链接
    private Integer isstart;            //是否启用，1：启用，0：不启用
    private Integer bannerds;           //banner显示顺序
    private String bcontent;            //设置banner上显示的文本

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getBannerId() {
        return bannerId;
    }

    public void setBannerId(Long bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    public String getBannerPic() {
        return bannerPic;
    }

    public void setBannerPic(String bannerPic) {
        this.bannerPic = bannerPic;
    }

    public String getBannerLink() {
        return bannerLink;
    }

    public void setBannerLink(String bannerLink) {
        this.bannerLink = bannerLink;
    }

    public Integer getIsstart() {
        return isstart;
    }

    public void setIsstart(Integer isstart) {
        this.isstart = isstart;
    }

    public Integer getBannerds() {
        return bannerds;
    }

    public void setBannerds(Integer bannerds) {
        this.bannerds = bannerds;
    }

    public String getBcontent() {
        return bcontent;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "bannerId=" + bannerId +
                ", bannerName='" + bannerName + '\'' +
                ", bannerPic='" + bannerPic + '\'' +
                ", bannerLink='" + bannerLink + '\'' +
                ", isstart=" + isstart +
                ", bannerds=" + bannerds +
                ", bcontent='" + bcontent + '\'' +
                '}';
    }
}
