package org.example.exceptions;

import java.io.IOException;
// Class containing methods pertaining to input validation
// Parameters for validation are chosen to be somewhat realistic
public class ExceptionHandler {
    public double checkPrice(double price) throws IllegalPriceException {
        if(price < 0){
            throw new IllegalPriceException("Pris må være positiv");
        }
        return price;
    }

    public double checkHeight(double height) throws IllegalDimensionsException{
        if (height < 20){
            throw new IllegalDimensionsException("Kabinett for lavt");
        } else if (height > 150){
            throw new IllegalDimensionsException("Kabinett for høyt!");
        }
        return height;
    }

    public double checkWidth(double width) throws IllegalDimensionsException{
        if (width < 5){
            throw new IllegalDimensionsException("Kabinett for tynt");
        } else if (width > 40) {
            throw new IllegalDimensionsException("Kabinett for bredt!");
        }
        return width;
    }

    public double checkDepth(double depth) throws IllegalDimensionsException{
        if (depth < 20){
            throw new IllegalDimensionsException("Kabinett for kort");
        } else if (depth > 125) {
            throw new IllegalDimensionsException("Kabinett for dypt!");
        }
        return depth;
    }

    public double checkWeight(double weight) throws IllegalWeightException{
        if (weight < 0){
            throw new IllegalWeightException("Vekt må være positiv");
        }
        return weight;
    }

    public int checkThreads(int threads) throws IllegalThreadsException {
        if(threads <= 0){
            throw new IllegalThreadsException("Antall tråder må være positiv");
        }
        return threads;
    }

    public double checkClockSpeed(double clockSpeed) throws IllegalClockSpeedException {
        if(clockSpeed < 1){
            throw new IllegalClockSpeedException("Her registrerer vi ikke trege CPU-er");
        } else if (clockSpeed > 10){
            throw new IllegalClockSpeedException("Ro ned nå, Speed Racer");
        }
        return clockSpeed;
    }

    public int checkDiameter (int diameter) throws IllegalDimensionsException {
        if(diameter < 5){
            throw new IllegalDimensionsException("Viftediameter for lav!");
        } else if (diameter > 40){
            throw new IllegalDimensionsException("Denne vifta kommer ikke til å passe i noe kabinett");
        }
        return diameter;
    }

    public double checkAirPressure (double pressure) throws IllegalPressureException {
        if(pressure <= 0 || pressure > 10){
            throw new IllegalPressureException("Lufttrykk utenfor lovlige grenser");
        }
        return pressure;
    }

    public int checkNoise (int noise) throws IllegalNoiseException {
        if(noise > 100){
            throw new IllegalNoiseException("Denne viften kommer til å forårsake hørselskader");
        }
        return noise;
    }

    public int checkRAM (int ram) throws IllegalRAMException{
        if(ram < 1){
            throw new IllegalRAMException("RAM utenfor lovlig område");
        }
        return ram;
    }

    public double checkWatts(double watts) throws IllegalWattsException {
        if(watts < 0){
            throw new IllegalWattsException("Energiforbruk utenfor lovlig område");
        }
        return watts;
    }

    public int checkWatts(int watts) throws IllegalWattsException {
        if(watts < 0){
            throw new IllegalWattsException("Energiforbruk utenfor lovlig område");
        }
        return watts;
    }

    public int checkVoltageIn(int voltage) throws IllegalVoltageException {
        if(voltage < 120 || voltage > 250){
            throw new IllegalVoltageException("Spenning inn utenfor lovlig område");
        }
        return voltage;
    }

    public int checkVoltageout(int voltage) throws IllegalVoltageException {
        if(voltage < 10 || voltage > 15){
            throw new IllegalVoltageException("Spenning ut utenfor lovlig område");
        }
        return voltage;
    }

    public int checkStorage (int storage, String type) throws IllegalCapacityException, IOException {
        if(type.equals("TB")){
            if (storage < 1 || storage > 15){
                throw new IllegalCapacityException("Lagring utenfor lovlig område");
            }
        } else if (type.equals("GB")){
            if (storage < 124 || storage > 2048){
                throw new IllegalCapacityException("Lagring utenfor lovlig område");
            }
        } else {
            throw new IOException("Ingen størrelsesorden valgt for lagring");
        }
        return storage;
    }

    public double checkSize(double size) throws IllegalScreenSizeException {
        if(size < 13){
            throw new IllegalScreenSizeException("Skjermstørrelse for lav");
        }
        return size;
    }

    public int checkRefreshRate(int refreshRate) throws IllegalRefreshRateException{
        if (refreshRate < 16){
            throw new IllegalRefreshRateException("Ingen kommer til å kjøpe en skjerm under 16Hz");
        }
        return refreshRate;
    }

    public int checkResponseTime(int responseTime) throws IllegalResponseTimeException{
        if(responseTime < 0){
            throw new IllegalResponseTimeException("En skjerm kan ikke se fremtiden");
        } else if (responseTime > 50){
            throw new IllegalResponseTimeException("Denne skjermen vil føles veldig dårlig å bruke");
        }
        return responseTime;
    }

    public int checkDPI(int dpi) throws IllegalDPIException{
        if (dpi < 100){
            throw new IllegalDPIException("Følsomhet for lav");
        }
        return dpi;
    }

    public int checkButtons(int buttons) throws IllegalButtonsException{
        if (buttons < 0){
            throw new IllegalButtonsException("Kan ikke ha negativt antall programmerbare knapper");
        }
        return buttons;
    }

    public int checkRAMPieces(int pieces) throws IllegalRAMException{
        if(pieces <= 0){
            throw new IllegalRAMException("Antall brikker må være større enn 0");
        }
        return pieces;
    }

    public static class DoubleStringConverter extends javafx.util.converter.DoubleStringConverter {
        private boolean conversionSuccessful;

        @Override
        public Double fromString(String s) {
            try {
                Double result = super.fromString(s);
                conversionSuccessful = true;
                return result;
            } catch(NumberFormatException e) {
                conversionSuccessful = false;
                return 0.0;
            }
        }

        public boolean wasSuccessful() {
            return conversionSuccessful;
        }
    }
}
