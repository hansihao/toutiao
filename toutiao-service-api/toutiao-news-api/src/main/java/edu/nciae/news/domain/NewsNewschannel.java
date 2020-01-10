package edu.nciae.news.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class NewsNewschannel implements Serializable {
    @ApiModelProperty(value = "新闻频道关联表id")
    private Long newsNewschannelId;

    @ApiModelProperty(value = "新闻id")
    private Long newsId;

    @ApiModelProperty(value = "频道id")
    private Integer newchannelId;

    @ApiModelProperty(value = "是否有效：0有效，1无效")
    private String status;

    private static final long serialVersionUID = 1L;

    public Long getNewsNewschannelId() {
        return newsNewschannelId;
    }

    public void setNewsNewschannelId(Long newsNewschannelId) {
        this.newsNewschannelId = newsNewschannelId;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public Integer getNewchannelId() {
        return newchannelId;
    }

    public void setNewchannelId(Integer newchannelId) {
        this.newchannelId = newchannelId;
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
        sb.append(", newsNewschannelId=").append(newsNewschannelId);
        sb.append(", newsId=").append(newsId);
        sb.append(", newchannelId=").append(newchannelId);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}