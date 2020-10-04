import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class Puzzle{
    public ArrayList<Integer> greaterThan10(int[] arr){
        int sum = 0;
        ArrayList<Integer> answer = new ArrayList<Integer> (); 
        for (int i = 0; i<arr.length; i++) {
            if (arr[i]>10){
                answer.add(arr[i]);
            }
            sum += arr[i];
        }
        System.out.println("sum: "+ sum);
        System.out.println(answer);
        return answer;
    }
    public ArrayList<String> fiveCharNames(ArrayList<String> arr) {
        ArrayList<String> arrList = new ArrayList<String>();
        Collections.shuffle(arr);
        for (int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
            if (arr.get(i).length() > 5) {
                arrList.add(arr.get(i));
            }
        }
        
        System.out.println(arrList);
        return arrList;   
    }
    public void shuffleAlpha(){
        ArrayList<Character> alpha = new ArrayList<Character>();
        char[] vowels = {'a','e','i','o','u'};
            for (char ch = 'a'; ch <= 'z'; ++ch){
                alpha.add(ch);
            }   
            Collections.shuffle(alpha);
            System.out.println("Last Letter: " + alpha.get(25));
            System.out.println("First Letter: " + alpha.get(0));
            for (int i = 0; i < vowels.length; i++){
                if (alpha.get(0) == vowels[i] ) { // if vowel print message
                    System.out.println("The first letter is a vowel");    
                }
            }
    }
    public void random55to100(){
        ArrayList<Integer> randNums = new ArrayList<Integer>();
        Random n = new Random();
        while (randNums.size() < 10){
            for (int j = 0; j < 10; j++) { //add a random number to new arraylist
                int rnum = n.nextInt(100);
                if (rnum > 54 && randNums.size() < 10) {
                    randNums.add(rnum);
                }
            }
        }
        System.out.println(randNums);
    }
    public ArrayList<Integer> sortRandom55to100(){
        ArrayList<Integer> randNums = new ArrayList<Integer>();
        Random n = new Random();
        while (randNums.size() < 10){
            for (int j = 0; j < 10; j++) { //add a random number to new arraylist
                int rnum = n.nextInt(100);
                if (rnum > 54 && randNums.size() < 10) {
                    randNums.add(rnum);
                }
            }
        }
        Collections.sort(randNums);
        System.out.println(randNums);
        System.out.println("Min: " + randNums.get(0));
        System.out.println("Max: " + randNums.get(9));
        return randNums;
    }
    public void randString(){
        Random rand = new Random();
        String rstring = "";
        for (int i = 0; i < 5; i++ ) {
            char c = (char) ('a' + rand.nextInt(26));
            rstring += c;
        }
        System.out.println(rstring);
    }
    public void randArr(){
        Random rand = new Random();
        ArrayList<String> list = new ArrayList<String>();
        for (int j = 0; j < 10; j++){
            String rstring = "";
            for (int i = 0; i < 5; i++ ) {
                char c = (char) ('a' + rand.nextInt(26));
                rstring += c;
            }
            list.add(rstring);
        }
        System.out.println(list);
    }    
}