package com.example;

public class StudyString1 {

	public static void main(String[] args) {
		String name = "Jack"; // immutable, constant-pool
		name.toUpperCase();
		System.out.println(name);
		name = new String("Jack"); // immutable, Heap
		long start = System.currentTimeMillis();
        String s = "";
//        for (int i=0;i<1_000_000;++i)
//        	s = s + i; // dynamic run-time, 10000 times creates String Object
        long stop = System.currentTimeMillis();
        System.out.println(s.length()+" - " + (stop-start) + " ms.");
        // StringBuilder -> not TS vs StringBuffer -> Thread-Safe Class
        var sb = new StringBuffer(388888890);
        start = System.currentTimeMillis();
        for (int i=0;i<50_000_000;++i)
        	sb.append(i); 
        stop = System.currentTimeMillis();
        System.out.println(sb.length()+" - " + (stop-start) + " ms.");
        
        
	}

}
