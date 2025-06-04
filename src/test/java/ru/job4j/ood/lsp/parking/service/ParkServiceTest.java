package ru.job4j.ood.lsp.parking.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.model.Car;
import ru.job4j.ood.lsp.parking.model.PassengerCar;
import ru.job4j.ood.lsp.parking.model.Truck;
import ru.job4j.ood.lsp.parking.store.CarsParking;
import ru.job4j.ood.lsp.parking.store.LargeCarsParking;
import ru.job4j.ood.lsp.parking.store.PassCarsParking;
import java.util.ArrayList;
import java.util.List;

class ParkServiceTest {

    @Test
    void whenTruckPark() {
        List<CarsParking> parkings = new ArrayList<>();
        LargeCarsParking largeCars = new LargeCarsParking(5);
        PassCarsParking passCars = new PassCarsParking(5);
        parkings.add(largeCars);
        parkings.add(passCars);
        Car truck = new Truck("Volvo", 4);
        ParkService parkService = new SimpleParkService();
        parkService.park(truck);
        assertThat(largeCars.findBy(car -> "Volvo".equals(car.getName())).get(0)).isEqualTo(truck);
    }

    @Test
    void whenPassengerCarPark() {
        List<CarsParking> parkings = new ArrayList<>();
        LargeCarsParking largeCars = new LargeCarsParking(5);
        PassCarsParking passCars = new PassCarsParking(5);
        parkings.add(largeCars);
        parkings.add(passCars);
        Car passengerCar = new PassengerCar("Toyota");
        ParkService parkService = new SimpleParkService();
        parkService.park(passengerCar);
        assertThat(passCars.findBy(car -> "Toyota".equals(car.getName())).get(0)).isEqualTo(passengerCar);
    }

    @Test
    void whenLargeParkIsBusyThenGoToPassengerCarPark() {
        List<CarsParking> parkings = new ArrayList<>();
        LargeCarsParking largeCars = new LargeCarsParking(5);
        PassCarsParking passCars = new PassCarsParking(5);
        parkings.add(largeCars);
        parkings.add(passCars);
        Car truck = new Truck("Volvo", 4);
        ParkService parkService = new SimpleParkService();
        parkService.park(truck);
        assertThat(passCars.findBy(car -> "Volvo".equals(car.getName())).get(0)).isEqualTo(truck);
    }

}