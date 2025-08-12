package org.ep.rop.domain.dto;
import org.ep.rop.domain.model.Entities.TitleEntity;

import java.util.ArrayList;
import java.util.List;

public class TitlesWrapper {
    private List<TitleEntity> titles = new ArrayList<>();

    public TitlesWrapper() {
    }

    public TitlesWrapper(List<TitleEntity> titles) {
        this.titles = titles;
    }

    public List<TitleEntity> getTitles() {
        return titles;
    }

    public void setTitles(List<TitleEntity> titles) {
        this.titles = titles;
    }


}

