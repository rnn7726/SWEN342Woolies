import java.util.ArrayList;

public class Bridge {
	int bridgeSemaphore = 2;
	ArrayList<Woolie> woolieLine = new ArrayList<Woolie>();

	public void enterBridge(Woolie woolie){
		
		synchronized(this) {
			if (bridgeSemaphore > 0)
			{
				// There is room on the bridge.
				// Add a woolie.
				bridgeSemaphore--;
			}
			else
			{
				// There is no room; this woolie waits in line.
				System.out.println(woolie.name + " MUST WAIT");

				// Get in line.
				woolieLine.add(woolie);

				try
				{
					//int counter = 0;

					// Not first in line with enough room; make the thread wait.
					while(woolieLine.indexOf(woolie) != 0 || bridgeSemaphore < 1)
					{
						/*synchronized(woolie)
						{
							woolie.wait();
						}*/
						System.out.println(bridgeSemaphore);
						//counter++;
					}

					//System.out.println(counter);

					woolieLine.remove(0);
					bridgeSemaphore--;
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	public void leaveBridge(){
		
		//synchronized (this){
			bridgeSemaphore++;
			/*if(woolieLine.size() > 0)
			{
				// If there is a woolie at the front of the line,
				// let him know it's cool to cross now.
				Woolie frontWoolie = woolieLine.remove(0);
				frontWoolie.notify();
				System.out.println(frontWoolie.name + "Notified!");
			}*/
		//}
	}
}
