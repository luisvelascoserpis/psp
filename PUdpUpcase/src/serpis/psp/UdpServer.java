package serpis.psp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {
	
	private static final int PORT = 12345;
	private static final int MAX_PACKET_SIZE = 2048; //max. udp size 2^16

	/**
	 * @param args
	 * @throws   
	 */
	public static void main(String[] args) throws IOException  {

		System.out.println("UdpServer");
		
		DatagramSocket datagramSocket = new DatagramSocket( PORT );
		
		byte[] buf = new byte[ MAX_PACKET_SIZE ];
		int length = buf.length;
		DatagramPacket inDatagramPacket = new DatagramPacket(buf, length);

		datagramSocket.receive(inDatagramPacket); //aquí espera hasta recibir
		
		System.out.println("remote ip  =" + inDatagramPacket.getAddress());
		System.out.println("remote port=" + inDatagramPacket.getPort());
		
		String message = new String(buf, 0, inDatagramPacket.getLength());
		
		System.out.println("message    =" + message);
		
		System.out.println("UdpServer end.");
	}

}
