package org.example.logicAndClasses;

import javafx.collections.ObservableList;
import org.example.componentClasses.*;

import java.util.List;

//  Container-class for logic used when checking the compatibility of a PC-build.
public class Checker {
	//  Methods to check if certain component-attributes are compatible with certain other component-attributes
	public static String checkMotherboardAndCPU(Motherboard mb, CPU cpu){
		String out = "";
		if (!(mb.getSocket().equals(cpu.getSocket()))){
			out = "" + "CPU Sockets don't match!\nMotherboard: " + mb.getManufacturer() + " " + mb.getName()
					+ " : \n  Socket: " + mb.getSocket() + "\nCPU: " + cpu.getManufacturer() + " " + cpu.getName()
					+ " : \n  Socket: " + cpu.getSocket() + "\n--------------------\n";
		}
		return out;
	}
	public static String checkMotherboardAndCabinet(Motherboard mb, Cabinet cab){
		String out = "";
		if (!(mb.getMbFormFactor().equals(cab.getMbFormFactor()))){
			out = "Motherboard form-factor does not match!\nMotherboard: " + mb.getManufacturer() + " "
					+ mb.getName() + " : \n Form-Factor: " + mb.getMbFormFactor() + "\nCabinet: "
					+ cab.getManufacturer() + " " + cab.getName() + " : \n Form-Factor: "
					+ cab.getMbFormFactor() + "\n--------------------\n";
		}
		return out;
	}
	public static String checkMotherboardAndRAM(Motherboard mb, RAM ram){
		String out = "";
		if (!(mb.getRamType().equals(ram.getMemoryType()))){
			out = "RAM-type does not match!\nMotherboard: " + mb.getManufacturer() + " "
					+ mb.getName() + " : \n RAM-type: " + mb.getRamType() + "\nRAM: "
					+ ram.getManufacturer() + " " + ram.getName() + " : \n RAM-type: "
					+ ram.getMemoryType() + "\n--------------------\n";
		}
		return out;
	}
	//  Method that returns the total power-requirement of a list of components
	public static double summarizeWatts(ObservableList<Component> components){
		double sum = 0.0;
		for(Component cmpnt: components){
			//  If a component is a PSU, we ignore it
			if(!(cmpnt.getType().equals("PowerSupply"))) {
				sum += cmpnt.getWattsRequired();
			}
		}
		return sum;
	}
	//  Method that returns the total price of a list of components
	public static double summarizePrice(ObservableList<Component> components){
		double sum = 0.0;
		for (Component cmpnt : components){
			sum += cmpnt.getPrice();
		}
		return sum;
	}
}
