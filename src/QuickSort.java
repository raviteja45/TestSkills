import java.util.Arrays;


public class QuickSort {

	public static void main(String args[]) {

		//int[] unsorted = { 34, 32, 43, 12, 11, 32, 22, 21, 32 };
		 int[] unsorted = { 5, 4, 3, 9, 1 };
		System.out.println("Unsorted array : " + Arrays.toString(unsorted));

		quickSort(unsorted, 0, unsorted.length - 1);
		System.out.println("Sorted array : " + Arrays.toString(unsorted));
	}

	static int partition(int arr[], int left, int right) {
		int i = left, j = right;
		int tmp;
		int pivot = arr[(left + right) / 2];
		while (i <= j) {
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		return i;
	}

	public static void quickSort(int arr[], int left, int right) {
		int index = partition(arr, left, right);
		System.out.println("Index "+index+" left "+left+" right "+right);
		if (left < index - 1)
			quickSort(arr, left, index - 1);
		if (index < right)
			quickSort(arr, index, right);
	}
}
