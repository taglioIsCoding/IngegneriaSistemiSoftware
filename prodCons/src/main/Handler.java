package main;

import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.interfaces.Interaction;
import unibo.basicomm23.msg.ApplMsgHandler;
import unibo.basicomm23.utils.CommUtils;

public class Handler extends ApplMsgHandler {

	public Handler(String name) {
		super(name);
	}

	@Override
	public void elaborate(IApplMessage message, Interaction conn) {
		
		// Gestione richieste sincrone
		if(message.isRequest()) {
			try {
				conn.reply("ack("+message+")");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// gestione richieste asincrone
		else if(message.isDispatch()) {
				CommUtils.outcyan("Async message:" + message.toString());
		}
		
		
	}

}
