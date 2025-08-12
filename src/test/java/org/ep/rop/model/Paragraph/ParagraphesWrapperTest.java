package org.ep.rop.model.Paragraph;

import org.ep.rop.domain.dto.ParagraphesWrapper;
import org.ep.rop.domain.model.Entities.ContentEntity;
import org.ep.rop.domain.model.Entities.ParagraphEntity;
import org.ep.rop.domain.model.P;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParagraphesWrapperTest {
    @Test
    public void ParagraphesWrapperTest() {
        // Arrange
        ParagraphEntity paragraph1 = new  ParagraphEntity();
        paragraph1.setNum("1)");
        paragraph1.setContent(new ContentEntity("Paragraph text1"));

        ParagraphEntity paragraph2 = new ParagraphEntity();
        paragraph2.setNum("2)");
        paragraph2.setContent(new ContentEntity("Paragraph text2"));


        ParagraphesWrapper wrapper = new  ParagraphesWrapper();
        wrapper.setParagraphes(List.of(paragraph1,paragraph2));

        // Act
        List< ParagraphEntity> paragraphes = wrapper.getParagraphes();

        // Assert
        assertNotNull(paragraphes);
        assertEquals(2, paragraphes.size());
        assertEquals("1)", paragraphes.get(0).getNum());
        assertEquals("Paragraph text1", paragraphes.get(0).getContent().getP());
        assertEquals("2)", paragraphes.get(1).getNum());
        assertEquals("Paragraph text2", paragraphes.get(1).getContent().getP());

    }
}
