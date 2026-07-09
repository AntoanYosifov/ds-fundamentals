import implementations.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        queue.offer(1);
        queue.poll();
        queue.offer(1);

    }
}
