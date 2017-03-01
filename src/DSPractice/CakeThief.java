public class CakeThief {

	public static int maxDuffleBafValue(CakeType[] cakes, int weightCapacity) {
		int[] maxValuesAtCapacity = new int[weightCapacity + 1];

		for (int currCapacity = 0; currCapacity <= weightCapacity; currCapacity++) {
			int currMaxValue = 0;

			for (CakeType cake : cakes) {
				if (cake.weight <= currCapacity) {
					int remainingCapacityAfterTakingCurrentCake = currCapacity - cake.weight;
					int maxValueUsingCake = cake.value
							+ maxValuesAtCapacity[remainingCapacityAfterTakingCurrentCake];

					currMaxValue = Math.max(currMaxValue, maxValueUsingCake);
				}
			}

			maxValuesAtCapacity[currCapacity] = currMaxValue;
		}

		return maxValuesAtCapacity[weightCapacity];
	}

}

class CakeType {

	int weight;
	int value;

	public CakeType(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}

}
