package org.example.Exceptions;

public class ExceptionHandler {
    public double priceCheck(double price) throws IllegalPriceException {
        if(price < 0){
            throw new IllegalPriceException("Pris må være positiv");
        }
        return price;
    }
    public int checkHeight(int height) throws IllegalDimensionsException{
        if (height < 0){
            throw new IllegalDimensionsException("Høyde må være positiv");
        }
        return height;
    }
    public int checkWidth(int width) throws IllegalDimensionsException{
        if (width < 0){
            throw new IllegalDimensionsException("Bredde må være positiv");
        }
        return width;
    }
    public int checkDepth(int depth) throws IllegalDimensionsException{
        if (depth < 0){
            throw new IllegalDimensionsException("Dybde må være positiv");
        }
        return depth;
    }
    public int checkWeight(int weight) throws IllegalWeightException{
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
    public double chechClockSpeed(double clockSpeed) throws IllegalClockSpeedException {
        if(clockSpeed < 1){
            throw new IllegalClockSpeedException("Her registrerer vi ikke trege CPU-er");
        } else if (clockSpeed > 10){
            throw new IllegalClockSpeedException("Ro ned nå, Speed Racer");
        }
        return clockSpeed;
    }
    public int checkDiameter (int diameter) throws IllegalDimensionsException {
        if(diameter < 0){
            throw new IllegalDimensionsException("Diameter må være positiv");
        } else if (diameter > 20){
            throw new IllegalDimensionsException("Denne vifta kommer ikke til å passe i noe kabinett");
        }
        return diameter;
    }
    public double checkAirPressure (double pressure) throws IllegalPressureException {
        if(pressure < 0 || pressure > 10){
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
}
