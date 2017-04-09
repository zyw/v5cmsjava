package cn.v5cn.v5cms.entity;

import javax.persistence.*;

public class Cols {
    @Id
    @Column(name = "colsId")
    private Long colsid;

    /**
     * 栏目名称
     */
    @Column(name = "columnName")
    private String columnname;

    /**
     * 栏目类型
     */
    @Column(name = "colTypeId")
    private Long coltypeid;

    /**
     * 栏目显示顺序
     */
    @Column(name = "sortNum")
    private Integer sortnum;

    /**
     * 是否显示
     */
    private Integer columndisplay;

    /**
     * 连接打开方式
     */
    @Column(name = "openWay")
    private String openway;

    /**
     * 外链地址
     */
    @Column(name = "columnOutside")
    private String columnoutside;

    /**
     * 栏目图片
     */
    private String columnpic;

    /**
     * 父栏目ID
     */
    @Column(name = "parentId")
    private Integer parentid;

    /**
     * treetable排序使用
     */
    @Column(name = "parentIds")
    private String parentids;

    /**
     * 栏目所属站点
     */
    @Column(name = "siteId")
    private Long siteid;

    /**
     * @return colsId
     */
    public Long getColsid() {
        return colsid;
    }

    /**
     * @param colsid
     */
    public void setColsid(Long colsid) {
        this.colsid = colsid;
    }

    /**
     * 获取栏目名称
     *
     * @return columnName - 栏目名称
     */
    public String getColumnname() {
        return columnname;
    }

    /**
     * 设置栏目名称
     *
     * @param columnname 栏目名称
     */
    public void setColumnname(String columnname) {
        this.columnname = columnname;
    }

    /**
     * 获取栏目类型
     *
     * @return colTypeId - 栏目类型
     */
    public Long getColtypeid() {
        return coltypeid;
    }

    /**
     * 设置栏目类型
     *
     * @param coltypeid 栏目类型
     */
    public void setColtypeid(Long coltypeid) {
        this.coltypeid = coltypeid;
    }

    /**
     * 获取栏目显示顺序
     *
     * @return sortNum - 栏目显示顺序
     */
    public Integer getSortnum() {
        return sortnum;
    }

    /**
     * 设置栏目显示顺序
     *
     * @param sortnum 栏目显示顺序
     */
    public void setSortnum(Integer sortnum) {
        this.sortnum = sortnum;
    }

    /**
     * 获取是否显示
     *
     * @return columndisplay - 是否显示
     */
    public Integer getColumndisplay() {
        return columndisplay;
    }

    /**
     * 设置是否显示
     *
     * @param columndisplay 是否显示
     */
    public void setColumndisplay(Integer columndisplay) {
        this.columndisplay = columndisplay;
    }

    /**
     * 获取连接打开方式
     *
     * @return openWay - 连接打开方式
     */
    public String getOpenway() {
        return openway;
    }

    /**
     * 设置连接打开方式
     *
     * @param openway 连接打开方式
     */
    public void setOpenway(String openway) {
        this.openway = openway;
    }

    /**
     * 获取外链地址
     *
     * @return columnOutside - 外链地址
     */
    public String getColumnoutside() {
        return columnoutside;
    }

    /**
     * 设置外链地址
     *
     * @param columnoutside 外链地址
     */
    public void setColumnoutside(String columnoutside) {
        this.columnoutside = columnoutside;
    }

    /**
     * 获取栏目图片
     *
     * @return columnpic - 栏目图片
     */
    public String getColumnpic() {
        return columnpic;
    }

    /**
     * 设置栏目图片
     *
     * @param columnpic 栏目图片
     */
    public void setColumnpic(String columnpic) {
        this.columnpic = columnpic;
    }

    /**
     * 获取父栏目ID
     *
     * @return parentId - 父栏目ID
     */
    public Integer getParentid() {
        return parentid;
    }

    /**
     * 设置父栏目ID
     *
     * @param parentid 父栏目ID
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    /**
     * 获取treetable排序使用
     *
     * @return parentIds - treetable排序使用
     */
    public String getParentids() {
        return parentids;
    }

    /**
     * 设置treetable排序使用
     *
     * @param parentids treetable排序使用
     */
    public void setParentids(String parentids) {
        this.parentids = parentids;
    }

    /**
     * 获取栏目所属站点
     *
     * @return siteId - 栏目所属站点
     */
    public Long getSiteid() {
        return siteid;
    }

    /**
     * 设置栏目所属站点
     *
     * @param siteid 栏目所属站点
     */
    public void setSiteid(Long siteid) {
        this.siteid = siteid;
    }
}