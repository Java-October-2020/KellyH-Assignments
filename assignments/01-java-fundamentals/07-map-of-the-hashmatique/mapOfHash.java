import java.util.HashMap;
import java.util.Set;
public class mapOfHash {
     public static void main(String[] args) {
        HashMap<String, String> setlist = new HashMap<String, String>();
        setlist.put("song1" , "Where are you? And I'm so sorry, I cannot sleep I cannot dream tonight");
        setlist.put("song2" , "I need somebody and always, this sick strange darkness comes creeping on, so haunting everytime");
        setlist.put("song3" , "And as i stare i counted, the webs from all the spiders, catching things and eating their insides");
        setlist.put("song4" , "Like indicision to call you, And hear your voice of treason");
        System.out.println(setlist.get("song1"));
        
        Set<String> keys = setlist.keySet();
        for(String key : keys) {
            System.out.println("Track: "+ key + " lyric: " + setlist.get(key));
        }
    }

}
