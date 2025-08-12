package org.ep.rop;
import static org.assertj.core.api.Assertions.assertThat;

import org.ep.rop.domain.controller.ArticleController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class SmokeTests {
    @Autowired
    private ArticleController controller;

    @Test
    void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}
