package org.ep.rop.domain.model.Entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Node("Article")
public class ArticleEntity {

    @Id
    @GeneratedValue(generatorClass = GeneratedValue.UUIDGenerator.class)
    private UUID id;

    @Property("num")
    private String num;

    @Property("heading")
    private String heading;

    @Property
    private String componentOrder;

    @Relationship(type = "HAS_PARAGRAPH", direction = Relationship.Direction.OUTGOING)
    public List<ParagraphEntity> paragraphes;

    @Relationship(type = "HAS_ALINEA", direction = Relationship.Direction.OUTGOING)
    public List<AlineaEntity> alineas;

    public ArticleEntity() {}

    public ArticleEntity(String num, String heading, String componentOrder, List<ParagraphEntity> paragraphes,List<AlineaEntity> alineas) {
        this.num = num;
        this.heading = heading;
        this.componentOrder = componentOrder;
        this.paragraphes = paragraphes;
        this.alineas = alineas;
    }

    public ArticleEntity(String num, String heading, String componentOrder, List<ParagraphEntity> paragraphes) {
        this.num = num;
        this.heading = heading;
        this.componentOrder = componentOrder;
        this.paragraphes = paragraphes;
    }

    // Getters
    public UUID getId() { return id; }

    public String getNum() { return num; }

    public String getHeading() { return heading;  }

    public List<ParagraphEntity> getParagraphes() { return paragraphes; }

    public String getComponentOrder() { return componentOrder;}

    //setter
    public void setNum(String num) { this.num = num; }

    public void setHeading(String heading) { this.heading = heading;  }

    public void setParagraphes(List<ParagraphEntity> paragraphes) { this.paragraphes = paragraphes; }

    public List<AlineaEntity> getAlineas() { return alineas; }

    public void setAlineas(List<AlineaEntity> alineas) { this.alineas = alineas; }

    public void setComponentOrder(String componentOrder) { this.componentOrder = componentOrder;}
}

