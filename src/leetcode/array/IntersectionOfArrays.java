package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
// [1, 2, 1, 3] [1, 4, 1, 2] --> [1,1,2]
public class IntersectionOfArrays {
	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 2, 1, 2 };
		int[] nums2 = new int[] { 1, 5, 1, 3, 2, 1, 1 };
		intersect1(nums1, nums2);

	}

	public static int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> mp = new HashMap<>();
		List<Integer> li = new ArrayList<>();
		for (int i : nums1) {
			mp.put(i, mp.getOrDefault(i, 0) + 1);
		}
		for (int j : nums2) {
			mp.computeIfPresent(j, (key, value) -> {
				if (value != 0 && value > 0) {
					li.add(key);
				}
				return value - 1;
			});

		}
		System.out.println(li);
		int[] arr = new int[li.size()];
		int k = 0;
		for (int i : li) {
			arr[k++] = i;
		}
		return arr;
	}

	public static int[] intersect1(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int i = 0;
		int j = 0;

		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j])
				i++;
			else if (nums1[i] > nums2[j])
				j++;
			else {
				list.add(nums1[i]);
				i++;
				j++;
			}
		}
		System.out.println(list);
		int[] res = new int[list.size()];
		int k = 0;
		for (Integer num : list)
			res[k++] = num;
		return res;
	}
}
