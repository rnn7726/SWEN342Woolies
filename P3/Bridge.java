public class Bridge{
	Object troll = new Object();
	boolean onBridge;
	
	public Bridge(){
		onBridge = false;
	}
	public void enterBridge(){
		if (!onBridge){
			onBridge = true;
		} else{
			while (onBridge){
				synchronized(troll){
					try {
						troll.wait();
					} catch (Exception e){e.printStackTrace();}
				}
			}
		}
		
	}
	public void leaveBridge(){
		synchronized (troll){
			onBridge = false;
			troll.notify();
		}
	}


}
