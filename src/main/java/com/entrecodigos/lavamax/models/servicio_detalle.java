package com.entrecodigos.lavamax.models;


import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
@Entity
public class servicio_detalle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_registro")
	@OrderBy
	private Long idserviciodetalle;
	
	@ManyToOne
	@JoinColumn(name = "idproducto")
	private productos producto;
	private Long idproductoficha;
	private Long idficha;
	private Long cantficha;
	private Date fecha;
	private String hora ;
	private Long descuento;
	private boolean cancelado;	private boolean ficha_adicional;

	
	
	
	public boolean isFicha_adicional() {
		return ficha_adicional;
	}

	public void setFicha_adicional(boolean ficha_adicional) {
		this.ficha_adicional = ficha_adicional;
	}

	private Long idservicio;
	
	public Long getIdserviciodetalle() {
		return idserviciodetalle;
			
	}
	
	public Long getIdservicio() {
		return idservicio;
	}
	public void setIdservicio(Long idservicio) {
		this.idservicio = idservicio;
	} 
	
	public productos getProducto() {
		return producto;
	}
	public void setProducto(productos producto) {
		this.producto = producto;
	}
	public Long getIdficha() {
		return idficha;
	}
	public void setIdficha(Long idficha) {
		this.idficha = idficha;
	}
	public Long getIdproductoficha() {
		return idproductoficha;
	}
	public void setIdproductoficha(Long idproductoficha) {
		this.idproductoficha = idproductoficha;
	}
	public Long getIdfciha() {
		return idficha;
	}
	public void setIdfciha(Long idfciha) {
		this.idficha = idfciha;
	}
	public Long getCantficha() {
		return cantficha;
	}
	public void setCantficha(Long cantficha) {
		this.cantficha = cantficha;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public void setIdserviciodetalle(Long idserviciodetalle) {
		this.idserviciodetalle = idserviciodetalle;
	}
	public Long getDescuento() {
		return descuento;
	}
	public void setDescuento(Long descuento) {
		this.descuento = descuento;
	}

	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}	
	
	
	
	
}
