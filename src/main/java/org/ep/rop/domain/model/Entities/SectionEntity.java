package org.ep.rop.domain.model.Entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;
import java.util.UUID;

@Node("Section")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SectionEntity {
    @Id
    @GeneratedValue(generatorClass = GeneratedValue.UUIDGenerator.class)
    private UUID id;

    @Property("num")
    public String num;

    @Property("heading")
    public String heading;

    @Property
    public String componentOrder;

    @Relationship(type = "HAS_RULE", direction = Relationship.Direction.OUTGOING)
    public List<ArticleEntity> articles;

    @Relationship(type = "HAS_PARAGRAH", direction = Relationship.Direction.OUTGOING)
    public List<ParagraphEntity> paragraphes;

    public SectionEntity() {}

    public SectionEntity(String num, String heading) {
        this.heading = heading;
        this.num = num;
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

    public List<ArticleEntity> getArticles() {
        return articles;
    }
    public List<ParagraphEntity> getParagraphes() {
        return paragraphes;
    }

    public String getComponentOrder() {
        return this.componentOrder;
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

    public void setParagraphes(List<ParagraphEntity> paragraphes) {
        this.paragraphes = paragraphes;
    }

    public void setComponentOrder(String componentOrder) { this.componentOrder = componentOrder;}
}