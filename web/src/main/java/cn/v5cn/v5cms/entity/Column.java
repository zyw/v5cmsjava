package cn.v5cn.v5cms.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ZYW on 2014/10/31.
 */
@Entity
@Table(name = "cols")
public class Column implements Serializable {
    private Long colsId;
    private String columnName;          //栏目名称
    private String columnlht;           //栏目列表页头模板
    private String columnlbt;           //栏目列表主体模板
    private String columncht;           //内容页头模板
    private String columncbt;           //内容也主体模板
    private int columnds;               //栏目显示顺序
    private int columndisplay;          //是否显示
    private int columnot;               //连接打开方式
    private String columnOutside;       //外链地址
    private String columnpic;           //栏目图片
    private Long parentId;              //父栏目ID
    private String parentIds;           //treetable排序使用

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getColsId() {
        return colsId;
    }

    public void setColsId(Long colsId) {
        this.colsId = colsId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnlht() {
        return columnlht;
    }

    public void setColumnlht(String columnlht) {
        this.columnlht = columnlht;
    }

    public String getColumnlbt() {
        return columnlbt;
    }

    public void setColumnlbt(String columnlbt) {
        this.columnlbt = columnlbt;
    }

    public String getColumncht() {
        return columncht;
    }

    public void setColumncht(String columncht) {
        this.columncht = columncht;
    }

    public String getColumncbt() {
        return columncbt;
    }

    public void setColumncbt(String columncbt) {
        this.columncbt = columncbt;
    }

    public int getColumnds() {
        return columnds;
    }

    public void setColumnds(int columnds) {
        this.columnds = columnds;
    }

    public int getColumndisplay() {
        return columndisplay;
    }

    public void setColumndisplay(int columndisplay) {
        this.columndisplay = columndisplay;
    }

    public int getColumnot() {
        return columnot;
    }

    public void setColumnot(int columnot) {
        this.columnot = columnot;
    }

    public String getColumnOutside() {
        return columnOutside;
    }

    public void setColumnOutside(String columnOutside) {
        this.columnOutside = columnOutside;
    }

    public String getColumnpic() {
        return columnpic;
    }

    public void setColumnpic(String columnpic) {
        this.columnpic = columnpic;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    @Override
    public String toString() {
        return "Column{" +
                "colsId=" + colsId +
                ", columnName='" + columnName + '\'' +
                ", columnlht='" + columnlht + '\'' +
                ", columnlbt='" + columnlbt + '\'' +
                ", columncht='" + columncht + '\'' +
                ", columncbt='" + columncbt + '\'' +
                ", columnds=" + columnds +
                ", columndisplay=" + columndisplay +
                ", columnot=" + columnot +
                ", columnOutside='" + columnOutside + '\'' +
                ", columnpic='" + columnpic + '\'' +
                ", parentId=" + parentId +
                ", parentIds=" + parentIds +
                '}';
    }
}
