
public class TempTracker {
	/*
    insert()—records a new temperature
    getMax()—returns the highest temp we've seen so far
    getMin()—returns the lowest temp we've seen so far
    getMean()—returns the mean ↴ of all temps we've seen so far
    getMode()—returns a mode ↴ of all temps we've seen so far
	
	assume temps are 0-110
	*/
	
	int[] tempOccur = new int[111]; //0..110
	int maxOccurance = 0;
	int mode;
	
	int records = 0;
	double totalTemp = 0.0;
	double median;
	
	Integer minTemp;
	Integer maxTemp;
	
	public boolean insert(int temp){
		
		//mode
		tempOccur[temp]++;
		if(tempOccur[temp] > maxOccurance){
			maxOccurance = tempOccur[temp];
			mode = temp;
		}
		
		//median
		records++;
		totalTemp += temp; 
		median = totalTemp/records;
		
		
		//min
		if(minTemp == null || minTemp > temp){
			minTemp = temp;
		}
		
		//max
		if(maxTemp == null || maxTemp < temp){
			maxTemp = temp;
		}
		
		return true;
		
	}
}
