package edu.nciae.news.vo;

import lombok.Data;

@Data
public class NewsCommentVo {
    private Long target;
    private String content;
    private Integer artId;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", target=").append(target);
        sb.append(", content=").append(content);
        sb.append(", artId=").append(artId);
        sb.append("]");
        return sb.toString();
    }
}
