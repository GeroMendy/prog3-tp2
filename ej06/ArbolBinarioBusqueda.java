package ej06;

public class ArbolBinarioBusqueda {

	private NodeABB raiz;
	private Comparable<Object> invalidInfo=null;
	
	public Comparable<Object> getRoot() {
		if(!this.isEmpty())return raiz.getValue();
		else return invalidInfo;
	}
	public boolean hasElem(Comparable<Object> x) {
		if(!this.isEmpty())return raiz.exist(x);
		else return false;
	}
	public boolean isEmpty() {
		return raiz==null;
	}
	public void insert(Comparable<Object> x) {
		if(!this.isEmpty())raiz.insert(x);
		else raiz=new NodeABB(x);
	}
	public void remove(Comparable<Object> x) {
		if(!this.isEmpty()) {
			if(!raiz.isThis(x))raiz.remove(x);
			else raiz=raiz.removeThis();
		}
	}
	public int getHeigth() {
		if(!this.isEmpty())return raiz.heigth();
		else return -1;
	}
	
	public void preOrden(Something s) {
		if(!this.isEmpty())raiz.preOrden(s);
	}
	public void inOrden(Something s) {
		if(!this.isEmpty())raiz.inOrden(s);
	}
	public void posOrden(Something s) {
		if(!this.isEmpty())raiz.posOrden(s);
	}
	
	public List getLongestBranch() {
		List l=new List();
		if(!this.isEmpty())raiz.longestBreach(l);
		return l;
	}
	public List getFrontera() {
		List l=new List();
		if(!this.isEmpty())raiz.getFrontera(l);
		return l;
	}
	public Comparable<Object> getMinElement() {
		if(!this.isEmpty())return raiz.getMin();
		else return invalidInfo;
	}
	public Comparable<Object> getMaxElement() {
		if(!this.isEmpty())return raiz.getMax();
		else return invalidInfo;
	}
	public List getElementsAtLevel(int level) {
		List l=new List();
		if(!this.isEmpty()&&level>=0)raiz.elementsAtLevel(level, l);
		return l;
	}
	
}
