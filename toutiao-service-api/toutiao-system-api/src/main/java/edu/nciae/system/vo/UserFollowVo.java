package edu.nciae.system.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowVo {
    private static final long serialVersionUID = 3L;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "头像路径")
    private String avatar;

    @ApiModelProperty(value = "粉丝数")
    private Integer fanscount;

    @ApiModelProperty(value = "是否相互关注: 1 相互关注， 0 未相互关注")
    private Integer mutualconcern;
}
