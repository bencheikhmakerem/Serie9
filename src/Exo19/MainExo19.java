package Exo19;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

public class MainExo19 {

	

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		AnalyzeBean analyzeBean=new AnalyzeBean();
		Person p=new Person("BEN CHEIKH", "Makerem", 24);
		Employee Em=new Employee("JEDDI", "Noor", 23);
		
	System.out.println("--------Test de la 1ère question-----------");
			String className = analyzeBean.getClassName(p);
			System.out.println(className);
			
	System.out.println("***********************************************\n");
	
	System.out.println("--------Test de la 2ème question-----------");
	
		Object Instance = analyzeBean.getInstance(className);
		System.out.println(Instance);
  
   System.out.println("***********************************************\n");
  
   System.out.println("--------Test de la 3ème question-----------");
     List<String> properties = new ArrayList<>();
     properties = analyzeBean.getProperties(p);
    
     System.out.println("**Les propriétes de la class Person**");
     properties.forEach(System.out::println);
     
     properties = analyzeBean.getProperties(Em);
     System.out.println("**Les propriétes de la class Employee**");
     properties.forEach(System.out::println);
     
     
     System.out.println("***********************************************\n");
    
     System.out.println("--------Test de la 4ème question-----------");
     
     Field FirstNameChamp=analyzeBean.get(p,"FirstName");
     Object champ=FirstNameChamp.get(p);
     System.out.println(FirstNameChamp.getName() +": " +   champ);
     
     Field LastNameChamp=analyzeBean.get(p,"LastName");
     Object champ1=LastNameChamp.get(p);
     System.out.println(LastNameChamp.getName() +": " +   champ1);
     
     Field AgeChamp=analyzeBean.get(p,"age");
     Object champ2=AgeChamp.get(p);
     System.out.println(AgeChamp.getName() +": " +   champ2);
     
     
     System.out.println("***********************************************\n");
    
     System.out.println("--------Test de la 5ème question-----------");
     
     Person p1= new Person();
     analyzeBean.set(p1, "LastName","JALLED" );
     analyzeBean.set(p1, "FirstName","Mahdi" );
     analyzeBean.set(p1, "age",26 );
     System.out.println("nouvelle personne: " +p1);
     
     
    
		
}
	}
