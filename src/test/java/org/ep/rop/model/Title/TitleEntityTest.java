package org.ep.rop.model.Title;

import org.ep.rop.domain.model.Entities.ChapterEntity;
import org.ep.rop.domain.model.Entities.TitleEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TitleEntityTest {

    @Test
    void TitleEntityWithParamTest() {

        TitleEntity title = new TitleEntity("Title 1","Heading Test");
        assertEquals("Title 1",title.getNum());
        assertEquals("Heading Test",title.getHeading());

        List<ChapterEntity> chapters = new ArrayList<ChapterEntity>();
        title = new TitleEntity("Title 1","Heading Test","01",chapters, null);
        assertEquals("Title 1", title.getNum());
        assertEquals("Heading Test", title.getHeading());
        assertEquals("01", title.getComponentOrder());
    }

    @Test
    void TitleEntityTest() {

        TitleEntity title = new TitleEntity();
        title.setNum("Title 1");
        title.setHeading("Heading Test");
        title.setComponentOrder("01");

        assertEquals("Title 1",title.getNum());
        assertEquals("Heading Test",title.getHeading());
        assertEquals("01",title.getComponentOrder());
    }

    @Test
    void TitleEntityWithChaptersTest() {

        TitleEntity title = new TitleEntity();
        title.setNum("Title 1");
        title.setHeading("Heading Test");
        title.setComponentOrder("01");

        assertEquals("Title 1",title.getNum());
        assertEquals("Heading Test",title.getHeading());
        assertEquals("01",title.getComponentOrder());

        ChapterEntity chapter = new ChapterEntity();
        List<ChapterEntity> chapters = new ArrayList<ChapterEntity>();
        chapters.add(chapter);
        title.setChapters(chapters);
        assertEquals(title.chapters,title.getChapters());
    }
}

