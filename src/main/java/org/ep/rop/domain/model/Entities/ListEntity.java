package org.ep.rop.domain.model.Entities;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;
import java.util.UUID;

@Node("List")
public class ListEntity {

    @Id
    @GeneratedValue(generatorClass = GeneratedValue.UUIDGenerator.class)
    private UUID id;

    private String p;

    @Relationship(type = "HAS_INTRO", direction = Relationship.Direction.OUTGOING)
    public IntroEntity intro;

    @Relationship(type = "HAS_ELEMENTS", direction = Relationship.Direction.OUTGOING)
    private List<BaseListElement> elements;

    @Relationship(type = "HAS_CLAUSE", direction = Relationship.Direction.OUTGOING)
    private List<ClauseEntity> clauses;

    @Relationship(type = "HAS_INDENT", direction = Relationship.Direction.OUTGOING)
    private List<IndentEntity> indents;

    @Relationship(type = "HAS_POINT", direction = Relationship.Direction.OUTGOING)
    private List<PointEntity> points;


    public ListEntity() {  }
/*
    public ListEntity(IntroEntity intro,List<BaseListElement> elements) {
     this.intro = intro;
     this.elements = elements;
    }
*/
    // Getter
    public String getP() { return p;   }

    public UUID getId() { return id;  }

    public IntroEntity getIntro() { return intro;}

    public List<PointEntity> getPoints() { return points;  }

    public List<IndentEntity> getIndents() { return indents;  }

    public List<ClauseEntity> getClauses() {
        return clauses;
    }

    public List<BaseListElement> getElements() {
        return elements;
    }

    // Setter
    public void setP(String p) { this.p = p;  }

    public void setIntro(IntroEntity intro) { this.intro = intro;  }

    public void setClauses(List<ClauseEntity> clauses) {
        this.clauses = clauses;
    }

    public void setPoints(List<PointEntity> points) {
        this.points = points;
    }

    public void setIndents(List<IndentEntity> indents) {
        this.indents = indents;
    }

    public void setElements(List<BaseListElement> elements) {
        this.elements = elements;
    }


}