package org.ep.rop.controller;

import org.ep.rop.MockNeo4jDriverConfig;
import org.ep.rop.domain.controller.ArticleController;
import org.ep.rop.domain.controller.ChapterController;
import org.ep.rop.domain.dto.ChaptersWrapper;
import org.ep.rop.domain.model.Entities.ChapterEntity;
import org.ep.rop.domain.repository.ChapterRepository;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class ChaptersControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @MockitoBean
    private ChapterRepository chapterRepository;

    @Test
    public void ChaptersControllerTests() {

        ChapterEntity chapter1 = new ChapterEntity();
        ChapterEntity chapter2 = new ChapterEntity();

        chapter1.setNum("CHAPTER 1");
        chapter2.setNum("CHAPTER 2");
        chapter1.setHeading("MEMBERS, PARLIAMENT BODIES AND POLITICAL GROUPS");
        chapter2.setHeading("OFFICERS OF PARLIAMENT");

        //wrapper
        ChaptersWrapper wrapper = new ChaptersWrapper();
        wrapper.setChapters(List.of(chapter1, chapter2));

        Mockito.when(chapterRepository.save(Mockito.any(ChapterEntity.class)))
                .thenReturn(Mono.just(chapter1), Mono.just(chapter2));

        String jsonBody = """
    {
      "chapters": [
         {
          "num": "CHAPTER 1",
          "heading": "MEMBERS, PARLIAMENT BODIES AND POLITICAL GROUPS"
        },
        {
          "num": "CHAPTER 2",
          "heading": "OFFICERS OF PARLIAMENT"
         }
      ]
    }
    """;

        // Act & Assert
        webTestClient.put()
                .uri("/chapters")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(jsonBody)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.length()").isEqualTo(2)
                .jsonPath("$[0].num").isEqualTo("CHAPTER 1")
                .jsonPath("$[0].heading").isEqualTo("MEMBERS, PARLIAMENT BODIES AND POLITICAL GROUPS")
                .jsonPath("$[1].num").isEqualTo("CHAPTER 2")
                .jsonPath("$[1].heading").isEqualTo("OFFICERS OF PARLIAMENT");
    }
}
