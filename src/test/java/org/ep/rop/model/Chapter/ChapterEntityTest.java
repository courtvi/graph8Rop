package org.ep.rop.model.Chapter;

import org.ep.rop.domain.model.Entities.ChapterEntity;
import org.ep.rop.domain.model.Entities.SectionEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ChapterEntityTest {

    @Test
    void ChapterEntityTest() {

        ChapterEntity chapter = new ChapterEntity();
        chapter.setNum("Chapter 1");
        chapter.setHeading("Chapter Test");
        chapter.setComponentOrder("01");

        assertEquals("Chapter 1",chapter.getNum());
        assertEquals("Chapter Test",chapter.getHeading());
        assertEquals("01", chapter.getComponentOrder());

        chapter = new ChapterEntity("Chapter 1","Chapter Test","01");
        assertEquals("Chapter 1",chapter.getNum());
        assertEquals("Chapter Test",chapter.getHeading());
        assertEquals("01", chapter.getComponentOrder());
    }

    @Test
    void ChapterEntityWithSectionTest() {

        ChapterEntity chapter = new ChapterEntity();
        chapter.setNum("Chapter 1");
        chapter.setHeading("Chapter Test");

        List<SectionEntity> sections = new ArrayList<>();
        chapter.setSections(sections);
        assertEquals("Chapter 1",chapter.getNum());
        assertEquals("Chapter Test",chapter.getHeading());
        assertEquals(sections,chapter.getSections());
    }
}


