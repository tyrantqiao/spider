package algorithms;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by GeoLin on 2017/7/13.
 */
public class FileMethod {

    public static int[] convertArray(String[] stringArray){
        int[] arr=new int[stringArray.length];
        for(int i=0;i<stringArray.length;i++){
            arr[i]=Integer.parseInt(stringArray[i]);
        }
        return arr;
    }

    public static void writeText(String pathName,String text){
        File file=new File(pathName);
        try{
            PrintWriter out=new PrintWriter(file.getAbsoluteFile());
            try {
                out.print(text);
            }finally {
                out.close();
                System.out.println(pathName+" creating");
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }


    public static String readText(String fileName){
        StringBuilder stringBuilder=new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(
                            new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    stringBuilder.append(s);
                    stringBuilder.append('\n');
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }
}
