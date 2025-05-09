import java.util.ArrayList;
import java.util.List;
public class Car{ 
    private ArrayList<Passenger> passengers; 
    private final int maxCapacity; 
    /**
     * constructor
     * @param maximum capacity
     */
    public Car(int maxCapacity){ 
        this.passengers = new ArrayList<>(); 
        this.maxCapacity = maxCapacity; 
    } 
     /**
     * getter
     * @return the maximum capatity
     */
    public int getCapacity(){
         return maxCapacity;
    } 
     /**
     * setter
     * @return the number of seatsRemaining 
     */
    public int seatsRemaining(){
        //int seatsRemaining=0;
        int seatsRemaining= maxCapacity - passengers.size(); 
         return seatsRemaining;
    } 
     /**
     * @return adds the passengers when the condition is met, otherwise returns false.
     */
    public boolean addPassenger(Passenger p){ 
        if(passengers.contains(p)){
            System.out.println(p.getName()+" is already in the car");
            return false;
        }
        if(passengers.size() < maxCapacity){
            passengers.add(p);
            System.out.println(p.getName()+ " has been added to the car");
            return true;
        } 
        else{
            System.out.println("Can't add a passenger to a full car. Try another one");
            return false;
        }

    } 
     /**
     * removes the passengers when the condition is met, otherwise returns false.
     */
    public boolean removePassenger(Passenger p3) { 
        if(passengers.contains(p3)) {
            passengers.remove(p3);
            System.out.println("Passenger removed ");
            return true;
        } 
        else {
            System.out.println("The passenger "+p3.getName()+" is not found in this car\n");
            return false;
        }

    } 
    public List<Passenger> getPassengers() {
        return this.passengers;
    }
    public void printManifest(){ 
        if (passengers.isEmpty()) { 
            System.out.println("This car is empty."); 
        } 
        else { 
            for (Passenger passenger : passengers){ 
                System.out.println("Passenger: " + passenger.getName()); 
                //System.out.println( passenger.getName()); 
            } 
        } 
    } 
}
