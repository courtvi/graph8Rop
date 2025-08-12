package org.ep.rop.model.Rop;

import org.ep.rop.domain.model.Entities.AnnexEntity;
import org.ep.rop.domain.model.Entities.RopEntity;
import org.ep.rop.domain.model.Entities.TitleEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RopEntityTest {

    @Test
    void RopTest() {
        RopEntity rop = new RopEntity();
        rop.setLegislature("legislature 9");
        rop.setDocTitle("RULES OF PROCEDURE");
        List<AnnexEntity> annexes = new ArrayList<>();
        List<TitleEntity> titles = new ArrayList<>();

        rop.setTitles(titles);
        rop.setAnnexes(annexes);

        assertEquals("legislature 9", rop.getLegislature());
        assertEquals("RULES OF PROCEDURE", rop.getDocTitle());
        assertEquals(annexes, rop.getAnnexes());
        assertEquals(titles, rop.getTitles());
    }

    @Test
    void RopTestWithParam() {

        List<AnnexEntity> annexes = new ArrayList<>();
        List<TitleEntity> titles = new ArrayList<>();

        RopEntity rop = new RopEntity("legislature 9","RULES OF PROCEDURE",titles,annexes);

        rop.setTitles(titles);
        rop.setAnnexes(annexes);

        assertEquals("legislature 9", rop.getLegislature());
        assertEquals("RULES OF PROCEDURE", rop.getDocTitle());
        assertEquals(annexes, rop.getAnnexes());
        assertEquals(titles, rop.getTitles());
    }
}
