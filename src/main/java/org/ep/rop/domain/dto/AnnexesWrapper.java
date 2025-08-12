package org.ep.rop.domain.dto;
import org.ep.rop.domain.model.Entities.AnnexEntity;

import java.util.List;

public class AnnexesWrapper {
    private List<AnnexEntity> annexes;

    public AnnexesWrapper() {
    }

    public AnnexesWrapper(List<AnnexEntity> annexes) {
        this.annexes = annexes;
    }

    public List<AnnexEntity> getAnnexes() {
        return annexes;
    }

    public void setAnnexes(List<AnnexEntity> annexes) {
        this.annexes = annexes;
    }


}