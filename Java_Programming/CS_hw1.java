// 자바 프로그래밍(컴공)_실습 과제1

package test;

class Rectangle{
	int x, y, length, height; // 1) int 타입의 x, y, width, height 필드
	
	// 기본 생성자
	public Rectangle() {}

	// 2) x, y, width, height 값을 매개변수로 받아 필드를 초기화하는 생성자
	public Rectangle(int x, int y, int length, int height) {
		this.x = x;
		this.y = y;
		this.length = length;
		this.height = height;
	}
	
	// 3) 사각형 넓이를 리턴
	public int square() {
		return length*height;
	}
	
	// 4) 사각형 좌표와 넓이를 화면에 출력
	public void show() {
		System.out.println("("+x+ "," +y+") 에서 크기가 " + length+"x" + height + "인 사각형");
	}
	
	// 5) 매개변수로 받은 r이 현 사각형 안에 있으면 true 리턴
	public boolean contains(Rectangle r) {
		if((this.x<=r.x) && (r.x<=this.x+ this.length) && (this.y<= r.y) && (r.y<=this.y + this.height))
			return true;
		else
			return false;
	}
	
}


public class Assignment1{    
    public static void main(String args[])  {
        Rectangle r = new Rectangle(2, 2, 8, 7);
        Rectangle s = new Rectangle(5, 5, 6, 6);
        Rectangle t = new Rectangle(1, 1, 10, 10);

        r.show();
        System.out.println("s의 면적은 " + s.square());
        if(t.contains(r)) System.out.println("t는 r을 포함합니다.");
        if(t.contains(s)) System.out.println("t는 s를 포함합니다.");
    }
}
