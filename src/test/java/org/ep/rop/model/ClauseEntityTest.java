package org.ep.rop.model;

import org.ep.rop.MockNeo4jDriverConfig;
import org.ep.rop.domain.controller.TitleController;
import org.ep.rop.domain.model.Entities.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ClauseEntityTest {

    @Test
    void ClauseContentTest() {
        ClauseEntity clause = new ClauseEntity();
        clause.setContent(new ContentEntity("Heading Test"));
        assertEquals("Heading Test", clause.getContent().getP());
    }
}