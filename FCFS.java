import java.util.*;

public class FCFS 
{
//	static int Queue[],n, a, b, head, max, seekTime;
//	static int diff = 0;
//	static float avg;
	
	public static void main(String args[])
	{ 
		
		//int Queue[];
		
		int n, a, b, head, max, seekTime;
		int diff = 0;
		float avg;
		
		Queue<Integer> q = new LinkedList<>();
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter max disk");
		max = scanner.nextInt();
		
		System.out.println("Enter request size");
		n = scanner.nextInt();
		
		System.out.println("Enter request entries");
		for(a = 1; a <= n; a++)
		{
			//Queue[a] = scanner.nextInt();

			q.add(scanner.nextInt());
		}
		
		System.out.println("Enter head position");
		head = scanner.nextInt();
		q[0] = head;
		//Queue[0] = head;
		
		// Diff from cylinders
		for(b = 0; b < n-1; b++)
		{
			diff = Math.abs(q[b+1] - q[b]);

			//diff = Math.abs(Queue[b+1] - Queue[b]);
			seekTime += diff;
		}
		
		avg = (float)seekTime/n;
		
		
		
	}
	
}
