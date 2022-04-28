package com.kabanov.carfactory.station;

import com.kabanov.carfactory.AssemblyCarEntity;

public interface Station {
    
    void process(AssemblyCarEntity assemblyCarEntity);
    
    StationType getStationType();
}
