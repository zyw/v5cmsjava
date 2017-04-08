package cn.v5cn.v5cms.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ZXF-PC1 on 2015/7/28.
 */
@Entity
@Table
public class Comments implements Serializable {

    private Long commentsId;
    private String commentAuthor;    //评论者姓名
    private String email;            //评论者的Email地址
    private String commentContent;   //评语内容
    private String reply;            //评论回复
    private String siteURL;          //评论者的站点URL
    private String commentIP;        //评语者的IP地址
    private Date commentDate;        //评语时间
    private Integer recommend;       //是否推荐
    private Integer commentApproved; //评语是否批准 0:待审批，1:通过审批，2:垃圾评语
    private Long commentParent;      //父评语ID

    private Content content;         //评语所属内容

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(Long commentsId) {
        this.commentsId = commentsId;
    }

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getSiteURL() {
        return siteURL;
    }

    public void setSiteURL(String siteURL) {
        this.siteURL = siteURL;
    }

    public String getCommentIP() {
        return commentIP;
    }

    public void setCommentIP(String commentIP) {
        this.commentIP = commentIP;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public Integer getCommentApproved() {
        return commentApproved;
    }

    public void setCommentApproved(Integer commentApproved) {
        this.commentApproved = commentApproved;
    }

    public Long getCommentParent() {
        return commentParent;
    }

    public void setCommentParent(Long commentParent) {
        this.commentParent = commentParent;
    }

    @ManyToOne
    @JoinColumn(name = "contentId")
    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "commentsId=" + commentsId +
                ", commentAuthor='" + commentAuthor + '\'' +
                ", email='" + email + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", reply='" + reply + '\'' +
                ", siteURL='" + siteURL + '\'' +
                ", commentIP='" + commentIP + '\'' +
                ", commentDate=" + commentDate +
                ", recommend=" + recommend +
                ", commentApproved=" + commentApproved +
                ", commentParent=" + commentParent +
                ", content=" + content +
                '}';
    }
}
