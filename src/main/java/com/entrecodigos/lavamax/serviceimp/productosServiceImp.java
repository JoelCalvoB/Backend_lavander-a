package com.entrecodigos.lavamax.serviceimp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.entrecodigos.lavamax.models.productos;
import com.entrecodigos.lavamax.repository.productosRepository;
import com.entrecodigos.lavamax.service.productosService;



@Service
public class productosServiceImp implements productosService{

	@Autowired
	private productosRepository repositorio;
	

	@Override
	public List<productos> getAll() {
		List<productos> productos = new ArrayList<productos>();
		 this.repositorio.findAll().forEach(productos::add);
		return productos;
	}

	@Override
	public productos get(Long id) {
		Optional<productos> optproductos = this.repositorio.findById(id);
		if(optproductos.isPresent()) {
			return optproductos.get();
		}else {
			return null;
		}
	}

	@Override
	public productos insertar(productos obj) {
		productos p = this.repositorio.save(obj);
		return p;
	}

	@Override
	public productos actualizar(productos obj) {
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
	public List<productos> getProductosPaginado(int pagina) {
		List<productos> listaProductos = new ArrayList<productos>();
		Pageable paginacion = PageRequest.of(pagina,10,Direction.ASC,"id");
		
		this.repositorio.findAll(paginacion).forEach(listaProductos::add);
		return listaProductos;
	}
}
