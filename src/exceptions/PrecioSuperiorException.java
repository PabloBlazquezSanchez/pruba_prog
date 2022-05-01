package exceptions;

//Esta clase sirve para capturar cuando al crear una promoción de una serie, el precio de esta supera los 12000 €
public class PrecioSuperiorException extends Exception {
	public PrecioSuperiorException(String msg) {
		super(msg);
	}

}
