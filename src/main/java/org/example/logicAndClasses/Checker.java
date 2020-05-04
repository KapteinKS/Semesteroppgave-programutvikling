package org.example.logicAndClasses;

import javafx.collections.ObservableList;
import org.example.componentClasses.*;

import java.util.List;

public class Checker {
//None of this is working yet =))
	public static String checkMotherboardAndCPU(Motherboard mb, CPU cpu){
		String out = "FINEremovethisLine";
		if (!(mb.getSocket().equals(cpu.getSocket()))){
			out = "" + "CPU Sockets don't match!\nMotherboard: " + mb.getManufacturer() + " " + mb.getName()
					+ " : \n  Socket: " + mb.getSocket() + "\nCPU: " + cpu.getManufacturer() + " " + cpu.getName()
					+ " : \n  Socket: " + cpu.getSocket() + "\n";
		}
		return out;
	}
	public static String checkMotherboardAndCabinet(Motherboard mb, Cabinet cab){
		String out = "";
		if (!(mb.getMbFormFactor().equals(cab.getMbFormFactor()))){
			out = "Motherboard form-factor does not match!\nMotherboard: " + mb.getManufacturer() + " "
					+ mb.getName() + " : \n Form-Factor: " + mb.getMbFormFactor() + "\nCabinet: "
					+ cab.getManufacturer() + " " + cab.getName() + " : \n Form-Factor: "
					+ cab.getMbFormFactor() + "\n";
		}
		return out;
	}
	public static String checkMotherboardAndRAM(Motherboard mb, RAM ram){
		String out = "";
		if (!(mb.getRamType().equals(ram.getMemoryType()))){
			out = "RAM-type does not match!\nMotherboard: " + mb.getManufacturer() + " "
					+ mb.getName() + " : \n RAM-type: " + mb.getRamType() + "\nRAM: "
					+ ram.getManufacturer() + " " + ram.getName() + " : \n RAM-type: "
					+ ram.getMemoryType() + "\n";
		}
		return out;
	}

	public static double summarizeWatts(ObservableList<Component> components){
		double sum = 0.0;
		for(Component cmpnt: components){
			if(!(cmpnt.getType().equals("PowerSupply"))) {
				sum += cmpnt.getWattsRequired();
			}
		}
		return sum;
	}

	public static double summarizePrice(ObservableList<Component> components){
		double sum = 0.0;
		for (Component cmpnt : components){
			sum += cmpnt.getPrice();
		}
		return sum;
	}



	/*

		'isCompatible(a,b)' ought to be able to check several types of components, and
		several types of compatibility.

		CPU on Motherboard via socket
		RAM on Motherboard via DDR-Protocol
		Motherboard on Chassi via Size

		All these neccessary attributes must be added to the components, to make the
		testing possible.

		'Checker.java' should also include a
		'enoughPower' method, that summarizes all the individual components power-consumption,
		and if it exceeds selected PSU, it will return FALSE.

		*INSERT SUICIDE MEME HERE*


 	*/


    /*
	public boolean isCompatible(Component a, Component b) throws ComponentCompatibilityException {
        try{
            if (a.getManufacturer.equals(b.getManufacturer)) {
                return true;
		}catch(ComponentCompatibilityException cce){
		    throw new ComponentCompatibilityException("Komponenter ikke kompitable");
		    return false;
		}
     */

}
