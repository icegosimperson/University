class DigitThread extends Thread {
	public void run() {
		for(int cnt=0; cnt<10; cnt++) {
			System.out.println(cnt);
		}
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
public class MultithreadExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread = new DigitThread();
		thread.start();
		for(char ch='A'; ch<='Z'; ch++) {
			System.out.println(ch);
		}
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
