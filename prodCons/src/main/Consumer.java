package main;

import unibo.basicomm23.enablers.ServerFactory;
import unibo.basicomm23.interfaces.IApplMsgHandler;
import unibo.basicomm23.interfaces.IServer;
import unibo.basicomm23.msg.ApplMsgHandler;
import unibo.basicomm23.msg.ProtocolType;

public class Consumer {

	public static void main(String args[]) {
		new Consumer().configure();
		
	}
	
	public static void configure() {
		ProtocolType protocol = ProtocolType.tcp;
		String hostAddr = "localhost";
		int entry = 8011;
		
		IApplMsgHandler handler = new Handler("ConsumerHandler");
		
		IServer server = ServerFactory.create(hostAddr, entry, protocol, handler);
		server.start();
	}
	
}
