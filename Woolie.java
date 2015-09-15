
public class Woolie implements Runnable {
	String name;
	int speed;
	String city;

	public Woolie(String name, int speed, String city){
		this.name = name;
		this.speed = speed;
		this.city = city;
	}
	public void run(){
		System.out.println(name + " has arrived at the bridge.");
		for (int i = 0; i < speed; i++){
			try {
				if(i == 0){
					System.out.println(name + " is starting to cross.");
				}
				Thread.sleep(1000);
				System.out.println("\t" + name + " " + (i+1) + " seconds.");
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(name + " leaves at " + city + ".");
	}
	public static void main(String name){
		Thread richard = new Thread(new Woolie("richard", 5, "there"));
		Thread test = new Thread(new Woolie("test", 2, "here"));
		richard.start();
		test.start();
	}
	
}
