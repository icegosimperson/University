import java.util.Scanner;

class Main {

static public void q1()
{
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    
    for(int i=0; i<N; i++){
      for(int j=0; j<i+1; j++)
        System.out.printf("*");
      System.out.println();
    }
  
}


static public void q2()
{
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    
    for(int i=0; i<N; i++){
      for(int j=N; j>i; j--)
        System.out.printf("*");
      System.out.println();
    }  

  
}


static public void q3()
{
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
  
    for(int i=0; i<N; i++){ 
      for(int star=1; star<=2*i+1; star++) 
        System.out.printf("*");
      System.out.println();
    }  
}

static public void q4()
{
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
  
    for(int i=0; i<N; i++){ 
      for(int star=2*N-1; star>=2*i+1; star--) 
        System.out.printf("*");
      System.out.println();
    }    
}


static public void q5()
{
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
  
    for(int i=0; i<N; i++){ 
      for(int z=0; z<N-i; z++)
        System.out.printf(" ");
      for(int star=1; star<=2*i+1; star++) 
        System.out.printf("*");
      System.out.println();
    }  

  
}

static public void q6()
{
    Scanner sc = new Scanner(System.in);
    int answer = sc.nextInt(); // 정답 
    int try_number=0; // 시도 횟수 변수 
    int input;
  
    do {
      input = sc.nextInt(); // 입력값
      try_number++;
      if(input>answer)
        System.out.printf("%d보다 낮습니다\n", input);
      else if(input<answer)
        System.out.printf("%d보다 높습니다\n", input);
      else
        System.out.printf("%d 정답입니다.", input);
    } while(input!=answer);
  
}

static public void q7()
{
  Scanner sc = new Scanner(System.in);
  int N = sc.nextInt(); // 3~18 정수 입력 받음
  int a, b, c;

  for(a=1; a<=6; a++){
    for(b=1; b<=6; b++){
      for(c=1; c<=6; c++){
        if((a+b+c)==N)
          System.out.printf("%d %d %d\n", a, b, c);
      }
    }
  }
}


static public void q8()
{
  Scanner sc = new Scanner(System.in);
  int N = sc.nextInt(); 
  for(int i=0; i<N; i++){
    for(int j=0; j<N; j++){
      if(i==j || i+j==N-1) // (0.8), (1,7), (2, 8) ...
        System.out.printf("X ");
      else
        System.out.printf("O ");
    }
    System.out.println("");
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
    q8();
  }
}
