package com.kabanov.carfactory.station;

import com.kabanov.carfactory.AssemblyCarEntity;

public class PolishingStation implements Station {
    
    @Override
    public void process(AssemblyCarEntity assemblyCarEntity) {
        assemblyCarEntity.polishing();
    }

    @Override
    public StationType getStationType() {
        return StationType.ASSEMBLE;
    }
}
