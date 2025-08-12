package org.ep.rop.model.Title;

import org.ep.rop.domain.dto.TitlesWrapper;
import org.ep.rop.domain.model.Entities.TitleEntity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TtitlesWrapperTest {
    @Test
    public void TitlesWrapperTest() {
        // Arrange
        TitleEntity title1 = new TitleEntity();
        title1.setNum("Title 1");
        title1.setHeading("Test Heading");
        TitleEntity title2 = new TitleEntity();
        title2.setNum("Title 2");
        title2.setHeading("Test Heading2");

        TitlesWrapper wrapper = new TitlesWrapper();
        wrapper.setTitles(List.of(title1,title2));

        // Act
        List<TitleEntity> titles = wrapper.getTitles();

        // Assert
        assertNotNull(titles);
        assertEquals(2, titles.size());
        assertEquals("Title 1", titles.get(0).getNum());
        assertEquals("Test Heading", titles.get(0).getHeading());

        assertEquals("Title 2", titles.get(1).getNum());
        assertEquals("Test Heading2", titles.get(1).getHeading());
    }
}
