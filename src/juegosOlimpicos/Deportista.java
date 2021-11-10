package juegosOlimpicos;

import java.util.ArrayList;

public class Deportista extends Persona {
	private Delegacion delegaciob;
	private ArrayList<Equipo> equipos;

	
	
	
	public Deportista() {
		super();
	}

	
	public Deportista(String nombre, String apellido, String email) {
		super(nombre, apellido, email);
	}

	public Deportista(int id ,String nombre, String apellido, String email) {
		super(id,nombre, apellido, email);
	}
	
	public Deportista(String nombre, String apellido, String email, Pais p) {
		super(nombre, apellido, email,p); // -1 es que no lo coloco la base de datos
	}
	
	public Deportista(int id ,String nombre, String apellido, String email, Pais p) {
		super(id,nombre, apellido, email,p);
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

	

}
