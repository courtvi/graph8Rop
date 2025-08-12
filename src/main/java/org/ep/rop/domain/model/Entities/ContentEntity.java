package org.ep.rop.domain.model.Entities;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.UUID;

@Node("Content")
public class ContentEntity {

    @Id
    @GeneratedValue(generatorClass = GeneratedValue.UUIDGenerator.class)
    private UUID id;

    private String p;

    public ContentEntity() {    }

    public ContentEntity(String p) {  this.p = p;  }

    // Getter
    public String getP() {  return p;  }

    public UUID getId() {  return id;  }

    // Setter
    public void setP(String p) {  this.p = p; }
}