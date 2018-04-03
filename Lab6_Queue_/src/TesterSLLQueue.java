import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TesterSLLQueue {

	public static void main(String[] args) throws FileNotFoundException {
		
	//TEST FOR SLLQueue
		
		String parentDirectory; 
		int x,y,id=1;
		SLLQueue<Job> inputQueue= new SLLQueue<>();
		
			parentDirectory = "input"; 
			Scanner parameters = new Scanner(new File(parentDirectory, "input.txt")); 
			while(parameters.hasNext()) {
			String s= parameters.nextLine(); 
			StringTokenizer st= new StringTokenizer(s,", ");
			
			while(st.hasMoreTokens()) {
				x=Integer.parseInt(st.nextToken());
				y=Integer.parseInt(st.nextToken());
				System.out.println(x+" "+y);
				Job j= new Job(id,x,y);
				inputQueue.enqueue(j);
				id++;
				
			}
			}
			
			parameters.close();
			SLLQueue<Job> processingQueue= new SLLQueue<>();
			ArrayList<Job> terminatedJobs= new ArrayList<>();
			int time=0;
			
			while(!inputQueue.isEmpty() || !processingQueue.isEmpty()) {
				if(!processingQueue.isEmpty()) {
					processingQueue.first().isServed(1);
					if(processingQueue.first().getRemainingTime()==0) {
						processingQueue.first().setDepartureTime(time);
						terminatedJobs.add(processingQueue.dequeue());
					}
					else {
						processingQueue.enqueue(processingQueue.dequeue());
					}
				}
				
					if(!inputQueue.isEmpty() && inputQueue.first().getArrivalTime()==time) {
						processingQueue.enqueue(inputQueue.dequeue());}
					
				time++;
				
			}
			double ave=0;
			for(int i=0;i<terminatedJobs.size();i++) {
				ave=ave+(terminatedJobs.get(i).getDepartureTime()-terminatedJobs.get(i).getArrivalTime());
			}
			System.out.printf("Average Time: %.2f",(ave/(terminatedJobs.size())));
		
			
	}
}
