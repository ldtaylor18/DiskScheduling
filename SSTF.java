import java.util.Scanner;

public class SSTF extends node
{
		
	    // Calculate diff of each track with the head position 
	    public static void calcDiff(int queue[], int head, node diff[])                                         
	    { 
	        for (int i = 0; i < diff.length; i++) 
	            diff[i].distance = Math.abs(queue[i] - head); 
	    } 

	    // Find minimum distance from head 
	    public static int findMin(node diff[]) 
	    { 
	        int index = -1, minimum = Integer.MAX_VALUE; 
	        
	        for (int i = 0; i < diff.length; i++) 
	        { 
	            if (!diff[i].accessed && minimum > diff[i].distance) 
	            { 
	                minimum = diff[i].distance; 
	                index = i; 
	            } 
	        } 
	        return index; 
	    } 
	  
	    public static void shortestSeekTimeFirst(int request[], int head) 
	    { 
	    	  
	        int seek_count = 0;  //Count number of seek operation
	        int[] seek_sequence = new int[request.length + 1]; //Store seq  
	        node diff[] = new node[request.length]; 
	        
	        if (request.length == 0)
	        {
	            return;
	        }
	                   
	        // Initialize array 
	        for (int i = 0; i < diff.length; i++)
	        {
	            diff[i] = new node(); 
	        }
	          
	        for (int i = 0; i < request.length; i++) 
	        { 	              
	            seek_sequence[i] = head; 
	            calcDiff(request, head, diff); 	
	            int index = findMin(diff); 	              
	            diff[index].accessed = true; 
	             
	            seek_count += diff[index].distance; //Increase count
	              
	            head = request[index]; //Move head
	        } 
	          
	        seek_sequence[seek_sequence.length - 1] = head;  

	        System.out.println("Total number of seek operations = " + seek_count);                                               
	        System.out.println("Seek Sequence is"); 
	          
	        // print the sequence 
	        for (int i = 0; i < seek_sequence.length; i++)  
	            System.out.println(seek_sequence[i]); 
}


	    public static void main(String[] args) 
	    { 
	    	// generate 1000 random #s to fill array
	    	//int head = Integer.parseInt(args[0]);
	    	
	    
	    	// request array 
	    	//int arr[] = { 176, 79, 34, 60, 92, 11, 41, 114 };  
	    	//shortestSeekTimeFirst(arr, 50); 
	    }
}