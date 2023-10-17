/*
자바의 java.util.Arrays 클래스는 배열 관련 다양한 유틸리티 메서드를 제공합니다. 그 중에서 sort 메서드는 배열의 요소를 오름차순으로 정렬하는 데 사용됩니다.

Arrays.sort 메서드의 특징:
다양한 오버로드: Arrays.sort는 다양한 데이터 타입에 대한 오버로드를 제공합니다. 기본형 배열 (int[], double[], char[] 등) 뿐만 아니라 객체 배열 (Object[])에 대해서도 사용할 수 있습니다.

오름차순 정렬: 기본적으로 Arrays.sort는 오름차순으로 정렬됩니다.

퀵소트 변형 사용: Arrays.sort의 내부 구현은 데이터의 종류와 크기에 따라 퀵소트, 병합 소트, 삽입 정렬의 변형을 사용합니다.

Comparator 지원: 객체 배열의 경우, 사용자 정의 정렬 순서를 적용하기 위해 Comparator 객체를 인자로 전달할 수 있습니다.

// 기본형 배열 정렬
int[] intArray = {3, 1, 4, 1, 5, 9, 2, 6};
Arrays.sort(intArray);
// intArray는 {1, 1, 2, 3, 4, 5, 6, 9}로 정렬됩니다.

// 객체 배열과 Comparator 사용
String[] strArray = {"apple", "banana", "cherry"};
Arrays.sort(strArray, Collections.reverseOrder());
// strArray는 {"cherry", "banana", "apple"}로 내림차순으로 정렬됩니다.

*/

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        
        // 정수 다섯개 입력
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        
        System.out.println("첫 번째로 큰 수: " + arr[4]);
        System.out.println("두 번째로 큰 수: " + arr[3]);
    }
}
