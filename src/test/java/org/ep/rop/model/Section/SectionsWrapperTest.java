package org.ep.rop.model.Section;

import org.ep.rop.domain.dto.SectionsWrapper;
import org.ep.rop.domain.model.Entities.SectionEntity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SectionsWrapperTest {
    @Test
    public void SectionsWrapperTest() {
        // Arrange
        SectionEntity title1 = new SectionEntity();
        title1.setNum("Section 1");
        title1.setHeading("Test Heading");
        SectionEntity title2 = new SectionEntity();
        title2.setNum("Section 2");
        title2.setHeading("Test Heading2");

        SectionsWrapper wrapper = new SectionsWrapper();
        wrapper.setSections(List.of(title1,title2));

        // Act
        List<SectionEntity> sections = wrapper.getSections();

        // Assert
        assertNotNull(sections);
        assertEquals(2, sections.size());
        assertEquals("Section 1", sections.get(0).getNum());
        assertEquals("Test Heading", sections.get(0).getHeading());

        assertEquals("Section 2", sections.get(1).getNum());
        assertEquals("Test Heading2", sections.get(1).getHeading());
    }
}
