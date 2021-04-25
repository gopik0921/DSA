package corejava;

import java.util.ArrayList;
import java.util.List;

public class Inheritence {
    void j() {
//    	List<?> list =new ArrayList<>();  
//    	list.add("1");  //Exception
    	
    }
}

class A extends B { // super is used to call parent, this also call parent
	@Override
	protected void c() { // protected and public or only possible, default and private not possible
		i = 10; // private, final not allowed
		super.d();
		this.d();
	}

	@Override
	protected void d() { // private only not possible

	}

// @Override
	void e() { // we cannot override private but we can have same signature

	}

//	void f() { // we cannot have static signature , but same signature can be static
//
//	}

	@Override
	public void g() { // cannot be private,protected,default only public is allowed

	}

// @Override
	static void h() { // private is not possible

	}

//	void j() { // not at all possible
//	}

}

class B {
	int i = 0; // static is also possible, final wont be assigned

	protected void c() {

	}

	void d() {

	}

	private void e() {

	}

	static void f() {

	}

	public void g() {

	}

	static void h() {

	}

//	default void i() { // default methods are only allowed in interfaces
//
//	}

	final void j() {

	}

}
