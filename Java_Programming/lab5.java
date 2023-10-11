package test;

//한 페이지 내에서는 하나의 public class만 존재해야함 (보통 main 포함 class가 public)
class Circle{
	public int radius; // 원의 반지름 필드
	public String name; // 원의 이름 필드
	
	public Circle() { // 매개 변수 없는 생성자
		radius =1; name=""; // radius 초기값 1
	}
	
	public Circle(int r, String n) { // 매개 변수를 가진 생성자
		radius = r; name =n;
	}
	public double getArea() { // 원의 면적 계산 메소드
		return 3.14*radius*radius; 
	}
}

class Rectangle{
	public int length, height;
	
	/*
	public Rectangle() {
	}
	*/
	public int getArea() {
		return length*height;
	}
	
}

public class FirstClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 객체 선언 방법 1
		Circle pizza = new Circle(10, "자바피자"); // Circle 객체 생성, 반지름 10
		// 객체 선언 방법2
		double area = pizza.getArea(); // 객체 선언 + 실체화
		System.out.println(pizza.name+"의 면적은"+area);
		
		Circle donut = new Circle(); // Circle 객체 선언
		area = donut.getArea(); // 도넛 면적 알아내기
		System.out.println(donut.name+"의 면적은"+area);
		
		// 사각형
		Rectangle nemo; // 객체 생성
		nemo = new Rectangle(); // 객체화
		nemo.length= 30;
		nemo.height= 50;
		
		int extent = nemo.getArea();
		System.out.println("사각형의 넓이는"+extent);
		
		Rectangle small = new Rectangle();
		small.height = 10;
		small.length = 5;
		extent = small.getArea();
		System.out.println("작은 사각형의 넓이는"+small);
	}

}
 

Book.java

package test;

public class Book {
	String title;
	String author;
	void show() {System.out.println(title + "" + author); }

	public Book() {
		this("", "");
		System.out.println("생성자 호출됨");
	}
	
	public Book(String title) {
		this(title, "작자미상");
	}
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}


	public static void main(String [] arg) {
		Book littlePrince = new Book("어린왕자", "생텍쥐페리");
		Book loveStory = new Book("춘향전");
		Book emptyBook = new Book();
		loveStory.show();
	}
}
 

Rectangle r1 = new Rectangle();
Rectangle r2 = new Rectangle(5);
Rectangle r3 = new Rectangle(2,4);

생성자 Qz

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
 

/* 객체의 치환
 * 객체의 치환은 객체가 복사되는 것이 아니며 레퍼런스가 복사된다.
 * obl.radius=2
 * obl.radius=2 출력됨 
 * 
 * garbage : 유효하지 않은 데이터
 * java garbage collection : JVM의 가비지 컬렉터가 불필요한 메모리를 알아서 정리
 * 
 * 객체 변수는 사실 레퍼런스(주소)변수 이다.
 * Rect a ; = 주소를 저장할 수 있는 a 설정 
 * a = new Rect(); // 동적할당 (이름이 없다)하면서 주소를 a에 저장 
 * Rect b = a; // a가 가리키고 있던 자원도 b도 가리키게됨 (객체는 여전히 1개) !객체가 생성된게 아님 
 * 
 * Rect c = new Rect();  //새로운 동적자원의 주소를 c에 저장 
 * c = a; // a가 가지고 있던 자원을 옮김 (기존 c가 가지고 있던 자원이 제거) - garbage collection
 */

package test;

class Circle{
	int radius;
	public Circle(int radius) {this.radius = radius; }
	public void set(int radius) {this.radius = radius; }
}

public class Main{
	public static void main(String [] args) {
		Circle ob1 = new Circle(1);
		Circle ob2 = new Circle(2);
		Circle s;
		
		s = ob2; // 변수 s가 ob2 객체 주소를 참조 
		ob1 = ob2; // 변수 ob1가 ob2의 객체 주소를 참조하면서 기존에 참조하던 ob1의 주소가 삭제(java garbage collection)
		System.out.println("obl.radius=" + ob1.radius);
		System.out.println("obl.radius=" + ob2.radius);
	}
}
 

/* 객체의 배열 만들기
 * 
 */

package test;

class Circle{
	int radius;
	public Circle(int radius) {
		this.radius = radius;
	}
	public double getArea() {
		return 3.14*radius*radius;
	}
}

// CircleArray
public class Main{
	public static void main(String [] args) {
		Circle [] c;
		c = new Circle[5]; // 배열의 개수(o), 생성자(x)
		
		/* 반드시 작성해야 하는 부분
		 * 반복문을 통해 배열을 하나씩 초기화해서 사용
		 * i가 생성자
		 */
		for(int i=0; i<c.length; i++)
			c[i] = new Circle(i);
		
		for(int i=0; i<c.length; i++)
			System.out.println(c[i].getArea() + "");
	}
}
 

/* 객체의 배열 만들기
 * 정사각형 넓이 출력
 */


package test;

class Rectangle{
	int w;
	int h;
	
	public Rectangle(int w) {
		this.w = w;
		this.h = w;
	}
	public double getArea() {
		return w*h;
	}
}

// Rectangle Array
public class Main{
	public static void main(String [] args) {
		Rectangle [] r;
		r = new Rectangle[5]; // 배열의 개수(o), 생성자(x)
		
		/* 반드시 작성해야 하는 부분
		 * 반복문을 통해 배열을 하나씩 초기화해서 사용
		 * i가 생성자
		 */
		for(int i=0; i<r.length; i++)
			r[i] = new Rectangle(i);
		
		for(int i=0; i<r.length; i++)
			System.out.println(r[i].getArea() + "");
	}
}
 

/* 예제 4-7 객체 배열 만들기 연습
 * Exception in thread "main" java.lang.Error: Unresolved compilation problem: at test.Main.main(Main.java:18)
 * 패키지를 import java.util.Scanner; 밑에 선언하니까 발생한 오류
 */

package test; // 패키지 선언은 항상 맨위에 와야함 
import java.util.Scanner;


class Book {
	String title, author;
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
}

// Rectangle Array
public class Main{
	public static void main(String [] args) {
		Book [] book = new Book[2]; // Book 배열 선언
		
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<book.length; i++) {
			System.out.print("제목>>");
			String title = sc.nextLine();
			
			System.out.print("저자>>");
			String author = sc.nextLine();
			
			book[i] = new Book(title, author); // 배열 원소 객체 생성
		}
		for(int i=0; i<book.length; i++)
			System.out.print("(" + book[i].title + "," + book[i].author + ")");
		
		sc.close();
		
	}
}
 

- Exception in thread "main" java.lang.Error: Unresolved compilation problem: at test.Main.main(Main.java:18) 오류 발생

import java.util.Scanner;
package test;
이렇게 선언하니까 오류가 발생했다

패키지 선언은 항상 맨 위에 해야 된다 

 

/*  메소드오버로딩
 * 
 */

package test; // 패키지 선언은 항상 맨위에 와야함 
class Circle{
	int radius;
	public Circle(int radius) {
		this.radius = radius;
	}
}


// 메소드 오버로딩(중복) 
public class Main{
	static void increase(int a) {
		a++;
	}
	
	/* 오버로딩 적용 안됨, 이유 : 매개변수의 타입 같음 (변수 이름은 제외하고 생각)
	 * 매개변수의 순서와 종류가 조금이라도 다르면 오버로딩 가능 
	 * 반환타입은 고려 대상이 아님 
	static void increase(int b) {
		b++;
	}
	*/

	static void increase(Circle p)
	{
		p.radius++;
	}
	
	static void increase(int[] a) {
		for(int i=0; i<a.length; i++) {
			a[i]++;
		}
	}
	
	public static void main(String [] args) {
		int a = 10; // 기본(원시)타입 변수 (primitive type) - 값 복사를 진행  
		int b[] = {1, 2, 3, 4, 5};  // 배열은 reference 변수  - 나머지 모든 객체는 reference 기억하기
		Circle c = new Circle(5); // 모든 객체는 reference 변수 
		increase(a); // call by value (값을 복사한 후에 작업하므로 원본에 영향x)
		increase(c); // call by reference (래퍼런스를 전달하기 때문에 원본에 영향o)
		increase(b); // call by reference
		
		System.out.println(a); // 10 출력 
		System.out.println(c.radius); // 6출력 
		System.out.println(b[3]); // 5 출력
		
	}
}
