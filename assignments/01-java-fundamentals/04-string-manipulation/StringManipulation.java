public class StringManipulation {
    public String trimAndConcat(String str1, String str2) {
        String str3 = str1.trim() + str2.trim();
        return str3;
    }
    public Integer getIndexOrNull(String str1, char letter) {
        int idx = str1.indexOf(letter);
            if (idx == -1) {
                return null;
            }
            else {
                return idx;
            }
    }
    public Integer getIndexOrNull(String str1, String str2) {
        int idx = str1.indexOf(str2);
            if (idx == -1) {
                return null;
            }
            else {
                return idx;
            }
    }
    public String concatSubString(String str1, int num1, int num2, String str2) {
        String word = str1.substring(num1, num2) + str2;

        return word;
    }
}
