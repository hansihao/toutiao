package edu.nciae.news.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class NewsDislike implements Serializable {
    @ApiModelProperty(value = "不喜欢表id")
    private Long dislikeId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "新闻id")
    private Long newsId;

    @ApiModelProperty(value = "操作时间")
    private Date dislikeTime;

    @ApiModelProperty(value = "有效状态：0 有效 1 无效")
    private String status;

    private static final long serialVersionUID = 1L;

    public Long getDislikeId() {
        return dislikeId;
    }

    public void setDislikeId(Long dislikeId) {
        this.dislikeId = dislikeId;
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

    public Date getDislikeTime() {
        return dislikeTime;
    }

    public void setDislikeTime(Date dislikeTime) {
        this.dislikeTime = dislikeTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dislikeId=").append(dislikeId);
        sb.append(", userId=").append(userId);
        sb.append(", newsId=").append(newsId);
        sb.append(", dislikeTime=").append(dislikeTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}