package com.dts.qlhs.repo;

import java.lang.reflect.Constructor;

public class Singleton {
	private static Singleton Instance = null;

	private Singleton() {
		System.out.println("create . . .");
	}

	public static Singleton getIntance() {
		if(Instance == null) {
			Instance = new Singleton();
		}
		return Instance;
	}

}

class testClass {
	
	static void usingSington() {
		 Singleton singleton = Singleton.getIntance();
		 print("singleton", singleton);
		 
	} 
	
	public static void main(String[] args) throws Exception {
		Singleton s1 = Singleton.getIntance();
		Singleton s2 = Singleton.getIntance();
//		Singleton s5 = new Singleton();
		print("s1", s1);
		print("s2", s2);
		
		//Reflection
		Class clazz = Class.forName("com.dts.qlhs.repo.Singleton"); 
		Constructor<Singleton> ctor = clazz.getDeclaredConstructor();
		ctor.setAccessible(true);
		Singleton s3 = Singleton.getIntance();
		print("s3", s3);
	}

	static void print(String name, Singleton obj) {
		System.out.println(String.format("obj : %s, Hascode: %d", name, obj.hashCode()));
	}

}
