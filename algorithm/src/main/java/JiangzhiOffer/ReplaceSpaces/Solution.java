package JiangzhiOffer.ReplaceSpaces;

public class Solution {
    private static String s = "my name is wang ying  hui";

    private static String solution(StringBuffer str) {
       if (str == null || str.length() == 0){
           return str.toString();
       }
       StringBuilder sb = new StringBuilder();
       int len = str.length();
       for (int i =0;i<len;++i){
           char ch = str.charAt(i);
           sb.append(ch == ' ' ? "20%" : ch);
       }
       return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(s);
        System.out.println(solution(new StringBuffer(s)));
    }
}
