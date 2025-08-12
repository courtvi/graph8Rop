package org.ep.rop.controller;

import org.ep.rop.MockNeo4jDriverConfig;
import org.ep.rop.domain.controller.TitleController;
import org.ep.rop.domain.dto.TitlesWrapper;
import org.ep.rop.domain.model.Entities.TitleEntity;
import org.ep.rop.domain.repository.ArticleRepository;
import org.ep.rop.domain.repository.ChapterRepository;
import org.ep.rop.domain.repository.TitleRepository;
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

public class TitlesControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @MockitoBean
    private ChapterRepository chapterRepository;

    @MockitoBean
    private ArticleRepository articleRepository;

    @MockitoBean
    private TitleRepository titleRepository;

    @Test
    public void TitlesControllerTests() {

        TitleEntity title1 = new TitleEntity();
        TitleEntity title2 = new TitleEntity();

        title1.setHeading("MEMBERS, PARLIAMENT BODIES AND POLITICAL GROUPS");
        title1.setNum("Title 1");
        title1.setComponentOrder("01");

        title2.setHeading("LEGISLATIVE, BUDGETARY,DISCHARGE AND OTHER PROCEDURES");
        title2.setNum("Title 2");
        title2.setComponentOrder("02");

        //wrapper
        TitlesWrapper wrapper = new TitlesWrapper();
        wrapper.setTitles(List.of(title1, title2));

        Mockito.when(titleRepository.save(Mockito.any(TitleEntity.class)))
                .thenReturn(Mono.just(title1), Mono.just(title2));

        String jsonBody = """
    {
      "titles": [
        {
          "num": "Title 1",
          "heading": "MEMBERS, PARLIAMENT BODIES AND POLITICAL GROUPS",
          "componentOrder": "01"
        },
        {
          "num": "Title 2",
          "heading": "LEGISLATIVE, BUDGETARY,DISCHARGE AND OTHER PROCEDURES",
          "componentOrder": "02"
        }
      ]
    }
    """;

        webTestClient.put()
                .uri("/titles")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(jsonBody)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.length()").isEqualTo(2)
                .jsonPath("$[0].num").isEqualTo("Title 1")
                .jsonPath("$[0].heading").isEqualTo("MEMBERS, PARLIAMENT BODIES AND POLITICAL GROUPS")
                .jsonPath("$[0].componentOrder").isEqualTo("01")
                .jsonPath("$[1].num").isEqualTo("Title 2")
                .jsonPath("$[1].heading").isEqualTo("LEGISLATIVE, BUDGETARY,DISCHARGE AND OTHER PROCEDURES")
                .jsonPath("$[1].componentOrder").isEqualTo("02");

    }
}
