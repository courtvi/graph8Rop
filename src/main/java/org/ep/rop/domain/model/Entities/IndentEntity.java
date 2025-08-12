package org.ep.rop.domain.model.Entities;

import org.ep.rop.domain.model.P;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.UUID;

@Node("Indent")
public class IndentEntity implements BaseListElement{

    @Id
    @GeneratedValue(generatorClass = GeneratedValue.UUIDGenerator.class)
    private UUID id;

    private P p;
    private ContentEntity content;

    public String num;

    public IndentEntity() {  }

    public IndentEntity(String num, ContentEntity content) {
        this.num = num;
        this.content = content;
    }

    // Getter
    public P getP() {
        return p;
    }

    public UUID getId() {   return id;   }

    public String getNum() {
        return this.num;
    }

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

    public void setNum(String num) {
        this.num = num;
    }

}