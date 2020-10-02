public class StringDemo {
    public static void main(String[] args) {
        StringManipulation manipulator = new StringManipulation();
        String result = manipulator.trimAndConcat("howdy    ", "    earth    ");
        System.out.println(result);

        char letter = 'o';
        Integer a = manipulator.getIndexOrNull("hello world", letter);
        Integer b = manipulator.getIndexOrNull("coding", letter);
        Integer c = manipulator.getIndexOrNull("hi", letter);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        
        String word = "Hello";
        String subString = "llo";
        String notSubString = "world";
        Integer f = manipulator.getIndexOrNull(word , subString);
        Integer g = manipulator.getIndexOrNull(word, notSubString);
        System.out.println(f);
        System.out.println(g);

        String word = manipulator.concatSubString("hello", 1, 2, "world");
        System.out.println(word);

    }
    
}