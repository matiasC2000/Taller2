package entrega3;

import java.util.List;

import juegosOlimpicos.Deportista;

public interface DeportistaDAO {
	public List<Deportista> getList();

	public void guardar(Deportista d);
}
