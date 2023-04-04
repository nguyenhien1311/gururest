package com.example.rest.repositories;

import com.example.rest.domain.Beer;
import com.example.rest.domain.BeerStyle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;
@RepositoryRestResource(path = "olala")
public interface BeerRepository extends JpaRepository<Beer, UUID> {
    Page<Beer> findAllByBeerNameLikeIgnoreCase(String name, Pageable pageable);

    Page<Beer> findAllByStyle(BeerStyle style,Pageable pageable);
}
