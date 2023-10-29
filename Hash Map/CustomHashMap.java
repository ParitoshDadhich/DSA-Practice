package hashmap;

import java.util.ArrayList;
import java.util.List;


// WHENEVER YOU WANT TO USE CUSTOM OBJECT IN MY HASMAP THEN I NEED
// TO IMPLEMENT HASHCODE METHOD AND EQUALS METHOD


/*
 *N -> NUMBER OF ELEMENTS INSIDE MAP
 *B -> SIZE OF MAP
 * 
 * TIME:
 * 	INSERT:  O(N) WORST CASE, WHEN ALL THE ELEMENTS ARE PRESENT AT SAME LOCATION
 * 	GET: 	 O(N) WORST CASE, SAME AS ABOVE
 * 
 * 	In order to improve the time complexity in insert/get then we are going to introduce load factor n/b
 * 	n/b -> at every bucketIndex of bucket only n/b size of LinkedList is possible. we will implement this functionality using rehashing.
 *  in java n/b = 0.75 by default
 *  
 *  Rehashing -> double the size of bucket 
 */

public class OurMap<K, V> {
	private List<MapNode<K, V>> bucket;
	private int capacity; // length of the bucket;
	private int size = 0; // number of elements in the map
	private final int INITIAL_CAPACITY = 5;
	
	public OurMap() {
		bucket = new ArrayList<>();
		capacity = INITIAL_CAPACITY;
		// We are adding null to bucket list because if I do not add anything to bucket list
		// then the size would be 0 but capacity is != 0 so if anyone want to access from 0 to capacity-1
		// then it will give error but it should not give error technically because capacity != 0.
		// that is why to not throw any error we are adding null to bucket list till its initially capacity.
		for(int i=0; i<capacity; i++) {
			bucket.add(null);
		}
	}
	
	public void put(K key, V value) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = bucket.get(bucketIndex);
		while(head != null) {
			if(head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		// if key is not present then creating a new entry and inserting value;
		size++;
		MapNode<K, V> newEntry = new MapNode<K, V>(key, value);
		head = bucket.get(bucketIndex);
		newEntry.next = head;	// newly added element will be present at starting due to this implementation
		bucket.set(bucketIndex, newEntry);
		
		
		// applying rehashing logic
		double loadFactor = (1.0*size)/capacity;
		System.out.println("Inserting key: " + key);
		System.out.println("Load Factor: " + loadFactor);
		if(loadFactor > 0.75) {
			rehash();
		}
		
	}
	
	private void rehash() {
		System.out.println("Rehashing bucket");
		List<MapNode<K, V>> temp = bucket;
		bucket = new ArrayList<>();
		capacity *= 2;
		for(int i=0; i<capacity; i++) {
			bucket.add(null);
		}
		size = 0;
		
		for(int i=0; i<temp.size(); i++) {
			MapNode<K, V> head = temp.get(i);
			while(head != null) {
				put(head.key, head.value);
				head = head.next;
			}
		}		
	}

	public V get(K key) {
		/*
		 * getBucketIndex is the hashFunction which will give us an index, where out key might present
		 * It comprises two functionality -> 1. HashCode 2. Compression
		 */
		int bucketIndex = getBucketIndex(key);
		// getting the head of the linkeList at bucketIndex
		MapNode<K, V> head = bucket.get(bucketIndex);
		while(head != null) {
			if(head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		
		// key does not exist;
		return null;
	}
	
	private int getBucketIndex(K key) {
		int hashcode = key.hashCode();
		return hashcode%capacity;
	}

	public void remove(K key) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = bucket.get(bucketIndex);
		MapNode<K, V> prev = null;
		while(head != null) {
			if(head.key.equals(key)) {
				
				if(prev == null) {
					bucket.set(bucketIndex, head.next);
				} else {
					prev.next = head.next;
				}
				
				head.key = null;
				head.value = null;
				head.next = null;
				size--;
				break; 
			}
			prev = head;
			head = head.next;
		}
	}
	
	
	private class MapNode<K, V> {
		K key;
		V value;
		MapNode<K, V> next;
		
		public MapNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

  public static void main(String[] args) {
		OurMap<Integer, String> nameToken = new OurMap<>();
		nameToken.put(1, "a");
		nameToken.put(2, "abcd");
		nameToken.put(5, "bhello");
		nameToken.put(6, "bsdasda");
		nameToken.put(6, "bcd");
		nameToken.put(1, "paritosh");
		
		System.out.println(nameToken.get(6));
		System.out.println(nameToken.get(2));
		System.out.println(nameToken.get(5));
		nameToken.remove(5);
		System.out.println(nameToken.get(5));
	}
}
