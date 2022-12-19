package Leetcode.Ramdomized;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Num382 {
    List<Integer> list = new ArrayList<>();
    Random random = new Random();
    public Num382(ListNode head) {
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
