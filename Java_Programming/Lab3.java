/*
Q1) 두 정수를 입력 받은 후, 크기를 비교하는 코드를 작성하시오

 

        비교 연산자 : >, < , = , != , >=, <=

        예) 25, 39 입력 했을 경우

 

        25 != 39                                                                          

        25 < 39                                                                           

        25 <= 39

 

 

Q2) 지구 위의 두 지점의 위도와 경도를 각각 입력 받은 후(총 4개의 실수(double형) 값), 두 지점의 거리값을 계산하시오. 두 점의 위도, 경도를 각각 (x1, y1), (x2, y2)라고 한다면, 두 지점의 거리 d는 아래와 같다

       

        

        d = radius * arccos(sin(x1) * sin(x2) + cos(x1) * cos(x2) * cos(y1 - y2))

        radius = 6371.01km (상수로 반드시 선언)

        

        입력받은 위도와 경도는 각도(degree)값임 (모두 반드시 double형)

        sin(), acos(), cos()에는 라디언 값을 입력해야 함

        삼각함수는 Math.cos(), Math.sin(), Math.acos(), Math.PI 을 이용할 수 있음

 

        예) (25,35), (35.5, 25.5) => d = 1480.0848451069087 km 

 

Q3*) 하나의 양의 정수 N을 입력 받아 N의 약수를 출력하는 프로그램을 작성하시오 (반드시  while 문을 이용)

 

        출격의 각 수는 하나의 공백으로 구분

 

        예) 7 입력 -> 1 7

        예) 18 입력 -> 1 2 3 6 9 18

        예) 23 입력 -> 1 23

 

        약수? 어떤수를 나누어 딱 떨어지는 수 

 

 

Q4*) 하나의 정수 N을 반복해서(종료 조건 시까지) 입력 받아 N의 합을 출력하는 프로그램을 작성하시오.

 

        종료 조건 : 0 입력

        반드시 while문을 이용

 

        예) 2 3 5 0 입력 -> 9 출력

        예) 3 2 1 0 입력 -> 6 출력

        

 

 

Q5) 한 학생의 국어, 영어, 수학 점수 (점수는 정수 값으로 0~100점 사이 값으로 입력된다)를 입력받아 다음과 같이 학점을 출력하는 프로그램을 작성하시오. 실수로 평균을 구하고, 평균값이

 

        75 이상이면 학점 ‘A’를 출력,

        75 미만 50 이상이면 학점 ‘B’를 출력,

        50 미만이면 학점 ‘F’를 출력한다.

 

        예) 85  75  65 입력 -> 75.00 A 출력

        예) 40  50  60 입력 -> 50.00 B 출력

        예) 52  47  50 입력 -> 49.67 F 출력

        

 

Q6*) 다음과 같이 동작하는 UP DOWN 숫자 맞추기 게임 프로그램을 작성하시오

 

      1. 첫 줄에 게임의 정답을 나타내는 정수 N (1≤N≤6)이 입력된다.

      2. 두 번째 줄에 정답을 <추측>한 수 M이 입력된다.

      3. 추측이 맞으면 ‘RIGHT’를 출력 한 후 프로그램을 종료한다.

      4. 추측한 수가 정답보다 작으면 ‘UP’을 출력하고, 정답보다 크면 ‘DOWN’을 출력한다.

      5. 추측이 틀린 경우, 2~4의 과정을 <한 번 더> 수행한 후 프로그램을 종료한다.(단, 출력은 그 다음 줄에)

 

      예) 5 (정답) -> 4(추측) : UP출력 -> 5(추측) : RIGHT출력 ->종료

          7 (정답) -> 4(추측) : UP출력 -> 6(추측) : UP출력 -> 종료

          5 (정답) -> 5(추측) : RIGHT출력 ->종료

 

 

Q7*)  음료의 종류를 나타내는 1~3사이 정수 N과 투입한 금액을 나타내는 양의 정수 M(100의 배수라고 가정)을 입력 받고, 예시와 같이 선택한 음료의 이름과 잔돈의 개수를 출력 하는 프로그램을 작성하시오.

 

      1. Americano(500원) 

      2. Cafe Latte (400원)

      3. Lemon Tea (300원)

      

      잔돈은 500원과 100원짜리만 있고, 100원짜리를 5개 이상 주는 경우는 없다고 가정한다

      잔돈의 개수는 500원짜리, 100원짜리 순으로 공백을 사이에 두고 출력한다

 

      예) 3, 1000 입력 ->  Lemon Tea, 1, 2 출력 (why? 700원 거스름 돈이므로, 500 x 1개, 100원 x 2개)

      예) 1, 1000 입력 ->  Americano, 1, 0 출력 (why? 500원 거스름 돈이므로, 500 x 1개, 100원 x 0개)

      예) 2, 1000 입력 ->  Cafe Latte, 1, 1 출력 (why? 600원 거스름 돈이므로, 500 x 1개, 100원 x 1개)

  */


import java.util.Scanner;

class Main {
  static void q1()
  {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();

    
    if (a!=b)
    {
      System.out.printf("%d != %d\n", a, b);
      if (a<b){
        System.out.printf("%d < %d\n", a, b);
        System.out.printf("%d <= %d\n", a, b);
      }
      else if(a>b){
        System.out.printf("%d > %d\n", a, b);
        System.out.printf("%d >= %d\n", a, b);
      }
    }
    if(a==b)
        System.out.printf("%d = %d\n", a, b);
  }
  
  static void q2()
  {
    Scanner sc = new Scanner(System.in);
    final double radius = 6371.01; // 반지름
    
    // 위도
    double x1 = Math.toRadians(sc.nextDouble());
    double y1 = Math.toRadians(sc.nextDouble());

    // 경도
    double x2 = Math.toRadians(sc.nextDouble());
    double y2 = Math.toRadians(sc.nextDouble());       

    double d = radius * Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));


    System.out.printf("d = %f km", d); // java에서는 %f (%lf X)
    
  }

  // N의 약수 출력 프로그램
  static void q3()
  {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int i=1;
    
    while(true)
    {
      if(N%i==0)
        System.out.printf("%d ", i);
      else if (N==i)
        break;
      i++;
    }
    
  }

  // 하나의 정수 N을 반복해서(종료 조건 시까지) 입력 받아 N의 합을 출력하는 프로그램
  static void q4()
  {
    Scanner sc = new Scanner(System.in);
    int num=0; // 합을 저장할 변수 선언 
    
    while(true){
      int N=sc.nextInt(); 
      num +=N;
      
      if (N==0) // 종료 조건 : 0 입력
        break;
    }
      System.out.printf("%d", num);

  }
  
  static void q5()
  {
    Scanner sc = new Scanner(System.in);
    int Korea_score = sc.nextInt();
    int Math_score = sc.nextInt();
    int English_score = sc.nextInt();

    double avg= (Korea_score+Math_score+English_score)/3;

    if(avg>=75)
      System.out.printf("A");
    else if(50<=avg && avg<=75)
      System.out.printf("B");
    else
      System.out.printf("F");
    
  }
  
  static void q6()
  {
    Scanner sc=new Scanner(System.in);
    int N = sc.nextInt(); // 1~6 정답값

    System.out.printf("%d(정답) -> ", N);

    
    for(int i=0; i<2; i++){
      int M = sc.nextInt(); // 두번 입력 받아야하니 반복문 안으로 
      System.out.printf("%d(추측) :", M);
      
      if(N==M){
        System.out.printf(" RIGHT->종료");
        return; // if문 종료는 break가 아니라 return
      }
      else if(N<M)
        System.out.printf(" DOWN-");
      else
        System.out.printf(" UP");

      // 출력값 형식 조절 
      if (i==0)
        System.out.printf("->");
      else
        System.out.printf("-> 종료");
    }
    
}

  // 음료 이름과 잔돈의 개수를 출력하는 프로그램
  static void q7()
  {
    Scanner sc = new Scanner(System.in);

    // 음료의 종류
    String d1 = "Amricano";
    String d2 = "Cafe Latte";
    String d3 = "Lemon Tea";

    // 음료의 금액 
    int w1 = 500;
    int w2 = 400;
    int w3 = 300;

    // 입력(음료 종류, 받은 금액)
    int input1 = sc.nextInt(); // 음료 종류
    int input2 = sc.nextInt(); // 받은 금액

    if(input1 == 1){
      int total = input2-w1;
      System.out.printf("%s, %d, %d", d1, total/500, total%500/100);
    }
    else if(input1 == 2){
      int total = input2-w2;
      System.out.printf("%s, %d, %d", d2, total/500, total%500/100);
    }
    else // input1 == d3
    {
      int total = input2-w3;
      System.out.printf("%s, %d, %d", d3, total/500, total%500/100);
    }

  }
  public static void main(String[] args) {

     q1();
     q2();
     q3();
     q4();
     q5();
     q6();
     q7();
    
    
  }
}
