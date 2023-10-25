1. static이란?

특정 멤버(변수, 메소드, 블록, 중첩 클래스)가 클래스에 속하며, 객체에 속하지 않음을 나타냄
static 멤버는 클래스 레벨에서 메모리에 로드, 클래스가 로드 될 때 한번만 초기화



2.static 메소드 특징

- 객체를 생성하지 않고 클래스 이름으로 호출할 수 있다
- static 메소드 내부에서는 static이 아닌 멤버(필드 or 메소드)에 직접 접근할 수 없다.
  
  -> 이유 : static 메소드는 객체의 인스턴스에 종속되지 않기 때문

ex) Math.abs(-10)
ex2) Arrays.sort()


public class Calculator {
    public static int add(int a, int b) {
        return a + b;
    }
}

public class Test {
    public static void main(String[] args) {
        int result = Calculator.add(5, 10); // 객체 생성 없이 메소드 호출
        System.out.println(result); // 출력: 15
    }
}

static으로 선언된 add 메소드는 Calculator 객체를 생성하지 않고 호출됨 



3. 사용하는 이유

객체와 관련 없는 작업을 수행할 때 사용
객체를 생성하지 않고 메소드에 접근할 수 있기에 메모리 처리 시간 아낄 수 있다. 

자주 사용되는 유틸리티 함수나 객체의 상태와 무관한 작업을 수행할 때 유용



4. non-static(인스턴스) 메소드와 비교

non-static 멤버
선언	class Sample{
   int n;
   void g() {...}
}	

멤버는 객체마다 별도로 존재 인스턴스 멤버라 부름	
객체 생성 시에 멤버 생성
- 객체가 생길 때 멤버도 생성
- 객체 생성 후 멤버 사용 가능
- 객체가 사라지면 멤버도 사라짐	
공유X
- 멤버는 객체 내에 각각 공간 유지	동일한 클래스의 모든 객체들에 의해 공유

  ----------------------------------------------------------------
	static 멤버
  
  class Sample{
   static int m;
   static void f() {...}
}

멤버는 클래스당 하나 생성
멤버는 객체 내부가 아닌 별도의 공간(클래스 코드가 적재되는 메모리)에 생성
클래스 멤버라고 부름

  클래스 로딩 시에 멤버 생성
- 객체가 생기기 전에 이미 생성
- 객체가 생기기 전에도 사용 가능
- 객체가 사라져도 멤버는 사라지지 X
- 멤버는 프로그램이 종료될 때 사라짐
  
  동일한 클래스의 모든 객체들에 의해 공유
  
  
5. non-static(인스턴스) 메소드와 주요 차이점 

1) 메모리 할당

static : 클래스가 메모리에 로드 될 때 한번만 메모리 할당

non static :  객체가 생성될 때마다 메모리 할당



2) 호출 방식

static : 클래스 이름 사용해서 호출

클래스 이름.static메소드 이름()
non-static : 객체 생성한 후 해당 객체를 사용하여 호출

객체 이름.메소드 이름();


3) 멤버 엑세스

static : static이 아닌 멤버(변수나 메소드)에 직접 접근 X / static 멤버에는 접근 O

non-static : 클래스의 static, non-static 모든 멤버에 접근 가능



4) 예제

public class Example {
    static int staticVar = 10;
    int nonStaticVar = 20;

    // static 메소드
    public static void staticMethod() {
        System.out.println(staticVar);
        // System.out.println(nonStaticVar); // 오류! static 메소드에서 non-static 변수에 직접 접근할 수 없습니다.
    }

    // non-static 메소드
    public void nonStaticMethod() {
        System.out.println(staticVar); // 가능!
        System.out.println(nonStaticVar); // 가능!
    }
}


6. 연습문제  : 다음 클래스에서 멤버 함수의 사용이 잘못된 것은?

class StaticTest{
	static int a;
	static int getA() {return a;}
	int b;
	int getB() {return b;}
	int f() {return getA();}
	static int g() {return getB();}
}
정답 : static int g() {return getB();}
이유 : static 변수가 아닌 메소드 getB()를 호출하였기 때문



Q2. getB()를 호출하려면?

class StaticTest {
    static int a;
    static int getA() {
        return a;
    }

    int b;
    int getB() {
        return b;
    }

    static int g() {
        StaticTest st = new StaticTest(); // 객체 생성
        return st.getB(); // 객체를 통한 non-static 메소드 호출
    }
}

이렇게 객체를 생성해서 호출 해야된다
 * static 메소드 내에서 non-static 메소드를 호출하려는 방법 : 객체 생성 후 호출
