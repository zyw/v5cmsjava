package cn.v5cn.v5cms.entity;

import com.google.common.collect.Sets;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by ZXF-PC1 on 2015/6/26.
 */
@Entity
@Table(name = "system_role")
public class SystemRole implements Serializable {
    private Long id;
    private String name;
    private Integer sortNum;
    private Long pid;
    private String des;
    private Integer available;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }


    private Set<SystemRes> reses = Sets.newHashSet();

    @ManyToMany
    @JoinTable(name = "system_role_res",joinColumns = @JoinColumn(name = "role_id"),inverseJoinColumns = @JoinColumn(name = "res_id"))
    public Set<SystemRes> getReses() {
        return reses;
    }

    public void setReses(Set<SystemRes> reses) {
        this.reses = reses;
    }

    @Override
    public String toString() {
        return "SystemRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sortNum=" + sortNum +
                ", pid=" + pid +
                ", des='" + des + '\'' +
                ", available=" + available +
                '}';
    }
}
