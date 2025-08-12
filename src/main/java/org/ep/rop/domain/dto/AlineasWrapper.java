package org.ep.rop.domain.dto;
import org.ep.rop.domain.model.Entities.AlineaEntity;

import java.util.List;

public class AlineasWrapper {
    private List<AlineaEntity> alineas;

    public AlineasWrapper() {
    }

    public List<AlineaEntity> getAlineas() {
        return alineas;
    }

    public void setAlineas(List<AlineaEntity> alineas) {
        this.alineas = alineas;
    }
}