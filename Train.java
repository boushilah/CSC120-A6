import java.util.ArrayList;

public class Train{
    private final Engine engine;
    private ArrayList<Car> cars;
    public int trainMaxCapacity;
    public int nCars;

    /**
     * Constructor
     * @param fuelType
     * @param fuelCapacity
     * @param nCars
     * @param trainMaxCapacity
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int trainMaxCapacity) {
        this.engine = new Engine(fuelType, fuelCapacity, fuelCapacity);
        this.cars = new ArrayList<>();
        this.trainMaxCapacity = trainMaxCapacity;
        int baseCapacity = trainMaxCapacity / nCars;
        int remainder = trainMaxCapacity % nCars;
        for (int i = 0; i < nCars; i++) {
            int carCapacity = baseCapacity + (i < remainder ? 1 : 0); 
            Car newCar = new Car(carCapacity);  // Creating an object of class Car                    
            this.cars.add(newCar);                                                      
        }
    }
    public Train(FuelType fuelType, double fuelCapacity){
        this.engine = new Engine(fuelType,500,500);
        this.cars = new ArrayList<>();
        this.nCars = 3;
        this.trainMaxCapacity = 150;
    }
    public Train(int nCars){
        this.engine = new Engine(FuelType.ELECTRIC, 500, 500);
        this.nCars= nCars;
        this.trainMaxCapacity = 150;
    }
        /**
     * Getter
     * @return an instance of the engine class.
     */
    public Engine getEngine(){
        return engine;
    }
    /**
     * 
     * @param i
     * @return the car at the "i" position in the car arraylist 
     */
    public Car getCar(int i) {
        return cars.get(i);
    }
    /**
     * getter
     * @return the train passenger capacity
     */
    public int getMaxCapacity(){
        int trainCapacity = 0;
        for (Car car : cars){
            trainCapacity += car.getCapacity();
        }
        return trainCapacity;
    }
    /**
     * 
     * @return Seats remaining. 
     */
    public int seatsRemaining() {
        int seatsRemaining = 0;
        for (Car car : cars) {
        seatsRemaining += car.seatsRemaining();
        }
        return seatsRemaining;
    }
    /**
     * prints out the manifest of the train. 
     */
    public void printManifest() {
        System.out.println("\nThe Manifest");
        if (cars.isEmpty()){
            System.out.println("No cars attached to this train.");
        } for (int i = 0; i < cars.size(); i++) {
            System.out.println("\nPassenger list for Car " + (i + 1) + ":");
            cars.get(i).printManifest();
        }
    }
 
    public static void main(String[] args) {
        Train myTrain = new Train(FuelType.ELECTRIC, 100.0, 3, 150);
        Passenger p1 = new Passenger("Hayle");
        Passenger p2 = new Passenger("Ben");
        Passenger p3 = new Passenger("Fatima");
 
        // Add passengers to cars at "i" position 
        myTrain.getCar(0).addPassenger(p1);
        myTrain.getCar(0).addPassenger(p2);
        myTrain.getCar(2).addPassenger(p3);
        myTrain.getCar(0).toString();
 
        // Print train manifest
        myTrain.printManifest();
        System.out.println("");
 
        if (myTrain.getEngine().go()){
            System.out.println("Choo choo!");
        } else{
            System.out.println("Out of fuel. Please refill.");
        }
        myTrain.getCar(1).removePassenger(p3);
        myTrain.getCar(0).addPassenger(p1);
        System.out.println("");
        myTrain.printManifest();
        System.out.println("The current number of seats Remaining is:"+myTrain.seatsRemaining());
        myTrain.getCar(2).seatsRemaining();
        Passenger p5 = new Passenger("Kayla");
        myTrain.getCar(2).removePassenger(p5);
    }
 }
 