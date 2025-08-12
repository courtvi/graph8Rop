package org.ep.rop.model.Alinea;

import org.ep.rop.domain.dto.AlineasWrapper;
import org.ep.rop.domain.model.Entities.ContentEntity;
import org.ep.rop.domain.model.Entities.AlineaEntity;
import org.ep.rop.domain.model.P;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AlineasWrapperTest {
    @Test
    public void AlineasWrapperTest() {
        // Arrange
        AlineaEntity alinea1 = new  AlineaEntity();
        AlineaEntity alinea2 = new AlineaEntity();

        alinea1.setContent(new ContentEntity("Alinea text1"));
        alinea2.setContent(new ContentEntity("Alinea text2"));

        AlineasWrapper wrapper = new  AlineasWrapper();
        wrapper.setAlineas(List.of(alinea1,alinea2));

        List<AlineaEntity> alineas = wrapper.getAlineas();
        assertNotNull(alineas);
        assertEquals(2, alineas.size());
        assertEquals("Alinea text1", alineas.get(0).getContent().getP());
        assertEquals("Alinea text2", alineas.get(1).getContent().getP());
    }
}
