package org.ep.rop.domain.dto;
import org.ep.rop.domain.model.Entities.ChapterEntity;

import java.util.ArrayList;
import java.util.List;

public class ChaptersWrapper {
    private List<ChapterEntity> chapters = new ArrayList<>();;

    public ChaptersWrapper() {
    }

    public ChaptersWrapper(List<ChapterEntity> chapters) {
        this.chapters = chapters;
    }

    public List<ChapterEntity> getChapters() {
        return chapters;
    }

    public void setChapters(List<ChapterEntity> chapters) {
        this.chapters = chapters;
    }
}