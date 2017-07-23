package algorithms;
import edu.princeton.cs.algs4.*;
import java.awt.Color;
import java.io.File;

/**
 * Created by GeoLin on 2017/7/12.
 */
public class Draw {

    public static void drawArrays(int[] arr){
        Color[] colors={Color.RED,Color.BLACK,Color.ORANGE};
        int N=arr.length;
        for(int i=0;i<N;i++){
            double x=1.0*i/N;
            double y=(double)arr[i]/2.0/N;
            double rw=0.5/N;
            double rh=(double)arr[i]/2.0/N;
            StdDraw.setPenColor(colors[StdRandom.uniform(3)]);
            StdDraw.filledRectangle(x,y,rw,rh);
        }
    }

    public static void main(String[] args){
        int N=100;
//        StdDraw.setXscale(0,N);
//        StdDraw.setYscale(0,N*N);
//        StdDraw.setPenRadius(.01);
//        double[] a=new double[N];
//        for(int i=0;i<N;i++){
//            a[i]=StdRandom.uniform();
//        }

        String s=FileMethod.readText("numbers.txt");

        System.out.println(s);



    }

}
