package com.entrecodigos.lavamax.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.entrecodigos.lavamax.models.cliente;

public interface clientesRepository extends PagingAndSortingRepository<cliente, Long> {

}
