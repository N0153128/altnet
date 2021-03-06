package HubServer;

import java.net.*;

public class Command {
	private DatagramSocket sock;
	private DatagramPacket pack;
	
	public void ping (DatagramSocket sock, DatagramPacket pack) {
		byte[] payload = new byte[256];
		payload = "State: Active".getBytes();
		try {
			DatagramPacket packet = new DatagramPacket(payload, payload.length, pack.getSocketAddress());
			sock.send(packet);
		} catch (Exception e) {
			System.out.println("Package not sent: " + e);
		}
		System.out.println("package sent: " + new String(payload, 0, payload.length));

	}

	public void share(DatagramSocket sock, DatagramPacket pack) {
		byte[] payload;
		String msg = "Address: " + pack.getAddress() + ":" + pack.getPort();
		payload = msg.getBytes();
		try {
			DatagramPacket packet = new DatagramPacket(payload, payload.length, pack.getSocketAddress());
			sock.send(packet);
		} catch (Exception e) {
			System.out.println("Package not sent: " + e);
		}
		System.out.println("package sent: " + msg);
	}

	public void off(DatagramSocket sock, DatagramPacket pack) {
		byte[] payload;
		String msg = "Server shutting down by: " + pack.getAddress() + ":" + pack.getPort();
		payload = msg.getBytes();
		try {
			DatagramPacket packet = new DatagramPacket(payload, payload.length, pack.getSocketAddress());
			sock.send(packet);
			System.exit(9);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
