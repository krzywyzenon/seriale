package lesson;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SavingLoadingObjects {

	//serializable 
	public static void main(String[] args) {
		Cat myCat = new Cat(2, "Behemoth");
		myCat.addKitten(new Cat(0, "Baby"));
		myCat.addKitten(new Cat(1, "LittleCat"));
		myCat.walkAlot();
		System.out.println("before saving");
		myCat.printStats();

		SavingLoadingObjects.saveCat(myCat, "thecatfile.txt");
		
		
		Cat myLoadedCat = loadCat("thecatfile.txt");
		System.out.println("after saving and loading");
		if(myLoadedCat == null)
			System.out.println("Cat is still sober");
		else
			myLoadedCat.printStats();
	}

	public static void saveCat(Cat cat, String fileName){
		ObjectOutputStream output = null;

		try {
			output = new ObjectOutputStream(new FileOutputStream(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("fuck you");
		}
		
		if(output != null){
			//write to file
			try {
				output.writeObject(cat);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//close output
			try {
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//zwraca naladowanego kota lub null jak sie  nie uda
	public static Cat loadCat(String fileName){
		
		Cat loadedCat = null;
		ObjectInputStream input = null;
		//Open Stream
		try {
			input = new ObjectInputStream(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(input!=null){

			//read
			Object obj = null;
			try {
				obj = input.readObject();
			} catch (ClassNotFoundException e1) {
				System.out.println("fuck you - class unknown.... ehh fuck you again");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if((obj!=null)&&(obj instanceof Cat)){
				loadedCat = (Cat)obj;
			}
			//close
			try {
				input.close();
			} catch (IOException e) {
				System.out.println("and fuck you again");
			}
		}
		return loadedCat;
	}
}
