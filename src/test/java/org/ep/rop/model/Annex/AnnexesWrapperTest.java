package org.ep.rop.model.Annex;

import org.ep.rop.domain.dto.AnnexesWrapper;
import org.ep.rop.domain.model.Entities.AnnexEntity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AnnexesWrapperTest {
    @Test
    public void AnnexesWrapperTest() {
        // Arrange
        AnnexEntity annex1 = new AnnexEntity();
        annex1.setNum("Annex 1");
        annex1.setHeading("Test Annex Heading");
        AnnexEntity annex2 = new AnnexEntity();
        annex2.setNum("Annex 2");
        annex2.setHeading("Test Annex Heading2");
        AnnexesWrapper wrapper = new AnnexesWrapper();
        wrapper.setAnnexes(List.of(annex1,annex2));

        // Act
        List<AnnexEntity> annexes = wrapper.getAnnexes();

        // Assert
        assertNotNull(annexes);
        assertEquals(2, annexes.size());
        assertEquals("Annex 1", annexes.get(0).getNum());
        assertEquals("Test Annex Heading", annexes.get(0).getHeading());

        assertEquals("Annex 2", annexes.get(1).getNum());
        assertEquals("Test Annex Heading2", annexes.get(1).getHeading());
    }
}
