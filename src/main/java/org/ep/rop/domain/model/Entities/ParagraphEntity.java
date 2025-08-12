package org.ep.rop.domain.model.Entities;

import org.springframework.data.neo4j.core.schema.*;

import java.util.List;
import java.util.UUID;


@Node("Paragraph")
public class ParagraphEntity {

    @Id
    @GeneratedValue(generatorClass = GeneratedValue.UUIDGenerator.class)
    private UUID id;

    @Property("num")
    private String num;

    @Relationship(type = "HAS_SUBPARAGRAPH", direction = Relationship.Direction.OUTGOING)
    private List<SubparagraphEntity> subparagraphes;

    @Relationship(type = "HAS_LIST", direction = Relationship.Direction.OUTGOING)
    public ListEntity list;

    private ContentEntity content;

    public ParagraphEntity() {    }

    public ParagraphEntity(String num, ContentEntity content, List<SubparagraphEntity> subparagraphes) {
        this.num = num;
        this.content = content;
        this.subparagraphes = subparagraphes;
    }

    public ParagraphEntity(String num, ContentEntity content) {
        this.num = num;
        this.content = content;
    }

    public ParagraphEntity(String num, ListEntity list) {
        this.num = num;
        this.list = list;
    }

    // Getters and setters
    public String getNum() {
        return num;
    }

    public ListEntity getList() {
        return list;
    }

    public UUID getId() {
        return id;
    }

    public List<SubparagraphEntity> getSubparagraphes() { return subparagraphes;}

    public ContentEntity getContent() {
        return content;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setContent(ContentEntity content) {
        this.content = content;
    }

    public void setList(ListEntity list) { this.list = list;}

    public void setSubparagraphes(List<SubparagraphEntity> subparagraphes) {
        this.subparagraphes = subparagraphes;
    }



}

