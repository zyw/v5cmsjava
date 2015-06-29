package cn.v5cn.v5cms.entity;

import com.google.common.collect.Sets;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by ZYW on 2014/10/14.
 */
@Entity
@Table(name = "system_res")
public class SystemRes implements Serializable {
    private Long id;
    private Long pid;
    private String name;
    private String permission;
    private String url;
    private Integer sortNum;        /*排序*/
    private String icon;
    private String pids;            /*TreeTable排序*/
    private Integer type;       //1 菜单 2 按钮
    private Integer available;  //1 可用 0 不可用
    private String des;

//    private List<SystemRes> children;

//    private boolean isParent = false;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    /*public boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(boolean isParent) {
        this.isParent = isParent;
    }

    public String catPids(){
        return this.pids+this.getId()+"/";
    }*/

    /*public List<SystemRes> getChildren() {
        return children;
    }

    public void setChildren(List<SystemRes> children) {
        this.children = children;
    }*/

    private Set<SystemRole> roles = Sets.newHashSet();

    @ManyToMany(mappedBy = "reses")
    public Set<SystemRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SystemRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "SystemRes{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", permission='" + permission + '\'' +
                ", url='" + url + '\'' +
                ", sortNum=" + sortNum +
                ", icon=" + icon +
                ", pids=" + pids +
                ", type=" + type +
                ", available=" + available +
                ", des='" + des + '\'' +
                '}';
    }
}
