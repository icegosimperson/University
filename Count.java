import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 숫자를 저장할 배열 선언
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            while (true) {
                System.out.print((i + 1) + "번째 숫자를 입력하세요 (1, 2, 3 중 하나): ");
                int input = scanner.nextInt();

                // 입력 숫자 확인
                if (input == 1 || input == 2 || input == 3) {
                    numbers[i] = input;
                    break;  // 올바른 입력을 받았으므로 다음 숫자 입력으로 넘어감
                } else {
                    System.out.println("잘못된 숫자를 입력하셨습니다. 다시 입력해주세요.");
                }
            }
        }

        // 저장된 배열 출력
        System.out.print("입력받은 숫자들: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
