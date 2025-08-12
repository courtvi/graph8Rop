package org.ep.rop.model.List;

import org.ep.rop.domain.model.Entities.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IndentEntityTest {

        @Test
        void ListwithIndentTest() {

            IntroEntity intro = new IntroEntity();
            String num ="-";
            IndentEntity indent1 = new IndentEntity(num, new ContentEntity("Indent 1"));
            IndentEntity indent2 = new IndentEntity(num, new ContentEntity("Indent 2"));

            List<BaseListElement> elements = new ArrayList<>();

            elements.add(indent1);
            elements.add(indent2);
            ListEntity list = new ListEntity();
            list.setIntro(intro);
            list.setElements(elements);

            // assertEquals("Some intro text", list.getIntro().getP());
            assertEquals(2, list.getElements().size());
            assertTrue(list.getElements().get(0) instanceof IndentEntity);
            assertEquals("Indent 1", ((IndentEntity) list.getElements().get(0)).getContent().getP());
            assertEquals("-", ((IndentEntity) list.getElements().get(0)).getNum());
            assertEquals("Indent 2", ((IndentEntity) list.getElements().get(1)).getContent().getP());
            assertEquals("-", ((IndentEntity) list.getElements().get(1)).getNum());
        }
}

