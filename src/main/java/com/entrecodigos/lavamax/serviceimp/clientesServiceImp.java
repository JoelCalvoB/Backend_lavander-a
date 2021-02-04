package com.entrecodigos.lavamax.serviceimp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entrecodigos.lavamax.models.cliente;
import com.entrecodigos.lavamax.repository.clientesRepository;
import com.entrecodigos.lavamax.service.clientesService;


@Service
public class clientesServiceImp implements clientesService{

	@Autowired
	private clientesRepository repositorio;
	
	
	@Override
	public List<cliente> getAll() {
		List<cliente> cliente = new ArrayList<cliente>();
		 this.repositorio.findAll().forEach(cliente::add);
		return cliente;
	}

	@Override
	public cliente get(Long id) {
		Optional<cliente> optcliente = this.repositorio.findById(id);
		if(optcliente.isPresent()) {
			return optcliente.get();
		}else {
			return null;
		}
	}

	@Override
	public cliente insertar(cliente obj) {
		return this.repositorio.save(obj);
	}

	@Override
	public cliente actualizar(cliente obj) {
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
	public List<cliente> getClientesPaginado(int pagina) {
		// TODO Auto-generated method stub
		return null;
	}

}
