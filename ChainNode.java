class ChainNode<K, V> {
  private K key;
  private V value;
  private ChainNode<K, V> next;

  public ChainNode(K newKey, V newValue,
                   ChainNode<K, V> nextNode) {
    key = newKey;
    value = newValue;
    next = nextNode;
  }  // end constructor

  public V getValue() {
    return value;
  }  // end getValue
  
  public void setValue(V value) {
    this.value=value;
  }  // end setValue


  public K getKey() {
    return key;
  }  // end getKey

 public ChainNode<K, V> getNext()
  {
    return next;
  }  // end getNext

 public void setNext(ChainNode<K, V> next)
  {
    this.next=next;
  }  // end setNext

 public String toString()  //use (key,value) format
{
    String str =  "{" + getKey() + ", " + getValue() + "}";
    return str;
//add implementation here
}

} // end ChainNode