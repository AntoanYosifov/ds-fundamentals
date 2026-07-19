package implementations;

import interfaces.Solvable;

public class BalancedParentheses implements Solvable {
    private String parentheses;

    private Stack<Character> openersStack;

    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
        this.openersStack = new Stack<>();
    }

    @Override
    public Boolean solve() {

        for (int i = 0; i < parentheses.length(); i++) {
            char c = parentheses.charAt(i);

            switch (c) {
                case '{':
                case '[':
                case '(':
                    openersStack.push(c);
                    break;
                case ')':
                    if (openersStack.isEmpty() || openersStack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (openersStack.isEmpty() || openersStack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (openersStack.isEmpty() || openersStack.pop() != '{') {
                        return false;
                    }
                    break;
            }
        }

        return openersStack.isEmpty();
    }
}
