import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    // String input;
	    String[] arr = new String[5];
	    String input = sc.nextLine();

	    // 영어문자 다섯개 입력 받기 (배열)
	    for(int i=0; i<5; i++){
	    	arr[i] = String.valueOf(input.charAt(i));
	    }

	    // 한번에 한칸씩 shift
	    for(int shift=0; shift<5; shift++) {
		    // 맨마지막 -> 첫번째 경우
		    for(int i=0; i<arr.length; i++){
		      System.out.print(arr[i]);
		    }
		    System.out.println();
		    
	    	String tmp = arr[4]; // 맨마지막 배열은 변수에 따로 저장
	    	for(int i=3; i>=0; i--){
	  	      arr[i+1] = arr[i];
	  	    }
	  	    arr[0] = tmp;
	    }
	   
  }
}
  
