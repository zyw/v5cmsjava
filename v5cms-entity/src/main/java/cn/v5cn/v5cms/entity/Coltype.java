package cn.v5cn.v5cms.entity;

import javax.persistence.*;

public class Coltype {
    @Id
    @Column(name = "colTypeId")
    private Long coltypeid;

    /**
     * 类型名称
     */
    @Column(name = "colTypeName")
    private String coltypename;

    /**
     * 栏目模板名称
     */
    private String coltpl;

    /**
     * 内容模板名称
     */
    private String contenttpl;

    /**
     * 栏目排序
     */
    private Integer colsort;

    /**
     * 是否有内容页
     */
    @Column(name = "hasContent")
    private Integer hascontent;

    /**
     * 是否可用
     */
    @Column(name = "isDisabled")
    private Integer isdisabled;

    /**
     * 栏目类型所属站点
     */
    @Column(name = "siteId")
    private Long siteid;

    /**
     * @return colTypeId
     */
    public Long getColtypeid() {
        return coltypeid;
    }

    /**
     * @param coltypeid
     */
    public void setColtypeid(Long coltypeid) {
        this.coltypeid = coltypeid;
    }

    /**
     * 获取类型名称
     *
     * @return colTypeName - 类型名称
     */
    public String getColtypename() {
        return coltypename;
    }

    /**
     * 设置类型名称
     *
     * @param coltypename 类型名称
     */
    public void setColtypename(String coltypename) {
        this.coltypename = coltypename;
    }

    /**
     * 获取栏目模板名称
     *
     * @return coltpl - 栏目模板名称
     */
    public String getColtpl() {
        return coltpl;
    }

    /**
     * 设置栏目模板名称
     *
     * @param coltpl 栏目模板名称
     */
    public void setColtpl(String coltpl) {
        this.coltpl = coltpl;
    }

    /**
     * 获取内容模板名称
     *
     * @return contenttpl - 内容模板名称
     */
    public String getContenttpl() {
        return contenttpl;
    }

    /**
     * 设置内容模板名称
     *
     * @param contenttpl 内容模板名称
     */
    public void setContenttpl(String contenttpl) {
        this.contenttpl = contenttpl;
    }

    /**
     * 获取栏目排序
     *
     * @return colsort - 栏目排序
     */
    public Integer getColsort() {
        return colsort;
    }

    /**
     * 设置栏目排序
     *
     * @param colsort 栏目排序
     */
    public void setColsort(Integer colsort) {
        this.colsort = colsort;
    }

    /**
     * 获取是否有内容页
     *
     * @return hasContent - 是否有内容页
     */
    public Integer getHascontent() {
        return hascontent;
    }

    /**
     * 设置是否有内容页
     *
     * @param hascontent 是否有内容页
     */
    public void setHascontent(Integer hascontent) {
        this.hascontent = hascontent;
    }

    /**
     * 获取是否可用
     *
     * @return isDisabled - 是否可用
     */
    public Integer getIsdisabled() {
        return isdisabled;
    }

    /**
     * 设置是否可用
     *
     * @param isdisabled 是否可用
     */
    public void setIsdisabled(Integer isdisabled) {
        this.isdisabled = isdisabled;
    }

    /**
     * 获取栏目类型所属站点
     *
     * @return siteId - 栏目类型所属站点
     */
    public Long getSiteid() {
        return siteid;
    }

    /**
     * 设置栏目类型所属站点
     *
     * @param siteid 栏目类型所属站点
     */
    public void setSiteid(Long siteid) {
        this.siteid = siteid;
    }
}