package Cryptology;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;


public class SHA_256 {
    public static class SHA256 {
        public String encrypt(String text) throws NoSuchAlgorithmException {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(text.getBytes());

            return bytesToHex(md.digest());
        }

        private String bytesToHex(byte[] bytes) {
            StringBuilder builder = new StringBuilder();
            for (byte b : bytes) {
                builder.append(String.format("%02x", b));
            }
            return builder.toString();
        }

    }
    public static void main(String[] args) throws NoSuchAlgorithmException {
        int check=0;
        SHA256 sha256 = new SHA256();
        Scanner sc = new Scanner(System.in);
        String [] password = new String[10]; // 3자리 수 패스워드 10개 만들기
        String [] crypto= new String[10]; // 암호화된 패스워드 저장
        for(int i=0;i<10;i++) {
            System.out.print("password: ");
            password[i] = sc.next();
            crypto[i] = sha256.encrypt(password[i]); // 해시를 이용한 암호화
            System.out.println("hash_value: "+crypto[i]);
        }
        loop: // 패스워드 전수조사
        for(int j=0;j<1000;j++){
            String number = String.format("%03d", check);
            check++;
            for(int i=0;i<10;i++){
                if(crypto[i].equals(sha256.encrypt(number))){
                    System.out.println("find");
                    System.out.println("password: "+number+" \thash_value: "+crypto[i]);
                    break loop;
                }

            }

        }

    }

}
