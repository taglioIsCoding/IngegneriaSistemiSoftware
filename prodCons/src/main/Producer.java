package main;

import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.interfaces.Interaction;
import unibo.basicomm23.msg.ProtocolType;
import unibo.basicomm23.utils.BasicMsgUtil;
import unibo.basicomm23.utils.ConnectionFactory;

public class Producer {

	public static void main(String[] args) throws Exception {
		ProtocolType protocol = ProtocolType.tcp;
		IApplMessage req =  BasicMsgUtil.buildRequest("client", "dofibo", "dofibo(39)", "service");
		IApplMessage disp =  BasicMsgUtil.buildDispatch("client", "dofibo", "dofibo(39)", "service");
		
		String hostAddr = "localhost";
		String entry    = "8011";

		Interaction conn = ConnectionFactory.createClientSupport(protocol, hostAddr, entry);

		// Syncronous request
		System.out.println("Send request");
		String answer = conn.request(req.toString());
		System.out.println("Sync answer: "+answer);
		
		// Async 
		System.out.println("Send request");
		conn.forward(disp.toString());

	}

}
