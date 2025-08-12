package org.ep.rop.model.List;

import org.ep.rop.domain.dto.IndentsWrapper;
import org.ep.rop.domain.model.Entities.ContentEntity;
import org.ep.rop.domain.model.Entities.IndentEntity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IndentsWrapperTest {
    @Test
    public void IndentsWrapperTest() {
        // Arrange
        IndentEntity indent1 = new  IndentEntity();
        indent1.setNum("-");
        indent1.setContent(new ContentEntity("indent text1"));

        IndentEntity indent2 = new IndentEntity();
        indent2.setNum("-");
        indent2.setContent(new ContentEntity("indent text2"));


        IndentsWrapper wrapper = new  IndentsWrapper();
        wrapper.setIndents(List.of(indent1,indent2));

        // Act
        List<IndentEntity> indentes = wrapper.getIndents();

        // Assert
        assertNotNull(indentes);
        assertEquals(2, indentes.size());
        assertEquals("-", indentes.get(0).getNum());
        assertEquals("indent text1", indentes.get(0).getContent().getP());
        assertEquals("-", indentes.get(1).getNum());
        assertEquals("indent text2", indentes.get(1).getContent().getP());

    }
}
