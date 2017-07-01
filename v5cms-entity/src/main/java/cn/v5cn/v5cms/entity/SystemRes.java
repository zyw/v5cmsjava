package cn.v5cn.v5cms.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "system_res")
public class SystemRes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pid;

    private String name;

    private String permission;

    private String url;

    @Column(name = "sortNum")
    private Integer sortnum;

    private String icon;

    /**
     * TreeTable排序
     */
    private String pids;

    /**
     * 1 菜单 2 按钮
     */
    private Integer type;

    /**
     * 1 可用 0 不可用
     */
    private Integer available;

    private String des;

    @Column(name = "isParent")
    private Boolean isparent;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return pid
     */
    public Long getPid() {
        return pid;
    }

    /**
     * @param pid
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return permission
     */
    public String getPermission() {
        return permission;
    }

    /**
     * @param permission
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return sortNum
     */
    public Integer getSortnum() {
        return sortnum;
    }

    /**
     * @param sortnum
     */
    public void setSortnum(Integer sortnum) {
        this.sortnum = sortnum;
    }

    /**
     * @return icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取TreeTable排序
     *
     * @return pids - TreeTable排序
     */
    public String getPids() {
        return pids;
    }

    /**
     * 设置TreeTable排序
     *
     * @param pids TreeTable排序
     */
    public void setPids(String pids) {
        this.pids = pids;
    }

    /**
     * 获取1 菜单 2 按钮
     *
     * @return type - 1 菜单 2 按钮
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置1 菜单 2 按钮
     *
     * @param type 1 菜单 2 按钮
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取1 可用 0 不可用
     *
     * @return available - 1 可用 0 不可用
     */
    public Integer getAvailable() {
        return available;
    }

    /**
     * 设置1 可用 0 不可用
     *
     * @param available 1 可用 0 不可用
     */
    public void setAvailable(Integer available) {
        this.available = available;
    }

    /**
     * @return des
     */
    public String getDes() {
        return des;
    }

    /**
     * @param des
     */
    public void setDes(String des) {
        this.des = des;
    }

    /**
     * @return isParent
     */
    public Boolean getIsparent() {
        return isparent;
    }

    /**
     * @param isparent
     */
    public void setIsparent(Boolean isparent) {
        this.isparent = isparent;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}