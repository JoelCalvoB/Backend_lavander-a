package com.entrecodigos.lavamax.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.entrecodigos.lavamax.models.servicio_detalle;



public interface servicio_detalleRepository extends PagingAndSortingRepository<servicio_detalle, Long> {
    public List<servicio_detalle> findByIdservicio(Long idservicio);
    
}