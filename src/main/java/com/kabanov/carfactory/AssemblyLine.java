package com.kabanov.carfactory;

import com.kabanov.carfactory.station.Station;
import com.kabanov.carfactory.station.StationType;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class AssemblyLine {

  private final List<Station> stations;
  
  private static final Comparator<Station> comparator = (o1, o2) -> {
    if (o1.getStationType() == StationType.QUALITY) {
      return 1;
    } else if (o2.getStationType() == StationType.QUALITY) {
      return -1;
    } else {
      return 0;  
    }
  }; 

  public AssemblyLine(List<Station> stations) {
    this.stations = sortStations(stations);
  }

  static List<Station> sortStations(List<Station> stations) {
    return stations.stream().sorted(comparator).toList();
  }

  static List<Station> sortStations1(List<Station> stations) {
    return Stream.concat(
                stations.stream()
                    .filter(station -> station.getStationType() != StationType.QUALITY),
                stations.stream()
                    .filter(station -> station.getStationType() == StationType.QUALITY))
            .toList();
  }

  public Car produce(AssemblyCarEntity assemblyCarEntity) {
    do {
      System.out.println("Assembling " + assemblyCarEntity);
      stations.forEach(station -> station.process(assemblyCarEntity));
      System.out.println("Quality check result: " + assemblyCarEntity.isQualityCheckPassed());
    } while (!assemblyCarEntity.isQualityCheckPassed());

    return assemblyCarEntity.build();
  }
}
