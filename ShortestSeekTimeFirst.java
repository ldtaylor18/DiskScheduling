import java.util.ArrayList;
import java.util.Random;

public class ShortestSeekTimeFirst {
    private ArrayList<Integer> list;
    private int totalDistance;
    private int head;

    public ShortestSeekTimeFirst(int head){
        list = new ArrayList<>();
        this.head = head;
        totalDistance = 0;
    }


    public void add(int num) {
     list.add(num);
    }

    public int service(){

        int min = 0;
        for(int i = 1; i<list.size(); i++){
            if(Math.abs(list.get(i)-head) < Math.abs(list.get(min)-head)) {
                min = i;
            }
        }

        totalDistance += Math.abs(list.get(min)-head);
        head = list.get(min);
        list.remove(min);

        return head;
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int getTotalDistance(){
        return totalDistance;
    }


    public static void main(String[] args) {

        int head = Integer.valueOf(args[0]); //Get the head from command line

        ShortestSeekTimeFirst SSTF = new ShortestSeekTimeFirst(head);

        Random random = new Random();
        for(int i = 0; i<1000; i++) {
            SSTF.add(random.nextInt(5000));
        }

        //Service all request
        while (!SSTF.isEmpty()) {
            SSTF.service();
        }

        //Get total distance
        System.out.println(SSTF.getTotalDistance());
    }
}
