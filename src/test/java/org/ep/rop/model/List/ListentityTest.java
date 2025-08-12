package org.ep.rop.model.List;

import org.ep.rop.domain.model.Entities.*;
import org.ep.rop.domain.model.P;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListentityTest {

    @Test
    void ListItemWithIndentTest() {

        IntroEntity intro = new IntroEntity();
        intro.setP("Intro text");
        List<IndentEntity> listIndents = new ArrayList<>();
        ListEntity list = new ListEntity();
        list.setIntro(intro);
        list.setIndents(listIndents);
        assertEquals("Intro text", list.getIntro().getP());
        assertEquals(listIndents, list.getIndents());
    }

    @Test
    void ListItemWithClauseTest() {
        IntroEntity intro = new IntroEntity();
        intro.setP("Intro text");
        List<ClauseEntity> listClauses = new ArrayList<>();
        ListEntity list = new ListEntity();
        list.setIntro(intro);
        list.setClauses(listClauses);
        assertEquals("Intro text", list.getIntro().getP());
        assertEquals(listClauses, list.getClauses());
    }

    @Test
    void ListItemWithPointTest() {
        IntroEntity intro = new IntroEntity();
        intro.setP("Intro text");
        List<PointEntity> listPoints = new ArrayList<>();
        ListEntity list = new ListEntity();
        list.setIntro(intro);
        list.setPoints(listPoints);
        assertEquals("Intro text", list.getIntro().getP());
        assertEquals(listPoints, list.getPoints());
    }

}