package main_package;

import java.util.EventObject;

public class Target extends EventObject {

	int xObject;
	int yObject;
	int xMouse;
	int yMouse;
	int size;
	String nazwa;

	public Target(Object obj) {
		super(obj);
	}

	public Target(Object obj, int xObject, int yObject, int xMouse, int yMouse,
			String nazwa, int size) {
		super(obj);
		this.xMouse = xMouse;
		this.xObject = xObject;
		this.yMouse = yMouse;
		this.yObject = yObject;
		this.nazwa = nazwa;
		this.size = size;
	}

	public Target(Object obj, int xMouse, int yMouse, String nazwa) {
		super(obj);
		this.xMouse = xMouse;
		this.yMouse = yMouse;
		this.nazwa = nazwa;
		
	}

	public int[] zwrocParametryObiektu() {

		int[] tab = { xMouse, yMouse, (xObject), (yObject), size };
		return tab;
	}

	public String zwrocnazwe() {

		return nazwa;
	}
}
