package edu.nciae.system.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserVo {
    private static final long serialVersionUID = 2L;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "头像路径")
    private String avatar;

    @ApiModelProperty(value = "电话号码")
    private String phonenumber;

    @ApiModelProperty(value = "性别：0-男，1-女")
    private String gender;

    @ApiModelProperty(value = "生日")
    private Date birthday;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "省份")
    private String userProvince;

    @ApiModelProperty(value = "市")
    private String userCity;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", avatar=").append(avatar);
        sb.append(", phonenumber=").append(phonenumber);
        sb.append(", gender=").append(gender);
        sb.append(", birthday=").append(birthday);
        sb.append(", remark=").append(remark);
        sb.append(", userProvince=").append(userProvince);
        sb.append(", userCity=").append(userCity);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
