/*
 * QueueCharArray.java
 * fall 2025
 * prof. lehman
 * 
 * Queue approach has first and last point
 * to first and last elements in array.
 * The variable size is used to denote
 * an empty vs. full queue
 * 
 * Implemented by: Hannah Shane
 */

public class QueueCharArray {

	// data
	char data[];
	int front;
	int back;
	int size;
	int MAX;

	// default constructor
	public QueueCharArray() {
		this(5);  // default max size is 5
	}

	// alternate constructor
	public QueueCharArray(int max) {
		this.MAX = max;
		this.data = new char[MAX];
		this.front = 0;
		this.back = -1;
		this.size = 0;
	}

	// delete all items in queue
	public void clear() {
		front = 0;
		back = -1;
		size = 0;
	}

	// add to back of queue
	public void add(char v) {
		if (full()) {
			return; // Fail silently as testQueue.java expects no error output
		}
		back = (back + 1) % MAX;
		data[back] = v;
		size++;
	}

	// see if queue is empty
	public boolean empty() {
		return size == 0;
	}

	// see if queue is full
	public boolean full() {
		return size == MAX;
	}

	// return element from front of queue
	public char front() {
		if (empty()) {
			return '?';  // return '?' if queue is empty
		}
		return data[front];
	}

	// remove element from front of queue
	public boolean remove() {
		if (empty()) {
			return false;
		}
		front = (front + 1) % MAX;
		size--;
		return true;
	}

	// return current number of items in queue
	public int size() {
		return size;
	}

	/**
	 * use with println to display queue
	 * 
	 * @return set as a String
	 */
	public String toString() {
		if (empty()) return "[empty]";
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < size; i++) {
			sb.append(data[(front + i) % MAX]);
			if (i < size - 1) sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}
} // class
