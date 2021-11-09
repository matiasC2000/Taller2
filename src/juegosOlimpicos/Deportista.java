package juegosOlimpicos;

import java.util.ArrayList;

public class Deportista extends Persona {
	private int id;
	private Delegacion delegaciob;
	private ArrayList<Equipo> equipos;

	
	
	
	public Deportista() {
		super();
	}



	public Deportista(String nombre, String apellido, int edad) {
		super(nombre, apellido, edad);
		// TODO Auto-generated constructor stub
	}

	
	
	public Delegacion getDelegaciob() {
		return delegaciob;
	}

	public void setDelegaciob(Delegacion delegaciob) {
		this.delegaciob = delegaciob;
	}

	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
