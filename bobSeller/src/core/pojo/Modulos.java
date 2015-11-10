package core.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Modulos")
public class Modulos {

	@Id
	@GeneratedValue
	private int idModulos;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "idMenu")
	private Menus idMenu;
	
	private String nombre;
	private String descripcion;
	private String version;
	private String clase;
	private String paquete;
	private String titulo;
	private String acl;
	private String estado;
	public int getIdModulos() {
		return idModulos;
	}
	public void setIdModulos(int idModulos) {
		this.idModulos = idModulos;
	}
	public Menus getIdMenu() {
		return idMenu;
	}
	public void setIdMenu(Menus idMenu) {
		this.idMenu = idMenu;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	public String getPaquete() {
		return paquete;
	}
	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAcl() {
		return acl;
	}
	public void setAcl(String acl) {
		this.acl = acl;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Modulos [idModulos=" + idModulos + ", idMenu=" + idMenu + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", version=" + version + ", clase=" + clase + ", paquete=" + paquete + ", titulo="
				+ titulo + ", acl=" + acl + ", estado=" + estado + "]";
	}
	
	
	
}