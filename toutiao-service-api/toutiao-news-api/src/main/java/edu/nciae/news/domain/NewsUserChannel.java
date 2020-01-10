package edu.nciae.news.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class NewsUserChannel implements Serializable {
    @ApiModelProperty(value = "用户频道表id")
    private Integer userChannelId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "频道id")
    private Integer channelId;

    @ApiModelProperty(value = "是否有效：0有效，1无效")
    private String status;

    private static final long serialVersionUID = 1L;

    public Integer getUserChannelId() {
        return userChannelId;
    }

    public void setUserChannelId(Integer userChannelId) {
        this.userChannelId = userChannelId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
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
        sb.append(", userChannelId=").append(userChannelId);
        sb.append(", userId=").append(userId);
        sb.append(", channelId=").append(channelId);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}