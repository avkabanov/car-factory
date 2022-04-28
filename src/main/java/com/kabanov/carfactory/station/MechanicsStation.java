package com.kabanov.carfactory.station;

import com.kabanov.carfactory.AssemblyCarEntity;

public class MechanicsStation implements Station {
    @Override
    public void process(AssemblyCarEntity assemblyCarEntity) {
        assemblyCarEntity.assemblyMechanics();
    }

    @Override
    public StationType getStationType() {
        return StationType.ASSEMBLE;
    }
}
