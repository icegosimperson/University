package test;

class Rectangle {
	int width;
	int length;
	
	// 생성자가 비어있는 경우
	public Rectangle() {
		this(1, 1);
		// System.out.println("생성자 호출됨");
	}
	
	// 생성자가 하나만 있는 경우 
	public Rectangle(int width) {
		this(width, width); // 정사각형으로 초기화, this.width =w; this.width=w;
		// 생성자가 여러번 호출됨
	}
	
	// 모든 생성자가 있는 경우 (가장 먼저 작성하는게 좋음)
	public Rectangle(int width, int length) {
		this.width = width; // 매게변수 = 멤버변수 (구분이 가능해야 함) 
		this.length =length;
	}
}

public class Main{
	public static void main(String [] args) {
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle(5);
		Rectangle r3 = new Rectangle(2,4);
	}
	
}
