package com.entrecodigos.lavamax.service;

import java.util.List;
import java.util.Map;

import com.entrecodigos.lavamax.models.unidadesMedida;

public interface unidadesMedidaService {
	public List<unidadesMedida> getAll();
	public unidadesMedida get(Long id);
	public unidadesMedida insertar(unidadesMedida obj);
	public unidadesMedida actualizar(unidadesMedida obj);
	public Map<String,String> eliminar(Long id);
}
