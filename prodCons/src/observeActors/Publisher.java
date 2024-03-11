package observeActors;

import java.util.List;

import unibo.basicomm23.interfaces.IApplMessage;

public interface Publisher {
	
	public void subscribe(ActorBasic24 actor);
	
	public void unsubscribe(ActorBasic24 actor);
	
	public void notify(IApplMessage msg);
	

}
