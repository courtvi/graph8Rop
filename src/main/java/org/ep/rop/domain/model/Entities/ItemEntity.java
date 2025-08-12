package org.ep.rop.domain.model.Entities;

import org.ep.rop.domain.model.P;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.UUID;

@Node("Item")
public class ItemEntity implements BaseListElement{

    @Id
    @GeneratedValue(generatorClass = GeneratedValue.UUIDGenerator.class)

    private UUID id;

    private P p;

    private ContentEntity content;

    public ItemEntity() {
    }

    public ItemEntity(ContentEntity content) {
        this.content = content;
    }

    // Getter
    public P getP() {
        return p;
    }

    public UUID getId() {  return id;  }

    public ContentEntity getContent() {
        return content;
    }

    // Setter
    public void setP(P p) {
        this.p = p;
    }

    public void setContent(ContentEntity content) {
        this.content = content;
    }
}


