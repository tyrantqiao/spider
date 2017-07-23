package algorithms;

import java.util.Stack;

/**
 * Created by GeoLin on 2017/7/15.
 */
public class Calculate {

    /**
     * @author Dijkstra
     * ( 1 + 2 ) use spilt to devide the String as String[], need whitespace.
     */
    public static double Evaluate(String expression){
        Stack<String> ops=new Stack<String>();
        Stack<Double> vals=new Stack<Double>();
        String[] expressions=expression.split(" ");

        for(String s:expressions){
//            System.out.println("begin:"+s+"---end");
            switch (s){
                case "(":
                case "+":ops.push("+");break;
                case "-":ops.push("-");break;
                case "*":ops.push("*");break;
                case "/":ops.push("/");break;
//                case "s":ops.push("sqrt");break;
                case ")":
                    String op=ops.pop();
                    double v=vals.pop();
                    switch (op){
                        case "+":v=vals.pop()+v;vals.push(v);break;
                        case "-":v=vals.pop()-v;vals.push(v);break;
                        case "*":v=vals.pop()*v;vals.push(v);break;
                        case "/":v=vals.pop()/v;vals.push(v);break;

                    }
                    break;
                default:
                    vals.push(Double.parseDouble(s));break;
            }
        }
        return vals.pop();
    }


    public static void main(String[] args){
        double result=Evaluate("( 1 + 2 ) ");
        System.out.println(result);
    }


}
