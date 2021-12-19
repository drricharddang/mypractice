package working;

public class StringMethods {
    String s = "";

    StringMethods (String s) {
        this.s = s;
    }

    int countChar(char charToCount) {
        int count = 0;
        char[] chars = this.s.toCharArray();

        for (char c:chars) {
            if (c == charToCount) {
                count++;
            }
        }
        return count;
    }
}
