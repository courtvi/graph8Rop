package org.ep.rop.model.Article;

import org.ep.rop.domain.model.Entities.AlineaEntity;
import org.ep.rop.domain.model.Entities.ArticleEntity;
import org.ep.rop.domain.model.Entities.ContentEntity;
import org.ep.rop.domain.model.Entities.ParagraphEntity;
import org.ep.rop.domain.model.P;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArticleEntityTest {

    @Test
    void ArticleTest() {
       ArticleEntity article = new ArticleEntity();
       article.setNum("Article 1");
       article.setHeading("Heading Test");
       article.setComponentOrder("01");
        assertEquals("Article 1", article.getNum());
        assertEquals("Heading Test", article.getHeading());
        assertEquals("01", article.getComponentOrder());
    }

    @Test
    void ArticleWithParagraphesTest() {
        ArticleEntity article = new ArticleEntity();
        article.setNum("Article 1");
        article.setHeading("Heading Test");
        List<ParagraphEntity> paragraphes = new ArrayList<>();
        article.setParagraphes(paragraphes);

        assertEquals("Article 1", article.getNum());
        assertEquals("Heading Test", article.getHeading());
        assertEquals(paragraphes, article.getParagraphes());
    }

    @Test
    void ArticleWithAlineasTest() {
        ArticleEntity article = new ArticleEntity();
        article.setNum("Article 1");
        article.setHeading("Heading Test");
        List<AlineaEntity> alineas = new ArrayList<>();
        article.setAlineas(alineas);

        assertEquals("Article 1", article.getNum());
        assertEquals("Heading Test", article.getHeading());
        assertEquals(alineas, article.getAlineas());
    }


    @Test
    void ArticleWithNumberedParagraphTest() {
        ArticleEntity article = new ArticleEntity();
        article.setNum("Article 1");
        article.setHeading("Heading Test");
        List<ParagraphEntity> paragraphes = new ArrayList<ParagraphEntity>();
        ParagraphEntity paragraph = new ParagraphEntity();
        paragraph.setNum("1.");
        paragraph.setContent(new ContentEntity("paragraph content"));
        paragraphes.add(paragraph);
        article.setParagraphes(paragraphes);
        assertEquals("Article 1", article.getNum());
        assertEquals("Heading Test", article.getHeading());
        assertEquals("1.", article.paragraphes.get(0).getNum());
        assertEquals("paragraph content", article.paragraphes.get(0).getContent().getP());
    }
    @Test
    void ArticleWithAlineaTest() {
        ArticleEntity article = new ArticleEntity();
        article.setNum("Article 1");
        article.setHeading("Heading Test");
        List<AlineaEntity> alineas = new ArrayList<AlineaEntity>();
        AlineaEntity alinea = new AlineaEntity();
        alinea.setContent(new ContentEntity("alinea content"));
        alineas.add(alinea);
        article.setAlineas(alineas);
        assertEquals("Article 1", article.getNum());
        assertEquals("Heading Test", article.getHeading());
        assertEquals("alinea content", article.alineas.get(0).getContent().getP());
    }

}