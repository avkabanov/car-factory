package com.kabanov.carfactory.station;

import com.kabanov.carfactory.AssemblyCarEntity;

public class PaintingStation implements Station {
    @Override
    public void process(AssemblyCarEntity assemblyCarEntity) {
        assemblyCarEntity.paint();
    }

    @Override
    public StationType getStationType() {
        return StationType.ASSEMBLE;
    }
}
