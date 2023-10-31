
/**
 * 여기에 Pizza 클래스 설명을 작성하십시오.
 * 
 * @22012464(작성자 이름) 
 * @version (버전번호나 날짜)
 */

public class Pizza
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 바꾸십시오
    private String size; 
    private int cheese;
    private int pepperoni;
    private int ham;
    /**
     * Pizza 클래스의 객체 생성자
     */
    /* -치즈 토핑 수를 저장하기 위한 필드
    -페퍼로니 토핑 수를 저장하기 위한 필드
    -햄 토핑 수를 저장하기 위한 필드 */
    
    public Pizza(String size, int cheese, int pepperoni, int ham)
    {
        // 인스턴스 변수의 초기화
        this.size = size;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.ham = ham;
    }

    /**
     * 예제 메소드 - 이 주석을 사용자에 맞게 바꾸십시오
     * 
     * @param  y   메소드의 예제 매개변수
     * @return     x 더하기 y 
     */
    
    // 현재 치즈 토핑의 수 
    public int getNumCheese()
    {
       // 여기에 코드를 작성하십시오.
       return cheese;
    }
    
    // 치즈 토핑의 수
     public void setNumCheese(int cheese)
    {
       // 여기에 코드를 작성하십시오.
       this.cheese = cheese;
    }
    
     public int getNumPepperoni()
    {
       // 여기에 코드를 작성하십시오.
       return pepperoni;
    }
    
     public void setNumPepperoni(int pepperoni)
    {
       // 여기에 코드를 작성하십시오.
       this.pepperoni = pepperoni;
    }
    
     public int getNumHam()
    {
       // 여기에 코드를 작성하십시오.
       return ham;
    }
    
     public void setNumHam(int ham)
    {
       // 여기에 코드를 작성하십시오.
       this.ham = ham;
    }
    
    
    public int calcCost(){
        int price=0; 
        switch(size){
            case "small":
                price=11;
                break;
            case "medium":
                price=12;
                break;
            case "large":
                price=14;
                break;
        }
        return price + (2*(cheese + pepperoni + ham));
    }
    
    public String getDescription(){
        return size + "피자+ " + Integer.toString(cheese) + "치즈+ " 
        + Integer.toString(pepperoni) + "페퍼로니+ " + Integer.toString(ham) + "햄+ "; 
    } 
    
    public static void main(String[] args) {
        Pizza testPizza = new Pizza("large", 1, 1, 2);
        System.out.println(testPizza.getDescription() + "=$" + testPizza.calcCost()); // should print $22
    }
}
