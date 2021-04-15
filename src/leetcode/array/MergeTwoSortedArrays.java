package leetcode.array;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
//		int[] n1 = new int[] { 1, 2, 9 ,0,0,0};
//		int[] n2 = new int[] { 0, 5, 6 };
//		merge(n1,3,n2,3);

		int[] n1 = new int[] { 1, 2, 9 };
		int[] n2 = new int[] { 0, 5, 6 };
		merge1(n1, n2);

	}

	public static void merge(int[] n1, int m, int[] n2, int n) {
		int l1 = m - 1;
		int l2 = n - 1;
		int c = n1.length - 1;

		while (l1 >= 0 && l2 >= 0) {
			n1[c--] = n1[l1] > n2[l2] ? n1[l1--] : n2[l2--];
		}

		while (l2 >= 0) {
			n1[c--] = n2[l2--];
		}

		print(n1);
	}
	
	

	public static void merge1(int[] n1, int[] n2) {

		int[] m = new int[n1.length + n2.length];
		int p = n1.length - 1, q = n2.length - 1;
		int c = m.length - 1;

		while (p >= 0 && q >= 0) {
			m[c--] = n1[p] > n2[q] ? n1[p--] : n2[q--];
		}

		while (p >= 0) {
			m[c--] = n1[p--];
		}

		while (q >= 0) {
			m[c--] = n2[q--];
		}

		print(m);

	}

	public static void print(int[] m) {
		for (int w : m) {
			System.out.print(w);
		}
	}
}
