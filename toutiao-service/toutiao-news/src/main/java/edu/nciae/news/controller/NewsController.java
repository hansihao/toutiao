package edu.nciae.news.controller;

import edu.nciae.common.annotation.LoginUser;
import edu.nciae.common.core.domain.Result;
import edu.nciae.news.service.NewsService;
import edu.nciae.news.vo.NewsVo;
import edu.nciae.system.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    /**
     * 根据id查询新闻
     * @param sysUserVo
     * @param newsId
     * @return
     */
    @GetMapping("/{newsId}")
    public Result getNewsById(@LoginUser SysUserVo sysUserVo, @PathVariable("newsId") Long newsId) {
        NewsVo newsVo = newsService.getNewsById(sysUserVo.getUserId(), newsId);
        return Result.success(newsVo);
    }


}
