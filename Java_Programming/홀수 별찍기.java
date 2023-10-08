import java.util.Scanner;

class Main {
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
  public static void main(String[] args) {
    q3();
  }
}
