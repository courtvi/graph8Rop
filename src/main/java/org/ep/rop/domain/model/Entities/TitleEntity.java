package org.ep.rop.domain.model.Entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.neo4j.core.schema.*;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

import java.util.List;
import java.util.UUID;

@Node("Title")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TitleEntity {
    @Id
    @GeneratedValue(generatorClass = GeneratedValue.UUIDGenerator.class)
    private UUID id;

    @Property("num")
    public String num;

    @Property("heading")
    public String heading;

    @Relationship(type = "HAS_CHAPTER", direction = Relationship.Direction.OUTGOING)
    public List<ChapterEntity> chapters;

    public TitleEntity() {}

    @Relationship(type = "HAS_RULE", direction = Relationship.Direction.OUTGOING)
    public List<ArticleEntity> articles;

    @Property
    public String componentOrder;

    @SchemaMapping(typeName = "Title", field = "hasArticles")
    public boolean hasArticles(TitleEntity title) {
        return title.getArticles() != null && !title.getArticles().isEmpty();
    }

    public TitleEntity(String num, String heading) {
        this.heading = heading;
        this.num = num;
    }

    public TitleEntity(String num, String heading, String componentOrder, List<ChapterEntity> chapters, List<ArticleEntity> articles) {
        this.heading = heading;
        this.num = num;
        this.componentOrder = componentOrder;
        this.chapters = chapters;
        this.articles = articles;

    }

    public UUID getId() {
       return id;
    }

    public String getNum() {
        return this.num;
    }

    public String getHeading() {
        return this.heading;
    }

    public String getComponentOrder() { return this.componentOrder;}

    public List<ArticleEntity> getArticles() { return this.articles;}

    public void setNum(String num) {
        this.num = num;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setComponentOrder(String componentOrder) { this.componentOrder = componentOrder;}

    public List<ChapterEntity> getChapters() {
        return chapters;
    }

    public void setChapters(List<ChapterEntity> chapters) {
        this.chapters = chapters;
    }

    public void setArticles(List<ArticleEntity> articles) { this.articles = articles;}

}