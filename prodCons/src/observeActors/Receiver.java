package observeActors;

 
import java.util.ArrayList;
import java.util.List;

import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.utils.CommUtils;
 

public class Receiver extends ActorBasic24 implements Publisher{

	private List<ActorBasic24> subscribers;
	
    public Receiver(String name, ActorContext24 ctx) {
        super(name,ctx);
        this.subscribers = new ArrayList<ActorBasic24>(); 
    }

    @Override
    protected void elabMsg(IApplMessage msg) throws Exception {
    	 CommUtils.outgreen(name + " | elab " + msg + " in:" + Thread.currentThread().getName());
         if( msg.isRequest() ) {
             IApplMessage reply = CommUtils.buildReply(name,"answer", "ok" + msg.msgContent(), msg.msgSender());
             CommUtils.outgreen(name + " | sendReply " + reply + " " + Thread.currentThread().getName());
             sendReply(msg,reply);  //invio la reply a un destinatario, anche remoto
             this.notify(msg);
             this.notify(reply);
         } else {
        	 this.notify(msg);
         }
        
    }

	@Override
	public void subscribe(ActorBasic24 actor) {
		subscribers.add(actor);
		
	}

	@Override
	public void unsubscribe(ActorBasic24 actor) {
		subscribers.remove(actor);
		
	}

	@Override
	public void notify(IApplMessage msg) {
		for(ActorBasic24 actor : subscribers) {
			forward(CommUtils.buildDispatch(name, "log", msg.toString(), actor.getName()));
		}
	}
    
}
