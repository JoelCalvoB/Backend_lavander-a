package com.entrecodigos.lavamax;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.entrecodigos.lavamax.models.menu;
import com.entrecodigos.lavamax.models.roles;
import com.entrecodigos.lavamax.models.sucursales;
import com.entrecodigos.lavamax.models.usuario;
import com.entrecodigos.lavamax.repository.menuRepository;
import com.entrecodigos.lavamax.repository.rolesRepository;
import com.entrecodigos.lavamax.repository.sucursalesRepository;
import com.entrecodigos.lavamax.repository.usuariosRepository;



@Configuration
public class configuracionCors {
	 @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurerAdapter() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**")
	                        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
	            }
	        };
	    }
	 
	 @Autowired
	 private menuRepository menuRepo;
	 
	 @Autowired
	 private rolesRepository rolesRepo;
	 
	 @Autowired
	 private sucursalesRepository sucurepo;
	 
	 @Autowired
	 private usuariosRepository usuRepo;
	 
	 @Bean	
	 public void insertarValoresAutomaticos() {
		 menu menu1 = new menu();
		 menu1.setId(Long.parseLong("1"));
		 menu1.setNombreMenu("sucursales");
		 menu1.setActivo(true);
		 menuRepo.save(menu1);
		 
		 menu menu2 = new menu();
		 menu2.setId(Long.parseLong("2"));
		 menu2.setNombreMenu("roles");
		 menu2.setActivo(true);
		 menuRepo.save(menu2);
		 
		 menu menu3 = new menu();
		 menu3.setId(Long.parseLong("3"));
		 menu3.setNombreMenu("usuarios");
		 menu3.setActivo(true);
		 menuRepo.save(menu3);
		 
		 menu menu4 = new menu();
		 menu4.setId(Long.parseLong("4"));
		 menu4.setNombreMenu("lineas");
		 menu4.setActivo(true);
		 menuRepo.save(menu4);
		 
		 menu menu5 = new menu();
		 menu5.setId(Long.parseLong("5"));
		 menu5.setNombreMenu("productos");
		 menu5.setActivo(true);
		 menuRepo.save(menu5);
		 
		 menu menu6 = new menu();
		 menu6.setId(Long.parseLong("6"));
		 menu6.setNombreMenu("unidadmedida");
		 menu6.setActivo(true);
		 menuRepo.save(menu6);
		 
		 menu menu7 = new menu();
		 menu7.setId(Long.parseLong("7"));
		 menu7.setNombreMenu("proveedores");
		 menu7.setActivo(true);
		 menuRepo.save(menu7);
		 
		 menu menu8 = new menu();
		 menu8.setId(Long.parseLong("8"));
		 menu8.setNombreMenu("clientes");
		 menu8.setActivo(true);
		 menuRepo.save(menu8);
		 
		 menu menu9 = new menu();
		 menu9.setId(Long.parseLong("9"));
		 menu9.setNombreMenu("servicios");
		 menu9.setActivo(true);
		 menuRepo.save(menu9);
		 
		 menu menu10 = new menu();
		 menu10.setId(Long.parseLong("10"));
		 menu10.setNombreMenu("corteinventarios");
		 menu10.setActivo(true);
		 menuRepo.save(menu10);
		 
		 menu menu11 = new menu();
		 menu11.setId(Long.parseLong("11"));
		 menu11.setNombreMenu("controlmovimientos");
		 menu11.setActivo(true);
		 menuRepo.save(menu11);
		 
		 menu menu12 = new menu();
		 menu12.setId(Long.parseLong("12"));
		 menu12.setNombreMenu("detallefichas");
		 menu12.setActivo(true);
		 menuRepo.save(menu12);
		 
		 roles rolnuevo = new roles();
		 
		 if(this.rolesRepo.count() == 0) {
			 roles rol = new roles();
			 rol.setId(Long.parseLong("1"));
			 rol.setNombre("Super administrador");
			 rol.setListaMenu(null);
			 rolnuevo = rolesRepo.save(rol);	 
			 List<menu> menus = new ArrayList<menu>();
			 menus.add(menu1);
			 menus.add(menu2);
			 menus.add(menu3);
			 menus.add(menu4);
			 menus.add(menu5);
			 menus.add(menu6);
			 menus.add(menu7);
			 menus.add(menu8);
			 menus.add(menu9);
			 rolnuevo.setListaMenu(menus);
			 
			 rolnuevo = rolesRepo.save(rolnuevo);
		 }
		 sucursales sucursal  = new sucursales();
		 if(this.sucurepo.count() == 0) {
			 
			 sucursal.setId(Long.parseLong("1"));
			 sucursal.setActiva(true);
			 sucursal.setDireccion("default");
			 sucursal.setNombre("default");
			 
			 sucursal = sucurepo.save(sucursal);
		 }
		 
		 
		
		 
		 
		if(this.usuRepo.count() == 0) {
			 usuario user = new usuario();
			 user.setUsuario("Admin");
			 user.setNombre("mi empresa");
			 user.setApellido("entrecodigos");
			 user.setRoles(rolnuevo);
			 user.setSucursales(sucursal);
			 user.setPassword("entrecodigos");
			 user.setActivo(true);
			 
			 usuRepo.save(user);
		}
		 
		 
		 
		 
	 }
}
