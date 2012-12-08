package lesson;

import java.io.Serializable;
import java.util.ArrayList;

public class Cat implements Serializable{
	private int age;
	private String name;
	private transient int stepsSinceReboot; //transient oznacza ze pomijamy zmienna przy savowaniu
	ArrayList<Cat> kittens;
	
	
	//przy konstruktorze najwyrazniej mozemy olac public i wogole kurwa wszystko
	
	Cat(int startAge, String startName){
		age = startAge;
		name = startName;
		kittens = new ArrayList<Cat>();
		stepsSinceReboot =0;
		
	}
	
	public void walkAlot(){
		stepsSinceReboot = 10;
	}
	public void printStats(){
		System.out.println("Name: " + name );
		System.out.println("Age: " + age );
		System.out.println("Steps: " + stepsSinceReboot);
		if(!kittens.isEmpty()){
			
			System.out.println("My kittens: ");
			
			
			
			for(Cat currentKitten : kittens){
				currentKitten.printStats();
			}
		}
	}
	
	public void setAge(int n){
		age = n;
	}
	
	public void addKitten(Cat newKitten){
		kittens.add(newKitten);
	}
	
}
