package Leetcode;

public class Num394 {
    String ans;
    public String decodeString(String s) {
        int len = s.length();
        ans = helper(s, len);
    return ans;
    }

    int i =0;
    public String helper(String s, int len){
        StringBuilder sb = new StringBuilder();
        int loop = 0;
        String rec = "";
        for(int i =0; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch >= 97 && ch <= 122)
                sb.append(ch); //sb에 알파벳 넣기
            else if(ch >= 48 && ch <= 57)
                loop = loop * 10 + (ch-48); //숫자일 경우
            else if (ch == '[') {
                rec = decodeString(s.substring(i+1));
                for(int j = 0; j<loop; j++)
                    sb.append(rec);
                int cnt = 1;
                while (cnt != 0){
                    i++;
                    if(s.charAt(i) == '[')
                        cnt++;
                    else if(s.charAt(i) == ']')
                        cnt--;
                }
                loop = 0;
            } else if (ch == ']') {
                break;
            }
        }
        return sb.toString();
    }
}
