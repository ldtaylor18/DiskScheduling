
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class FCFS {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        Random rand = new Random();

        int head = Integer.valueOf(args[0]);
        queue.add(head);

        //Generate a random series of 1000 cylinder requests
        for(int i = 0; i<1000; i++){
            queue.add(rand.nextInt(5000));
        }

        //Get head
        int headMovement = 0;
        int temp = queue.peek();
        queue.remove();

        //Process request and count head movements.
        while(!queue.isEmpty()) {

            int val1 = queue.peek();
            queue.remove();

            headMovement += Math.abs(temp-val1);
            temp = val1;
        }
        System.out.println("Total head movement: " + headMovement);
    }
}
