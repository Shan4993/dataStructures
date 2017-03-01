
public class RectangleOverlap {
	
	//Q: Find the overlapping rectangle that is created by two potential rectangles
	//Source: Interviewcake
	
	public RangeOverlap findRangeOverlap(int point1, int length1, int point2, int length2){
		int highestStartPoint = Math.max(point1,point2);
		int lowestEndPoint = Math.min(point1+length1,point2+length2);
		
		if(highestStartPoint < lowestEndPoint){//overlap happens
			int overlapLength = lowestEndPoint - highestStartPoint;
			return new RangeOverlap(highestStartPoint, overlapLength);
		}else{
			return new RangeOverlap(null,null);
		}
	}
	
	public Rectangle findRectangleOverlap(Rectangle r1, Rectangle r2){
		RangeOverlap xOverlap = findRangeOverlap(r1.leftX, r1.width, r2.leftX, r2.width);
		RangeOverlap yOverlap = findRangeOverlap(r1.bottomY, r1.height, r2.bottomY, r2.height);
		
		//check null
		if(xOverlap == null || yOverlap == null){
			return new Rectangle();
		}
		
		return new Rectangle(xOverlap.startPoint, yOverlap.startPoint, xOverlap.length, yOverlap.length);
		
	}

}

class RangeOverlap{
	Integer startPoint;
	Integer length;
	
	public RangeOverlap(Integer sp, Integer l){
		this.startPoint = sp;
		this.length = l;
	}
}

class Rectangle {

    // coordinates of bottom left corner
    Integer leftX;
    Integer bottomY;

    // dimensions
    Integer width;
    Integer height;

    public Rectangle(Integer leftX, Integer bottomY, Integer width, Integer height) {
        this.leftX = leftX;
        this.bottomY = bottomY;
        this.width  = width;
        this.height = height;
    }

    public Rectangle() {}

    public String toString() {
        return String.format("(%d, %d, %d, %d)", leftX, bottomY, width, height);
    }
}


