package com.kabanov.carfactory;

import com.kabanov.carfactory.station.InteriorPartsStation;
import com.kabanov.carfactory.station.MechanicsStation;
import com.kabanov.carfactory.station.PaintingStation;
import com.kabanov.carfactory.station.PolishingStation;
import com.kabanov.carfactory.station.QualityStation;
import com.kabanov.carfactory.station.Station;
import java.util.List;

public class Main {

  /*
   * Please note, here are some things I haven't implemented for the sake of simplicity, but definitely
   * room for improvement: 
   *  - set up a logger and use it instead of printing to the standard output.
   *  - set up Spring or Guice for the DI.   
   */

  public static void main(String[] args) {
    List<Station> stations =
        List.of(
            new InteriorPartsStation(),
            new QualityStation(),
            new MechanicsStation(),
            new PolishingStation(),
            new PaintingStation());
    AssemblyLine assemblyLine = new AssemblyLine(stations);
    Car car = assemblyLine.produce(new AssemblyCarEntity());
    System.out.println("Produced a car: " + car);
  }
}
