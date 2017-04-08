package cn.v5cn.v5cms.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ZXF-PC1 on 2015/7/28.
 */
@Entity
@Table(name = "leave_word")
public class LeaveWord implements Serializable {
    private Long id;
    private String title;           //留言标题
    private String content;         //留言内容
    private String reply;           //回复内容
    private String author;          //留言作者
    private String email;           //邮箱
    private String phone;           //电话
    private String qq;              //QQ
    private Integer recommend;      //是否推荐，1：推荐，0：不推荐
    private Integer approved;       //留言是否批准 0:待审批，1:通过审批，2:垃圾评语
    private Date lwtime;            //留言时间

    private LeaveWordType leaveWordType;    //留言类型

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public Integer getApproved() {
        return approved;
    }

    public void setApproved(Integer approved) {
        this.approved = approved;
    }

    public Date getLwtime() {
        return lwtime;
    }

    public void setLwtime(Date lwtime) {
        this.lwtime = lwtime;
    }

    @ManyToOne
    @JoinColumn(name = "lwtId")
    public LeaveWordType getLeaveWordType() {
        return leaveWordType;
    }

    public void setLeaveWordType(LeaveWordType leaveWordType) {
        this.leaveWordType = leaveWordType;
    }

    @Override
    public String toString() {
        return "LeaveWord{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", reply='" + reply + '\'' +
                ", author='" + author + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", qq='" + qq + '\'' +
                ", recommend=" + recommend +
                ", approved=" + approved +
                ", lwtime=" + lwtime +
                ", leaveWordType=" + leaveWordType +
                '}';
    }
}
