package serpis.psp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class TcpClient {

	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 12345;
	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		System.out.printf("TcpClient SERVER_IP=%s port=%s\n", SERVER_IP, SERVER_PORT);
		Socket socket = new Socket(SERVER_IP, SERVER_PORT);

		String lineOut = "Hola";
		
		System.out.printf("TcpClient Enviado='%s'\n", lineOut);
		
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
		printWriter.printf("%s\n", lineOut);
		printWriter.flush();
		
		Scanner scanner = new Scanner(socket.getInputStream());
		String lineIn = scanner.nextLine();
		
		System.out.printf("TcpClient Recibido='%s'\n", lineIn);
		
		System.out.printf("TcpClient end.\n");
		
		socket.close();
	}

}
