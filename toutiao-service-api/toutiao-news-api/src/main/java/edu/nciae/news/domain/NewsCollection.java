package edu.nciae.news.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class NewsCollection implements Serializable {
    @ApiModelProperty(value = "收藏表id")
    private Long collectionId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "新闻id")
    private Long newsId;

    @ApiModelProperty(value = "收藏状态：0：收藏，1：取消收藏")
    private String status;

    @ApiModelProperty(value = "收藏时间")
    private Date collectionTime;

    private static final long serialVersionUID = 1L;

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
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

    public Date getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Date collectionTime) {
        this.collectionTime = collectionTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", collectionId=").append(collectionId);
        sb.append(", userId=").append(userId);
        sb.append(", newsId=").append(newsId);
        sb.append(", status=").append(status);
        sb.append(", collectionTime=").append(collectionTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}