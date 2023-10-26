import java.util.Scanner;

class Main {

  static void q1() {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 초를 의미하는 양의 정수 입력

    int see = N/3600; // 1시간 = 3600초
    int boon = N%3600/60; // 1분 = 60초
    int second = N%60;
    System.out.printf("%d:%d:%d", see, boon, second);
  }

  public static void main(String[] args) {
    q1();
  }
}
