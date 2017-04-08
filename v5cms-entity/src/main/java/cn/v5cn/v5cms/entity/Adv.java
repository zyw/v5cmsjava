package cn.v5cn.v5cms.entity;

import cn.v5cn.v5cms.util.annotation.Ignore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ZYW on 2014/7/28.
 */
@Table
@Entity
public class Adv implements Serializable {
    private Long advId;
    private String advName;
    private String advStartTime;
    private String advEndTime;
    private int startUsing;         //1：启用 0：关闭
    private int advType;            //1: 图片，2：Flash，3：文本，4：代码
    private Date createDate;        //创建时间
    private String advCode;         //广告代码
    private String advTypeInfo;     //包含广告类型信息的JSON字符串

    private AdvPos advPos;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getAdvId() {
        return advId;
    }

    public void setAdvId(Long advId) {
        this.advId = advId;
    }

    public String getAdvName() {
        return advName;
    }

    public void setAdvName(String advName) {
        this.advName = advName;
    }

    public String getAdvStartTime() {
        return advStartTime;
    }

    public void setAdvStartTime(String advStartTime) {
        this.advStartTime = advStartTime;
    }

    public String getAdvEndTime() {
        return advEndTime;
    }

    public void setAdvEndTime(String advEndTime) {
        this.advEndTime = advEndTime;
    }

    public int getStartUsing() {
        return startUsing;
    }

    public void setStartUsing(int startUsing) {
        this.startUsing = startUsing;
    }

    public int getAdvType() {
        return advType;
    }

    public void setAdvType(int advType) {
        this.advType = advType;
    }
    @Ignore
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAdvCode() {
        return advCode;
    }

    public void setAdvCode(String advCode) {
        this.advCode = advCode;
    }

    public String getAdvTypeInfo() {
        return advTypeInfo;
    }

    public void setAdvTypeInfo(String advTypeInfo) {
        this.advTypeInfo = advTypeInfo;
    }

    @ManyToOne()
    @JoinColumn(name = "advPosId")
    public AdvPos getAdvPos() {
        return advPos;
    }

    public void setAdvPos(AdvPos advPos) {
        this.advPos = advPos;
    }

    @Override
    public String toString() {
        return "Adv{" +
                "advId=" + advId +
                ", advName='" + advName + '\'' +
                ", advStartTime='" + advStartTime + '\'' +
                ", advEndTime='" + advEndTime + '\'' +
                ", startUsing=" + startUsing +
                ", advType=" + advType +
                ", createDate=" + createDate +
                ", advCode='" + advCode + '\'' +
                ", advTypeInfo='" + advTypeInfo + '\'' +
                ", advPos=" + advPos +
                '}';
    }
}
