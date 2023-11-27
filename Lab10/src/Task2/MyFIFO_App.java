package Task2;

import java.util.LinkedList;
import java.util.Queue;

public class MyFIFO_App {

	// Method stutter that accepts a queue of integers as a parameter
	// and replaces every element of the queue with two copies of that element
	public static <E> void stutter(Queue<E> input) {
		int size = input.size();
		for (int i = 0; i < size; i++) {
			E element = input.poll();
			input.offer(element);
			input.offer(element);
		}
	}

	// Method mirror that accepts a queue of strings as a parameter
	// and appends the queue's contents to itself in reverse order
	public static <E> void mirror(Queue<E> input) {
		int size = input.size();
		Queue<E> tempQueue = new LinkedList<>();

		// Copy elements to a temporary queue in reverse order
		for (int i = 0; i < size; i++) {
			E element = input.poll();
			tempQueue.offer(element);
			input.offer(element);
		}

		// Append the reversed elements to the original queue
		while (!tempQueue.isEmpty()) {
			input.offer(tempQueue.poll());
		}
	}

	public static void main(String[] args) {
		// Testing stutter method
		Queue<Integer> intQueue = new LinkedList<>();
		intQueue.offer(1);
		intQueue.offer(2);
		intQueue.offer(3);

		System.out.println("Original queue: " + intQueue);
		stutter(intQueue);
		System.out.println("Stuttered queue: " + intQueue);

		// Testing mirror method
		Queue<String> stringQueue = new LinkedList<>();
		stringQueue.offer("a");
		stringQueue.offer("b");
		stringQueue.offer("c");

		System.out.println("Original queue: " + stringQueue);
		mirror(stringQueue);
		System.out.println("Mirrored queue: " + stringQueue);
	}
}
