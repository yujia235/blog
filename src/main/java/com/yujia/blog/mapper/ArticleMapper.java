package com.yujia.blog.mapper;

import com.yujia.blog.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleMapper extends JpaRepository<Article, Integer> {
}
