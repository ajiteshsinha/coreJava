package com.ajitesh.collections;

import java.util.Stack;

public class QueueWithStack {
	
	
	
	private Stack<Integer> stk  = null;
	
	
	public void enqueue(int elem) {
		
		this.stk.push(elem);
	}
	
	/** Recursive call */
	public int dequeue() {
		
		int curr = stk.pop();
		if(this.stk.isEmpty()) return curr;
		
	//	System.out.println(stk +  " elem " + res);
		
		 int res = dequeue();
	//		System.out.println("adding : " +  res);
			enqueue(curr);
		return res;
	}
	
	public void fifo() {
		stk =  new Stack<>();
		enqueue(1);
		enqueue(2);
		enqueue(3);
		enqueue(4);
		
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
	//	System.out.println(dequeue());
		
	}
	
	public static void main(String[] args) {
		QueueWithStack qws =  new QueueWithStack();
		 qws.fifo();
		 
	}

}
