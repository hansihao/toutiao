package edu.nciae.news.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class NewsVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "新闻表id")
    private Long newsId;

    @ApiModelProperty(value = "发表用户id")
    private Integer userId;

    @ApiModelProperty(value = "发表用户的作者")
    private String userName;

    @ApiModelProperty(value = "发表用户头像")
    private String avatar;

    @ApiModelProperty(value = "是否关注作者: 0 无关注， 1 已关注")
    private Integer isfollow;

    @ApiModelProperty(value = "用户对文章的态度, 0: 无态度，1-不喜欢，2-点赞")
    private Integer attitude;

    @ApiModelProperty(value = "是否收藏文章: 0 无， 1 已收藏")
    private Integer iscollection;

    @ApiModelProperty(value = "文章标题")
    private String newsTitle;

    @ApiModelProperty(value = "发表时间")
    private Date postTime;

    @ApiModelProperty(value = "文字内容")
    private String content;

    @ApiModelProperty(value = "阅读量")
    private Integer readingVolume;

    @ApiModelProperty(value = "点赞量")
    private Integer praisePoints;

    @ApiModelProperty(value = "收藏量")
    private Integer collectionVolume;

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
        sb.append(", readingVolume=").append(readingVolume);
        sb.append(", praisePoints=").append(praisePoints);
        sb.append(", collectionVolume=").append(collectionVolume);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
