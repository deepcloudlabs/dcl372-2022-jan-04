package com.example;

import java.text.Collator;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StudyString3 {

	public static void main(String[] args) throws ParseException {
		String name1 = "şima";
		String name2 = "sima";
		System.out.println(name1.equals(name2));
		List<String> names = new ArrayList<>();
		names.add("ali");
		names.add("sema");
		names.add("şima");
		names.add("zehra");
		names.add("veli");
		names.add("şule");
		names.sort(String::compareTo);
		System.out.println(names);
		// Collation
		String basicRules=  "< z < b < c < ç < d < e < f < g < ğ < h "+
		        "< ı < i < j < k < l < m < n < o < ö < p "+
		       "< r < s < ş < t < u < ü < v < y < a ";
		String trExpension= "& şi ; she & ş ; sch & s ; ş & u ; ü & i ; ı " + 
		                    "& c ; ç & o ; ö & ğ ; g" ;	
		final Collator collator= new RuleBasedCollator(basicRules + trExpension);
		Collator.getInstance(new Locale("tr","TR"));
		collator.setStrength(Collator.PRIMARY);
		names.sort(collator::compare);
		System.out.println(names);
		System.out.println(collator.equals(name1, name2));
		System.out.println(collator.equals("şule", "schule"));
		System.out.println(collator.equals("şima", "shema"));
		
	}

}
