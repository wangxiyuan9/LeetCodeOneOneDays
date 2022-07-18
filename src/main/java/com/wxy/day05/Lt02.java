package com.wxy.day05;

import javax.security.auth.callback.CallbackHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Description:
 * 20. 有效的括号
 * Author: wxy
 * Date: 2022/7/18 15:54
 */
public class Lt02 {

    public static void main(String[] args) {

    }

}
class Solution01 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if(stack.isEmpty() || !map.containsKey(stack.peek()))
                stack.push(aChar);
            //in and not empty
            else if(map.get(stack.peek())==aChar)//stack peek:len-1
                stack.pop();
            else
                stack.push(aChar);
        }
        return stack.isEmpty();
    }
}

