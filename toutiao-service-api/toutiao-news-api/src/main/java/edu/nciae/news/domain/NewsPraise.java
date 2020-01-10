package edu.nciae.news.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class NewsPraise implements Serializable {
    @ApiModelProperty(value = "点赞表id")
    private Long praiseId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "新闻id")
    private Long newsId;

    @ApiModelProperty(value = "状态：0 点赞 1 取消点赞")
    private String status;

    @ApiModelProperty(value = "点赞时间")
    private Date praiseTime;

    private static final long serialVersionUID = 1L;

    public Long getPraiseId() {
        return praiseId;
    }

    public void setPraiseId(Long praiseId) {
        this.praiseId = praiseId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPraiseTime() {
        return praiseTime;
    }

    public void setPraiseTime(Date praiseTime) {
        this.praiseTime = praiseTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", praiseId=").append(praiseId);
        sb.append(", userId=").append(userId);
        sb.append(", newsId=").append(newsId);
        sb.append(", status=").append(status);
        sb.append(", praiseTime=").append(praiseTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}