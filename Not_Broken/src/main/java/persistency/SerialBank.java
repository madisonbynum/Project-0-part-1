package persistency;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import views.Launcher;

public class SerialBank {
	
//	private static final String SerializeMyBank = "SerializedBankUI.txt";
	public static Launcher launcher= new Launcher();	
		
		
		public void writeSerializeMyBank() {
			
			
			File file = new File("./SaveMyBank.ser");
			
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
				oos.writeObject(launcher);
				oos.close();
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		
		public void loadSerializeMyBank() {	
			
			File file = new File("./SaveMyBank.ser");
			
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
				launcher = (Launcher) ois.readObject();
				ois.close();
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		
		
}


