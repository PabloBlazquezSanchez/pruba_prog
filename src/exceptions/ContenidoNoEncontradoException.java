package exceptions;

//Esta clase sirve para capturar cuando al crear una promoci�n no se encuentra el t�tulo del contenido
public class ContenidoNoEncontradoException extends Exception {
	public ContenidoNoEncontradoException(String msg) {
		super(msg);
	}
}
