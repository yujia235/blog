package com.yujia.blog;

import com.yujia.blog.mapper.ArticleMapper;
import com.yujia.blog.pojo.Article;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BlogApplicationTests {

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    void findAll() {
        List<Article> articleList = articleMapper.findAll();
        articleList.forEach(System.out::println);
    }

}
