package org.ep.rop.controller;

import org.ep.rop.MockNeo4jDriverConfig;
import org.ep.rop.domain.controller.SectionController;
import org.ep.rop.domain.dto.SectionsWrapper;
import org.ep.rop.domain.model.Entities.SectionEntity;
import org.ep.rop.domain.repository.SectionRepository;
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
public class SectionsControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @MockitoBean
    private SectionRepository sectionRepository;

    @Test
    public void SectionControllerTests() {

        SectionEntity section1 = new SectionEntity();
        SectionEntity section2 = new SectionEntity();

        section1.setHeading("heading of section 1");
        section2.setHeading("heading of section 2");

        section1.setNum("Section 1");
        section2.setNum("Section 2");

        //wrapper
        SectionsWrapper wrapper = new SectionsWrapper();
        wrapper.setSections(List.of(section1, section2));

        Mockito.when(sectionRepository.save(Mockito.any(SectionEntity.class)))
                .thenReturn(Mono.just(section1), Mono.just(section2));

        String jsonBody = """
    {
      "sections": [
        {
          "num": "Section 1",
          "heading": "heading of section 1"
        },
        {
          "num": "Section 2",
          "heading": "heading of section 2"
        }
      ]
    }
    """;

        webTestClient.put()
                .uri("/sections")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(jsonBody)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.length()").isEqualTo(2)
                .jsonPath("$[0].num").isEqualTo("Section 1")
                .jsonPath("$[0].heading").isEqualTo("heading of section 1")
                .jsonPath("$[1].num").isEqualTo("Section 2")
                .jsonPath("$[1].heading").isEqualTo("heading of section 2");
    }
}
