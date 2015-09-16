public class Woolie implements Runnable {
	String name;
	int speed;
	String city;
	static Bridge b = new Bridge();

	public Woolie(String name, int speed, String city, Bridge bridge){
		this.name = name;
		this.speed = speed;
		this.city = city;
		b = bridge;
	}
	public void run(){
		System.out.println(name + " has arrived at the bridge.");
		b.enterBridge(this);
		for (int i = 0; i < speed; i++){
			try {
				if(i == 0){
					System.out.println(name + " is starting to cross.");
				}
				Thread.sleep(1000);
				System.out.println("\t" + name + " " + (i+1) + " seconds.");
				
			} catch (Exception e) {e.printStackTrace();}
		}
		System.out.println(name + " leaves at " + city + ".");
		b.leaveBridge();
	}
	public static void main(String args[]){
		Thread richard = new Thread(new Woolie("richard", 5, "there", b));
		Thread test = new Thread(new Woolie("test", 2, "here", b));
		Thread thread = new Thread(new Woolie("thread", 4, "here", b));
		richard.start();
		test.start();
		thread.start();
	}
	
}
