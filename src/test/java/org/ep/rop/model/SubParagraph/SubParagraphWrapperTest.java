package org.ep.rop.model.SubParagraph;

import org.ep.rop.domain.dto.SubparagraphesWrapper;
import org.ep.rop.domain.model.Entities.ContentEntity;
import org.ep.rop.domain.model.Entities.SubparagraphEntity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SubParagraphWrapperTest {

    @Test
    public void SubParagraphesWrapperTest() {
        // Arrange
        SubparagraphEntity subparagraph1 = new  SubparagraphEntity();
        subparagraph1.setContent(new ContentEntity("Subparagraph text1"));

        SubparagraphEntity subparagraph2 = new SubparagraphEntity();
        subparagraph2.setContent(new ContentEntity("Subparagraph text2"));

        SubparagraphesWrapper wrapper = new SubparagraphesWrapper();
        wrapper.setSubparagraphes(List.of(subparagraph1,subparagraph2));

        List<SubparagraphEntity> subparagraphes = wrapper.getSubparagraphes();

        assertNotNull(subparagraphes);
        assertEquals(2, subparagraphes.size());
        assertEquals("Subparagraph text1", subparagraphes.get(0).getContent().getP());
        assertEquals("Subparagraph text2", subparagraphes.get(1).getContent().getP());

    }
}
