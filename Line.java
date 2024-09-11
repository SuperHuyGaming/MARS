//TO DO: Finish this!
//import java.util.*;
//import java.util.Iterator;

class Line<T> {
//	ArrayList<Integer> testing = new ArrayList<>();
//	int m = testing.size();
	//you MUST use this field for credit on your assignment
	//if you change the name of the type, you will lose a
	//_lot_ of points, don't do it!
	private T[] data;
	private int size = 0;
	
	@SuppressWarnings("unchecked")
	public Line() {

		//default for data should be capacity of 1
		this.data = (T[]) new Object[1];
		//Note for @SuppressWarnings("unchecked")
		//you may add this to any _helper_ methods for _this_
		//method, but you may not add it to other methods
		//in this project
		
		//O(1)
	}
	
	public T get(int index) {

		//should throw appropriate exception if index is out of bounds
		//for this action (see main method tester for this file)
		if (index < 0 || index >= getSize()) {
			throw new ArrayIndexOutOfBoundsException("Index is out of bounds " + index);
		}
		//returns the value at the given index
		return data[index];
		//O(1)




	}
	@SuppressWarnings("unchecked")
	public T remove(int index) {

		//should throw appropriate exception if index is out of bounds
		//for this action (see main method tester for this file)
		if (index < 0 || index >= getSize()) {
			throw new IndexOutOfBoundsException("Index is out of bounds " + index);
		}
		//removed the object at the given index from the line
		//later objects move forward in the line
		//returns the value removed

		T remove_object = data[index];
		for (int i = index; i < size; i++) {
			data[i] = data[i+1];
		}
		size--;
		return remove_object; //replace this default return!
	}
	
	@SuppressWarnings("unchecked")
	public void add(T item, int index) {
		//should throw appropriate exception if index is out of bounds
//		if (size == 0 && data.length == 1 && index == 0) {
//			data[0] = item;
//			size++;
//			return;
//		}
		//for this action (see main method tester for this file)
		if ((index < 0) || (index > getSize())) {
			throw new IndexOutOfBoundsException("Index is out of bounds " + index);
		}
		//Note for @SuppressWarnings("unchecked")
		//you may add this to any _helper_ methods for _this_
		//method, but you may not add it to other methods
		//in this project
		
		//adds item to the given index, shifting values over
		//should double the data array side if more space is
		//needed
		T[] n_data;
		if (size >= data.length) {
			n_data = (T[]) new Object[data.length * 2];
		}
		else {
			n_data = (T[]) new Object[data.length];
		}

		for (int i = 0; i <= index ; i++) {
			if (i == index) {
				n_data[i] = item;
				if (i >= data.length - 1) {
					continue;
				}
				n_data[i+1] = data[i];
				continue;

			}

			n_data[i] = data[i];
		}
		/**
		 * If the capacity of new array = capacity of old array after adding and all numbers from left side are added in
		 * , we don't need to add anything else)
		 */
		if ((n_data.length == data.length) && (index >= getSize() - 1)) {
			data = n_data;
			size++;
		}
		else {
			for (int i = index ; i < data.length ; i++) {
				n_data[i+1] = data[i];
			}
			data = n_data;
			size++;
		}
	}
	
	public int getSize() {
		//O(1)
		
		return size; //replace this default return!
	}
	
	public int getCapacity() {
		//O(1)
		
		return data.length; //replace this default return!
	}

	public static void main(String[] args) {
		//This is a main-method tester.
		//You may alter/change/remove this method.
		
		//It doesn't test everything, but it should give you an idea of
		//the types of scenarios you should be testing when writing this
		//class. The JUnit tests for grading will test a lot more things!
		
		Line<Integer> test = new Line<>();
		if(test.getSize() == 0 && test.getCapacity() == 1) {
			System.out.println("yay 1");
		}
		
		test.add(1, 0);
		if(test.getSize() == 1 && test.getCapacity() == 1 && test.get(0) == 1) {
			System.out.println("yay 2");
		}
		
		test.add(2, 0);
		if(test.getSize() == 2 && test.getCapacity() == 2 && test.get(0) == 2 && test.get(1) == 1) {
			System.out.println("yay 3");
		}
		
		test.add(3, 2);
		if(test.getSize() == 3 && test.getCapacity() == 4 && test.get(0) == 2 && test.get(1) == 1 && test.get(2) == 3) {
			System.out.println("yay 4");
		}
		
		test.remove(2);
		if(test.getSize() == 2 && test.getCapacity() == 4 && test.get(0) == 2 && test.get(1) == 1) {
			System.out.println("yay 5");
		}
		
		test.remove(0);
		if(test.getSize() == 1 && test.getCapacity() == 4 && test.get(0) == 1) {
			System.out.println("yay 6");
		}
		
		try {
			test.add(4, 2);
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("yay 7");
		}
		
		try {
			test.remove(-1);
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("yay 8");
		}
		
		test.remove(0);
		try {
			test.get(0);
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("yay 9");
		}
	}
}