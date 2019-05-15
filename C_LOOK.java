import java.util.ArrayList;
import java.util.Random;

public class C_LOOK {
    private ArrayList<Integer> list;
    private int totalDistance;
    private int head;


    public C_LOOK(int head) {
        list = new ArrayList<>(5000);
        this.head = head;
        totalDistance = 0;
    }


    public void add(int num) {
        list.add(num);
    }


    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    /**
     * The service method will serve a request
     *
     * @param left The direction will be to the left otherwise it'll be to the right
     * @return The served request.
     */

    public void service(boolean left) {


        while (!list.isEmpty()) {


            int min = 0; //The starting value for min.
            boolean found = false;

            for (int i = 0; i < list.size(); i++) {

                if (left) {

                    //Get the closest value that is <= head
                    if (Math.abs(list.get(i) - head) <= Math.abs(list.get(min) - head) && list.get(i) <= head) {
                        min = i;
                        found = true;
                    }
                } else {

                    //Get the closest value that is >= head
                    if (Math.abs(list.get(i) - head) <= Math.abs(list.get(min) - head) && list.get(i) >= head) {
                        min = i;
                        found = true;
                    }
                }
            }

            if (found) {
                totalDistance += Math.abs(list.get(min) - head);
                head = list.get(min);
                list.remove(min);
            } else {

                if (left) {
                    int temp = 0;
                    for(int i = 1; i<list.size(); i++) {
                        if(list.get(temp) < list.get(i))
                            temp = i;
                    }
                    head = list.get(temp);
                }
                else {
                    int temp = 0;
                    for(int i = 1; i<list.size(); i++) {
                        if(list.get(temp) > list.get(i))
                            temp = i;
                    }
                    head = list.get(temp);
                }
            }
        }
    }


    public static void main(String[] args) {

        int head = Integer.valueOf(args[0]); //Get the head from command line

        C_LOOK scan = new C_LOOK(head);
        Random random = new Random();

        for(int i = 0; i<1000; i++)
            scan.add(random.nextInt(5000));

        scan.service(false);
        System.out.println("Total distance: " + scan.getTotalDistance());
    }
}
