package ua.lviv.iot.spring.first.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.spring.first.rest.models.DessertPlate;
import ua.lviv.iot.spring.first.rest.service.DessertPlateService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/dessert-plates")
public class DessertPlateController {

    private final DessertPlateService dessertPlateService;

    @Autowired
    public DessertPlateController(DessertPlateService dessertPlateService) {
        this.dessertPlateService = dessertPlateService;
    }

    @GetMapping
    public List<DessertPlate> getAllDessertPlates() {
        return dessertPlateService.getAllDessertPlates();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DessertPlate> getDessertPlateById(@PathVariable Integer id) {
        try {
            DessertPlate dessertPlate = dessertPlateService.getDessertPlateById(id);
            return ResponseEntity.ok(dessertPlate);
        } catch (NoSuchElementException e) {
            System.out.println("Dessert plate with id " + id + " not found");
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<DessertPlate> addDessertPlate(@RequestBody DessertPlate dessertPlate) {
        DessertPlate addedDessertPlate = dessertPlateService.addDessertPlate(dessertPlate);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedDessertPlate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DessertPlate> updateDessertPlate(@PathVariable Integer id, @RequestBody DessertPlate dessertPlate) {
        DessertPlate updatedDessertPlate = dessertPlateService.updateDessertPlate(Math.toIntExact(id), dessertPlate);
        return updatedDessertPlate != null ? ResponseEntity.ok(updatedDessertPlate) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDessertPlate(@PathVariable Integer id) {
        if (dessertPlateService.deleteDessertPlate(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

