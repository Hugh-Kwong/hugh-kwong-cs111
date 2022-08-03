import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int top;

    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {

    }
    
    /** Removes the element on top of the stack and returns that element. */
    public void pop() {
        while(!q1.isEmpty()){ 
            int temp = q1.remove();//cannot use dequeue cause of linkedlist cause of the declaration above
            if(!q1.isEmpty()) q2.add(temp);
        } 

        while(!q2.isEmpty())
        {
            q1.add(q2.remove());
        }
        


        
    }
    
    /** Get the top element. */
    public int top() {
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
        
    }

    public static void main(String[] args) { 
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.pop();
        System.out.println(obj.top());
        obj.pop();
        obj.pop();
        System.out.println(obj.empty());
    } 

}