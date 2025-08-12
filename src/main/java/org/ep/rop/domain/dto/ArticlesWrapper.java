package org.ep.rop.domain.dto;
import org.ep.rop.domain.model.Entities.ArticleEntity;

import java.util.List;

public class ArticlesWrapper {
    private List<ArticleEntity> articles;

    public ArticlesWrapper() {
    }

    public ArticlesWrapper(List<ArticleEntity> articles) {
        this.articles = articles;
    }

    public List<ArticleEntity> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleEntity> articles) {
        this.articles = articles;
    }
}