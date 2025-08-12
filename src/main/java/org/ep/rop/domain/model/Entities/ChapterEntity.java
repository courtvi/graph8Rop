package org.ep.rop.domain.model.Entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;
import java.util.UUID;

@Node("Chapter")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ChapterEntity {
    @Id
    @GeneratedValue(generatorClass = GeneratedValue.UUIDGenerator.class)
    private UUID id;

    @Property("num")
    private String num;
    @Property("heading")
    private String heading;

    @Property
    public String componentOrder;

    @Relationship(type = "HAS_RULE", direction = Relationship.Direction.OUTGOING)
    public List<ArticleEntity> articles;

    @Relationship(type = "HAS_SECTION", direction = Relationship.Direction.OUTGOING)
    public List<SectionEntity> sections;


    public ChapterEntity() {
    }
    public ChapterEntity(String num, String heading, String componentOrder) {
        this.heading = heading;
        this.num = num;
        this.componentOrder = componentOrder;
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

    public String getComponentOrder() {
        return this.componentOrder;
    };

    public List<ArticleEntity> getArticles() {
        return articles;
    }

    public List<SectionEntity> getSections() {
        return sections;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setArticles(List<ArticleEntity> articles) {
        this.articles = articles;
    }

    public void setComponentOrder(String componentOrder) { this.componentOrder = componentOrder;}

    public void setSections(List<SectionEntity> sections) {
        this.sections = sections;
    }
}