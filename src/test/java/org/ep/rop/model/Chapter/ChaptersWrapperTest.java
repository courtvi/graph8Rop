package org.ep.rop.model.Chapter;

import org.ep.rop.domain.dto.ChaptersWrapper;
import org.ep.rop.domain.model.Entities.ChapterEntity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ChaptersWrapperTest {
    @Test
    public void ChaptersWrapperTest() {
        // Arrange
        ChapterEntity chapter1 = new ChapterEntity();
        chapter1.setNum("Chapter 1");
        chapter1.setHeading("Test Chapter Heading");
        ChapterEntity chapter2 = new ChapterEntity();
        chapter2.setNum("Chapter 2");
        chapter2.setHeading("Test Chapter Heading2");
        ChaptersWrapper wrapper = new ChaptersWrapper();
        wrapper.setChapters(List.of(chapter1,chapter2));

        // Act
        List<ChapterEntity> chapters = wrapper.getChapters();

        // Assert
        assertNotNull(chapters);
        assertEquals(2, chapters.size());
        assertEquals("Chapter 1", chapters.get(0).getNum());
        assertEquals("Test Chapter Heading", chapters.get(0).getHeading());

        assertEquals("Chapter 2", chapters.get(1).getNum());
        assertEquals("Test Chapter Heading2", chapters.get(1).getHeading());
    }
}
