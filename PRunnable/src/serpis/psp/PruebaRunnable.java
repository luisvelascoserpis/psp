package serpis.psp;

public class PruebaRunnable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("main");

		//Solución I
		for (int hilo = 1; hilo <= 4; hilo++) {
			Thread thread = new Thread(new ContadorEC(hilo));
			thread.start();
		}
		
		
		System.out.println("main end.");
	}

}
