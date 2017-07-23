package algorithms;

import java.io.File;
import java.util.Arrays;

/**
 * Created by GeoLin on 2017/7/13.
 */
public class Find {
    public static void main(String[] args){
        String[] numsText=FileMethod.readText("numbers.txt").trim().split(" ");
        for(String s:numsText)
            System.out.println(s);
        int[] arr= FileMethod.convertArray(numsText);
        Arrays.sort(arr);
        int result=binaryFind(arr,71);
        System.out.println("result "+result);

        Draw.drawArrays(arr);
    }

    public static int binaryFind(int[] arr,int searchNum){
        int lo=0;
        int hi=arr.length-1;
        while(lo<=hi){
            int mid=(hi-lo)/2+lo;
            if(arr[mid]==searchNum)return mid;
            else if(arr[mid]<searchNum)lo=mid+1;
            else if(arr[mid]>searchNum)hi=mid-1;
        }
        return -1;
    }
}
