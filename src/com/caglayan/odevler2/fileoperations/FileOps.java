package com.caglayan.odevler2.fileoperations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.caglayan.odevler2.school.School;

/**
 * Class for read and write objects to file
 * 
 * @author cagla
 *
 */
public class FileOps {

	/**
	 * Writes serialized object to file
	 * 
	 * @param obj  will be written to file
	 * @param file for location
	 */
	public static void writeSerializedObject(School obj, File file) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));) {
			oos.writeObject(obj);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Reads serialized object from file
	 * 
	 * @param file for location
	 * @return Object read from file
	 */
	public static School readSerializedObject(File file) {
		School obj = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));) {
			obj = (School) ois.readObject();
		} catch (FileNotFoundException ex) {
			System.out.println("...");
		} catch (EOFException ex) {
			System.out.println("...");
		}catch (IOException ex) {
			System.out.println("...");
		} catch (ClassNotFoundException ex) {
			System.out.println("...");
		} 
		return obj;
	}

	public static void writeInt(File file, int number) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
			bufferedWriter.write(Integer.toString(number));
			bufferedWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int readInt(File file) {
		int read = -1;
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			read = Integer.parseInt(bufferedReader.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return read;
	}
}
