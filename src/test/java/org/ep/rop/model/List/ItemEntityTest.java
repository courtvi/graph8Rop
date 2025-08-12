package org.ep.rop.model.List;

import org.ep.rop.domain.model.Entities.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemEntityTest {

    @Test
    void ListwithItemTest() {

        IntroEntity intro = new IntroEntity();
        ItemEntity item1 = new ItemEntity(new ContentEntity("Item 1"));
        ItemEntity item2 = new ItemEntity(new ContentEntity("Item 2"));
        List<BaseListElement> elements = new ArrayList<>();
        elements.add(item1);
        elements.add(item2);
        ListEntity list = new ListEntity();
        list.setIntro(intro);
        list.setElements(elements);
        assertEquals(2, list.getElements().size());
        assertTrue(list.getElements().get(0) instanceof ItemEntity);
        assertEquals("Item 1", ((ItemEntity) list.getElements().get(0)).getContent().getP());
        assertEquals("Item 2", ((ItemEntity) list.getElements().get(1)).getContent().getP());
    }

    @Test
    void ListItemTest() {
        ItemEntity item1 = new ItemEntity();
        item1.setContent(new ContentEntity("Item 1"));
        assertEquals("Item 1",item1.getContent().getP());
    }
}