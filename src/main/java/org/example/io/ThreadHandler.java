package org.example.io;

import javafx.concurrent.Task;
import org.example.App;
import org.example.componentClasses.Component;
//import org.example.io.ReadOrderFromFile;
import org.example.logicAndClasses.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
//  Class that facilitates data-loading being done in it's own thread
public class ThreadHandler extends Task<String> {
	public ThreadHandler(){}
	//  When called, all data is loaded into the program (done at startup)
	protected String call() throws Exception {
			try {
				System.out.println("Thread starting");
				Thread.sleep(3000);	//  Pause to show it working
				App.setComponentCollection(openComponents());	//  Load in components
				App.setUserCollection(openUsers());				//  Load in users
				App.setOrderCollection(openOrder());			//  Load in orders
				System.out.println("Thread finished");
			} catch (InterruptedException ie) {
			}
			return "";
	}

	//  Method for loading components from .jobj file
	public ComponentCollection openComponents() throws IOException, ClassNotFoundException {
		try(InputStream in = Files.newInputStream(Paths.get("components.jobj"));
			ObjectInputStream oin = new ObjectInputStream(in)){
			List<Component> components = (ArrayList<Component>) oin.readObject();

			ComponentCollection inComponents = new ComponentCollection();

			for(Component c : components){
				inComponents.add(c);
			}
			return inComponents;
		}
		catch (IOException ioe){
			throw new IOException("Something wrong with reading from file!");
		}
		catch (ClassNotFoundException cnfe){
			throw new ClassNotFoundException("File reader couldn't find class for object");
		}
	}
	//  Method for loading users form .jobj file
	public static UserCollection openUsers() throws IOException, ClassNotFoundException {
		try (InputStream in = Files.newInputStream(Paths.get("users.jobj"));
			 ObjectInputStream oin = new ObjectInputStream(in)){
			List<User> users = (ArrayList<User>) oin.readObject();
			UserCollection userCollection = new UserCollection();
			for(User u : users){
				userCollection.addUser(u);
			}
			return userCollection;
		} catch (IOException ioe){
			throw new IOException("Something went wrong reading from file");
		} catch (ClassNotFoundException c){
			throw new ClassNotFoundException("File reader couldn't find a class");
		}
	}
	//  Method for loading orders from .csv file
	public static OrderCollection openOrder() throws IOException{
		OrderCollection listOfOrders = new OrderCollection();
		try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("orders.csv"))){
			String line;
			while ((line = bufferedReader.readLine()) != null){
				listOfOrders.addOrder(parseOrder(line));
			}
		}catch (IOException ioe){
			ioe.printStackTrace();
		}
		if (listOfOrders.size()==0){
			throw new IOException("Fil er tom.");
		}
		return listOfOrders;
	}
	//  Submethod for openOrder()
	private static Order parseOrder(String line) throws IOException{
		String[] split = line.split(",");
		//  As an order can contain varying amount of components ordered, we use this ArrayList & for-loop.
		ArrayList<String> componentsOrdered = new ArrayList<>();
		for (int i = 3; i < split.length; i++){
			componentsOrdered.add(split[i]);
		}
		return new Order(split[0],split[1],split[2],componentsOrdered,Double.parseDouble(split[split.length-1]));
	}

}
