import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BracketChecker {
    public void checkBrackets() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a bracket string to check: ");
        String input = sc.nextLine();

        Deque<Character> stack = new ArrayDeque<>();
        boolean balanced = true;

        for (char c : input.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    balanced = false;
                    break;
                }
                char top = stack.pop();
                if (!isMatchingPair(top, c)) {
                    balanced = false;
                    break;
                }
            }
        }

        if (!stack.isEmpty()) {
            balanced = false;
        }

        System.out.println(balanced ? "✅ Brackets are BALANCED and paired correctly!" : "❌ Brackets are NOT balanced!");
    }

    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }
}