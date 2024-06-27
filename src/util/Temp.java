package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Temp {
	
	public static void main(String[] args) {
		

//		Member m = new Member("m00001","大A","aaa","111","xxx@xxxx",null,null,null,null,null,null,null,null,null);
//		saveFile("member.txt",m);
//		
//		Object obj = readFile("member.txt");
//		Member m2 = (Member) obj;
//		System.out.println(m2.getMemberId()+"===="+m2.getMemberName());
		
		
	}
	

	public static void saveFile(String filePath, Object o) {
		try {
			FileOutputStream fos = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(o);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Object readFile(String filePath) {
		Object obj = null;

		try {
			FileInputStream fis = new FileInputStream(filePath);
			ObjectInputStream ois = new ObjectInputStream(fis);
			obj = ois.readObject();

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		return obj;
	}
}
