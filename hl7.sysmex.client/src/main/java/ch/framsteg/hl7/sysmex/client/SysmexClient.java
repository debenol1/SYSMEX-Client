package ch.framsteg.hl7.sysmex.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SysmexClient {
	public static void main(String[] args) {
		String serverName = args[0];
		int port = Integer.parseInt(args[1]);
		String patientID = args[2];
		try {
			System.out.println("Connecting to " + serverName + " on port " + port);
			Socket client = new Socket(serverName, port);

			System.out.println("Just connected to " + client.getRemoteSocketAddress());
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);

			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("D1UXP-300^AP807129^A5730                   20220428000000000000000" + patientID
					+ "00000000043004440013100393008850029500333002550016820104007281000720004000320042500119001040009200180000230");

			// out.writeUTF("Hello from " + client.getLocalSocketAddress());
			out.writeUTF(stringBuilder.toString());
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);

			System.out.println("Server says " + in.readUTF());
			client.close();
		} catch (IOException e) {
			System.out.println("No connection established. Server might be offline...");
			e.printStackTrace();
		}
	}

}
