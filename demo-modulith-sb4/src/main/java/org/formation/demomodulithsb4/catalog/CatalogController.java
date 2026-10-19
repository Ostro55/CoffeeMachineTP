package org.formation.demomodulithsb4.catalog;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("coffees")
public class CatalogController {

    private final Catalog catalog;

    CatalogController(Catalog catalog) {
        this.catalog = catalog;
    }

    @PostMapping
    Long createCoffee(@RequestParam String name, @RequestParam int price) {
        return catalog.createCoffee(name, price);
    }
}
