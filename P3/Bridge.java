import java.util.ArrayList;

public class Bridge {
	int bridgeSemaphore = 3;
	ArrayList<Woolie> woolieLine = new ArrayList<Woolie>();

	public synchronized void enterBridge(Woolie woolie)
	{
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
				// Not first in line with enough room; make the thread wait.
				while(woolieLine.indexOf(woolie) != 0 || bridgeSemaphore < 1)
				{
					// Wait gives up the lock.
					wait();
				}

				woolieLine.remove(0);
				bridgeSemaphore--;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	public synchronized void leaveBridge()
	{	
		bridgeSemaphore++;
		notifyAll();
	}
}
