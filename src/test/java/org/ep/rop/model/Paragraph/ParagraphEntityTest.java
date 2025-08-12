package org.ep.rop.model.Paragraph;

import org.ep.rop.domain.model.Entities.*;
import org.ep.rop.domain.model.P;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class ParagraphEntityTest {

@Test
void ParagraphContentTest() {
    ParagraphEntity paragraph = new ParagraphEntity();
    paragraph.setNum("Article 1");
    paragraph.setContent(new ContentEntity("Heading Test"));
    assertEquals("Article 1", paragraph.getNum());
    assertEquals("Heading Test", paragraph.getContent().getP());
}

    @Test
    void ParagraphSubparagraphContentTest() {
        ParagraphEntity paragraph = new ParagraphEntity();
        paragraph.setNum("Article 1");
        paragraph.setContent(new ContentEntity("Heading Test"));

        SubparagraphEntity subparagraph1 = new SubparagraphEntity();
        subparagraph1.setContent(new ContentEntity("SubParagraph1 Test"));
        SubparagraphEntity subparagraph2 = new SubparagraphEntity();
        subparagraph2.setContent(new ContentEntity("SubParagraph2 Test"));

        List<SubparagraphEntity> subparagraphes = new ArrayList<>();
        subparagraphes.add(subparagraph1);
        subparagraphes.add(subparagraph2);
        paragraph.setSubparagraphes(subparagraphes);

        assertEquals("Article 1", paragraph.getNum());
        assertEquals("Heading Test", paragraph.getContent().getP());
        assertEquals("SubParagraph1 Test", paragraph.getSubparagraphes().get(0).getContent().getP());

    }


}
