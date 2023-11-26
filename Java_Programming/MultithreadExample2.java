public class MultithreadExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalcThread thread1 = new CalcThread();
		PrintThread thread2 = new PrintThread();
		SharedArea obj = new SharedArea();
		
		thread1.sharedArea = obj;
		thread2.sharedArea = obj;
		thread1.start();
		thread2.start();
	}
}

class CalcThread extends Thread{
	SharedArea sharedArea;
	public void run() {
		double total = 0.0;
		for(int cnt =1; cnt<1000000000; cnt+=2) {
			if(cnt/2%2 ==0)
				total += 1.0/cnt;
			else
				total -= 1.0/cnt;
			sharedArea.result = total*4;
			sharedArea.isReady = true;
		}
	}
}

class SharedArea{
	double result;
	boolean isReady;
}

class PrintThread extends Thread{
	SharedArea sharedArea;
	public void run() {
		while(sharedArea.isReady != true)
			continue;
		System.out.println(sharedArea.result);
	}
}
