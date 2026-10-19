package org.formation.demomodulithsb4.inventory.internal;

import org.formation.demomodulithsb4.catalog.CoffeeCreated;
import org.springframework.modulith.events.ApplicationModuleListener;

public class InventoryListener {

    private final StockRepository stockRepository;

    public InventoryListener(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @ApplicationModuleListener
    void on(CoffeeCreated event) {
        stockRepository.save(new StockEntity(event.coffeeId(), 0));
    }
}
