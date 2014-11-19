package cn.v5cn.v5cms.entity.wrapper;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ZYW on 2014/11/19.
 */
public class ZTreeNode implements Serializable {
    private Long id;
    private String name;
    private List<ZTreeNode> children;

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

    public List<ZTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<ZTreeNode> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "ZTreeNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", children=" + children +
                '}';
    }
}
