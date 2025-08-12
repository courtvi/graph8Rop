package org.ep.rop.domain.dto;

import org.ep.rop.domain.model.Entities.PointEntity;

import java.util.List;

public class PointsWrapper {
    private List<PointEntity> points;

    public PointsWrapper() {
    }

    public PointsWrapper(List<PointEntity> points) {
        this.points = points;
    }

    public List<PointEntity> getPoints() {
        return points;
    }

    public void setPoints(List<PointEntity> points) {
        this.points = points;
    }
}