package web.service;


import org.springframework.stereotype.Service;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private static final List<Car> cars = new ArrayList<>();

    static {
        cars.add(new Car(1, "Black", 100));
        cars.add(new Car(2, "Red", 150));
        cars.add(new Car(3, "Gray", 130));
        cars.add(new Car(4, "Pink", 110));
        cars.add(new Car(5, "Yellow", 120));
    }

    public List<Car> getCars(Integer count) {

        if (count == null || count >= cars.size()) {
            return cars;
        } else {
            return cars.stream().limit(count).collect(Collectors.toList());
        }
    }

}
