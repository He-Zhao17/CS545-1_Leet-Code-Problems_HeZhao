import java.util.List;

/***
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

//Time >99.94%
//Memory > 13.1%

//Definition for singly-linked list.
class ListNode {
     public int val;
     public ListNode next;
     public ListNode(int val, ListNode next ) {
         this.val = val;
         this.next = next;
     }
     public ListNode(int val) {
         this.val = val;

     }
 }

public class Leetcode_2 {

    //2. Add Two Numbers _ Medium
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2) {
        boolean sumOver10 = false;
        ListNode result = new ListNode(0, null);
        ListNode currentPointer = null;
        ListNode pointer = result;

        while (l1 != null && l2 != null) {
            if (sumOver10) {
                if ( (l1.val + l2.val) > 8) {
                    pointer.val = l1.val + l2.val - 9;
                    sumOver10 = true;
                    currentPointer = pointer;
                    pointer.next = new ListNode(0, null);
                    pointer = pointer.next;
                    l1 = l1.next;
                    l2 = l2.next;
                } else {
                    pointer.val = l1.val + l2.val + 1;
                    sumOver10 = false;
                    currentPointer = pointer;
                    pointer.next = new ListNode(0, null);
                    pointer = pointer.next;
                    l1 = l1.next;
                    l2 = l2.next;
                }


            } else {
                if ( (l1.val + l2.val) > 9) {
                    pointer.val = l1.val + l2.val - 10;
                    sumOver10 = true;
                    currentPointer = pointer;
                    pointer.next = new ListNode(0, null);
                    pointer = pointer.next;
                    l1 = l1.next;
                    l2 = l2.next;


                } else {
                    pointer.val = l1.val + l2.val;
                    sumOver10 = false;
                    currentPointer = pointer;
                    pointer.next = new ListNode(0, null);
                    pointer = pointer.next;
                    l1 = l1.next;
                    l2 = l2.next;
                }
                }

        }

        if (l1 == null && l2 != null) {
            while (l2 != null) {
                if (sumOver10) {
                    if (l2.val > 8) {
                        pointer.val = l2.val - 9;
                        sumOver10 = true;
                    } else {
                        pointer.val = l2.val + 1;
                        sumOver10 = false;
                    }
                    currentPointer = pointer;
                    pointer.next = new ListNode(0, null);
                    pointer = pointer.next;
                    l2 = l2.next;
                } else {
                    pointer.val = l2.val;
                    currentPointer = pointer;
                    pointer.next = new ListNode(0, null);
                    pointer = pointer.next;
                    l2 = l2.next;
                }

            }
            if (sumOver10) {
                pointer.val = 1;
                return result;
            } else {
                currentPointer.next = null;
                return result;
            }

        } else if(l1 != null && l2 == null) {
            while (l1 != null) {
                if (sumOver10) {
                    if (l1.val > 8) {
                        pointer.val = l1.val - 9;
                        sumOver10 = true;
                    } else {
                        pointer.val = l1.val + 1;
                        sumOver10 = false;
                    }
                    currentPointer = pointer;
                    pointer.next = new ListNode(0, null);
                    pointer = pointer.next;
                    l1 = l1.next;
                } else {
                    pointer.val = l1.val;
                    currentPointer = pointer;
                    pointer.next = new ListNode(0, null);
                    pointer = pointer.next;
                    l1 = l1.next;
                }

            }
            if (sumOver10) {
                pointer.val = 1;
                return result;
            } else {
                currentPointer.next = null;
                return result;
            }
        } else {
            if (sumOver10) {
                pointer.val = 1;
                return result;
            } else {
                currentPointer.next = null;
                return result;
            }

        }


    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);

        ListNode l2 = new ListNode(9);
        ListNode pointer = l1;
        for (int i = 0; i < 6; i++) {
            pointer.next = new ListNode(9);
            pointer = pointer.next;
        }
        pointer = l2;
        for (int i = 0; i <3; i++) {
            pointer.next = new ListNode(9);
            pointer = pointer.next;
        }

        Leetcode_2 temp = new Leetcode_2();
        ListNode result = temp.AddTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}


