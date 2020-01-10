package edu.nciae.news.mapper;

import edu.nciae.news.domain.NewsNewschannel;

import java.util.List;

public interface NewsNewschannelMapper {
    int deleteByPrimaryKey(Long newsNewschannelId);

    int insert(NewsNewschannel record);

    NewsNewschannel selectByPrimaryKey(Long newsNewschannelId);

    List<NewsNewschannel> selectAll();

    int updateByPrimaryKey(NewsNewschannel record);
}