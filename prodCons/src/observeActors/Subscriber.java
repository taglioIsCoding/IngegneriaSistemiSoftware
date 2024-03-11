package observeActors;

import actors.IActor24;
import unibo.basicomm23.interfaces.IApplMessage;

public interface Subscriber{
	
	public abstract void handleStateChange (IApplMessage msg);

}
