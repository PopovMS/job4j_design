package ru.job4j.ood.lsp.parking.service;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.model.Car;
import ru.job4j.ood.lsp.parking.model.PassengerCar;
import ru.job4j.ood.lsp.parking.model.Truck;
import ru.job4j.ood.lsp.parking.store.CarsParking;
import ru.job4j.ood.lsp.parking.store.LargeCarsParking;
import ru.job4j.ood.lsp.parking.store.PassCarsParking;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

public class ParkServiceTest {

    @Test
    public void whenTruckPark() {
        LargeCarsParking largeCars = new LargeCarsParking(5, 2);
        PassCarsParking passCars = new PassCarsParking(5, 1);
        CarsParking[] carsParkings = new CarsParking[] {largeCars, passCars};
        Car truck = new Truck("Volvo", 4);
        ParkService parkService = new SimpleParkService(carsParkings);
        parkService.park(truck);
        assertThat(largeCars.findBy(car -> "Volvo".equals(car.getName())).get(0)).isEqualTo(truck);
    }

    @Test
    public void whenPassengerCarPark() {
        LargeCarsParking largeCars = new LargeCarsParking(5, 2);
        PassCarsParking passCars = new PassCarsParking(5, 1);
        CarsParking[] carsParkings = new CarsParking[] {largeCars, passCars};
        Car passengerCar = new PassengerCar("Toyota");
        ParkService parkService = new SimpleParkService(carsParkings);
        parkService.park(passengerCar);
        assertThat(passCars.findBy(car -> "Toyota".equals(car.getName())).get(0)).isEqualTo(passengerCar);
    }

    @Test
    public void whenLargeParkIsBusyThenGoToPassengerCarPark() {
        LargeCarsParking largeCars = new LargeCarsParking(5, 2);
        PassCarsParking passCars = new PassCarsParking(5, 1);
        CarsParking[] carsParkings = new CarsParking[] {largeCars, passCars};
        Car truck = new Truck("Volvo", 4);
        Car truck2 = new Truck("MAN", 4);
        ParkService parkService = new SimpleParkService(carsParkings);
        parkService.park(truck);
        parkService.park(truck2);
        assertThat(passCars.findBy(car -> "MAN".equals(car.getName())).get(0)).isEqualTo(truck2);
    }

    @org.junit.Test(expected = NoSuchElementException.class)
    public void whenTruckUnpark() {
        LargeCarsParking largeCars = new LargeCarsParking(5, 2);
        PassCarsParking passCars = new PassCarsParking(5, 1);
        CarsParking[] carsParkings = new CarsParking[] {largeCars, passCars};
        Car truck = new Truck("Volvo", 4);
        ParkService parkService = new SimpleParkService(carsParkings);
        parkService.park(truck);
        parkService.unpark(truck.getName());
        largeCars.findBy(car -> "Volvo".equals(car.getName()));
    }
}