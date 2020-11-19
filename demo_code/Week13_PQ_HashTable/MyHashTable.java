import java.util.ArrayList;

public class MyHashTable<DataType> {
	private int numBuckets = 1300000;
	private ArrayList<DataType>[] buckets;

	public MyHashTable() {
		buckets = new ArrayList[numBuckets];
		for (int i = 0; i < numBuckets; i++) {
			buckets[i] = new ArrayList<DataType>();
		}
	}

	public void add(DataType item) {
		int bucket = Math.abs(item.hashCode() % numBuckets);
		buckets[bucket].add(item);
	}

	public boolean contains(DataType item) {
		int bucket = Math.abs(item.hashCode() % numBuckets);
		return buckets[bucket].contains(item);
	}

	public static void main(String[] args) {
		MyHashTable<Integer> myTable = new MyHashTable<Integer>();

		for (int i = 0; i < 10; i++) {
			myTable.add(i);
		}

		for (int i = 5; i < 15; i++) {
			System.out.println(myTable.contains(i));
		}
	}

}
