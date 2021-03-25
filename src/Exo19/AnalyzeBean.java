package Exo19;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AnalyzeBean {
	
	//Method qui retourne le nom d'une classe	
	public String getClassName(Object o) {
				
				Class<?> clss = o.getClass();
				return clss.getName(); 
			}
				
	//Methode qui retourne une instance de la classe passé en paramètre 
	public Object getInstance(String className) {
			 {
				Class<?> clss1;
				try {
					clss1 = Class.forName(className);
					
					Object Instance = clss1.getConstructor().newInstance();
					return Instance;


				} catch (ClassNotFoundException|IllegalAccessException|NoSuchMethodException
						|InvocationTargetException|SecurityException|InstantiationException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
	}
	//Methode qui retourne la liste des noms des propriétés de l'objet en paramètre
	public List<String> getProperties(Object o) {
				List<String> properties = new ArrayList<>();
					
				 Method[] methods = o.getClass().getMethods();
				 for (Method method : methods) {
					 if(method.getName().startsWith("get")||method.getName().startsWith("is")
							 &&method.getParameterCount()==0 && Modifier.isPublic(method.getModifiers())) {
						 String NomProp = "";
						 if(method.getName().startsWith("get"))
						 {
							 NomProp=method.getName().substring(3);				
						 }
						 if(method.getName().startsWith("is"))
						 {
							 NomProp=method.getName().substring(2);				
						 }
						 
						 NomProp= 
								 NomProp.substring(0, 1).toLowerCase() + 
								 NomProp.substring(1);
						 properties.add(NomProp);
						}

						 
					 }
				return properties;
					
				}
	 public Field get(Object bean, String property) {
		 Class<?> Bean = bean.getClass();
		 
		 try {
			Field F=Bean.getDeclaredField(property);
			F.setAccessible(true);
			return(F);
		} catch (NoSuchFieldException|SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		 
		 
		 return null;
		 
	 }
	 }
		 public void set(Object bean, String property, Object value)   {
			 try {	
			String method = "set" + property.substring(0, 1).toUpperCase() + property.substring(1); 
							Method setProprety = bean.getClass().getMethod(method, value.getClass());
							
								setProprety.invoke(bean, value);
							
			 }catch (IllegalAccessException|IllegalArgumentException|InvocationTargetException | NoSuchMethodException | SecurityException e) 
			 {
									// TODO Auto-generated catch block
									e.printStackTrace();
			 }				
			
			
		}
		
}


