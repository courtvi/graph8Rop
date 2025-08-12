package org.ep.rop.model.List;

import org.ep.rop.domain.dto.PointsWrapper;
import org.ep.rop.domain.model.Entities.ContentEntity;
import org.ep.rop.domain.model.Entities.PointEntity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PointsWrapperTest {
    @Test
    public void PointsWrapperTest() {
        // Arrange
        PointEntity point1 = new  PointEntity();
        point1.setNum("1");
        point1.setContent(new ContentEntity("point text1"));

        PointEntity point2 = new PointEntity();
        point2.setNum("2");
        point2.setContent(new ContentEntity("point text2"));


        PointsWrapper wrapper = new  PointsWrapper();
        wrapper.setPoints(List.of(point1,point2));

        // Act
        List<PointEntity> points = wrapper.getPoints();

        // Assert
        assertNotNull(points);
        assertEquals(2, points.size());
        assertEquals("1", points.get(0).getNum());
        assertEquals("point text1", points.get(0).getContent().getP());
        assertEquals("2", points.get(1).getNum());
        assertEquals("point text2", points.get(1).getContent().getP());

    }
}
