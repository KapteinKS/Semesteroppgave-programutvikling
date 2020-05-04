package org.example.logicAndClasses;

import org.example.componentClasses.CPU;
import org.example.componentClasses.Component;
import org.example.componentClasses.Motherboard;

public class Checker {
//None of this is working yet =))
	public static String checkMotherboardxCPU(Motherboard mb, CPU cpu){
		String out = "FINEremovethisLine";
		if (!(mb.getSocket().equals(cpu.getSocket()))){
			out = "" + "Sockets don't match!\nMotherboard: " + mb.getManufacturer() + " " + mb.getName() + " : \n  Socket: " + mb.getSocket()
					+ "\nCPU: " + cpu.getManufacturer() + " " + cpu.getName() + " : \n  Socket: " + cpu.getSocket();
		}
		return out;
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
