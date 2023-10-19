package test;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 1. 정답이 되는 3글자 영단어 입력 받기
        System.out.print("3글자 영단어를 입력하세요: ");
        String answer = sc.next();
        
        // 2. 입력받은 정답을 배열에 문자열로 쪼개서 저장
        char[] answer_arr = answer.toCharArray();
        
        // 정답 상태 출력을 위한 배열 생성 및 초기화
        char[] displayArr = new char[answer_arr.length];
        for(int i = 0; i < displayArr.length; i++) {
            displayArr[i] = '_';
        }
        
        int count = 0;
        while(count < 5) {
            // 사용자로부터 문자 입력 받기
            System.out.print("입력: ");
            char input = sc.next().charAt(0);
            
            boolean isMatched = false;
            for(int i = 0; i < answer_arr.length; i++) {
                if(input == answer_arr[i]) {
                    displayArr[i] = input;
                    isMatched = true;
                }
            }
            
            // 정답 상태 출력
            for(int i = 0; i < displayArr.length; i++) {
                System.out.print(displayArr[i]);
            }
            System.out.println();
            
            count++;
            
            // 정답을 맞춘 경우
            if(String.valueOf(displayArr).equals(answer)) {
                System.out.println("정답!");
                break;
            }
        }
        
        if(count == 5 && !String.valueOf(displayArr).equals(answer)) {
            System.out.println("프로그램 종료");
        }
    }
}
