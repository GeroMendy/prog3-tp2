package ej06;

public class NodeABB {

	private NodeABB left,rigth;
	private Comparable<Object> info;

	public NodeABB(Comparable<Object> o) {
		this.info = o;
	}
	public Comparable<Object> getValue() {
		return info;
	}
	public boolean exist(Comparable<Object> x) {
		if(info.compareTo(x)>0&&hasLeft()) {
			return left.exist(x);
		}else if(info.compareTo(x)<0&&hasRigth()) {
			return rigth.exist(x);
		}else {
			return x==info;
		}
	}
	public int heigth() {
		if(!hasLeft()&!hasRigth()) {
			return 1;
		}else if(hasLeft()&&hasRigth()) {
			int l=left.heigth(),r=rigth.heigth();
			if(l>r)return l+1;
			else return r+1;
		}else if(!hasLeft()) {
			return rigth.heigth()+1;
		}else return left.heigth()+1;
	}
	public void insert(Comparable<Object> x) {
		if(info.compareTo(x)<0) {
			if(!hasRigth())	rigth=new NodeABB(x);
			else rigth.insert(x);
		}else if(info.compareTo(x)>0) {
			if(!hasLeft()) left = new NodeABB(x);
			else left.insert(x);
		}	//Si es igual no hace nada.
	}
	public void preOrden(Something s) {
		s.doSomething(info);
		if(hasLeft())left.preOrden(s);
		if(hasRigth())rigth.preOrden(s);
	}
	public void inOrden(Something s) {
		if(hasLeft())left.inOrden(s);
		s.doSomething(info);
		if(hasRigth())rigth.inOrden(s);
	}
	public void posOrden(Something s) {
		if(hasLeft())left.posOrden(s);
		if(hasRigth())rigth.posOrden(s);
		s.doSomething(info);
	}
	public Comparable<Object> getMax() {
		if(!hasRigth()) return info;
		else return rigth.getMax();
	}
	public Comparable<Object> getMin() {
		if(!hasLeft()) return info;
		else return left.getMin();
	}
	public void getFrontera(List l) {
		if(!hasLeft()&&!hasRigth()) l.add(info);
		else {
			if(hasRigth())rigth.getFrontera(l);
			if(hasLeft())left.getFrontera(l);
		}
	}
	public void elementsAtLevel(int x,List l) {
		if(x==0) l.add(info);
		else {
			x--;
			if(hasRigth())rigth.elementsAtLevel(x, l);
			if(hasLeft())left.elementsAtLevel(x, l);
		}
	}
	public void longestBreach(List l) {
		l.add(info);
		if(hasLeft()&hasRigth()) {
			if(left.heigth()>rigth.heigth())left.longestBreach(l);
			else rigth.longestBreach(l);
		}else if(hasLeft()) left.longestBreach(l);
		else if(hasRigth()) rigth.longestBreach(l);
	}
	public void remove(Comparable<Object> x) {
		if(info.compareTo(x)>0) {
			if(hasLeft()) {
				if(left.isThis(x))left=left.removeThis();
				else left.remove(x);
			}
		}else {
			if(hasRigth()) {
				if(rigth.isThis(x))rigth=rigth.removeThis();
				else rigth.remove(x);
			}
		}
	}
	protected boolean isThis(Comparable<Object> x) {
		return info.compareTo(x)==0;
	}
	public NodeABB removeThis() {
		if(!hasLeft()&&!hasRigth())return null;
		else if(hasLeft()&&hasRigth()) {
			Comparable<Object> newVal = left.getMax();
			this.remove(newVal);
			info=newVal;
			return this;
		}else if(hasLeft())return left;
		else return rigth;
	}
	private boolean hasLeft() {
		return left!=null;
	}
	private boolean hasRigth() {
		return rigth!=null;
	}
}
