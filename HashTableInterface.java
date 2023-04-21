public interface HashTableInterface<K,V> {

public boolean tableIsEmpty(); 
public int tableSize();

// if key is not already in HashTable pair (key,value) is inserted and returns true
// if key is already in the HashTable it does not re-insert or overwrite and returns false
public boolean tableInsert(K key, V value); 

// if searchKey is not in the HashTable returns null
// otherwise deletes the searchKey and its association from the HashTable and 
// returns the previous value associated with searchKey
public V tableDelete(K searchKey); 

//returns the value associated with searchKey in the HashTable //or null if the serchKey is not in the HashTable 
public V tableRetrieve(K searchKey);

// returns the integer hashCode computed using Horner's rule - assumes K is String 
public int hashCode(K key); 

//returns the String representation of the HashTable [all (key,value) pairs in the HashTable]
public String toString(); 

}  // end HashTableInterface