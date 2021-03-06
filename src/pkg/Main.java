package pkg;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

	static int min = 1;
	static int max = 100;
	
	public static void main(String[] args) {
		
		int listNum = 50000;
		List<Integer> numbers1 = new ArrayList<Integer>();
		for(var i = 0; i < listNum; i++) {
			numbers1.add(ThreadLocalRandom.current().nextInt(min, max + 1));
		}
		int[] numbers2 = new int[listNum];
		for(var i = 0; i < listNum; i++) {
		numbers2[i] = (ThreadLocalRandom.current().nextInt(min, max + 1));
	}
		
		Sort sort = new Sort();
		
		double startTime = System.nanoTime();

		sort.mergeSort(numbers2, 0, numbers2.length -1);
		double endTime = System.nanoTime();

		double duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
		System.out.println("mergesort took " + duration/1000000000 + " seconds to sort " + numbers2.length + " random integers.");

		
		sort.bubbleSort(numbers1);


	}
	


}
