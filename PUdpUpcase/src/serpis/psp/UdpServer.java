package serpis.psp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
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
		
		byte[] inBuf = new byte[ MAX_PACKET_SIZE ];
		int inLength = inBuf.length;
		DatagramPacket inDatagramPacket = new DatagramPacket(inBuf, inLength);

		datagramSocket.receive(inDatagramPacket); //aquí espera hasta recibir
		System.out.println("remote ip  =" + inDatagramPacket.getAddress());
		System.out.println("remote port=" + inDatagramPacket.getPort());
		System.out.println("getLength()=" + inDatagramPacket.getLength());
		String inMessage = new String(inBuf, 0, inDatagramPacket.getLength());
		System.out.println("inMessage  =" + inMessage);
		
		String outMessage = inMessage.toUpperCase();
		System.out.println("outMessage =" + outMessage);
		byte[] outBuf = outMessage.getBytes();
		int outLength = outBuf.length;
		InetAddress outInetAddress = inDatagramPacket.getAddress(); //ip del remitente
		int outPort = inDatagramPacket.getPort(); //port del remitente
		DatagramPacket outDatagramPacket = 
				new DatagramPacket(outBuf, outLength, outInetAddress, outPort);
		datagramSocket.send(outDatagramPacket);
				
		System.out.println("UdpServer end.");
	}

}
