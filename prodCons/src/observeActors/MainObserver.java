package observeActors;

import unibo.basicomm23.msg.ProtocolType;
import unibo.basicomm23.utils.CommUtils;
 

public class MainObserver {

	
	protected void alienCaller() {
		// AlienJava caller = new AlienJava("javacaller", ProtocolType.tcp, "localhost", "8123");
		// caller.activate();
	}
   
	public void configureTheSystem(){
         
		 int port1 = 8123;
	        CommUtils.outblue("MainExampleTowardsActors24 CREA I CONTESTI ");
	        ActorContext24 ctx1 = new ActorContext24("ctx1", "localhost", port1);
	        CommUtils.outblue("MainExampleTowardsActors24 CREA GLI ATTORI ");

	        Sender a1   = new Sender("a1",ctx1);
	        Receiver a2 = new Receiver("a2",ctx1);
	        ActorLogger logger = new ActorLogger("logger", ctx1);

	        a2.subscribe(logger);
	        ctx1.showActorNames();
	        
	        logger.activateAndStart();
	        a1.activateAndStart();
	        a2.activateAndStart();
    }
    public static void main(String[] args ){
        new MainObserver().configureTheSystem();
    }
}
