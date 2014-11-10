package cn.v5cn.v5cms.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ZYW on 2014/11/5.
 */

@Entity
@Table(name = "coltype")
public class ColumnType implements Serializable {
    private Long colTypeId;
    private String colTypeName;                 //类型名称
    private String coltpl;                      //栏目模板名称
    private String contenttpl;                  //内容模板名称
    private int colsort;                        //栏目排序
    private int hasContent;                     //是否有内容页
    private int isDisabled=1;                     //是否可用
    private Long siteId;                //站点ID

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getColTypeId() {
        return colTypeId;
    }

    public void setColTypeId(Long colTypeId) {
        this.colTypeId = colTypeId;
    }

    public String getColTypeName() {
        return colTypeName;
    }

    public void setColTypeName(String colTypeName) {
        this.colTypeName = colTypeName;
    }

    public String getColtpl() {
        return coltpl;
    }

    public void setColtpl(String coltpl) {
        this.coltpl = coltpl;
    }

    public String getContenttpl() {
        return contenttpl;
    }

    public void setContenttpl(String contenttpl) {
        this.contenttpl = contenttpl;
    }

    public int getColsort() {
        return colsort;
    }

    public void setColsort(int colsort) {
        this.colsort = colsort;
    }

    public int getHasContent() {
        return hasContent;
    }

    public void setHasContent(int hasContent) {
        this.hasContent = hasContent;
    }

    public int getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(int isDisabled) {
        this.isDisabled = isDisabled;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    @Override
    public String toString() {
        return "ColumnType{" +
                "colTypeId=" + colTypeId +
                ", colTypeName='" + colTypeName + '\'' +
                ", coltpl='" + coltpl + '\'' +
                ", contenttpl='" + contenttpl + '\'' +
                ", colsort=" + colsort +
                ", hasContent=" + hasContent +
                ", isDisabled=" + isDisabled +
                ", siteId=" + siteId +
                '}';
    }
}
