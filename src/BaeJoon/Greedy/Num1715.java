package BaeJoon.Greedy;
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num1715 {

    static int cardPack;
    static int[] card;
    static int shuffle =0;

    static int answer =0;

    static List<Integer> list = new ArrayList<>();
    public static void calc(){
        Arrays.sort(card);
        for(int i =0; i<card.length; i++){
            list.add(card[i]);
        }
        while(true){
            if(list.size() == 1){
                break;
            }
            Collections.sort(list);
            shuffle = list.get(0) + list.get(1);
            answer += shuffle;
            list.remove(0);
            list.remove(0);
            list.add(shuffle);

        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        cardPack = Integer.parseInt(st.nextToken());
        card = new int[cardPack];

        for(int i =0; i<cardPack; i++){
            card[i] = Integer.parseInt(br.readLine());
        }

        calc();
    }
}
*/
/**
 * 우선순위 큐 + 그리디
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Num1715 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> cardQueue = new PriorityQueue<Integer>();
        List<Integer> list = new ArrayList<Integer>();

        int cardPack = Integer.parseInt(br.readLine());

        for(int i = 0; i < cardPack; i++) {
            cardQueue.offer(Integer.parseInt(br.readLine()));
        }

        int sum = Integer.MAX_VALUE;
        if(cardPack == 1) {
            sum = 0;
        }
        else {
            while(true) {
                int number1 = cardQueue.poll();
                int number2 = 0;
                if(!cardQueue.isEmpty())
                    number2 = cardQueue.poll();

                list.add(number1+number2);
                if(cardQueue.isEmpty())
                    break;
                cardQueue.offer(number1 + number2);
            }

            sum = list.stream().mapToInt(Integer::intValue).sum();
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
