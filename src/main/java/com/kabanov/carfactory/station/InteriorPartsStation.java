package com.kabanov.carfactory.station;

import com.kabanov.carfactory.AssemblyCarEntity;

public class InteriorPartsStation implements Station {
    
    @Override
    public void process(AssemblyCarEntity assemblyCarEntity) {
        assemblyCarEntity.assemblyInterior();    
    }

    @Override
    public StationType getStationType() {
        return StationType.ASSEMBLE;
    }
}
