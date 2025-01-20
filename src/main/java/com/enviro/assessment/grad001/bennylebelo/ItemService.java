package com.enviro.assessment.grad001.bennylebelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private ItemRepository items;

    public Item addItem(Item item) {
        return items.save(item);
    }

    public Iterable<Item> getAll() {
        return items.findAll();
    }

    public void deleteItem(Integer id) {
        items.deleteById(id);
    }

    public Iterable<Item> findByID(Iterable<Integer> id) {
        return items.findAllById(id);
    }
}
