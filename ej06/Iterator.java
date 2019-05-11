package ej06;

public class Iterator {

	private ListNode node;
	
	public Iterator(ListNode n) {
		node=n;
	}
	public boolean hasNext() {
		return node!=null;
	}
	public Comparable<Object> next(){
		Comparable<Object>data = node.getData();
		node=node.next();
		return data;
	}
	
}
