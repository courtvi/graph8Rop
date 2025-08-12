package org.ep.rop.domain.model.Entities;

import org.ep.rop.domain.model.Entities.ContentEntity;
import org.ep.rop.domain.model.P;
import org.springframework.data.neo4j.core.schema.*;

import java.util.UUID;

@Node("Clause")
public class ClauseEntity implements BaseListElement{

    @Id
    @GeneratedValue(generatorClass = GeneratedValue.UUIDGenerator.class)
    private UUID id;

    @Relationship(type = "CONTENT", direction = Relationship.Direction.OUTGOING)
    private ContentEntity content;

    public ClauseEntity() {
    }

    public ClauseEntity(ContentEntity content) { this.content = content;  }

    // Getter
    public ContentEntity getContent() {
        return content;
    }

    public UUID getId() { return id; }

    // Setter
    public void setContent(ContentEntity content) {
        this.content = content;
    }
}