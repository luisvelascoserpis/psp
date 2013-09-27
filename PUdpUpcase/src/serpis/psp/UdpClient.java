package serpis.psp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpClient {

	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 12345;
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		System.out.println("UdpClient");
		
		DatagramSocket datagramSocket = new DatagramSocket();
		
		String message = "Hola udp.";
		byte[] buf = message.getBytes();
		
		int length = buf.length;
		
		InetAddress serverInetAddress = InetAddress.getByName( SERVER_IP );
		
		DatagramPacket outDatagramPacket = new DatagramPacket(buf, length, serverInetAddress, SERVER_PORT);
		
		datagramSocket.send(outDatagramPacket);
		
		datagramSocket.close();
		
		System.out.println("UdpClient end.");
		
	}

}
