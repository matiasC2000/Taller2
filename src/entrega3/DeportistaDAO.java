package entrega3;

import java.util.List;

import juegosOlimpicos.Deportista;

public interface DeportistaDAO {
	public List<Deportista> getList();
	
	
	/**
	 * @param d
	 * @return retorna el id del deportista
	 */
	public int guardar(Deportista d);
}
