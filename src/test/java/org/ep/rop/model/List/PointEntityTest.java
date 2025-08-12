package org.ep.rop.model.List;

import org.ep.rop.domain.model.Entities.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PointEntityTest {

    @Test
    void ListwithPointTest() {

        IntroEntity intro = new IntroEntity();
        String num ="-";
        PointEntity point1 = new PointEntity(num, new ContentEntity("Point 1"));
        PointEntity point2 = new PointEntity(num, new ContentEntity("Point 2"));

        List<BaseListElement> elements = new ArrayList<>();

        elements.add(point1);
        elements.add(point2);
        ListEntity list = new ListEntity();
        list.setIntro(intro);
        list.setElements(elements);

        // assertEquals("Some intro text", list.getIntro().getP());
        assertEquals(2, list.getElements().size());
        assertTrue(list.getElements().get(0) instanceof PointEntity);
        assertEquals("Point 1", ((PointEntity) list.getElements().get(0)).getContent().getP());
        assertEquals("-", ((PointEntity) list.getElements().get(0)).getNum());
        assertEquals("Point 2", ((PointEntity) list.getElements().get(1)).getContent().getP());
        assertEquals("-", ((PointEntity) list.getElements().get(1)).getNum());
    }
}

