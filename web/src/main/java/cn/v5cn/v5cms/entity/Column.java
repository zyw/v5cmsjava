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
    private int sortNum;               //栏目显示顺序
    private int columndisplay=1;       //是否显示
    private String openWay;            //连接打开方式
    private String columnOutside;      //外链地址
    private String columnpic;          //栏目图片
    private Long parentId;             //父栏目ID
    private String parentIds;          //treetable排序使用
    private Long siteId;               //站点ID

    private ColumnType columnType;     //栏目类型

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

    public int getSortNum() {
        return sortNum;
    }

    public void setSortNum(int sortNum) {
        this.sortNum = sortNum;
    }

    public int getColumndisplay() {
        return columndisplay;
    }

    public void setColumndisplay(int columndisplay) {
        this.columndisplay = columndisplay;
    }

    public String getOpenWay() {
        return openWay;
    }

    public void setOpenWay(String openWay) {
        this.openWay = openWay;
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

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    @ManyToOne
    @JoinColumn(name = "colTypeId")
    public ColumnType getColumnType() {
        return columnType;
    }

    public void setColumnType(ColumnType columnType) {
        this.columnType = columnType;
    }

    @Override
    public String toString() {
        return "Column{" +
                "colsId=" + colsId +
                ", columnName='" + columnName + '\'' +
                ", sortNum=" + sortNum +
                ", columndisplay=" + columndisplay +
                ", openWay=" + openWay +
                ", columnOutside='" + columnOutside + '\'' +
                ", columnpic='" + columnpic + '\'' +
                ", parentId=" + parentId +
                ", parentIds='" + parentIds + '\'' +
                ", siteId=" + siteId +
                ", columnType=" + columnType +
                '}';
    }
}
