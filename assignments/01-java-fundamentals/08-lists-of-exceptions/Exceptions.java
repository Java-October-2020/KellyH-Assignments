import java.util.ArrayList;
public class Exceptions {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<Object>();
            list.add("13");
            list.add("hello world");
            list.add(48);
            list.add("goodbye world");
        
        
        for(int i = 0; i < list.size(); i++) {
            try {
                Integer castedValue = (Integer) list.get(i); // area of problem code
                System.out.println(castedValue);
            }

            catch (Exception e) {
                System.out.println("Error: " + e.getClass().getSimpleName() + " " + "Index: " + i + " " + "Value: " + list.get(i) );
            }
        }
        System.out.println("Program finished");
    }
}