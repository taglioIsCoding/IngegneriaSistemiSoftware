package observeActors;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.utils.CommUtils;

public class ActorLogger extends ActorBasic24 implements Subscriber  {

	private PrintWriter filewriter;
	
	public ActorLogger(String name, ActorContext24 ctx){
        super(name,ctx);
        
        try {
			filewriter = new PrintWriter(new File("log.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
            
    }

    @Override
    protected void elabMsg(IApplMessage msg) throws Exception {
    	handleStateChange(msg);
    }

	@Override
	public void handleStateChange(IApplMessage msg) {
		 // CommUtils.outred("LOG -> " + msg);
		
		filewriter.println("LOG -> " + msg);
		filewriter.flush();
	}

}
