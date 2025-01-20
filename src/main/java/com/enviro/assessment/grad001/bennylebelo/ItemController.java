package com.enviro.assessment.grad001.bennylebelo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/setup")
    public String dummyData() {
        // Pre-populated data
        itemService.addItem(new Item("Plastic Bottle", "Recyclable",
                "Rinse the bottle to remove any residues before disposal.",
                "Flatten the bottle to save space and deposit it in the recycling bin."));
        itemService.addItem(new Item("Used Battery", "Hazardous",
                "Store in a cool, dry place and avoid mixing with regular waste.",
                "Take the battery to a designated e-waste collection center."));
        itemService.addItem(new Item("Apple Core", "Compostable",
                "Dispose in a compost bin or bury in soil for decomposition.",
                "Not applicable as it is organic waste."));

        return "Dummy Data Sucessfully Set Up";
    }



    @GetMapping("/db")//Return the entire table
    public Map<String, Iterable> getDatabase() {
        Map<String, Iterable> response = new HashMap<>();
        response.put("Waste Table", itemService.getAll());
        return response;
    }

//    @GetMapping("/{id}")//Return an Item by ID
//    public <String, Item> getItemById(@Valid @PathVariable Iterable<Integer> id) {
//
//        return database.get(id);
//    }

//    @PostMapping//Create an entirely new item
//    @ResponseStatus(HttpStatus.CREATED)
//    public Item addItem(@Valid @RequestBody Item newItem) {
//        if (database.containsKey(newItem.getId())) {throw new ResponseStatusException(HttpStatus.CONFLICT, "Item already exists");}
//        database.put(newItem.getId(), newItem);
//        return newItem;
//    }
//
//    @PutMapping("/{id}")//Update Item at a given id
//    public Item updateItem(@PathVariable Integer id, @RequestBody Item updatedItem) {
//        if (!database.containsKey(id)) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found");
//        }
//        database.put(id, updatedItem);
//        return updatedItem;
//    }
//
//    @DeleteMapping("/{id}")//Delete Item at a given id
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteItem(@PathVariable String id) {
//        if (!database.containsKey(id)) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found");
//        }
//        database.remove(id);
//    }
}
