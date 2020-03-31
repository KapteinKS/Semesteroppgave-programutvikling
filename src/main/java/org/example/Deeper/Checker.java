package org.example.Deeper;
import org.example.components.Component;

public class Checker {
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

		*INSERT SUICIDE MEME HERE*


 	*/


//<<<<<<< HEAD

	public boolean isCompatible(Component a, Component b) {

		if (a.getManufacturer().equals(b.getManufacturer())) {
			return true;
		} else {
			return false;

//=======
    /*
	public boolean isCompatible(Component a, Component b) throws ComponentCompatibilityException {
        try{
            if (a.getManufacturer.equals(b.getManufacturer)) {
                return true;
		}catch(ComponentCompatibilityException cce){
		    throw new ComponentCompatibilityException("Komponenter ikke kompitable");
		    return false;

     */
//>>>>>>> 0d0f9ddeca9a5190f8d173704fcfc3c537af90bf
		}
	}

}
