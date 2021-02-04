package com.entrecodigos.lavamax.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.entrecodigos.lavamax.models.servicio;

public interface servicioRepository extends PagingAndSortingRepository<servicio, Long>{
     
	@Query("select u from servicio u where u.ordenPagada = ?1 order by u.idservicio")
	List<servicio> findByTicketCobrado(boolean cobrado);
	
	@Query("select u from servicio u where u.ordenPagada = ?1 and u.fechaterminado = ?2 order by u.idservicio")
	List<servicio> finbyticketCobradoFecha(boolean cobrado,Date fecha);
	
}
