package com.example.rest.bootstrap;

import com.example.rest.domain.Beer;
import com.example.rest.domain.BeerStyle;
import com.example.rest.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;
import java.util.stream.IntStream;

@Component
public class BeerBootstrap implements CommandLineRunner {

    @Autowired
    BeerRepository repository;

    @Override
    public void run(String... args) throws Exception {
        loadBeer();
        System.out.println(repository.count());
    }

    private synchronized void loadBeer() {
        Random random = new Random();
        if (repository.count() == 0) {
            IntStream.range(0, 15).forEach(value -> {
                repository.save(Beer.builder()
                        .beerName("Beer " + value)
                        .upc("upc" + value)
                        .style(BeerStyle.randomStyle())
                        .quantityOnHand(random.nextInt(1000))
                        .price(BigDecimal.valueOf(random.nextLong(1000)))
                        .build());
            });
        }
    }
}
