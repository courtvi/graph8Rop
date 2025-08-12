package org.ep.rop.model.List;

import org.ep.rop.domain.model.Entities.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClauseEntityTest {

    @Test
    void ListwithClauseTest() {

        IntroEntity intro = new IntroEntity();
        ClauseEntity clause1 = new ClauseEntity(new ContentEntity("Clause 1"));
        ClauseEntity clause2 = new ClauseEntity(new ContentEntity("Clause 2"));

        List<BaseListElement> elements = new ArrayList<>();

        elements.add(clause1);
        elements.add(clause2);

        ListEntity list = new ListEntity();
        list.setIntro(intro);
        list.setElements(elements);

        // assertEquals("Some intro text", list.getIntro().getP());
        assertEquals(2, list.getElements().size());
        assertTrue(list.getElements().get(0) instanceof ClauseEntity);
        assertEquals("Clause 1", ((ClauseEntity) list.getElements().get(0)).getContent().getP());
        assertEquals("Clause 2", ((ClauseEntity) list.getElements().get(1)).getContent().getP());
    }
}
