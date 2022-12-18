package BaeJoon.Realization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2596 {
    public static final String A = "000000";
    public static final String B = "001111";
    public static final String C = "010011";
    public static final String D = "011100";
    public static final String E = "100110";
    public static final String F = "101001";
    public static final String G = "110101";
    public static final String H = "111010";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String msg = br.readLine();
        errorCheck(msg, num);
    }

    public static void errorCheck(String msg, int N){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<msg.length(); i+=6){
            String str = msg.substring(i, i+6);
            if(str.equals(A) || errorCheck(str, A)){
                sb.append("A");
            }else if(str.equals(B) || errorCheck(str, B)){
                sb.append("B");
            }else if(str.equals(C) || errorCheck(str, C)){
                sb.append("C");
            }else if(str.equals(D) || errorCheck(str, D)){
                sb.append("D");
            }else if(str.equals(E) || errorCheck(str, E)){
                sb.append("E");
            }else if(str.equals(F) || errorCheck(str, F)){
                sb.append("F");
            }else if(str.equals(G) || errorCheck(str, G)){
                sb.append("G");
            }else if(str.equals(H) || errorCheck(str, H)){
                sb.append("H");
            }else{
                sb = new StringBuffer();
                sb.append((i/6)+1);
                break;
            }
        }
        System.out.println(sb.toString());
    }

    public static boolean errorCheck(String str, String alpha){
        int cnt = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) != alpha.charAt(i)){
                cnt++;
            }
        }
        if(cnt == 1){ // 한글자만 틀림
            return true;
        }
        return false; //두글자 이상 틀림
    }

}