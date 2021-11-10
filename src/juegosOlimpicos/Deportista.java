package juegosOlimpicos;

import java.util.ArrayList;

public class Deportista extends Persona {
	private Delegacion delegacion;
	private Disciplina disciplina;
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
	
	public Deportista(String nombre, String apellido, String email, Pais p,Disciplina d) {
		super(nombre, apellido, email,p); // -1 es que no lo coloco la base de datos
		this.disciplina = d;
	}
	
	public Deportista(int id ,String nombre, String apellido, String email, Pais p, Disciplina d) {
		super(id,nombre, apellido, email,p);
		this.disciplina = d;
	}

	
	
	public Delegacion getDelegacion() {
		return delegacion;
	}

	public void setDelegacion(Delegacion delegaciob) {
		this.delegacion = delegaciob;
	}

	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}


	public Disciplina getDisciplina() {
		return disciplina;
	}


	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	

}
