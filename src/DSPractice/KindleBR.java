public class KindleBR {
	public static void main(String[] args) {
		// "1 3 4 2 2 6 1 7 8 9"
		// 1 , 2
		// 4, 6
		// as we walk, as soon as we get a interval record it
		// once we hit the opposite letter from the last letter, compare the
		// length and update the passage if necessary
		char[] book = new char[] { '1', '3', '4', '2', '2', '6', '1', '7', '8',
				'9' };
		char a = '1', b = '2';
		Passage pass = findSmallestPassage(book, a, b);
		System.out.println(pass.wordPairOne.word + ", " + pass.wordPairTwo.word);
		System.out.println(pass.wordPairOne.index + ", " + pass.wordPairTwo.index);
	}

	public static Passage findSmallestPassage(char[] book, char wordA,
			char wordB) {
		int minLength = Integer.MAX_VALUE;

		Passage passage = new Passage();

		Pair p1 = new Pair();
		p1.word = wordA;
		Pair p2 = new Pair();
		p2.word = wordB;

		for (int currIndex = 0; currIndex < book.length; currIndex++) {
			char currWord = book[currIndex];
			if (!initialPairsAssigned(p1, p2)) {
				if (currWord == p1.word) {
					p1.index = currIndex;
				} else if (currWord == p2.word) {
					p2.index = currIndex;
				}
				
				if(p1.word != null && p2.word != null){
					minLength = Math.min(minLength, p2.index-p1.index);					
				}
			}else{
				if (currWord == p1.word) {
					if(p1.index < p2.index){//p2 came after
						System.out.println("here");
						int currLengthBetweenCurrAndLastOccurringWord = currIndex-p2.index;
						if(currLengthBetweenCurrAndLastOccurringWord < minLength){
							p1.index = currIndex;
							minLength = currIndex-p2.index;
						}
					}
				} else if (currWord == p2.word) {
					if(p2.index < p1.index){
						System.out.println("or here");
						int currLengthBetweenCurrAndLastOccurringWord = currIndex - p1.index;
						if(currLengthBetweenCurrAndLastOccurringWord < minLength){
							p2.index = currIndex;
							minLength = currIndex - p1.index;
						}
					}
				}
			}
		}
		passage.wordPairOne = p1; passage.wordPairTwo = p2;
		return passage;
	}

	private static boolean initialPairsAssigned(Pair p1, Pair p2) {
		return p1.index != -1 && p2.index != -1;
	}

}

class Pair {
	Character word = null;
	int index = -1;

	public Pair() {
	}
}

class Passage {
	Pair wordPairOne;
	Pair wordPairTwo;

	public Passage() {

	}

	public Passage(int s, int e) {
		int startIndex = s;
		int endIndex = e;
	}
}