package core.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RegistroModulosHook")
public class RegistroModulosHook {

	@Id
	@GeneratedValue
	private int idRegistro;
	private int posicion;
	
	@ManyToOne
	@JoinColumn(name = "idHook")
	private Hook hook;
	
	@ManyToOne
	@JoinColumn(name = "idModulos")
	private Modulos modulos;

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public Hook getHook() {
		return hook;
	}

	public void setHook(Hook hook) {
		this.hook = hook;
	}

	public Modulos getModulos() {
		return modulos;
	}

	public void setModulos(Modulos modulos) {
		this.modulos = modulos;
	}
	
	
}
