import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluator {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a postfix expression (must be in this form, i.e., 3,2,+,4,*)");
            String postfix = scanner.nextLine().trim();
            System.out.println("The final result for the given postfix expression = " + evaluateThePostfixExpression(postfix));
        } catch (Exception e) {
            System.out.println("ERROR: " + e.toString());
        }
    }

    public static Integer evaluateThePostfixExpression(String input) {
        Stack<Integer> stack = new Stack<Integer>();
        String[] parts = input.split(",");
        for (String part : parts) {
            if (isNumeric(part)) {
                stack.push(Integer.valueOf(part + ""));
                System.out.println(part + " pushed to the stack");
                System.out.println("current elements in the stack --> " + stack.toString());
            } else {
                if (part.equals("+")) {
                    int a = (Integer) stack.pop();
                    System.out.println(a + " popped from the stack");
                    int b = (Integer) stack.pop();
                    System.out.println(b + " popped from the stack");
                    System.out.println("the addition operation --> " + a + " + " + b + " = " + (a + b));
                    int d = operator(part.charAt(0), a, b);
                    stack.push(d);
                    System.out.println(d + " pushed to the stack");
                    System.out.println("current elements in the stack --> " + stack.toString());
                }
                if (part.equals("-")) {
                    int a = (Integer) stack.pop();
                    System.out.println(a + " popped from the stack");
                    int b = (Integer) stack.pop();
                    System.out.println(b + " popped from the stack");
                    System.out.println("the subtraction operation --> " + a + " - " + b + " = " + (a - b));
                    int d = operator(part.charAt(0), a, b);
                    stack.push(d);
                    System.out.println(d + " pushed to the stack");
                    System.out.println("current elements in the stack --> " + stack.toString());
                }
                if (part.equals("*")) {
                    int a = (Integer) stack.pop();
                    System.out.println(a + " popped from the stack");
                    int b = (Integer) stack.pop();
                    System.out.println(b + " popped from the stack");
                    System.out.println("the multiplication operation --> " + a + " * " + b + " = " + (a * b));
                    int d = operator(part.charAt(0), a, b);
                    stack.push(d);
                    System.out.println(d + " pushed to the stack");
                    System.out.println("current elements in the stack --> " + stack.toString());
                }
                if (part.equals("/")) {
                    int a = (Integer) stack.pop();
                    int b = (Integer) stack.pop();
                    System.out.println("the division operation --> " + a + " / " + b + " = " + (a / b));
                    int d = operator(part.charAt(0), a, b);
                    stack.push(d);
                    System.out.println(d + " pushed to the stack");
                    System.out.println("current elements in the stack --> " + stack.toString());
                }
            }
        }
        if (!stack.isEmpty()) {
            return (Integer) stack.peek();
        }
        return null;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int intNum = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static int operator(char ch, int a, int b) {
        return switch (ch) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> b / a;
            default -> 0;
        };
    }

}