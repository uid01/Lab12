// ********************************************************
// Hash table implementation.
// Assumption: A table contains unique keys with possibly non-unique associated values
// *********************************************************

public class HashTable<K, V> implements HashTableInterface<K,V> {
    private ChainNode[] primary; // hash table's primary array
    private int size= 0; // number of entries (number of (key,value) pairs)
    
    public HashTable() {
    primary = new ChainNode[3];
    } // end default constructor
    
    // table operations
    public boolean tableIsEmpty() {
    return size==0;
    } // end tableIsEmpty
    
    public int tableSize() {
    return size;
    } // end tableSize = number of (key,value) pairs in the HashTable
    
    //implement the following 5 methods
    
    // if key is not already in HashTable pair (key,value) is inserted and returns true
    // if key is already in the HashTable it does not re-insert or overwrite and returns false
    public boolean tableInsert(K key, V value)
    {
    if(tableRetrieve(key)==null)
    {
        int index = hashCode(key) % primary.length;
        ChainNode newNode = new ChainNode(key, value, primary[index]);
        primary[index] = newNode;
        size ++;
        return true;
    }
    else{
        return false;
    }
    }
    
    // if key is in HashTable deletes the key and its association from the HashTable and returns true
    // if key is not in the HashTable returns false
public V tableDelete(K searchKey) {
    V result = null;
    int index = hashCode(searchKey) % primary.length;
    ChainNode curr = primary[index];
    if (curr == null) {
            return null; 
    }
    if (curr.getKey().equals(searchKey)) {
        result = (V) curr.getValue();
        primary[index] = curr.getNext();
    } else {
        while (curr.getNext() != null && !curr.getNext().getKey().equals(searchKey)) {
            curr = curr.getNext();
        }
        if (curr.getNext() != null) {
            result = (V) curr.getNext().getValue();
            curr.setNext(curr.getNext().getNext());
        }
    }
    if (result != null) {
        size--;
    }
    return result;
}

    
    //returns the value associated with searchKey in the HashTable or null if the searchKey is not in the HashTable
    public V tableRetrieve(K searchKey){
         V result = null;
         for(int i = 0; i < primary.length; i++)
            {
            ChainNode curr = primary[i];
            while(curr!=null)
                {
                if (((String) curr.getKey()).compareTo(((String)searchKey)) == 0)
                    {
                    return (V) curr.getValue();
                    }
                curr = curr.getNext();
                }
            }
         return result;
    }

// returns the integer hashCode computed using Horner's rule - assumes K is String
public int hashCode(K key) 
{//
    ((String)key).toUpperCase();
    int sum = 0;
    for (int i=0; i < ((String)key).length(); i++)
    {
        char c= ((String)key).charAt(i);
        int rank = c - 'A' + 1;
        int nthpowerof32 = 1 << ((((String)key).length() - i -1) * 5);
        sum += nthpowerof32 * rank;
}
return sum;
}

//returns the String representation of the HashTable [all (key,value) pairs in the HashTable]
// returns the String representation of the HashTable [all (key,value) pairs in the HashTable]
public String toString() {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < primary.length; i++) {
        ChainNode curr = primary[i];
        while(curr != null) {
            sb.append(curr.toString()).append(" ");
            curr = curr.getNext();
        }
    }
    return sb.toString();
}



}  // end HashTable
