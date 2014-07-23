package cn.v5cn.v5cms.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ZYW on 2014/7/23.
 */
@Entity
@Table
public class AdvPos implements Serializable {
    private Long advPosId;
    @NotEmpty
    private String advPosName;       //版位名称
    private int advPosState;        //状态0:关闭，1:启用
    private String advPosDes;        //描述
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getAdvPosId() {
        return advPosId;
    }

    public void setAdvPosId(Long advPosId) {
        this.advPosId = advPosId;
    }

    public String getAdvPosName() {
        return advPosName;
    }

    public void setAdvPosName(String advPosName) {
        this.advPosName = advPosName;
    }

    public int getAdvPosState() {
        return advPosState;
    }

    public void setAdvPosState(int advPosState) {
        this.advPosState = advPosState;
    }

    public String getAdvPosDes() {
        return advPosDes;
    }

    public void setAdvPosDes(String advPosDes) {
        this.advPosDes = advPosDes;
    }

    @Override
    public String toString() {
        return "AdvPos{" +
                "advPosId=" + advPosId +
                ", dvPosName='" + advPosName + '\'' +
                ", advPosState=" + advPosState +
                ", advPosDes='" + advPosDes + '\'' +
                '}';
    }
}