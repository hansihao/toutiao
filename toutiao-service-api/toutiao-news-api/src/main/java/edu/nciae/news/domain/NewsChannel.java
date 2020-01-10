package edu.nciae.news.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class NewsChannel implements Serializable {
    @ApiModelProperty(value = "频道表id")
    private Integer channelId;

    @ApiModelProperty(value = "频道表名称")
    private String channelName;

    @ApiModelProperty(value = "是否默认：0是，1否")
    private String isdefault;

    @ApiModelProperty(value = "是否删除：0否，1删除")
    private String status;

    private static final long serialVersionUID = 1L;

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(String isdefault) {
        this.isdefault = isdefault;
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
        sb.append(", channelId=").append(channelId);
        sb.append(", channelName=").append(channelName);
        sb.append(", isdefault=").append(isdefault);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}