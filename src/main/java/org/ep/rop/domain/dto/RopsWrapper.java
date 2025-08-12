package org.ep.rop.domain.dto;

import org.ep.rop.domain.model.Entities.RopEntity;

import java.util.ArrayList;
import java.util.List;

public class RopsWrapper {
    private List<RopEntity> rops = new ArrayList<>();

    public RopsWrapper() {
    }

    public RopsWrapper(List<RopEntity> rops) {
        this.rops = rops;
    }

    public List<RopEntity> getRops() {
        return rops;
    }

    public void setRops(List<RopEntity> rops) {
        this.rops = rops;
    }


}

