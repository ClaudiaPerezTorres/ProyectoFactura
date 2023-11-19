package factura;

import java.util.ArrayList;

public class Datos {

	public Datos() {
		this.datos = new ArrayList<Producto>();
	}
	
	public void adicionarRegistro(Producto p) {
		datos.add(p);
	}
	
	public Producto obtenerPosicion(int posicion) {
		return datos.get(posicion);
	}
	
	public int tamano() {
		return datos.size();
	}
	
	private ArrayList<Producto>datos;
}
