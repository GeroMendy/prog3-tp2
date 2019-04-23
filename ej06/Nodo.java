package ej06;

public class Nodo{

	private Nodo sig;
	private Comparable<Object> data;
	
	public Nodo(Nodo sig,Comparable<Object> data) {
		this.sig = sig;
		this.data = data;
	}
	public Comparable<Object> getData() {
		return data;
	}
	public Nodo next() {
		return sig;
	}
	public boolean hasNext() {
		return sig==null;
	}
	public void setNext(Nodo sig) {
		this.sig = sig;
	}
}


