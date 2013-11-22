package serpis.psp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TcpServer {

	//private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 12345;
	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		System.out.printf("TcpServer port=%s\n", SERVER_PORT);
		
		ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
		
		Socket socket = serverSocket.accept();
		
		Scanner scanner = new Scanner(socket.getInputStream());
		String lineIn = scanner.nextLine();
		System.out.printf("TcpServer Recibido='%s'\n", lineIn);
		
		String lineOut = lineIn.toUpperCase();
		System.out.printf("TcpServer Enviado='%s'\n", lineOut);
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
		printWriter.printf("%s\n", lineOut);
		printWriter.flush();
		
		System.out.printf("TcpServer end.\n");
		
		socket.close();
	}

}
