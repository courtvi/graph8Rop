package org.ep.rop.model.Article;


import org.ep.rop.domain.dto.ArticlesWrapper;
import org.ep.rop.domain.model.Entities.ArticleEntity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ArticlesWrapperTest {

    @Test
    public void ArticlesWrapperTest() {
        // Arrange
        ArticleEntity article1 = new ArticleEntity();
        article1.setNum("Article 1");
        article1.setHeading("Test Heading");
        ArticleEntity article2 = new ArticleEntity();
        article2.setNum("Article 2");
        article2.setHeading("Test Heading2");

        ArticlesWrapper wrapper = new ArticlesWrapper();
        wrapper.setArticles(List.of(article1,article2));

        // Act
        List<ArticleEntity> articles = wrapper.getArticles();

        // Assert
        assertNotNull(articles);
        assertEquals(2, articles.size());
        assertEquals("Article 1", articles.get(0).getNum());
        assertEquals("Test Heading", articles.get(0).getHeading());

        assertEquals("Article 2", articles.get(1).getNum());
        assertEquals("Test Heading2", articles.get(1).getHeading());
    }

}