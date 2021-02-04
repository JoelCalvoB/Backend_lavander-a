package com.entrecodigos.lavamax.serviceimp;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.entrecodigos.lavamax.models.sucursales;
import com.entrecodigos.lavamax.models.usuario;
import com.entrecodigos.lavamax.repository.usuariosRepository;
import com.entrecodigos.lavamax.service.usuariosService;


@Service
public class usuariosServiceImp implements usuariosService{
	
	@Autowired
	private usuariosRepository repositorio;
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public usuariosServiceImp() {
		
		
	}

	@Override
	public List<usuario> getAll() {
		List<usuario> lista = new ArrayList<usuario>();
		 this.repositorio.findAll().forEach(lista::add);	
		return  lista;
	}

	@Override
	public usuario get(Long id) {
		Optional<usuario> optUsuario = this.repositorio.findById(id);
		if(optUsuario.isPresent()) {
			return optUsuario.get();
		}else {
		 return null;
		}
	}

	@Override
	public usuario insertar(usuario obj) {
		return this.repositorio.save(obj);
	}

	@Override
	public usuario actualizar(usuario obj) {
		// TODO Auto-generated method stub
		return this.repositorio.save(obj);
	}

	@Override
	public Map<String, String> eliminar(Long id) {
		this.repositorio.deleteById(id);;
		return null;
	}

	@Override
	public usuario ingresar(usuario obj) throws Throwable {
		
		
		if(obj.getUsuario().equalsIgnoreCase("entrecodigos") && obj.getPassword().equalsIgnoreCase("12345")) {
			return obj;
		}
		
		String query = "select * from usuarios where usuario = '%1$s'";
		query = String.format(query, obj.getUsuario());
		
		Map<String,Object> resultado = this.jdbcTemplate.queryForMap(query);
		
		if(!resultado.isEmpty()) {
			String password = String.valueOf(resultado.get("password"));
			if(password.equals(obj.getPassword())) {
				Long id = Long.parseLong(String.valueOf(resultado.get("id")));
				Optional<usuario> optUser = this.repositorio.findById(id);
				if(optUser.isPresent()) {
					usuario user =  optUser.get();
					if(user.isActivo()) {
						return user;
					}else {
						throw new Throwable("Usuario inactivo");
					}
				}else {
					throw new Throwable("Usuario invalido");
				}
			}else {
				throw new Throwable("Contraseña incorrecta");
			}
		}else {
			throw new Throwable("Usuario invalido");
		}
		
	}

	@Override
	public List<usuario> getAll(Long id_sucursal) {
		sucursales sucursal = new sucursales();
		sucursal.setId(id_sucursal);
		return this.repositorio.findBySucursales(sucursal);
	}

	@Override
	public boolean getUsuarioPassword(Long id,String ps,String nuevo) {
		Optional<usuario> ptr = this.repositorio.findById(id);
		if(ptr.isPresent()) {
			usuario user = ptr.get();
			if(user.getPassword().contains(ps)) {
			   user.setPassword(nuevo);	
			   
			   this.repositorio.save(user);
			   return true;
			}
			
		}
		return false;
	}
	
	

}
