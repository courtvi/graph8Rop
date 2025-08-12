package org.ep.rop.domain.dto;
import org.ep.rop.domain.model.Entities.ParagraphEntity;

import java.util.List;

public class ParagraphesWrapper {
    private List<ParagraphEntity> paragraphes;

    public ParagraphesWrapper() {
    }

    public ParagraphesWrapper(List<ParagraphEntity> paragraphes) {
        this.paragraphes = paragraphes;
    }

    public List<ParagraphEntity> getParagraphes() {
        return paragraphes;
    }

    public void setParagraphes(List<ParagraphEntity> paragraphes) {
        this.paragraphes = paragraphes;
    }
}