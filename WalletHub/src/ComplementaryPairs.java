import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ComplementaryPairs {

	public static HashSet<ArrayList<Integer>> getComplementaryPairs(int[] arr, int k) {
		HashSet<ArrayList<Integer>> pairs = new HashSet<>();
		HashMap<Integer, ArrayList<Integer>> pairsMap = new HashMap<>();


		for (int i = 0; i < arr.length; i++) {
			ArrayList<Integer> iList = pairsMap.get(k - arr[i]);
			if (iList == null) {
				iList = new ArrayList<>();
			}
			iList.add(i);
			pairsMap.put(k - arr[i], iList);
		}

		for (int i = 0; i < arr.length; i++) {
			if (pairsMap.get(arr[i]) != null) {
				for (Integer j : pairsMap.get(arr[i])) {
					if (i != j) {
						ArrayList<Integer> pairList = new ArrayList<>();
						pairList.add(i);
						pairList.add(j);
						pairs.add(pairList);
					}
				}
			}
		}

		return pairs;
	}
}
