package cn.v5cn.v5cms.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ZYW on 2014/11/19.
 */
@Entity
@Table(name = "content")
public class Content implements Serializable {
    private Long contentId;
    private Long columnId;
    private String cname;               //内容标题
    private String cbody;               //发布的内容
    private String lastdt;              //最后更新的时间
    private Long writerId;              //作者ID
    private Integer stick;              //是否置顶，1：置顶，2：反之
    private Integer stickNum;           //置顶序号，只有是置顶状态，才起作用
    private Integer isdraft;            //是否是草稿，1：是，0：否
    private Integer publish;            //是否发布，1：是，0：否
    private String cpics;               //与文章关联的图片，多个使用逗号分割
    private String cattas;              //文章中使用的附件，多个使用丢号分割
    private String dispic;              //展示图

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public Long getColumnId() {
        return columnId;
    }

    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCbody() {
        return cbody;
    }

    public void setCbody(String cbody) {
        this.cbody = cbody;
    }

    public String getLastdt() {
        return lastdt;
    }

    public void setLastdt(String lastdt) {
        this.lastdt = lastdt;
    }

    public Long getWriterId() {
        return writerId;
    }

    public void setWriterId(Long writerId) {
        this.writerId = writerId;
    }

    public Integer getStick() {
        return stick;
    }

    public void setStick(Integer stick) {
        this.stick = stick;
    }

    public Integer getStickNum() {
        return stickNum;
    }

    public void setStickNum(Integer stickNum) {
        this.stickNum = stickNum;
    }

    public Integer getIsdraft() {
        return isdraft;
    }

    public void setIsdraft(Integer isdraft) {
        this.isdraft = isdraft;
    }

    public Integer getPublish() {
        return publish;
    }

    public void setPublish(Integer publish) {
        this.publish = publish;
    }

    public String getCpics() {
        return cpics;
    }

    public void setCpics(String cpics) {
        this.cpics = cpics;
    }

    public String getCattas() {
        return cattas;
    }

    public void setCattas(String cattas) {
        this.cattas = cattas;
    }

    public String getDispic() {
        return dispic;
    }

    public void setDispic(String dispic) {
        this.dispic = dispic;
    }

    @Override
    public String toString() {
        return "Content{" +
                "contentId=" + contentId +
                ", columnId=" + columnId +
                ", cname='" + cname + '\'' +
                ", cbody='" + cbody + '\'' +
                ", lastdt='" + lastdt + '\'' +
                ", writerId=" + writerId +
                ", stick=" + stick +
                ", stickNum=" + stickNum +
                ", isdraft=" + isdraft +
                ", publish=" + publish +
                ", cpics='" + cpics + '\'' +
                ", cattas='" + cattas + '\'' +
                ", dispic='" + dispic + '\'' +
                '}';
    }
}
