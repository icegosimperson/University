import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        q4();
    }

    static void q4() {
        Scanner sc = new Scanner(System.in);
        int[] counts = new int[4]; // 인덱스 0은 사용하지 않습니다.

        System.out.println("10개의 숫자를 입력하세요 (1, 2, 3 중 하나): ");
        for (int i = 0; i < 10; ) { 
            int input = sc.nextInt();

            if (input >= 1 && input <= 3) {
                counts[input]++;
                i++;
            } else {
                System.out.println("오류: 1, 2, 3 중 하나의 숫자를 입력해주세요.");
            }
        }

        for (int i = 1; i <= 3; i++) {
            System.out.println(i + " : " + "*".repeat(counts[i]));
        }
    }
}
