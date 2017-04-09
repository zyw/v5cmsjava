package cn.v5cn.v5cms.entity;

import javax.persistence.*;

public class Label {
    @Id
    @Column(name = "labelId")
    private Long labelid;

    /**
     * 标签名称
     */
    @Column(name = "labelName")
    private String labelname;

    /**
     * 标签别名
     */
    private String alias;

    /**
     * @return labelId
     */
    public Long getLabelid() {
        return labelid;
    }

    /**
     * @param labelid
     */
    public void setLabelid(Long labelid) {
        this.labelid = labelid;
    }

    /**
     * 获取标签名称
     *
     * @return labelName - 标签名称
     */
    public String getLabelname() {
        return labelname;
    }

    /**
     * 设置标签名称
     *
     * @param labelname 标签名称
     */
    public void setLabelname(String labelname) {
        this.labelname = labelname;
    }

    /**
     * 获取标签别名
     *
     * @return alias - 标签别名
     */
    public String getAlias() {
        return alias;
    }

    /**
     * 设置标签别名
     *
     * @param alias 标签别名
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }
}