package cn.v5cn.v5cms.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "leave_word")
public class LeaveWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 留言类型ID
     */
    @Column(name = "lwtId")
    private Long lwtid;

    /**
     * 留言标题
     */
    private String title;

    /**
     * 留言作者
     */
    private String author;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * QQ
     */
    private String qq;

    /**
     * 是否推荐，1：推荐，0：不推荐
     */
    private Integer recommend;

    /**
     * 留言是否批准 0:待审批，1:通过审批，2:垃圾评语
     */
    private Integer approved;

    /**
     * 留言时间
     */
    private Date lwtime;

    /**
     * 留言内容
     */
    private String content;

    /**
     * 回复内容
     */
    private String reply;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取留言类型ID
     *
     * @return lwtId - 留言类型ID
     */
    public Long getLwtid() {
        return lwtid;
    }

    /**
     * 设置留言类型ID
     *
     * @param lwtid 留言类型ID
     */
    public void setLwtid(Long lwtid) {
        this.lwtid = lwtid;
    }

    /**
     * 获取留言标题
     *
     * @return title - 留言标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置留言标题
     *
     * @param title 留言标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取留言作者
     *
     * @return author - 留言作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置留言作者
     *
     * @param author 留言作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取QQ
     *
     * @return qq - QQ
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置QQ
     *
     * @param qq QQ
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获取是否推荐，1：推荐，0：不推荐
     *
     * @return recommend - 是否推荐，1：推荐，0：不推荐
     */
    public Integer getRecommend() {
        return recommend;
    }

    /**
     * 设置是否推荐，1：推荐，0：不推荐
     *
     * @param recommend 是否推荐，1：推荐，0：不推荐
     */
    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    /**
     * 获取留言是否批准 0:待审批，1:通过审批，2:垃圾评语
     *
     * @return approved - 留言是否批准 0:待审批，1:通过审批，2:垃圾评语
     */
    public Integer getApproved() {
        return approved;
    }

    /**
     * 设置留言是否批准 0:待审批，1:通过审批，2:垃圾评语
     *
     * @param approved 留言是否批准 0:待审批，1:通过审批，2:垃圾评语
     */
    public void setApproved(Integer approved) {
        this.approved = approved;
    }

    /**
     * 获取留言时间
     *
     * @return lwtime - 留言时间
     */
    public Date getLwtime() {
        return lwtime;
    }

    /**
     * 设置留言时间
     *
     * @param lwtime 留言时间
     */
    public void setLwtime(Date lwtime) {
        this.lwtime = lwtime;
    }

    /**
     * 获取留言内容
     *
     * @return content - 留言内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置留言内容
     *
     * @param content 留言内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取回复内容
     *
     * @return reply - 回复内容
     */
    public String getReply() {
        return reply;
    }

    /**
     * 设置回复内容
     *
     * @param reply 回复内容
     */
    public void setReply(String reply) {
        this.reply = reply;
    }
}