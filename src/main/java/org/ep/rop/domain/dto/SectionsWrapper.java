package org.ep.rop.domain.dto;
import org.ep.rop.domain.model.Entities.SectionEntity;

import java.util.ArrayList;
import java.util.List;

public class SectionsWrapper {
    private List<SectionEntity> sections = new ArrayList<>();

    public SectionsWrapper() {
    }

    public SectionsWrapper(List<SectionEntity> sections) {

        this.sections = this.sections;
    }

    public List<SectionEntity> getSections() {

        return sections;
    }

    public void setSections(List<SectionEntity> sections) {
        this.sections = sections;
    }
}

