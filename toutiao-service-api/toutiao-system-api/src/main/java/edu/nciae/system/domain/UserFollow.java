package edu.nciae.system.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class UserFollow implements Serializable {
    @ApiModelProperty(value = "关注关系表id")
    private Integer followId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "被关注者id")
    private Integer followUser;

    @ApiModelProperty(value = "关注时间")
    private Date createTime;

    @ApiModelProperty(value = "关注状态:0 关注，1取消关注")
    private String status;

    private static final long serialVersionUID = 1L;

    public Integer getFollowId() {
        return followId;
    }

    public void setFollowId(Integer followId) {
        this.followId = followId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFollowUser() {
        return followUser;
    }

    public void setFollowUser(Integer followUser) {
        this.followUser = followUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        sb.append(", followId=").append(followId);
        sb.append(", userId=").append(userId);
        sb.append(", followUser=").append(followUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}