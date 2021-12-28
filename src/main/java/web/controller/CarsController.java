package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    @GetMapping(value = "/cars")
    public String printCars(ModelMap model, @RequestParam(value = "count", required = false) Integer count) {

        List<Car> cars0 = new ArrayList<>();
        cars0.add(new Car(1, "Black", 100));
        cars0.add(new Car(2, "Red", 150));
        cars0.add(new Car(3, "Gray", 130));
        cars0.add(new Car(4, "Pink", 110));
        cars0.add(new Car(5, "Yellow", 120));

        List<Car> cars = new ArrayList<>();
        if (count == null || count >= cars0.size()) {
            cars = cars0;
        } else {
            for (int i = 0; i < count; i++) {
                cars.add(cars0.get(i));
            }
        }
        model.addAttribute("cars", cars);
        return "cars";
    }

}
