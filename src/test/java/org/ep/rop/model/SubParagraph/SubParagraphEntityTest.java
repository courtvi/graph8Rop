package org.ep.rop.model.SubParagraph;

import org.ep.rop.domain.model.Entities.ContentEntity;
import org.ep.rop.domain.model.Entities.SubparagraphEntity;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;

public class SubParagraphEntityTest {

    @Test
    void SubParagraphContentTest() {
        SubparagraphEntity subparagraph = new SubparagraphEntity();
        subparagraph.setContent(new ContentEntity("Heading Test"));
        assertEquals("Heading Test", subparagraph.getContent().getP());
    }
}
