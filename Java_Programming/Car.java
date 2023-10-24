/*자동차 클래스
<상태> 시동, 속도, 방향, 변수들은 반드시 공개된 인터페이스 (메소드)를 통해서만 접근할 수 있다. 
시동 (True/False)
속도
방향

<기능>
시동걸기() 
- 시동이 false일 때 true로 변경 
-  true일 때는 동작X

시동끄기()
- 시동이 true일 때 false로 변경 
-  false일 때는 동작X

가속하기()
- 한번 호출할 때마다 속도 10씩 증가
- 속도가 200이상될 수 없다

감속하기()
- 속도 10씩 감소
- 속도 음수X

왼쪽 돌리기()
- 시동이 걸려있을 때, 방향이 5씩 감소
- 방향이 0미만 X

오른쪽 돌리기()
- 시동이 걸려있을 때, 방향이 5씩 증가
- 방향이 180초과 X 
 */



class Car{
	public static int cnt =0; // 생성된 자동차 객체의 수 의미
	private boolean run; // 시동
	private int speed; // 속도
	private int dir; // 방향
	
	// 생성자 (초기 상태 설정)
	public Car() {
		cnt++; // 객체 생성자가 호출될 때마다 증가 
		run = false;
		speed =0;
		dir =90;
	}
	// 접근 메소드
	public void CarStart() {
		if(!run) // run이 false
		{
			run=true;
		}
	}
		public void CarOff() {
			if(run)
			{
				run = false;
		}
		}
		public void Acclerator() {
			
			if(run && speed <200) {
				speed+=10;
				if(speed >200) {
					speed =200;
				}
			}
	}
		public void Break() {
			if(run && speed > 0) {
				speed -=10; // 10씩 감소
				if(speed <0) {
					speed = 0; 
				}
			}
		}
	public void Left() {
		if(run && dir >0) {
			dir -= 5;
			if (dir<0) {
				dir=0;
			}
		}
	}
	public void right() {
		if(run && dir < 180) {
			dir += 5;
			if (dir >180) {
				dir =180;
			}
		}
	}
	// 현재 자동차의 상태
	public void State() {
		System.out.println("run=" + run);
		System.out.println("speed=" + speed);
		System.out.println("dir=" + dir);
	}
}

// static은 객체 생성 없이도 자원을 메모리에 올려준다. 
// 전역 변수처럼 공유자원으로 활용 가능
public class CarMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Car.cnt); // 0 출력
		
		Object a = new Car(); // 모든 클래스는 자동으로 java.lang.Object를 상속받음
		Object b [] = new Object[5]; // 클래스가 다른데 하나의 배열로 묶인다 (다형성)
		
		Car myCar = new Car(); // 자동차 객체 생성
		Car myCar1 = new Car();
		Car myCar2 = new Car();
		
		myCar.CarStart();
		myCar.Acclerator();
		myCar.State();
		// myCar.speed =10; 캡슐화 위반
		myCar.Left();
		myCar.State();
		
		System.out.println(Car.cnt); // 만들어진 객체 3개 -> 3 출력
		
	}

}
