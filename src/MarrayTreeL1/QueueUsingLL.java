/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarrayTreeL1;

/**
 *
 * @author krish
 */
public class QueueUsingLL<T> {

	private Node<T> front;
	private Node<T> rear;
	private int size;

	public QueueUsingLL() {
		front = null;
		rear = null;
		size = 0;
	}
	int size(){
		return size;
	}

	boolean isEmpty(){
		return size == 0;
	}

	T front() throws QueueEmptyException{
		if(size == 0){
			throw new QueueEmptyException();
		}	
		return front.data;
	}

	void enqueue(T element){
		Node<T> newNode = new Node<>(element);
		if(rear == null){
			front = newNode;
			rear = newNode;
		}else{
			rear.next = newNode;
			rear = newNode;
		}
		size++;

	}

	T dequeue() throws QueueEmptyException{
		if(size == 0){
			throw new QueueEmptyException();
		}	
		
		T temp = front.data;
		front = front.next;
		if(size == 1){
			rear = null;
		}
		size--;
		
		return temp;
	}


}
