package org.ep.rop.domain.dto;

import org.ep.rop.domain.model.Entities.IndentEntity;

import java.util.List;

public class IndentsWrapper {
    private List<IndentEntity> indents;

    public IndentsWrapper() {
    }

    public IndentsWrapper(List<IndentEntity> indents) {
        this.indents = indents;
    }

    public List<IndentEntity> getIndents() {
        return indents;
    }

    public void setIndents(List<IndentEntity> indents) {
        this.indents = indents;
    }
}