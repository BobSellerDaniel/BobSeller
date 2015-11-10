package core.pojo;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Hook")
public class Hook {

	@Id
	@GeneratedValue
	private int idHook;
	private String nombre;
	private String descripcion;
	private String display;
	
	@OneToMany(mappedBy="hook")
	private Set<RegistroModulosHook> registroHook;
	
	public Set<RegistroModulosHook> getRegistroModulosHook() {return registroHook;}
	public void setRegistroModulosHook(Set<RegistroModulosHook> registroHook) {this.registroHook = registroHook;}
	public int getIdHook() {return idHook;}
	public void setIdHook(int idHook) {this.idHook = idHook;}
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public String getDescripcion() {return descripcion;}
	public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
	public String getDisplay() {return display;}
	public void setDisplay(String display) {this.display = display;}
	
	@Override
	public String toString() {
		return "Hook [idHook=" + idHook + ", nombre=" + nombre + ", descripcion=" + descripcion + ", display=" + display
				+ "]";
	}
}
