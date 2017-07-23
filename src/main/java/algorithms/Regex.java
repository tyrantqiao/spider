package algorithms;

/**
 * Created by GeoLin on 2017/7/15.
 */
public class Regex {
    public String learnTrim(String s){
        int len = s.length();
        int st = 0;
        char[] val = s.toCharArray();    /* avoid getfield opcode */

        while ((st < len) && (val[st] <= ' ')) {
            st++;
            System.out.println("st "+st);
        }
        while ((st < len) && (val[len - 1] <= ' ')) {
            len--;
            System.out.println("len "+len);
        }
        return ((st > 0) || (len < s.length())) ? s.substring(st, len) : String.valueOf(this);
    }

    public static void main(String[] args){
        Regex regex=new Regex();
        System.out.println(regex.learnTrim(" \t \n 12 45 12  78  78 45 12   "));
    }

}
