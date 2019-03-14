package exceptions;

public class NoCashRegisterException extends Exception {

	public NoCashRegisterException() {
		super("No hay cajas registradoras para la simulacion");
	}


}
