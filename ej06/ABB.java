package ej06;

public class ABB {

	private ABB left,rigth;
	private Comparable<Object>info;
	
	public ABB(Comparable<Object>o) {
		info=o;
	}
	
	public boolean hasElem(Comparable<Object>o) {
		int i=o.compareTo(info);
		if(i>0&&hasRigth())return rigth.hasElem(o);
		else if(i<0&&hasLeft())return left.hasElem(o);
		else return i==0;
	}
	public boolean hasLeft() {
		return left!=null;
	}
	public boolean hasRigth() {
		return rigth!=null;
	}
	public void insert(Comparable<Object>o) {
		int i=o.compareTo(info);
		if(i>0) {
			if(hasRigth())rigth.insert(o);
			else rigth=new ABB(o);
		}else if(i<0) {
			if(hasLeft())left.insert(o);
			else left=new ABB(o);
		}
	}
	public List getFrontera() {
		List l=new List();
		if(!hasLeft()&&!hasRigth())l.add(info);
		else {
			if(hasLeft())addList(l,left.getFrontera());
			if(hasRigth())addList(l,rigth.getFrontera());
		}
		return l;
	}
	private void addList(List base,List otra) {
		Iterator it = otra.iterator();
		while(it.hasNext()) {
			base.add(it.next());
		}
	}
}
