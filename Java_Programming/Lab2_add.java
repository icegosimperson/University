import java.util.Scanner;

public class Main {

  static void q1() {
    // 첫번째 문제
    double result = 10 / 3.0; // 어느 숫자이든 하나이상이 실수형일
    System.out.printf("%.4f", result);
    System.out.println(", 1번 문제 끝");
  }

  static void q2() {
    // 두 번째 문제
    Scanner sc = new Scanner(System.in);
    System.out.println("2번 문제 : 3의 배수임을 확인 하겠습니다.");
    int n = sc.nextInt(); // 정수 입력

    if (n % 3 == 0)
      System.out.println("true");
    else
      System.out.println("false");

  }

  static void q3() {
    Scanner sc = new Scanner(System.in);
    System.out.printf("3번 문제:");
    String i = sc.nextLine(); // 엔터 입력까지 입력

    switch (i) {
      case "a":
      case "e":
      case "i":
      case "o":
      case "u":
        System.out.println("모음입니다.");
        break;
      default:
        System.out.println("자음입니다.");
    }
  }

  // Long to int (.intValue)
  static void q4() {
    Long num1 = 2322331L; // long이 아니라 Long으로 선언 
    Long num2 = 52341241L;

    int i_num1 = num1.intValue();
    int i_num2 = num2.intValue();
    
    System.out.println(i_num1);
    System.out.println(i_num2);
  }

  // String to int (Integer.parseInt, Integer.valueOf)
  static void q5() {
    String str1 = "23";
    String str2 = "4566";

    int i_num3 = Integer.parseInt(str1);
    int i_num4 = Integer.parseInt(str2);
    
    System.out.println(i_num3);
    System.out.println(i_num4);
    
  }

  static void q6() {
    Scanner sc = new Scanner(System.in);
    System.out.printf("0과 30사이의 값을 입력하세요:");
    int x = sc.nextInt(); // 엔터 입력까지 입력

    if(0<=x && x<10)
      System.out.println("0보다 크고 10 미만입니다");
    else if(10<=x && x<20)
      System.out.println("10보다 크고 20 미만입니다");
    else if(20<=x&& x<=30)
      System.out.println("20보다 크고 30 미만입니다");
    else
      System.out.println("0과 30사이의 값을 입력하세요");
  }

  static void q7() {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 엔터 입력까지 입력
    int M = sc.nextInt(); // 엔터 입력까지 입력

    if(M==N*N)
      System.out.println(M);
    else if(N==M*M)
      System.out.println(N);
    else
      System.out.println(N*M);
    
  }

  static void q8() {
    // 배열 설정
    int[] Answer = new int[3];
    int[] Guess = new int[3];

    // 정답값과 추측값 3개씩 입력받아 배열에 저장하기
    Scanner sc = new Scanner(System.in);
    System.out.print("정답값 3개 입력: ");
    for (int i=0; i<Answer.length; i++)
      Answer[i] = sc.nextInt();

    System.out.print("추측값 3개 입력: ");
    for (int j=0; j<Guess.length; j++)
      Guess[j] = sc.nextInt();

    // strike, ball값 선언
    int strike=0;
    int ball=0;

    // strike 확인 (i==j 조건 추가)
    for (int i=0; i<Answer.length; i++){
      for (int j=0; j<Guess.length; j++){
        if(i ==j && Answer[i] ==Guess[j])
          strike++;
      }
    }

    // ball 확인 (i!=j 조건 추가)
    for (int i=0; i<Answer.length; i++){
      for (int j=0; j<Guess.length; j++){
        if(i != j && Answer[i] ==Guess[j])
          ball++;
      }
    }    
    
    System.out.println("strike개수 :" +strike);
    System.out.println("ball 개수:" +ball);
    
  }

  public static void main(String[] args) {

    q1();
    q2();
    q3();
    q4();
    q5();
    q6();
    q7();
    q8();

  }
}
