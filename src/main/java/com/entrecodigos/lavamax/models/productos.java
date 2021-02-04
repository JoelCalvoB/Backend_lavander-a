package com.entrecodigos.lavamax.models;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class productos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_producto")
	private Long id;
	
	private String codigo;
	private String nombre;	
	private Long igualdad;
	private double p_costo;
	private double p_mayoreo;
	private double p_mediamayoreo;
	private double p_venta;
	private double p_especial;
	private double por_mayoreo;
	private double por_mediamayoreo;
	private double por_venta;
	private double por_especial;
	private boolean generar_seriesunidad;
	private boolean caducidad_serie;
	private boolean tieneiva;
	private double iva;
	private boolean tieneieeps;
	private double ieeps;
	private Long id_ficha;
	
	
	@ManyToOne
	@JoinColumn(name = "id_medida")
    private unidadesMedida unidadmedida;
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
    private clasificacion clasificacion;
	
	@ManyToOne
	@JoinColumn(name = "id_sucursal")
	
    private sucursales sucursales;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Long getIgualdad() {
		return igualdad;
	}
	public void setIgualdad(Long igualdad) {
		this.igualdad = igualdad;
	}
	
	public double getP_costo() {
		return p_costo;
	}
	public void setP_costo(double p_costo) {
		this.p_costo = p_costo;
	}
	public double getP_mayoreo() {
		return p_mayoreo;
	}
	public void setP_mayoreo(double p_mayoreo) {
		this.p_mayoreo = p_mayoreo;
	}
	public double getP_venta() {
		return p_venta;
	}
	public void setP_venta(double p_venta) {
		this.p_venta = p_venta;
	}
	public double getP_especial() {
		return p_especial;
	}
	public void setP_especial(double p_especial) {
		this.p_especial = p_especial;
	}
	public double getPor_mayoreo() {
		return por_mayoreo;
	}
	public void setPor_mayoreo(double por_mayoreo) {
		this.por_mayoreo = por_mayoreo;
	}
	public double getPor_venta() {
		return por_venta;
	}
	public void setPor_venta(double por_venta) {
		this.por_venta = por_venta;
	}
	public double getPor_especial() {
		return por_especial;
	}
	public void setPor_especial(double por_especial) {
		this.por_especial = por_especial;
	}
	public boolean isGenerar_seriesunidad() {
		return generar_seriesunidad;
	}
	public void setGenerar_seriesunidad(boolean generar_seriesunidad) {
		this.generar_seriesunidad = generar_seriesunidad;
	}
	public boolean isCaducidad_serie() {
		return caducidad_serie;
	}
	public void setCaducidad_serie(boolean caducidad_serie) {
		this.caducidad_serie = caducidad_serie;
	}
	
	public Long getId_ficha() {
		return id_ficha;
	}
	public void setId_ficha(Long id_ficha) {
		this.id_ficha = id_ficha;
	}
	public unidadesMedida getUnidadmedida() {
		return unidadmedida;
	}
	public void setUnidadmedida(unidadesMedida unidadmedida) {
		this.unidadmedida = unidadmedida;
	}
	public double getP_mediamayoreo() {
		return p_mediamayoreo;
	}
	public void setP_mediamayoreo(double p_mediamayoreo) {
		this.p_mediamayoreo = p_mediamayoreo;
	}
	public double getPor_mediamayoreo() {
		return por_mediamayoreo;
	}
	public void setPor_mediamayoreo(double por_mediamayoreo) {
		this.por_mediamayoreo = por_mediamayoreo;
	}
	public boolean isTieneiva() {
		return tieneiva;
	}
	public void setTieneiva(boolean tieneiva) {
		this.tieneiva = tieneiva;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public boolean isTieneieeps() {
		return tieneieeps;
	}
	public void setTieneieeps(boolean tieneieeps) {
		this.tieneieeps = tieneieeps;
	}
	public double getIeeps() {
		return ieeps;
	}
	public void setIeeps(double ieeps) {
		this.ieeps = ieeps;
	}
	
	
	@JsonIgnoreProperties(value = "productos")
	public clasificacion getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}
	public sucursales getSucursales() {
		return sucursales;
	}
	public void setSucursales(sucursales sucursales) {
		this.sucursales = sucursales;
	}	
}
