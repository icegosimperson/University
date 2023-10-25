/*

4.3 생성자 
- 생성자 : 객체가 생성되는 순간에 자동으로 호출되는 메소드 
- 객체의 초기화를 위해 실행되는 메소드 
- 클래스 이름과 동일한 메소드를 특별히 생성자라고 부름

- 생성자 이름은 반드시 클래스 이름과 동일하게 작성
- 생성자는 여러개 작성(오버로딩) 할 수 있다.
- 생성자는 new를 통해 객체를 생성할 때 한번만 호출
- 생성자에 리턴 타입을 지정할 수 없다. 
- 생성자의 목적은 객체가 생성될 때, 필요한 초기 작업을 위함

this 레퍼런스 : 객체 자신에 대한 레퍼런스
- 클래스 내부에서 사용
사용하는 이유 
1 멤버 변수와 매개변수(or 지역변수)간의 이름충돌을 해결하기 위해서
2 this 키워드를 사용하여 해당 변수가 클래스 내의 변수임을 명확히 표현 – 코드 가독성↑
- 매개변수 : 함수나 메소드가 호출될 때 값을 전달받는 변수, 함수나 메소드의 정의 부분에서 괄호 안에 나열됨
*/

class TV{
    private int size = 0;
    private String manufacturer = null;
    
    public TV() {
        this(32, "LG");
    }
    public TV(String manufacturer){
        this(32,manufacturer);
    }
    public TV( int size, String manufacturer) {
        this.size = size;
        this.manufacturer = manufacturer;
        System.out.println(size + "인치" + manufacturer);
    }
}
 
public class Ex {
    public static void main(String[] args) {
        TV tv = new TV();
        TV tv1 = new TV("삼성");
        TV tv2 = new TV(65, "삼성");
    }
}
