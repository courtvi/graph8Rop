package org.ep.rop.model.Section;

import org.ep.rop.domain.model.Entities.SectionEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SectionEntityTest {

    @Test
    void SectionEntityTest() {

        SectionEntity section = new SectionEntity();
        section.setNum("Section 1");
        section.setHeading("Heading Test");

        assertEquals("Section 1",section.getNum());
        assertEquals("Heading Test",section.getHeading());
    }
}

