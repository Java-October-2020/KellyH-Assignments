import java.util.ArrayList;
import java.util.Arrays;
public class javaBasics {
    
        public void oneTo255() {
            int i = 0;
            for (i = 1; i <256; i++) {
                System.out.println(i);
            }
        }
        public void odd255() {
            // for (int i = 1; i <256; i++) {
            //     if (i % 2 != 0) {
            //         System.out.println(i);
            int i = 1;
            while (i < 256) {
                if (i %2 != 0) {
                    System.out.println(i);
                }
                i += 1;
            }
        }
        public void sum255(){
            int i =0;
            int sum = 0;
            while (i < 256) {
                sum += i;
                System.out.println("Number: " + i +" Sum: " + sum );
                i += 1;
            }
        }
        public void iterateArr(int[] arr){
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }
        public void findMax(int[] arr) {
            int max = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max){
                    max = arr[i];
                }
            }
            System.out.print(max);
        }
        public void getAvg(int[] arr) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            int avg = sum / arr.length;
            System.out.println(avg);
        }
        public void oddArr255(){
            ArrayList<Integer> y = new ArrayList<Integer>();
            for (int i = 0; i <256; i++){
                if (i %2 != 0) {
                    y.add(i);
                }
            }
            System.out.println(y);
        }
        public int greaterThanY(int[] arr, int y){
            int num = 0;
            for (int i = 0; i<arr.length; i++) {
                if (arr[i] > y){
                    num += 1; 
                }
            }
            System.out.println(num);
            return num;
        }
        public void squareArr(int[] arr) {
            for (int i = 0; i<arr.length;i++) {
                arr[i] = arr[i] * arr[i];
            }
            System.out.println(Arrays.toString(arr));
        }
        public void removeNeg(int[] arr) {
            for (int i = 0; i<arr.length; i++){
                if(arr[i] < 0) {
                    arr[i] = 0;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
        public void maxMinAvg(int[] arr){
            int max = arr[0];
            int min = arr[0];
            int sum = 0;
            for (int i = 0; i <arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
                if (arr[i] < min){
                    min = arr[i];
                }
                sum += arr[i];
            }
            int avg = sum / arr.length;
            int[] answer = {max,min,avg};
            System.out.println(Arrays.toString(answer));
        }
        public void shiftBy1(int[] arr){
            for (int i =0; i<arr.length; i++){
                if (i < arr.length - 1) {
                arr[i] = arr[i+1];
                }
                else {
                    arr[i] = 0;
                } 
            }
            System.out.println(Arrays.toString(arr));
        }
}