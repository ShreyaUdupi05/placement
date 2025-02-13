package Day_5;
import java.util.Stack;

class MinStack {
    private Stack<Integer> stack; // Main stack to store elements
    private Stack<Integer> minStack; // Auxiliary stack to store minimum values

    // Constructor
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    // Push element onto the stack
    public void push(int val) {
        stack.push(val);
        // Push to minStack if it's empty or if the new value is smaller than the current minimum
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    // Pop the element from the stack
    public void pop() {
        if (!stack.isEmpty()) {
            int val = stack.pop();
            // Pop from minStack only if the popped value is the same as the current minimum
            if (val == minStack.peek()) {
                minStack.pop();
            }
        }
    }
    
    // Get the top element of the stack
    public int top() {
        return stack.peek();
    }
    
    // Get the minimum element of the stack
    public int getMin() {
        return minStack.peek();
    }
}

public class Main {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        
        // Simulating the calls and printing results as required
        System.out.println("null"); // Output for the first 'MinStack' initialization
        minStack.push(-2);
        System.out.println("null"); // Output for 'push' method
        
        minStack.push(0);
        System.out.println("null"); // Output for 'push' method
        
        minStack.push(-3);
        System.out.println("null"); // Output for 'push' method
        
        System.out.println(minStack.getMin()); // Returns -3 (Output for 'getMin')
        
        minStack.pop();
        System.out.println("null"); // Output for 'pop' method
        
        System.out.println(minStack.top()); // Returns 0 (Output for 'top')
        
        System.out.println(minStack.getMin()); // Returns -2 (Output for 'getMin')
    }
}
