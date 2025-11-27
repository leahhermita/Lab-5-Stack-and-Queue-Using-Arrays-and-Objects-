/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5_stackqueue;
import java.util.Scanner;

/**
 *
 * @author caryd
 */


// ======================
// TASK 1: Stack using Array
// ======================
class StackArray {
    int maxSize;
    int top;
    int[] stack;

    StackArray(int size) {
        maxSize = size;
        stack = new int[maxSize];
        top = -1;
    }

    void push(int value) {
        if (top == maxSize - 1)
            System.out.println("⚠ Stack Overflow");
        else
            stack[++top] = value;
    }

    void pop() {
        if (top == -1)
            System.out.println("⚠ Stack Underflow");
        else
            top--;
    }

    int peek() {
        if (top == -1) return -1;
        return stack[top];
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == maxSize - 1;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack contents (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}

// ======================
// TASK 2: Queue using Array
// ======================
class QueueArray {
    int maxSize;
    int front, rear;
    int[] queue;

    QueueArray(int size) {
        maxSize = size;
        queue = new int[maxSize];
        front = 0;
        rear = -1;
    }

    void enqueue(int value) {
        if (rear == maxSize - 1)
            System.out.println("⚠ Queue Full");
        else
            queue[++rear] = value;
    }

    void dequeue() {
        if (front > rear)
            System.out.println("⚠ Queue Empty");
        else
            front++;
    }

    int peek() {
        if (front > rear) return -1;
        return queue[front];
    }

    boolean isEmpty() {
        return front > rear;
    }

    boolean isFull() {
        return rear == maxSize - 1;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue contents (front to rear): ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

// ======================
// TASK 3: Stack and Queue using Objects
// ======================
class Stack {
    private int maxSize;
    private int top;
    private Object[] elements;

    Stack(int size) {
        maxSize = size;
        elements = new Object[maxSize];
        top = -1;
    }

    public void push(Object value) {
        if (isFull())
            System.out.println("⚠ Stack Overflow");
        else
            elements[++top] = value;
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("⚠ Stack Underflow");
            return null;
        }
        return elements[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public Object peek() {
        if (isEmpty()) return null;
        return elements[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack contents (top to bottom): ");
        for (int i = top; i >= 0; i--)
            System.out.print(elements[i] + " ");
        System.out.println();
    }
}

class Queue {
    private int maxSize;
    private int front, rear;
    private Object[] elements;

    Queue(int size) {
        maxSize = size;
        elements = new Object[maxSize];
        front = 0;
        rear = -1;
    }

    public void enqueue(Object value) {
        if (isFull())
            System.out.println("⚠ Queue Full");
        else
            elements[++rear] = value;
    }

    public Object dequeue() {
        if (isEmpty()) {
            System.out.println("⚠ Queue Empty");
            return null;
        }
        return elements[front++];
    }

    public boolean isEmpty() {
        return front > rear;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue contents (front to rear): ");
        for (int i = front; i <= rear; i++)
            System.out.print(elements[i] + " ");
        System.out.println();
    }
}

// ======================
// MAIN PROGRAM
// ======================
public class Lab5Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ====== Stack using Array ======
        System.out.println("=== STACK USING ARRAY ===");
        StackArray sArr = new StackArray(5);
        sArr.push(10);
        sArr.push(20);
        sArr.push(30);
        sArr.display();
        sArr.pop();
        sArr.display();
        System.out.println("Top element: " + sArr.peek());

        // ====== Queue using Array ======
        System.out.println("\n=== QUEUE USING ARRAY ===");
        QueueArray qArr = new QueueArray(5);
        qArr.enqueue(1);
        qArr.enqueue(2);
        qArr.enqueue(3);
        qArr.display();
        qArr.dequeue();
        qArr.display();
        System.out.println("Front element: " + qArr.peek());

        // ====== Stack using Object (OOP) ======
        System.out.println("\n=== STACK USING OBJECT ===");
        Stack sObj = new Stack(5);
        sObj.push(100);
        sObj.push(200);
        sObj.display();
        sObj.pop();
        sObj.display();

        // ====== Queue using Object (OOP) ======
        System.out.println("\n=== QUEUE USING OBJECT ===");
        Queue qObj = new Queue(5);
        qObj.enqueue(10);
        qObj.enqueue(20);
        qObj.enqueue(30);
        qObj.display();
        qObj.dequeue();
        qObj.display();

        // ==============================================
        // PRACTICE PROBLEMS
        // ==============================================

        // ---------- PROBLEM 1: Undo/Redo Simulation ----------
        System.out.println("\n=== PROBLEM 1: Undo/Redo Simulation (Stack) ===");
        Stack undoStack = new Stack(10);
        Stack redoStack = new Stack(10);

        undoStack.push("Typed: Hello");
        undoStack.push("Added space");
        undoStack.push("Typed: World!");
        undoStack.display();

        System.out.println("Undoing last action...");
        redoStack.push(undoStack.pop());
        undoStack.display();
        redoStack.display();

        System.out.println("Redoing last action...");
        undoStack.push(redoStack.pop());
        undoStack.display();

        // ---------- PROBLEM 2: Customer Queue Management ----------
        System.out.println("\n=== PROBLEM 2: Customer Queue Management ===");
        Queue customerQueue = new Queue(5);
        customerQueue.enqueue("Customer A");
        customerQueue.enqueue("Customer B");
        customerQueue.enqueue("Customer C");
        customerQueue.display();

        System.out.println("Serving a customer...");
        customerQueue.dequeue();
        customerQueue.display();

        System.out.println("New customer arrived...");
        customerQueue.enqueue("Customer D");
        customerQueue.display();

        // ---------- PROBLEM 3: Palindrome Checker ----------
        System.out.println("\n=== PROBLEM 3: Palindrome Checker (Stack & Queue) ===");
        System.out.print("Enter a word: ");
        String word = sc.nextLine().toLowerCase();

        Stack charStack = new Stack(word.length());
        Queue charQueue = new Queue(word.length());

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            charStack.push(c);
            charQueue.enqueue(c);
        }

        boolean isPalindrome = true;
        for (int i = 0; i < word.length(); i++) {
            Object fromStack = charStack.pop();
            Object fromQueue = charQueue.dequeue();
            if (!fromStack.equals(fromQueue)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome)
            System.out.println("✅ \"" + word + "\" is a palindrome!");
        else
            System.out.println("❌ \"" + word + "\" is not a palindrome!");
    }
}
