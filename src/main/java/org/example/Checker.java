package org.example;
import org.example.Exceptions.ComponentCompatibilityException;
import org.example.components.Component;

public class Checker{
//None of this is working yet =))


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


 	*/


	/*
	public boolean isCompatible(Component a, Component b) throws ComponentCompatibilityException {

		if (a.getManufacturer.equals(b.getManufacturer)) {
			return true;
		} else {
			return false;
		}
	}

 */
}
