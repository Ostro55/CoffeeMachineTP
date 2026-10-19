package org.formation.demomodulithsb4.catalog;

import lombok.RequiredArgsConstructor;
import org.formation.demomodulithsb4.catalog.internal.CoffeeEntity;
import org.formation.demomodulithsb4.catalog.internal.CoffeeRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class Catalog {

    private final CoffeeRepository coffeeRepository;
    private final ApplicationEventPublisher events;

    @Transactional
    public Long createCoffee(String name, int price) {
        CoffeeEntity saved = coffeeRepository.save(new CoffeeEntity(name, price));
        events.publishEvent(new CoffeeCreated(saved.getId(), saved.getName()));
        return saved.getId();
    }
}
