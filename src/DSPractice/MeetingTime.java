import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class MeetingTime {
	public static ArrayList<Meeting> mergeRanges(ArrayList<Meeting> meetings){
		ArrayList<Meeting> sortedMeetings = new ArrayList<Meeting>(meetings);
		Collections.sort(sortedMeetings, new Comparator<Meeting>(){
			public int compare(Meeting m1, Meeting m2){
				return m1.startTime - m2.startTime;
			}
		});
		
		ArrayList<Meeting> mergedMeetings = new ArrayList<Meeting>();
		mergedMeetings.add(sortedMeetings.get(0));
		
		for(Meeting currMeeting: sortedMeetings){
			Meeting lastMergedMeeting = mergedMeetings.get(mergedMeetings.size()-1);
			
			if(lastMergedMeeting.endTime >= currMeeting.startTime){
				lastMergedMeeting.endTime = Math.max(lastMergedMeeting.endTime, currMeeting.endTime);
			}else{
				mergedMeetings.add(currMeeting);
			}
		}
		
		return mergedMeetings; 
	} 
	
	public static void main(String[] args){
		ArrayList<Meeting> meetings = new ArrayList<Meeting>();
		meetings.add(new Meeting(0,1));
		meetings.add(new Meeting(3,5));
		meetings.add(new Meeting(5,8));
		meetings.add(new Meeting(10,12));
		meetings.add(new Meeting(9,10));
		
		ArrayList<Meeting> result = mergeRanges(meetings);
		
		
		System.out.println(result);
		for(int i=0;i<meetings.size();i++){
			
		}
	}
	
}


class Meeting {

  int startTime;
  int endTime;

  public Meeting(int startTime, int endTime) {
      // number of 30 min blocks past 9:00 am
      this.startTime = startTime;
      this.endTime   = endTime;
  }

  public String toString() {
      return String.format("(%d, %d)", startTime, endTime);
  }
}
