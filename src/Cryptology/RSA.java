package Cryptology;

import java.util.Scanner;

public class RSA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        int N = p*q;
        int pq = (p-1)*(q-1);
        int e = 3;
        int i;
        int d = (pq+1) / e;
        System.out.println(d);
        int M = 8;

        int C = (int)Math.pow(M, e) % N;
        long decode = (long)Math.pow(C, d) % N;
        System.out.println(C);
        System.out.println(decode);
    }


}
