package org.ep.rop.domain.model.Entities;


import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Node("Annex")
public class AnnexEntity {
    @Id
    @GeneratedValue(generatorClass = GeneratedValue.UUIDGenerator.class)
    private UUID id;

    @Property("num")
    private String num;

    @Property("heading")
    private String heading;

    @Relationship(type = "HAS_PARAGRAPH", direction = Relationship.Direction.OUTGOING)
    public List<ParagraphEntity> paragraphes;

    @Relationship(type = "HAS_SECTION", direction = Relationship.Direction.OUTGOING)
    public List<SectionEntity> sections;

    @Relationship(type = "HAS_ARTICLES", direction = Relationship.Direction.OUTGOING)
    public List<ArticleEntity> articles;

    public String componentOrder;

    public AnnexEntity() {}

    public AnnexEntity(String num, String heading, String componentOrder, List<ArticleEntity> articles, List<ParagraphEntity> paragraphes, List<SectionEntity> sections) {
        this.num = num;
        this.heading = heading;
        this.componentOrder = componentOrder;
        this.articles = articles != null ? articles : new ArrayList<>();
        this.paragraphes = paragraphes != null ? paragraphes : new ArrayList<>();
        this.sections = sections != null ? sections : new ArrayList<>();
    }

    public String getNum() {
        return num;
    }

    public UUID getId() {
        return id;
    }

    public String getComponentOrder() { return componentOrder;}

    public String getHeading() {
        return heading;
    }

    public List<ParagraphEntity> getParagraphes() { return paragraphes;}

    public List<SectionEntity> getSections() { return sections;}

    public void setNum(String num) { this.num = num; }

    public void setHeading(String heading) {this.heading = heading;}

    public void setComponentOrder(String componentOrder) { this.componentOrder = componentOrder;}

    public void setSections(List<SectionEntity> sections) { this.sections = sections;}

    public void setParagraphes(List<ParagraphEntity> paragraphes) { this.paragraphes = paragraphes;
    }
}
