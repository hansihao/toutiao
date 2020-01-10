package edu.nciae.news.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class NewsComment implements Serializable {
    @ApiModelProperty(value = "评论id")
    private Long commentId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "新闻id")
    private Long newsId;

    @ApiModelProperty(value = "评论内容")
    private String commentContent;

    @ApiModelProperty(value = "评论时间")
    private Date commentTime;

    @ApiModelProperty(value = "评论状态：0：评论，1：删除")
    private String status;

    @ApiModelProperty(value = "评论点赞数")
    private Integer commentPraiseVolume;

    @ApiModelProperty(value = "评论的父id，如果没有则为0")
    private Long commentParentId;

    private static final long serialVersionUID = 1L;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCommentPraiseVolume() {
        return commentPraiseVolume;
    }

    public void setCommentPraiseVolume(Integer commentPraiseVolume) {
        this.commentPraiseVolume = commentPraiseVolume;
    }

    public Long getCommentParentId() {
        return commentParentId;
    }

    public void setCommentParentId(Long commentParentId) {
        this.commentParentId = commentParentId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", commentId=").append(commentId);
        sb.append(", userId=").append(userId);
        sb.append(", newsId=").append(newsId);
        sb.append(", commentContent=").append(commentContent);
        sb.append(", commentTime=").append(commentTime);
        sb.append(", status=").append(status);
        sb.append(", commentPraiseVolume=").append(commentPraiseVolume);
        sb.append(", commentParentId=").append(commentParentId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}