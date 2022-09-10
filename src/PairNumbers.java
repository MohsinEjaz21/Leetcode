import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PairNumbers {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 4, 5 };
		pair(nums);

	}

	static List<HashMap<String, Integer>> pair(int[] nums) {
		HashMap<String, Integer> map = new HashMap<>();
		List<HashMap<String, Integer>> rs = new ArrayList<>();

		int i = 0, j = 0;
		int len = nums.length;
		while (i < len) {
			j=i+1;
			while (j < len) {
				System.out.println("x :" + i);
				System.out.println("y :" + j);
				map.put("x", i);
				map.put("y", j);
				rs.add(map);
				j++;
			}
			i++;
		}
		return rs;
	}

}
