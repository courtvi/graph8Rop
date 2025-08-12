package org.ep.rop.domain.dto;
import org.ep.rop.domain.model.Entities.SubparagraphEntity;

import java.util.List;

public class SubparagraphesWrapper {
    private List<SubparagraphEntity> subparagraphes;

    public SubparagraphesWrapper() {
    }

    public SubparagraphesWrapper(List<SubparagraphEntity> subparagraphes) {
        this.subparagraphes = subparagraphes;
    }

    public List<SubparagraphEntity> getSubparagraphes() {
        return subparagraphes;
    }

    public void setSubparagraphes(List<SubparagraphEntity> subparagraphes) {
        this.subparagraphes = subparagraphes;
    }
}