package ej06;

public class List{

	private Nodo first;
	private int size;
	
	public List() {
		first=null;
		size = 0;
	}
	
	public void add(Comparable<Object> data) {
		Nodo aux = new Nodo(first,data);
		first = aux;
		size++;
	}
	public Comparable<Object> extractFront() {
		Nodo aux = first;
		first = first.next();
		size--;
		return aux.getData();
	}
	public Comparable<Object> get(int pos) {
		Nodo aux = first;
		for(int i=1;i<pos;i++) {
			aux = aux.next();
		}
		return aux.getData();
	}
	public void remove(int pos) {
		Nodo sig = first.next();
		if(pos==0) {
			first = sig;
		}else {
			Nodo ant=first;
			for(int i=1;i<pos;i++) {
				ant = sig;
				sig = sig.next();
			}
			ant.setNext(sig);
		}
		size--;
	}
	public int getSize() {
		return size;
	}
}