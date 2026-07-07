import java.util.Queue;
import java.util.LinkedList;

class MyStack {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {

        q2.add(x);

        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        Queue<Integer> t = q1;
        q1 = q2;
        q2 = t;
    }

    public int pop() {

        if (q1.isEmpty())
            return -1;

        return q1.remove();
    }

    public int top() {

        if (q1.isEmpty())
            return -1;

        return q1.peek();
    }

    public boolean empty() {

        return q1.isEmpty();
    }
}