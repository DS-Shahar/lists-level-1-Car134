package com.shaharyi.node;

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
  
  public static <T> Node<T> arrayToList(T[] array) {
	    Node<T> head = null;
	    for (int i = array.length - 1; i >= 0; i--) {
	        head = new Node<>(array[i], head); // יצירת node חדש ומחבר אותו לרשימה
	    }
	    return head;
}
  public static <T> void printList(Node<T> head) {
	    if (head == null) {
	        return;
	    }
	    System.out.println(head.getValue());
	    printList(head.getNext());
	}
  public static Node<Integer> createListFromInput(Node <T>) {
	  
	    Node<Integer> head = null;
	    int num;
	    
	    while (true) {
	        num = scanner.nextInt();
	        if (num == -1) {
	            break;
	        }
	        head = new Node<>(num, head);
	    }
	    
	    return head;
	}
  public static <T extends Number> void printEvenValues(Node<T> head) {
	    if (head == null) {
	        return;
	    }
	    if (head.getValue().intValue() % 2 == 0) {
	        System.out.println(head.getValue());
	    }
	    printEvenValues(head.getNext());
	}
  public static <T> boolean contains(Node<T> head, T value) {
	    if (head == null) {
	        return false;
	    }
	    if (head.getValue().equals(value)) {
	        return true;
	    }
	    return contains(head.getNext(), value);
	}
  public static <T> Node<T> removeFirst(Node<T> head, T value) {
	    if (head == null) {
	        return null;
	    }
	    if (head.getValue().equals(value)) {
	        return head.getNext(); // מחזירה את הרשימה לאחר מחיקת החוליה הראשונה
	    }
	    head.setNext(removeFirst(head.getNext(), value));
	    return head;
	}
  public static <T> Node<T> removeAtIndex(Node<T> head, int index) {
	    if (head == null) {
	        return null;
	    }
	    if (index == 1) {
	        return head.getNext();
	    }
	    head.setNext(removeAtIndex(head.getNext(), index - 1));
	    return head;
	}
  public static <T> boolean areAllValuesInList(Node<T> l1, Node<T> l2) {
	    if (l1 == null) {
	        return true;
	    }
	    if (!contains(l2, l1.getValue())) {
	        return false;
	    }
	    return areAllValuesInList(l1.getNext(), l2);
	}
  public static <T> void printCommonValues(Node<T> l1, Node<T> l2) {
	    if (l1 == null) {
	        return;
	    }
	    if (contains(l2, l1.getValue())) {
	        System.out.println(l1.getValue());
	    }
	    printCommonValues(l1.getNext(), l2);
	}
  public static <T> Node<T> getCommonValues(Node<T> l1, Node<T> l2) {
	    if (l1 == null) {
	        return null;
	    }
	    if (contains(l2, l1.getValue())) {
	        Node<T> rest = getCommonValues(l1.getNext(), l2);
	        return new Node<>(l1.getValue(), rest);
	    }
	    return getCommonValues(l1.getNext(), l2);
	}
  public static <T> Node<T> removeValuesInL2(Node<T> l1, Node<T> l2) {
	    if (l1 == null) {
	        return null;
	    }
	    if (contains(l2, l1.getValue())) {
	        return removeValuesInL2(l1.getNext(), l2); // מתעלמת מהחוליה הזו
	    }
	    l1.setNext(removeValuesInL2(l1.getNext(), l2));
	    return l1;
	}

}