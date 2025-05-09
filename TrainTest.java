import org.junit.Test.*;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;
import org.junit.Before;

public class TrainTest{
    public Train t;
    @Before
    public void setup(){
        this.t = new Train();
    }
   @Test
    public void testTrainConstructor(){
        t = new Train(FuelType.ELECTRIC, 100.0, 3, 150);
        Car firstCar = t.getCar(0);
        String p= "Alice";
        firstCar.addPassenger(new Passenger(p));
        assertEquals("Alice", firstCar.getPassengers().get(0).getName());
    } 
    @Test
    public void testTrainGetCar(){
        assertEquals(3, t.nCars);
    }
    @Test
    public void testTrainPassengerCount() {
        Train t = new Train(FuelType.ELECTRIC, 100.0, 3, 150);
        t.getCar(0).addPassenger(new Passenger("Alice")); 
        assertEquals(149, t.seatsRemaining()); 
    }
    @Test
    public void testTrainPrintManifest() {
        Train t = new Train(FuelType.ELECTRIC, 100.0, 3, 150);
        t.getCar(0).addPassenger(new Passenger("Alice"));
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        t.printManifest();
        String output = outContent.toString();
        assertTrue(output.contains("Alice"));
        assertTrue(output.contains("Passenger list for Car 1"));
}
    @Test
    public void testPassengerBoardCarFull(){
        Car car = new Car(1);
        new Passenger("Alice").boardCar(car);
        new Passenger("Bob").boardCar(car);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        String output = outContent.toString();
        assertFalse(output.contains("Bob"));
}

    @Test
    public void testPassengerBoardCarWithSpace() {
        Car car = new Car(1);
        new Passenger("Alice").boardCar(car);
        int passengerCount = car.getPassengers().size();
        assertEquals(passengerCount,car.getPassengers().size());
}

    @Test
    public void testCarAddPassenger(){
        Car car = new Car(4);
        new Passenger("Alice").boardCar(car);
        new Passenger("Bob").boardCar(car);
        assertEquals(2,car.getPassengers().size());
    }
    @Test
    public void testCarRemovePassenger(){
        Car car = new Car(1);
        Passenger alice = new Passenger("Alice");
        car.addPassenger(alice); 
        car.removePassenger(alice); 
        car.removePassenger(alice);  
        assertTrue(car.seatsRemaining() >= 0);
    }
    @Test
    public void testEngineGo(){
        Engine engine = new Engine(FuelType.ELECTRIC, 30.0, 100.0);
        double initialFuel = engine.getCurrentFuel();
        assertTrue(engine.go());
        double expected=engine.getCurrentFuel();
        //double expected= initialFuel-5;
        assertTrue(expected< initialFuel);
    }
    @Test
    public void testEngineConstructor() {
        FuelType expectedType = FuelType.ELECTRIC;
        double expectedCurrentFuel = 100.0;
        double expectedMaxCapacity = 200.0;
        Engine engine = new Engine(expectedType, expectedCurrentFuel, expectedMaxCapacity);
        assertEquals(expectedType, engine.getFuelType());
        assertTrue(expectedCurrentFuel== engine.getCurrentFuel());
    }

}