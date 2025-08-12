package org.ep.rop.controller;

import org.ep.rop.MockNeo4jDriverConfig;
import org.ep.rop.domain.controller.ArticleController;
import org.ep.rop.domain.model.Entities.AlineaEntity;
import org.ep.rop.domain.model.Entities.ArticleEntity;
import org.ep.rop.domain.model.Entities.ContentEntity;
import org.ep.rop.domain.model.Entities.ParagraphEntity;
import org.ep.rop.domain.repository.ArticleRepository;
import org.ep.rop.domain.dto.ArticlesWrapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class ArticleControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @MockitoBean
    private ArticleRepository articleRepository;

    @Test
    public void createArticlesTest() {
        // Article 1 with paragraphs
        ContentEntity paraContent1 = new ContentEntity("Some paragraph text");
        ContentEntity paraContent2 = new ContentEntity("Some paragraph text");

        ParagraphEntity para1 = new ParagraphEntity("1.", paraContent1);
        ParagraphEntity para2 = new ParagraphEntity("2.", paraContent2);
        List<ParagraphEntity> paragraphes = List.of(para1, para2);

        ArticleEntity article1 = new ArticleEntity("Article 1", "European Parliament", "01", paragraphes, null);

        // Article 2 with alineas
        ContentEntity alineaContent1 = new ContentEntity("alinea 1 text");
        ContentEntity alineaContent2 = new ContentEntity("alinea 2 text");

        AlineaEntity alinea1 = new AlineaEntity();
        alinea1.setContent(alineaContent1);

        AlineaEntity alinea2 = new AlineaEntity();
        alinea2.setContent(alineaContent2);
        List<AlineaEntity> alineas = List.of(alinea1, alinea2);

        ArticleEntity article2 = new ArticleEntity("Article2", "Test","01", null, alineas);

        // Wrapper
        ArticlesWrapper wrapper = new ArticlesWrapper();
        wrapper.setArticles(List.of(article1, article2));

        // Mock behavior
        Mockito.when(articleRepository.save(Mockito.any(ArticleEntity.class)))
                .thenReturn(Mono.just(article1), Mono.just(article2));

        String jsonBody = """
    {
      "articles": [
        {
          "num": "Article 1",
          "heading": "European Parliament",
          "paragraphes": [
            {
              "num": "1.",
              "content": {
                "p": "Some paragraph text"
              }
            },
            {
              "num": "2.",
              "content": {
                "p": "Some paragraph text"
              }
            }
          ]
        },
        {
          "num": "Article2",
          "heading": "Test",
          "alineas": [
            {
              "content": {
                "p": "alinea 1 text"
              }
            },
            {
              "content": {
                "p": "alinea 2 text"
              }
            }
          ]
        }
      ]
    }
    """;

        // Act & Assert
        webTestClient.put()
                .uri("/articles")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(jsonBody)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.length()").isEqualTo(2)
                .jsonPath("$[0].num").isEqualTo("Article 1")
                .jsonPath("$[0].paragraphes.length()").isEqualTo(2)
                .jsonPath("$[1].num").isEqualTo("Article2")
                .jsonPath("$[1].alineas.length()").isEqualTo(2)
                .jsonPath("$[1].alineas[1].content.p").isEqualTo("alinea 2 text");
    }

    @Test
    public void updateArticleHeadingTest() {
        String num = "Article 1";

        ArticleEntity existingArticle = new ArticleEntity();
        existingArticle.setNum(num);
        existingArticle.setHeading("Old Heading");

        ArticleEntity updatedArticle = new ArticleEntity();
        updatedArticle.setNum(num);
        updatedArticle.setHeading("ArticleUpdate test");

        ArticlesWrapper wrapper = new ArticlesWrapper();
        wrapper.setArticles(List.of(updatedArticle));

        Mockito.when(articleRepository.findByHeading(num)).thenReturn(Mono.just(existingArticle));
        Mockito.when(articleRepository.save(Mockito.any(ArticleEntity.class))).thenReturn(Mono.just(updatedArticle));


        String jsonBody = """
                {
                     "articles": [
                       {
                         "num": "Article 1",
                         "heading": "Old Heading"
                       }
                       ]
                }
     """;


        webTestClient.put()
                .uri("/articles?{num}", num)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(jsonBody)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath( "$.length()").isEqualTo(1)
                .jsonPath("$[0].heading").isEqualTo("ArticleUpdate test");
    }

}
