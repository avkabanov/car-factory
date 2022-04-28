package com.kabanov.carfactory;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.kabanov.carfactory.station.Station;
import com.kabanov.carfactory.station.StationType;
import java.util.List;
import java.util.UUID;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

class AssemblyLineTest {

    @Test
    public void assembleStationShouldBeRetriggeredWhenQualityCheckFailed() {
        AssemblyCarEntity entity = new AssemblyCarEntity();

        Station assembleStation = getMockedStation(StationType.ASSEMBLE);
        Station qualityStation = getMockedStation(StationType.QUALITY);

        doNothing().doAnswer(
                        inv -> {
                            entity.setQualityCheckPassed();
                            return null;
                        })
                .when(qualityStation)
                .process(entity);

        AssemblyLine assemblyLine = new AssemblyLine(List.of(assembleStation, qualityStation));
        assemblyLine.produce(entity);

        InOrder inOrder = inOrder(assembleStation, qualityStation, assembleStation, qualityStation);
        inOrder.verify(assembleStation).process(entity);
        inOrder.verify(qualityStation).process(entity);
        inOrder.verify(assembleStation).process(entity);
        inOrder.verify(qualityStation).process(entity);
    }

    @Test
    public void qualityStationsShouldGoLast() {
        Station assembleFirst = getMockedStation(StationType.ASSEMBLE, "assembleFirst");
        Station qualityFirst = getMockedStation(StationType.QUALITY, "qualityFirst");
        Station assembleSecond = getMockedStation(StationType.ASSEMBLE, "assembleSecond");
        Station qualitySecond = getMockedStation(StationType.QUALITY, "qualitySecond");

        List<Station> stationsList = List.of(
                assembleFirst,
                qualityFirst,
                assembleSecond,
                qualitySecond
        );

        Assertions.assertThat(AssemblyLine.sortStations(stationsList))
                .isEqualTo(
                        List.of(
                                assembleFirst,
                                assembleSecond,
                                qualityFirst,
                                qualitySecond));
    }

    private static Station getMockedStation(StationType stationType) {
        return getMockedStation(stationType, UUID.randomUUID().toString());
    }

    private static Station getMockedStation(StationType stationType, String stationName) {
        Station station = mock(Station.class);
        when(station.getStationType()).thenReturn(stationType);
        when(station.toString()).thenReturn(stationName);

        return station;
    }
}
