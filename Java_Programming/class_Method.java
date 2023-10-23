/*0. 객체 지향 개념을 사용하는 이유 : 코드 복잡성을 줄이고, 수정 및 유지 보수를 편리하게 하려고 등 여러 이유가 있다.
TV 클래스 정의하고 객체를 만들어서 해당 객체를 출력하는 예제이다. 

1. TV 클래스 선언 - 클래스, 멤버변수, 생성자
- 이유: TV 관련 데이터 기능을 하나의 단위로 그룹화 하려고 

class TV {
    // 멤버 변수
    String company;
    int year, inch;

    // 생성자
    public TV(String company, int year, int inch) {
        this.company = company; 
        this.inch = inch;
        this.year = year;
    }


멤버 변수 : 클래스의 속성 또는 상태를 나타내는 변수
-> 인스턴스(객체)가 생성되면 객체의 복사본을 가지게됨 
-> 객체의 복사본이 생기면 좋은 이유는, 하나의 객체에서 (예:channel)을 변경하더라도 다른 객체의 (예:channel) 값은 영향을 받지 않는다. 

매개변수(파라미터, parameter) : 함수나 메서드를 호출할 때 전달되는 값을 받아들이는 변수

this. : 현재의 인스턴스(객체)를 참조하는 키워드

- 클래스의 멤버 변수를 명시적으로 참조하고자 할 때 this를 사용
-  매개변수와 멤버 변수의 이름이 동일할 때도 명확하게 둘을 구분하기 위함 

생성자 : 객체가 생성될 때 자동으로 호출되어 객체의 초기화 작업을 수행하는 역할
- 목적 :  클래스의 멤버 변수(필드)를 초기 상태로 설정

2. 멤버함수(메서드)

public void show() {
    System.out.printf("%s 에서 만든 %d년형 %d인치 TV\n",
            this.company, this.year, this.inch);
}
TV 클래스의 메서드(함수)
이 메서드는 TV의 정보를 출력

3. 메인 클래스 및 메인 메서드 (보통 Main, 파일 저장명 때문에 class_Method로 변경했음)
public class class_Method {
    public static void main(String[] args) {
        ...
    }
}
자바 런타임시 가장 먼저 실행되는 곳 : 메인 메서드

4. 객체 생성 및 메서드 호출

public class class_Method {
    public static void main(String[] args) {
        TV myTv = new TV("LG", 2017, 32);
		myTv.show();
    }
}
: TV 클래스의 객체를 생성하고 초기화한 후, 그 객체의 참조를 myTv 변수에 할당


TV myTv = new TV("LG", 2017, 32);
1) 객체 생성(myTv) : TV 클래스의 객체를 참조하기 위해
2) new 키워드 :  메모리에 객체를 위한 공간이 할당
3) TV는 TV 클래스의 생성자를 호출하.
4) 괄호 안의 값들( "LG", 2017, 32)는 생성자의 매개변수로 전달
5) TV 클래스에 정의된 생성자를 호출하여 company, year, inch 필드를 초기화하는 작업을 수행


* 클래스는 설계도, 설계도를 기반으로 실제로 만들어진 물건 or 실체

myTv.show();
초기화된 myTv 객체의 정보를 화면에 출력
*/

public class class_Method {
    public static void main(String[] args) {
        TV myTv = new TV("LG", 2017, 32);
        myTv.show();
    }
}

class TV {
    // 멤버 변수
    String company;
    int year, inch;

    // 생성자
    public TV(String company, int year, int inch) {
        this.company = company; 
        this.inch = inch;
        this.year = year;
    }

    // 멤버 함수 (메서드)
    public void show() {
        System.out.printf("%s 에서 만든 %d년형 %d인치 TV\n",
                this.company, this.year, this.inch);
    }
}
