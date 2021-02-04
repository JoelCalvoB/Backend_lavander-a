package com.entrecodigos.lavamax.serviceimp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entrecodigos.lavamax.models.clasificacion;
import com.entrecodigos.lavamax.repository.clasificacionRepository;
import com.entrecodigos.lavamax.service.clasificacionService;

@Service
public class clasificacionServiceImp implements clasificacionService{


	@Autowired
	private clasificacionRepository repositorio;
	
	@Override
	public List<clasificacion> getAll() {
		List<clasificacion> clasificacion = new ArrayList<clasificacion>();
		 this.repositorio.findAll().forEach(clasificacion::add);
		return clasificacion;
	}

	@Override
	public clasificacion get(Long id) {
		Optional<clasificacion> optclasificacion = this.repositorio.findById(id);
		if(optclasificacion.isPresent()) {
			return optclasificacion.get();
		}else {
			return null;
		}
	}

	@Override
	public clasificacion insertar(clasificacion obj) {
		return this.repositorio.save(obj);
	}

	@Override
	public clasificacion actualizar(clasificacion obj) {
		return this.repositorio.save(obj);
	}

	@Override
	public Map<String, String> eliminar(Long id) {
		this.repositorio.deleteById(id);
		Map<String,String> resultado = new HashMap<String,String>();
		resultado.put("resultado", "Registro eliminado con exito");
		return resultado;
	}

	@Override
	public List<clasificacion> getClasificacionPaginado(int pagina) {
		// TODO Auto-generated method stub
		return null;
	}

}
