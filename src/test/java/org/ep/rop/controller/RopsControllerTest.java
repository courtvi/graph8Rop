package org.ep.rop.controller;

import org.ep.rop.MockNeo4jDriverConfig;
import org.ep.rop.domain.controller.RopController;
import org.ep.rop.domain.dto.RopsWrapper;
import org.ep.rop.domain.model.Entities.RopEntity;
import org.ep.rop.domain.repository.RopRepository;
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
public class RopsControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @MockitoBean
    private RopRepository ropRepository;
    private TitleRepository titleRepository;

    @Test
    public void RopsControllerTests() {

        RopEntity rop1 = new RopEntity("legislature 9", "RULES OF PROCEDURE");
        RopEntity rop2 = new RopEntity("legislature 10", "RULES OF PROCEDURE");


        //wrapper
        RopsWrapper wrapper = new RopsWrapper();
        wrapper.setRops(List.of(rop1, rop2));

        Mockito.when(ropRepository.save(Mockito.any(RopEntity.class)))
                .thenReturn(Mono.just(rop1), Mono.just(rop2));

        String jsonBody = """
    {
      "rops": [
        {
          "legislature": "legislature 9",
          "docTitle": "RULES OF PROCEDURE"
        },
        {
          "num": "legislature 10",
          "heading": "RULES OF PROCEDURE"
        }
      ]
    }
    """;

        webTestClient.put()
                .uri("/rop")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(jsonBody)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.length()").isEqualTo(2)
                .jsonPath("$[0].legislature").isEqualTo("legislature 9")
                .jsonPath("$[0].docTitle").isEqualTo("RULES OF PROCEDURE")
                .jsonPath("$[1].legislature").isEqualTo("legislature 10")
                .jsonPath("$[1].docTitle").isEqualTo("RULES OF PROCEDURE");
    }
}
