package ua.lviv.iot.spring.first.rest.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.first.rest.models.DessertPlate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DessertPlateService {
    private Map<Integer, DessertPlate> dessertPlates = new HashMap<>();
    private int nextAvailableId = 1;

    public DessertPlate addDessertPlate(DessertPlate dessertPlate) {
        if (dessertPlate.getId() == null) {
            dessertPlate.setId((Integer) nextAvailableId++);
        }
        dessertPlates.put(dessertPlate.getId(), dessertPlate);
        return dessertPlate;
    }

    public DessertPlate getDessertPlateById(Integer id) {
        return dessertPlates.get(id);
    }

    public List<DessertPlate> getAllDessertPlates() {
        return new ArrayList<>(dessertPlates.values());
    }

    public boolean deleteDessertPlate(Integer id) {
        if (dessertPlates.containsKey(id)) {
            dessertPlates.remove(id);
            return true;
        }
        return false;
    }

    public DessertPlate updateDessertPlate(Integer id, DessertPlate dessertPlate) {
        if (dessertPlates.containsKey(id)) {
            dessertPlate.setId(id);
            dessertPlates.put(id, dessertPlate);
            return dessertPlate;
        }
        return null;
    }
}