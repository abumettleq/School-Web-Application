package com.example.demo.Controller;

import com.example.demo.Entity.News;
import com.example.demo.Service.NewsService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;
    @RequestMapping
    public String showNews(Model model) {
        List<News> newsList = newsService.getAllNews();
        model.addAttribute("newsList", newsList);
        return "news";
    }

    @RequestMapping("/article")
    public String showNews(@Param("article_id") int article_id, Model model) {
        News news = newsService.getArticle(article_id);
        model.addAttribute("article", news);
        return "article";
    }
}
