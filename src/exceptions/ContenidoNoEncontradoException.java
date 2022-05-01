package exceptions;

//Esta clase sirve para capturar cuando al crear una promoción no se encuentra el título del contenido
public class ContenidoNoEncontradoException extends Exception {
	public ContenidoNoEncontradoException(String msg) {
		super(msg);
	}
}
