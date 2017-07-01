package cn.v5cn.v5cms.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "system_role")
public class SystemRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "sortNum")
    private Integer sortnum;

    private Long pid;

    private String des;

    /**
     * 1 可用 0 不可用
     */
    private Integer available;

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