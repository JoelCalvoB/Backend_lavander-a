package com.entrecodigos.lavamax.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.entrecodigos.lavamax.models.sucursales;
import com.entrecodigos.lavamax.models.usuario;

public interface usuariosRepository  extends CrudRepository<usuario, Long>{
   List<usuario> findBySucursales(sucursales sucursales);  
}
