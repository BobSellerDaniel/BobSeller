package core.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="indexadmintablas")
public class IndexAdminTablas {
	
	@Id
	@GeneratedValue
	private String nombreTabla;
	private int filas;
	private int idMax;
	private int idMin;
	
	public String getNombreTabla() {return nombreTabla;}
	public void setNombreTabla(String nombreTabla) {this.nombreTabla = nombreTabla;}
	
	public int getFilas() {return filas;}
	public void setFilas(int filas) {this.filas = filas;}
	
	public int getIdMax() {return idMax;}
	public void setIdMax(int idMax) {this.idMax = idMax;}
	
	public int getIdMin() {return idMin;}
	public void setIdMin(int idMin) {this.idMin = idMin;}
	
	@Override
	public String toString() {
		return "IndexAdminTablas [nombreTabla=" + nombreTabla + ", filas=" + filas + ", idMax=" + idMax + ", idMin="+ idMin + "]";
	}
	
}
