/* 1번. getmax
 * - 메인메소드에 10개의 배여려을 선언하고 값을 임의로 할당
 * - 배열에서 가장 큰 값을 찾아 리턴하는 메소드를 작성
 * - 메소드를 이용하여 가장 큰 값을 메인에서 출력
 */
 public class Example {

    public static void main(String[] args) {
        int[] arr = new int[] {30, 20, 10, 50, 40, 60, 90, 80, 70, 100};

        System.out.println("최대값: " + getMax(arr));
        System.out.println("최솟값: " + getMin(arr));
        System.out.println("합계: " + getSum(arr));
        System.out.println("절사평균: " + getAvg(arr));
    }  

    // 배열에서 가장 큰 값을 찾아 리턴하는 메소드
    static int getMax(int[] arr) {
        int maxVal = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }
        return maxVal;
    }
    
    // 배열에서 가장 작은 값을 찾아 리턴하는 메소드
    static int getMin(int[] arr) {
        int minVal = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < minVal) {
                minVal = arr[i];
            }
        }
        return minVal;
    }
    
    // 배열의 합을 구해서 리턴하는 메소드
    static int getSum(int[] arr) {
        int sum = 0;
        for(int j = 0; j < arr.length; j++) {
            sum += arr[j];
        }
        return sum;
    }
    
    // 배열의 절사평균을 구해주는 메소드
    static double getAvg(int[] arr) {
        double sum = getSum(arr);
        int max = getMax(arr);
        int min = getMin(arr);
        
        sum -= (max + min);        
        double avg = sum / (arr.length - 2);
        return avg;
    }
}
