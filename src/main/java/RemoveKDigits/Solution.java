package RemoveKDigits;

import java.util.Stack;

public class Solution {

    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();

        char[] chars = num.toCharArray();

        for(char ch: chars){
            int x = ch - '0';

            while(!stack.isEmpty() && x < stack.peek() && k > 0){
                stack.pop();
                k--;
            }

            stack.push(x);
        }

        while (k > 0){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            int x = stack.pop();

            sb.append(x);
        }

        sb.reverse();

        int i=0;
        while(i < sb.length() && sb.charAt(i) == '0'){
            i++;
        }


       return sb.length() == i ? "0" : sb.substring(i);
    }
}
