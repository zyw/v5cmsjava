package cn.v5cn.v5cms.entity;

import java.util.Date;
import javax.persistence.*;

public class Comments {
    @Id
    @Column(name = "commentsId")
    private Long commentsid;

    /**
     * 评语所属内容ID
     */
    @Column(name = "contentId")
    private Long contentid;

    /**
     * 评论者姓名
     */
    @Column(name = "commentAuthor")
    private String commentauthor;

    /**
     * 评论者的Email地址
     */
    private String email;

    /**
     * 评论者的站点URL
     */
    @Column(name = "siteURL")
    private String siteurl;

    /**
     * 评语者的IP地址
     */
    @Column(name = "commentIP")
    private String commentip;

    /**
     * 评语时间
     */
    @Column(name = "commentDate")
    private Date commentdate;

    /**
     * 是否推荐
     */
    private Integer recommend;

    /**
     * 评语是否批准 0:待审批，1:通过审批，2:垃圾评语
     */
    @Column(name = "commentApproved")
    private Integer commentapproved;

    /**
     * 父评语ID
     */
    @Column(name = "commentParent")
    private Long commentparent;

    /**
     * 评语内容
     */
    @Column(name = "commentContent")
    private String commentcontent;

    /**
     * 评论回复
     */
    private String reply;

    /**
     * @return commentsId
     */
    public Long getCommentsid() {
        return commentsid;
    }

    /**
     * @param commentsid
     */
    public void setCommentsid(Long commentsid) {
        this.commentsid = commentsid;
    }

    /**
     * 获取评语所属内容ID
     *
     * @return contentId - 评语所属内容ID
     */
    public Long getContentid() {
        return contentid;
    }

    /**
     * 设置评语所属内容ID
     *
     * @param contentid 评语所属内容ID
     */
    public void setContentid(Long contentid) {
        this.contentid = contentid;
    }

    /**
     * 获取评论者姓名
     *
     * @return commentAuthor - 评论者姓名
     */
    public String getCommentauthor() {
        return commentauthor;
    }

    /**
     * 设置评论者姓名
     *
     * @param commentauthor 评论者姓名
     */
    public void setCommentauthor(String commentauthor) {
        this.commentauthor = commentauthor;
    }

    /**
     * 获取评论者的Email地址
     *
     * @return email - 评论者的Email地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置评论者的Email地址
     *
     * @param email 评论者的Email地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取评论者的站点URL
     *
     * @return siteURL - 评论者的站点URL
     */
    public String getSiteurl() {
        return siteurl;
    }

    /**
     * 设置评论者的站点URL
     *
     * @param siteurl 评论者的站点URL
     */
    public void setSiteurl(String siteurl) {
        this.siteurl = siteurl;
    }

    /**
     * 获取评语者的IP地址
     *
     * @return commentIP - 评语者的IP地址
     */
    public String getCommentip() {
        return commentip;
    }

    /**
     * 设置评语者的IP地址
     *
     * @param commentip 评语者的IP地址
     */
    public void setCommentip(String commentip) {
        this.commentip = commentip;
    }

    /**
     * 获取评语时间
     *
     * @return commentDate - 评语时间
     */
    public Date getCommentdate() {
        return commentdate;
    }

    /**
     * 设置评语时间
     *
     * @param commentdate 评语时间
     */
    public void setCommentdate(Date commentdate) {
        this.commentdate = commentdate;
    }

    /**
     * 获取是否推荐
     *
     * @return recommend - 是否推荐
     */
    public Integer getRecommend() {
        return recommend;
    }

    /**
     * 设置是否推荐
     *
     * @param recommend 是否推荐
     */
    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    /**
     * 获取评语是否批准 0:待审批，1:通过审批，2:垃圾评语
     *
     * @return commentApproved - 评语是否批准 0:待审批，1:通过审批，2:垃圾评语
     */
    public Integer getCommentapproved() {
        return commentapproved;
    }

    /**
     * 设置评语是否批准 0:待审批，1:通过审批，2:垃圾评语
     *
     * @param commentapproved 评语是否批准 0:待审批，1:通过审批，2:垃圾评语
     */
    public void setCommentapproved(Integer commentapproved) {
        this.commentapproved = commentapproved;
    }

    /**
     * 获取父评语ID
     *
     * @return commentParent - 父评语ID
     */
    public Long getCommentparent() {
        return commentparent;
    }

    /**
     * 设置父评语ID
     *
     * @param commentparent 父评语ID
     */
    public void setCommentparent(Long commentparent) {
        this.commentparent = commentparent;
    }

    /**
     * 获取评语内容
     *
     * @return commentContent - 评语内容
     */
    public String getCommentcontent() {
        return commentcontent;
    }

    /**
     * 设置评语内容
     *
     * @param commentcontent 评语内容
     */
    public void setCommentcontent(String commentcontent) {
        this.commentcontent = commentcontent;
    }

    /**
     * 获取评论回复
     *
     * @return reply - 评论回复
     */
    public String getReply() {
        return reply;
    }

    /**
     * 设置评论回复
     *
     * @param reply 评论回复
     */
    public void setReply(String reply) {
        this.reply = reply;
    }
}