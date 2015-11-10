package core.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mapeo_hook")
public class mapeo_hook implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private int idHook;
	@Id
	private int idModulos;
	@Id
	private int idMenu;
	private int idPadre;
	private int posicion;
	private String url;
	private String urlDescripcion;
	private String hookNombre;
	private String hookDescripcion;
	private String display;
	private String moduloNombre;
	private String moduloDescripcion;
	private String moduloVersion;
	private String moduloClase;
	private String moduloPaquete;
	private String moduloTitulo;
	private String moduloEstado;
	private String moduloAcl;
	private String menuNombre;
	private String menuDescripcion;
	private String menuIcono;
	private String menuTitulo;
	public int getIdHook() {
		return idHook;
	}
	public void setIdHook(int idHook) {
		this.idHook = idHook;
	}
	public int getIdModulos() {
		return idModulos;
	}
	public void setIdModulos(int idModulos) {
		this.idModulos = idModulos;
	}
	public int getIdMenu() {
		return idMenu;
	}
	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}
	public int getIdPadre() {
		return idPadre;
	}
	public void setIdPadre(int idPadre) {
		this.idPadre = idPadre;
	}
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrlDescripcion() {
		return urlDescripcion;
	}
	public void setUrlDescripcion(String urlDescripcion) {
		this.urlDescripcion = urlDescripcion;
	}
	public String getHookNombre() {
		return hookNombre;
	}
	public void setHookNombre(String hookNombre) {
		this.hookNombre = hookNombre;
	}
	public String getHookDescripcion() {
		return hookDescripcion;
	}
	public void setHookDescripcion(String hookDescripcion) {
		this.hookDescripcion = hookDescripcion;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getModuloNombre() {
		return moduloNombre;
	}
	public void setModuloNombre(String moduloNombre) {
		this.moduloNombre = moduloNombre;
	}
	public String getModuloDescripcion() {
		return moduloDescripcion;
	}
	public void setModuloDescripcion(String moduloDescripcion) {
		this.moduloDescripcion = moduloDescripcion;
	}
	public String getModuloVersion() {
		return moduloVersion;
	}
	public void setModuloVersion(String moduloVersion) {
		this.moduloVersion = moduloVersion;
	}
	public String getModuloClase() {
		return moduloClase;
	}
	public void setModuloClase(String moduloClase) {
		this.moduloClase = moduloClase;
	}
	public String getModuloPaquete() {
		return moduloPaquete;
	}
	public void setModuloPaquete(String moduloPaquete) {
		this.moduloPaquete = moduloPaquete;
	}
	public String getModuloTitulo() {
		return moduloTitulo;
	}
	public void setModuloTitulo(String moduloTitulo) {
		this.moduloTitulo = moduloTitulo;
	}
	public String getModuloEstado() {
		return moduloEstado;
	}
	public void setModuloEstado(String moduloEstado) {
		this.moduloEstado = moduloEstado;
	}
	public String getModuloAcl() {
		return moduloAcl;
	}
	public void setModuloAcl(String moduloAcl) {
		this.moduloAcl = moduloAcl;
	}
	public String getMenuNombre() {
		return menuNombre;
	}
	public void setMenuNombre(String menuNombre) {
		this.menuNombre = menuNombre;
	}
	public String getMenuDescripcion() {
		return menuDescripcion;
	}
	public void setMenuDescripcion(String menuDescripcion) {
		this.menuDescripcion = menuDescripcion;
	}
	public String getMenuIcono() {
		return menuIcono;
	}
	public void setMenuIcono(String menuIcono) {
		this.menuIcono = menuIcono;
	}
	public String getMenuTitulo() {
		return menuTitulo;
	}
	public void setMenuTitulo(String menuTitulo) {
		this.menuTitulo = menuTitulo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "mapeo_hook [idHook=" + idHook + ", idModulos=" + idModulos + ", idMenu=" + idMenu + ", idPadre="
				+ idPadre + ", posicion=" + posicion + ", url=" + url + ", urlDescripcion=" + urlDescripcion
				+ ", hookNombre=" + hookNombre + ", hookDescripcion=" + hookDescripcion + ", display=" + display
				+ ", moduloNombre=" + moduloNombre + ", moduloDescripcion=" + moduloDescripcion + ", moduloVersion="
				+ moduloVersion + ", moduloClase=" + moduloClase + ", moduloPaquete=" + moduloPaquete
				+ ", moduloTitulo=" + moduloTitulo + ", moduloEstado=" + moduloEstado + ", moduloAcl=" + moduloAcl
				+ ", menuNombre=" + menuNombre + ", menuDescripcion=" + menuDescripcion + ", menuIcono=" + menuIcono
				+ ", menuTitulo=" + menuTitulo + "]";
	}
	
}
