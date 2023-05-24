// Bryson Davis
// CS-2463-TW01S
// 4-30-2023

public class GenericSort<T extends Comparable<? super T>> {
	void genericInsertionSort(T[] inputArray) {
	
		for (int i = 1; i < inputArray.length; i++) {
			int currentIndexOfArray = i;
			
			while (currentIndexOfArray > 0 && inputArray[currentIndexOfArray - 1].compareTo(inputArray[currentIndexOfArray]) > 0) {
				T temporaryVar = inputArray[currentIndexOfArray];
				
				inputArray[currentIndexOfArray] = inputArray[currentIndexOfArray - 1];
				inputArray[currentIndexOfArray - 1] = temporaryVar;
				
				currentIndexOfArray--;
			}
		}
	}
	
	public static void main(String[] args) {
		
		Integer[] arrayOfIntegerss = { 14, 32, 23, 64, 88, 94, 5, 4, 82, 98, 61, 35, 53, 342, 590, 56, 25, 47, 77, 89 };
		GenericSort<Integer> genericIntegerSorter = new GenericSort<>();
		System.out.println("Unsorted List for Integers:");
		System.out.println(java.util.Arrays.toString(arrayOfIntegerss));
		System.out.println("Sorted List for Integers:");
		genericIntegerSorter.genericInsertionSort(arrayOfIntegerss);
		System.out.println(java.util.Arrays.toString(arrayOfIntegerss));
		
		String[] arrayOfStrings = { "Apple", "Pear", "Cherry", "Apricot", "Grapefruit", "Papaya", "Lemon", "Strawberry",
		"Kiwifruit", "Mango", "Peach", "Raspberry", "Blueberry", "Lime", "Grape", "Avocado", "Pomegranate", "Pineapple",
		"Orange", "Banana" };
		GenericSort<String> genericStringSorter = new GenericSort<>();
		System.out.println("Unsorted List for Strings:");
		System.out.println(java.util.Arrays.toString(arrayOfStrings));
		System.out.println("Sorted List for Strings:");
		genericStringSorter.genericInsertionSort(arrayOfStrings);
		System.out.println(java.util.Arrays.toString(arrayOfStrings));
		
		Double[] arrayOfDoubles = { 3.4141, 0.0022, 1.3, 0.2324, 4.2787, 0.4995, 0.0964, 2.2352, 0.9840, 1.3156, 3.3333, 1.566, 0.92, 5.17,
		2.22, 9.96, 0.318, 7.35, 8.37, 6.32 };
		GenericSort<Double> genericDoubleSorter = new GenericSort<>();
		System.out.println("Unsorted List for Doubles:");
		System.out.println(java.util.Arrays.toString(arrayOfDoubles));
		System.out.println("Sorted List for Doubles:");
		genericDoubleSorter.genericInsertionSort(arrayOfDoubles);
		System.out.println(java.util.Arrays.toString(arrayOfDoubles));
		
	}

}