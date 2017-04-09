package cn.v5cn.v5cms.entity;

import javax.persistence.*;

@Table(name = "leave_word_type")
public class LeaveWordType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 留言类型名称
     */
    private String name;

    /**
     * 留言类型顺序
     */
    @Column(name = "sortNum")
    private Integer sortnum;

    /**
     * 留言类型描述
     */
    private String lwdes;

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
     * 获取留言类型名称
     *
     * @return name - 留言类型名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置留言类型名称
     *
     * @param name 留言类型名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取留言类型顺序
     *
     * @return sortNum - 留言类型顺序
     */
    public Integer getSortnum() {
        return sortnum;
    }

    /**
     * 设置留言类型顺序
     *
     * @param sortnum 留言类型顺序
     */
    public void setSortnum(Integer sortnum) {
        this.sortnum = sortnum;
    }

    /**
     * 获取留言类型描述
     *
     * @return lwdes - 留言类型描述
     */
    public String getLwdes() {
        return lwdes;
    }

    /**
     * 设置留言类型描述
     *
     * @param lwdes 留言类型描述
     */
    public void setLwdes(String lwdes) {
        this.lwdes = lwdes;
    }
}