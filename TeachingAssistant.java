import java.util.concurrent.Semaphore;

public class TeachingAssistant 
{
	Thread taThread;
	Thread [] studentThread;
	Semaphore taSem, studentSem;
	
	int waitingStudents = 0;
	int numberOfStudents = 4;
	int numberOfChairs = 3;
	int taNapTime = 3;
	
	public TeachingAssistant(Thread taThread, Thread studentThread, Semaphore taSem, Semaphore studentSem)
	{
		this.taThread = taThread;
		//this.studentThread = studentThread;
		this.taSem = taSem;
		this.studentSem = studentSem;

	}
	
	public void run()
	{
		
	}
	
	
	public static void main(String[] args)
	{
		
	}
	
}
