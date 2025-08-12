package org.ep.rop.domain.model.Entities;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.UUID;

@Node("Intro")
public class IntroEntity {

    @Id
    @GeneratedValue(generatorClass = GeneratedValue.UUIDGenerator.class)
    private UUID id;


    private String p;

    // Getter
    public String getP() {  return p; }

    public UUID getId() { return id; }

    // Setter
    public void setP(String p) { this.p = p;  }
}
