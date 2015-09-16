public class Bridge{
	boolean onBridge;
	
	public Bridge(){
		onBridge = false;
	}
	public synchronized void enterBridge(){
		if (!onBridge){
			onBridge = true;
		} else{
			while (onBridge){
				try {
					wait();
				} catch (Exception e){e.printStackTrace();}
			}
		}
		
	}
	public synchronized void leaveBridge(){
		onBridge = false;
		notify();
	}


}
