package main;

import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.interfaces.Interaction;
import unibo.basicomm23.msg.ProtocolType;
import unibo.basicomm23.utils.BasicMsgUtil;
import unibo.basicomm23.utils.ConnectionFactory;

public class UseInteraction {

	public static void main(String[] args) throws Exception {
		/*1*/ProtocolType protocol = ProtocolType.tcp;
		/*2*/IApplMessage req =  BasicMsgUtil.buildRequest("client", "dofibo", "dofibo(39)", "service");
		/*3*/String hostAddr = "130.132.11.22";
		/*4*/String entry    = "8011";

		/*5*/Interaction conn = ConnectionFactory.createClientSupport(protocol, hostAddr, entry);

		// Syncronous request
		/*1*/ String answer = conn.request(req.toString());
		System.out.println("Sync answer: "+answer);
		
		// Asyncronous request
		/*1*/ conn.forward(req.toString());
		/*2*/ answer = conn.receiveMsg();
		System.out.println("Async answer: "+answer);
	}

}
