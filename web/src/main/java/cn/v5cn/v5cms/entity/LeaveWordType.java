package cn.v5cn.v5cms.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ZXF-PC1 on 2015/7/28.
 */
@Entity
@Table(name = "leave_word_type")
public class LeaveWordType implements Serializable {
    private Long id;
    private String name;            //留言类型名称
    private Integer sortNum;        //留言类型顺序
    private String lwdes;           //留言类型描述

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

    public String getLwdes() {
        return lwdes;
    }

    public void setLwdes(String lwdes) {
        this.lwdes = lwdes;
    }

    @Override
    public String toString() {
        return "LeaveWordType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sortNum=" + sortNum +
                ", lwdes='" + lwdes + '\'' +
                '}';
    }
}
