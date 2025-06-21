import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String infix = br.readLine();

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < infix.length(); i++){
            char ch = infix.charAt(i);

            if(ch >= 'A' && ch <= 'Z'){
                result.append(ch);
            }
            else if(ch == '('){
                stack.push(ch);
            }
            else if(ch == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    result.append(stack.pop());
                }
                stack.pop();
            }
            else{
                while(!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(ch)){
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while(!stack.isEmpty()){
            result.append(stack.pop());
        }

        System.out.println(result.toString());
    }

   static int getPriority(char op){
        if(op == '(' || op == ')'){
            return 0;
        }
        else if(op == '+' || op == '-'){
            return 1;
        }
        else if(op == '*' || op == '/'){
            return 2;
        }
        return -1;
    }
}