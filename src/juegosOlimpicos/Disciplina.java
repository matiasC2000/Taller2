package juegosOlimpicos;

import java.util.ArrayList;

/** 
 * Cada disciplina (basquet, natacion, etc)
 * @author Reverte y Calvo
 **/

public class Disciplina {
	private int id;
	private String nombre;
	private Juegos juego;
	private ArrayList<Equipo> equipos;
	private Tipo_Disciplina categoria;
	private ArrayList<Evento> partidos;
	
	
	public Disciplina(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Juegos getJuego() {
		return juego;
	}
	public void setJuego(Juegos juego) {
		this.juego = juego;
	}
	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}
	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}
	public Tipo_Disciplina getCategoria() {
		return categoria;
	}
	public void setCategoria(Tipo_Disciplina categoria) {
		this.categoria = categoria;
	}
	public ArrayList<Evento> getPartidos() {
		return partidos;
	}
	public void setPartidos(ArrayList<Evento> partidos) {
		this.partidos = partidos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
