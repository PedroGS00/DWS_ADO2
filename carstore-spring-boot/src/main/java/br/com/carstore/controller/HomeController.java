package br.com.carstore.controller;

import br.com.carstore.model.CarDTO;
import br.com.carstore.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private final CarService carService;

    public HomeController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("carDTO", new CarDTO());
        return "index";
    }

    @PostMapping("/cars")
    public String createCar(@ModelAttribute CarDTO car) {
        carService.save(car);
        return "redirect:/cars";
    }

    @GetMapping("/cars")
    public String getAllCars(Model model) {
        model.addAttribute("cars", carService.findAll());
        return "dashboard";
    }

    @PostMapping("/cars/delete/{id}")
    public String deleteCar(@PathVariable String id) {
        carService.deleteById(id);
        return "redirect:/cars";
    }

    @GetMapping("/cars/edit/{id}")
    public String editCar(@PathVariable String id, Model model) {
        CarDTO carDTO = carService.findById(id);
        if (carDTO == null) {
            return "redirect:/cars";
        }
        model.addAttribute("carDTO", carDTO);
        return "edit";
    }

    @PostMapping("/cars/update/{id}")
    public String updateCar(@PathVariable String id, @ModelAttribute CarDTO car) {
        carService.update(id, car);
        return "redirect:/cars";
    }
}
