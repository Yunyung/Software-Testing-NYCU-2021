import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    int defaultSpeed = 0;
    String defaultDir = "north";
    private Vehicle v_default;
    private Vehicle v_new ;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        v_default = new Vehicle();
        v_new = new Vehicle();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        if (Vehicle.totalVehicle() > 0){
            v_new.finalize();
            v_default.finalize();
        }
    }

    @org.junit.jupiter.api.Test
    void testFinalize() {
        System.out.println("testFinalize Test");
        v_new.finalize();
        v_default.finalize();
        assertEquals(0, Vehicle.totalVehicle());
    }

    @org.junit.jupiter.api.Test
    void setSpeed() {
        System.out.println("setSpeed Test");
        int newSpeed = 100;
        v_new.setSpeed(newSpeed);
        assertEquals(newSpeed, v_new.getSpeed());
    }

    @org.junit.jupiter.api.Test
    void setDir() {
        System.out.println("setDir Test");
        String newDir = "western";
        v_new.setDir(newDir);
        assertEquals(newDir, v_new.getDir());
    }

    @org.junit.jupiter.api.Test
    void getSpeed() {
        System.out.println("getSpeed Test");
        assertEquals(defaultSpeed, v_default.getSpeed());
    }

    @org.junit.jupiter.api.Test
    void getDir() {
        System.out.println("getDir Test");
        assertEquals(defaultDir, v_default.getDir());
    }

    @org.junit.jupiter.api.Test
    void totalVehicle() {
        System.out.println("totalVehicle Test");
        assertEquals(2, v_default.totalVehicle());
    }
}