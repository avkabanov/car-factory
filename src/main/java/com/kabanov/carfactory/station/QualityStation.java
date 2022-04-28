package com.kabanov.carfactory.station;

import com.kabanov.carfactory.AssemblyCarEntity;
import java.util.Random;

public class QualityStation implements Station {
  private static final Random random = new Random();

  @Override
  public void process(AssemblyCarEntity assemblyCarEntity) {
    if (isQualityCheckPassed(assemblyCarEntity)) {
      assemblyCarEntity.setQualityCheckPassed();
    }
  }

  static boolean isQualityCheckPassed(AssemblyCarEntity assemblyCarEntity) {
    // with the probability of 80% the station quality check passed.
    return random.nextInt(100) < 80;
  }

  @Override
  public StationType getStationType() {
    return StationType.QUALITY;
  }
}
