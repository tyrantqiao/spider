package algorithms;

import edu.princeton.cs.algs4.StdRandom;
import java.io.*;
/**
 * Created by GeoLin on 2017/7/13.
 */
public class RandomNums {
    public static void main(String[] args){
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<100;i++){
            stringBuilder.append(StdRandom.uniform(100));
            stringBuilder.append(" ");
        }
        System.out.println(stringBuilder.toString());
        FileMethod.writeText("numbers.txt",stringBuilder.toString());
    }

}
