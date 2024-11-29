public class Node<T> {
  private T value;
  private Node<T> next;

  public Node(T value) {
    this.value = value;
    this.next = null;
  }

  public Node(T value, Node<T> next) {
    this.value = value;
    this.next = next;
  }

  public T getValue() {
    return value;
  }

  public Node<T> getNext() {
    return next;
  }

  public boolean hasNext() {
    return (next != null);
  }

  public void setValue(T value) {
    this.value = value;
  }

  public void setNext(Node<T> next) {
    this.next = next;
  }
 
  public String toString() {
    return value + " --> " + next;
  }
  public Node delNode(Node<Integer>h, int x) {
	  Node p=new Node<Integer>(-1,h);
	  h=p;
	  while(p.hasNext()) {
		  if(p.getNext().getValue() == x) {
			  Node<Integer> t = p.getNext();
			  p.setNext(p.getNext().getNext());
			  t.setNext(null);
			  return h.getNext();
		  }
		  p=p.getNext();
	  }
	  return h.getNext();
  }
}
