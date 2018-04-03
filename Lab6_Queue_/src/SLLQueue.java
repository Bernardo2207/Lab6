
/** 
   A partial implementation of the Queue using a singly linked list with references 
   to the first and to the last node.
**/
public class SLLQueue<E> implements Queue<E> {
       // inner class for nodes in singly linked lists
	
	private  class Node<E> {   
		
		private E element; 
		private Node<E> next; 
	
		private Node(E e){
			element=e;
			next=null;
			
		}
		public E getElement() {
			return this.element;
		}
		public Node<E> getNext(){
			return this.next;
		}
		
		public void setElement(E e) {
			this.element=e;
		}
		public void setNext(Node<E> target) {
			this.next=target;
		}
		
	}	
	private Node<E> first, last;   // references to first and last node
	private int size; 
	
	public SLLQueue() {           // initializes instance as empty queue
		first = last = null; 
		size = 0; 
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public E first() {
		if (isEmpty()) return null;
		return first.getElement(); 
	}
	public E dequeue() {
		if (isEmpty()) return null;		
		//... 
		else {
			E etr= first.getElement();
			first=first.getNext();
			size--;
			return etr;
		}
	}
	public void enqueue(E e) {
		if (size == 0) 
			first = last = new Node<>(e); 
		else { 
			//...
			Node<E> t= new Node<>(e);
			t.setNext(null);
			last.setNext(t);
			last=t;
		}
		size++; 
	}
}
