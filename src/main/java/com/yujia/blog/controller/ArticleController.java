package com.yujia.blog.controller;

import com.yujia.blog.mapper.ArticleMapper;
import com.yujia.blog.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArticleController {

    @Autowired
    private ArticleMapper articleMapper;

    @RequestMapping("/toIndex")
    public ModelAndView toIndex(@RequestParam(name = "pageNum", required = false) Integer pageNum
            , @RequestParam(name = "pageSize", required = false) Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 2 : pageSize;
        Page<Article> articlePage = articleMapper.findAll(PageRequest.of(pageNum - 1, pageSize));
        int totalPages = articlePage.getTotalPages();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("articleList", articlePage.getContent());
        modelAndView.addObject("prePage", pageNum == 1 ? 1 : pageNum - 1);
        modelAndView.addObject("nextPage", pageNum == totalPages ? totalPages : pageNum + 1);
        modelAndView.addObject("totalPages", totalPages);
        modelAndView.addObject("pageSize", pageSize);
        modelAndView.setViewName("/client/index");
        return modelAndView;
    }
}
