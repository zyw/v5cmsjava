package cn.v5cn.v5cms.entity;

import javax.persistence.*;

public class Banner {
    @Id
    @Column(name = "bannerId")
    private Long bannerid;

    /**
     * banner名称
     */
    @Column(name = "bannerName")
    private String bannername;

    /**
     * banner图片
     */
    @Column(name = "bannerPic")
    private String bannerpic;

    /**
     * banner跳转链接
     */
    @Column(name = "bannerLink")
    private String bannerlink;

    /**
     * 是否启用，1：启用，0：不启用
     */
    private Integer isstart;

    /**
     * banner显示顺序
     */
    private Integer bannerds;

    /**
     * 设置banner上显示的文本
     */
    private String bcontent;

    /**
     * @return bannerId
     */
    public Long getBannerid() {
        return bannerid;
    }

    /**
     * @param bannerid
     */
    public void setBannerid(Long bannerid) {
        this.bannerid = bannerid;
    }

    /**
     * 获取banner名称
     *
     * @return bannerName - banner名称
     */
    public String getBannername() {
        return bannername;
    }

    /**
     * 设置banner名称
     *
     * @param bannername banner名称
     */
    public void setBannername(String bannername) {
        this.bannername = bannername;
    }

    /**
     * 获取banner图片
     *
     * @return bannerPic - banner图片
     */
    public String getBannerpic() {
        return bannerpic;
    }

    /**
     * 设置banner图片
     *
     * @param bannerpic banner图片
     */
    public void setBannerpic(String bannerpic) {
        this.bannerpic = bannerpic;
    }

    /**
     * 获取banner跳转链接
     *
     * @return bannerLink - banner跳转链接
     */
    public String getBannerlink() {
        return bannerlink;
    }

    /**
     * 设置banner跳转链接
     *
     * @param bannerlink banner跳转链接
     */
    public void setBannerlink(String bannerlink) {
        this.bannerlink = bannerlink;
    }

    /**
     * 获取是否启用，1：启用，0：不启用
     *
     * @return isstart - 是否启用，1：启用，0：不启用
     */
    public Integer getIsstart() {
        return isstart;
    }

    /**
     * 设置是否启用，1：启用，0：不启用
     *
     * @param isstart 是否启用，1：启用，0：不启用
     */
    public void setIsstart(Integer isstart) {
        this.isstart = isstart;
    }

    /**
     * 获取banner显示顺序
     *
     * @return bannerds - banner显示顺序
     */
    public Integer getBannerds() {
        return bannerds;
    }

    /**
     * 设置banner显示顺序
     *
     * @param bannerds banner显示顺序
     */
    public void setBannerds(Integer bannerds) {
        this.bannerds = bannerds;
    }

    /**
     * 获取设置banner上显示的文本
     *
     * @return bcontent - 设置banner上显示的文本
     */
    public String getBcontent() {
        return bcontent;
    }

    /**
     * 设置设置banner上显示的文本
     *
     * @param bcontent 设置banner上显示的文本
     */
    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }
}