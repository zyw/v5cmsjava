package cn.v5cn.v5cms.entity;

import javax.persistence.*;

@Table(name = "content_label")
public class ContentLabel {
    @Id
    @Column(name = "content_labelId")
    private Long contentLabelid;

    @Column(name = "contentId")
    private Integer contentid;

    @Column(name = "labelId")
    private Integer labelid;

    /**
     * @return content_labelId
     */
    public Long getContentLabelid() {
        return contentLabelid;
    }

    /**
     * @param contentLabelid
     */
    public void setContentLabelid(Long contentLabelid) {
        this.contentLabelid = contentLabelid;
    }

    /**
     * @return contentId
     */
    public Integer getContentid() {
        return contentid;
    }

    /**
     * @param contentid
     */
    public void setContentid(Integer contentid) {
        this.contentid = contentid;
    }

    /**
     * @return labelId
     */
    public Integer getLabelid() {
        return labelid;
    }

    /**
     * @param labelid
     */
    public void setLabelid(Integer labelid) {
        this.labelid = labelid;
    }
}