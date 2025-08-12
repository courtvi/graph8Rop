package org.ep.rop.domain.model.Entities;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.UUID;

@Node("Alinea")
public class AlineaEntity {

    @Id
    @GeneratedValue(generatorClass = GeneratedValue.UUIDGenerator.class)
    private UUID id;

    public ContentEntity content;

    @Relationship(type = "HAS_LIST", direction = Relationship.Direction.OUTGOING)
    public ListEntity list;

    public AlineaEntity() {
    }
    public AlineaEntity(ContentEntity content) {
        this.content = content;
    }

    public UUID getId() {
        return id;
    }

    public ContentEntity getContent() {
        return content;
    }

    public ListEntity getList() {
        return list;
    }

    public void setContent(ContentEntity content) {
        this.content = content;
    }

    public void setList(ListEntity list) { this.list = list;}
}