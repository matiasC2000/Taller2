package entrega3;

import java.util.List;
import juegosOlimpicos.Pais;

public interface PaisDAO {
	public List<Pais> getList();

	public void guardar(Pais d);

	public int getFilas();

	public void eliminar(int id);
	
	public Pais getPais(int id);

	public void editar(Pais p);
}
