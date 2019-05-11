package ej06;

public class ListNode{

	private ListNode sig;
	private Comparable<Object> data;
	
	public ListNode(ListNode sig,Comparable<Object> data) {
		this.sig = sig;
		this.data = data;
	}
	public Comparable<Object> getData() {
		return data;
	}
	public ListNode next() {
		return sig;
	}
	public boolean hasNext() {
		return sig==null;
	}
	public void setNext(ListNode sig) {
		this.sig = sig;
	}
}


