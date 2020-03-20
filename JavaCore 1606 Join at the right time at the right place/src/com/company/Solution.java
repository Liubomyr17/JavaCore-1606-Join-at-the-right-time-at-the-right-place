package com.company;

/*

1606 join: at the right time at the right place
Think about where and for which object you need to call the join method so that the result is displayed in order
first for firstThread, and then for secondThread.
Call the join method in the right place.
Output Example:
firstThread: String 1
firstThread: String 2
...
firstThread: String 19
firstThread: String 20
secondThread: String 1
...
secondThread: String 20

Requirements:
1. The main method should call the join method on the firstThread object.
2. The main method should not call the join method on the secondThread object.
3. The main method should not call System.out.println () or System.out.print ().
4. The output of the program should correspond to the example from the assignment.

 */

import java.util.ArrayList;
import java.util.List;

/*
join: в нужное время в нужном месте
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        PrintListThread firstThread = new PrintListThread("firstThread");
        PrintListThread secondThread = new PrintListThread("secondThread");
        firstThread.start();
        firstThread.join();
        secondThread.start();
    }

    public static void printList(List<String> list, String threadName) {
        for (String item : list) {
            System.out.println(String.format("%s : %s", threadName, item));
        }
    }

    public static List<String> getList(int n) {
        List<String> result = new ArrayList<String>();
        if (n < 1) return result;

        for (int i = 0; i < n; i++) {
            result.add(String.format("String %d", (i + 1)));
        }
        return result;
    }

    public static class PrintListThread extends Thread {
        public PrintListThread(String name) {
            super(name);
        }

        public void run() {
            printList(getList(20), getName());
        }
    }
}



