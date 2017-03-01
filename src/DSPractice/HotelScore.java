import java.util.*;

public class HotelScore {
	//Q:Given a score set for a hotel, return the hotels that scored a minimum value specified 
	
	
	public static void main(String[] args){
		Score[] score = {
				new Score(1001, 501, 7),
                new Score(1001, 502, 7),
                new Score(1001, 503, 7),
                new Score(2001, 504, 10),
                new Score(2001, 505, 25),
                new Score(2001, 506, 15),
                new Score(3001, 507, 5)
		};
		
		
		System.out.println(getHotels(score, 5));
		
		System.out.println(getHotels(score, 7));
		
		System.out.println(getHotels(score, 12));
	}
	
	public static ArrayList<Integer> getHotels(Score[] score, int min){
		Map<Integer, ArrayList<Integer>> avgMap = new HashMap<>();//hotel id -> list of scores for that hotel
		for(Score s: score){
			if(!avgMap.containsKey(s.hotel_id)){
				avgMap.put(s.hotel_id, new ArrayList<Integer>());
			}
			ArrayList<Integer> tempList = avgMap.get(s.hotel_id);
			tempList.add(s.score);
			avgMap.put(s.hotel_id, tempList);
		}
		

        ArrayList<Integer> finalList = new ArrayList<Integer>();
		
        for(int hotelID: avgMap.keySet()){
        	ArrayList<Integer> scoreList = avgMap.get(hotelID);
        	int total = 0;
        	for(int currScore: scoreList){
        		total += currScore;
        	}
        	
        	float avgVal = (float) total/scoreList.size();
        	
        	if(avgVal >= min){
        		finalList.add(hotelID);
        	}
        }
        
		return finalList;
	}
	

	public static class Score{
		private int hotel_id;
        private int user_id;
        private int score;

        public Score(int hotel_id, int user_id, int score) {
            this.hotel_id = hotel_id;
            this.user_id = user_id;
            this.score = score;
        }
	}
	
}
