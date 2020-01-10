package edu.nciae.news.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable {
    @ApiModelProperty(value = "新闻表id")
    private Long newsId;

    @ApiModelProperty(value = "发表用户id")
    private Integer userId;

    @ApiModelProperty(value = "文章标题")
    private String newsTitle;

    @ApiModelProperty(value = "发表时间")
    private Date postTime;

    @ApiModelProperty(value = "文字内容")
    private String content;

    @ApiModelProperty(value = "新闻状态：0 正常 1： 删除")
    private String status;

    @ApiModelProperty(value = "阅读量")
    private Integer readingVolume;

    @ApiModelProperty(value = "点赞量")
    private Integer praisePoints;

    @ApiModelProperty(value = "收藏量")
    private Integer collectionVolume;

    private static final long serialVersionUID = 1L;

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getReadingVolume() {
        return readingVolume;
    }

    public void setReadingVolume(Integer readingVolume) {
        this.readingVolume = readingVolume;
    }

    public Integer getPraisePoints() {
        return praisePoints;
    }

    public void setPraisePoints(Integer praisePoints) {
        this.praisePoints = praisePoints;
    }

    public Integer getCollectionVolume() {
        return collectionVolume;
    }

    public void setCollectionVolume(Integer collectionVolume) {
        this.collectionVolume = collectionVolume;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", newsId=").append(newsId);
        sb.append(", userId=").append(userId);
        sb.append(", newsTitle=").append(newsTitle);
        sb.append(", postTime=").append(postTime);
        sb.append(", content=").append(content);
        sb.append(", status=").append(status);
        sb.append(", readingVolume=").append(readingVolume);
        sb.append(", praisePoints=").append(praisePoints);
        sb.append(", collectionVolume=").append(collectionVolume);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}