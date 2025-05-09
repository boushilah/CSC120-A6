public class Passenger{ 
    private String name; 
    /**
     * Constructor
     * @param name
     */
    public Passenger(String name){ 
        this.name = name; 
    } 
    /**
     * Getter
     * @return name
     */
    public String getName(){ 
        return name; 
    } 
    /**
     * Method for boarding a car
     * @param c
     */
    public void boardCar(Car c) { 
        if (!c.addPassenger(this)) { 
            System.out.println(name + " couldn't board. Car is full.");
        } 
    } 
    /**
     * Method for removing passenger from a car
     * @param c
     */
    public void getOffCar(Car c) { 
        if (!c.removePassenger(this)) { 
            System.out.println(name + " isn't on this car.");
        } 
    } 
}
