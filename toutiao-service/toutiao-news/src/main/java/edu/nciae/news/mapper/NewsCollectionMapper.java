package edu.nciae.news.mapper;

import edu.nciae.news.domain.NewsCollection;

import java.util.List;

public interface NewsCollectionMapper {
    int deleteByPrimaryKey(Long collectionId);

    int insert(NewsCollection record);

    NewsCollection selectByPrimaryKey(Long collectionId);

    List<NewsCollection> selectAll();

    int updateByPrimaryKey(NewsCollection record);
}