package org.ep.rop.model.Annex;

import org.ep.rop.domain.model.Entities.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnnexEntityTest {

    @Test
    void AnnexEntityTest() {

        AnnexEntity annex = new AnnexEntity();
        annex.setNum("Annex 1");
        annex.setHeading("Heading Test");
        annex.setComponentOrder("01");

        assertEquals("Annex 1",annex.getNum());
        assertEquals("Heading Test",annex.getHeading());
        assertEquals("01",annex.getComponentOrder());
        }
    @Test
    void AnnexEntityTestWithParam() {
        AnnexEntity annex = new AnnexEntity("Annex 1","Heading Test","01", null, null, null);
        assertEquals("Annex 1",annex.getNum());
        assertEquals("Heading Test",annex.getHeading());
        assertEquals("01",annex.getComponentOrder());
    }

    @Test
    void AnnexEntityTestWithParagraphes() {
        List<ParagraphEntity> paragraphes = new ArrayList<>();

        AnnexEntity annex = new AnnexEntity("Annex 1","Heading Test","01", null, paragraphes, null);
        assertEquals("Annex 1",annex.getNum());
        assertEquals("Heading Test",annex.getHeading());
        assertEquals("01",annex.getComponentOrder());
        assertEquals(paragraphes, annex.getParagraphes());

        annex = new AnnexEntity();
        annex.setParagraphes(paragraphes);
        assertEquals(paragraphes, annex.getParagraphes());
    }

    @Test
    void AnnexEntityTestWithSections() {
        List<SectionEntity> sections = new ArrayList<>();

        AnnexEntity annex = new AnnexEntity("Annex 1","Heading Test","01", null,null, sections);
        assertEquals("Annex 1",annex.getNum());
        assertEquals("Heading Test",annex.getHeading());
        assertEquals("01",annex.getComponentOrder());
        assertEquals(sections, annex.getSections());
    }

    @Test
    void AnnexEntityTestWithArticles() {
        List<ArticleEntity> articles = new ArrayList<>();

        AnnexEntity annex = new AnnexEntity("Annex 1","Heading Test","01", articles,null, null);
        assertEquals("Annex 1",annex.getNum());
        assertEquals("Heading Test",annex.getHeading());
        assertEquals("01",annex.getComponentOrder());
        assertEquals(articles, annex.getSections());
    }
}


