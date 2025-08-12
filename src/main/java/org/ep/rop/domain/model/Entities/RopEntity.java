package org.ep.rop.domain.model.Entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;
import java.util.UUID;

@Node("Rop")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RopEntity {

    @GeneratedValue
    @Id
    private UUID id;

    @Property("docTitle")
    public String docTitle;

    @Property("legislature")
    public String legislature;

    @Relationship(type = "HAS_TITLE", direction = Relationship.Direction.OUTGOING)
    public List<TitleEntity> titles;

    @Relationship(type = "HAS_ANNEX", direction = Relationship.Direction.OUTGOING)
    public List<AnnexEntity> annexes;


    public RopEntity() {}

    public RopEntity(String legislature, String title) {
        this.docTitle = title;
        this.legislature = legislature;
    }

    public RopEntity(String legislature, String title, List<TitleEntity> titles, List<AnnexEntity> annexes) {
        this.legislature = legislature;
        this.docTitle = title;
        this.titles = titles;
        this.annexes = annexes;
    }

    public UUID getId() {
        return id;
    }

    public String getLegislature() {
        return this.legislature;
    }

    public String getDocTitle() {
        return this.docTitle;
    }

    public void setLegislature(String legislature) {
        this.legislature = legislature;
    }

    public void setDocTitle(String title) {
        this.docTitle = title;
    }

    public List<TitleEntity> getTitles() {
        return titles;
    }

    public void setTitles(List<TitleEntity> titles) {
        this.titles = titles;
    }

    public List<AnnexEntity> getAnnexes() {
        return annexes;
    }

    public void setAnnexes(List<AnnexEntity> annexes) {
        this.annexes = annexes;
    }

}