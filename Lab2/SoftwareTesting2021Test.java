import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SoftwareTesting2021Test {
    @Mock
    Date mockDate;

    @Mock
    Hospital mockHospital;

    @Spy
    Hospital spyHospital;

    SoftwareTesting2021 softwareTesting2021 = new SoftwareTesting2021();

    Student feverStudent = new Student();

    @Test
    public void test_a() throws InterruptedException {
        // Set Hospital
        softwareTesting2021.setHospital(mockHospital);
        // Set Wednesday
        when(mockDate.getWeekday()).thenReturn(4);
        softwareTesting2021.date = mockDate;
        // Verify student is fever
        assertTrue(feverStudent.getTemperature() > 37);
        // Enter class
        softwareTesting2021.enterClass(feverStudent);
        // Verify that method was never called on a mock
        verify(mockHospital, never()).treatment(feverStudent);
    }

    @Test
    public void test_b() throws InterruptedException {
        String expected_result = "After a long time treatment. The student can get out! ^__^";

        // spy Hospital.isolation() function, because original isolation function need to wait 14 days
        doNothing().when(spyHospital).isolation(any(Student.class));
        // Set Spy Hospital
        softwareTesting2021.setHospital(spyHospital);
        // Set Thursday
        when(mockDate.getWeekday()).thenReturn(5);
        softwareTesting2021.date = mockDate;
        // Verify student is fever
        assertTrue(feverStudent.getTemperature() > 37);
        // Enter class
        String actualResult = softwareTesting2021.enterClass(feverStudent);
        // verify expected result and actual Result
        assertEquals(expected_result, actualResult);
    }

    @Test
    public void test_c() throws InterruptedException {
        // Create 3 students with corresponding id
        String[] studentIds = {"87", "487", "9487"};
        Student st1 = new Student(studentIds[0], 38);
        Student st2 = new Student(studentIds[1], 38);
        Student st3 = new Student(studentIds[2], 38);

        // spy Hospital.isolation() function, because original isolation function need to wait 14 days
        doNothing().when(spyHospital).isolation(any(Student.class));
        // set spy Hospital
        softwareTesting2021.setHospital(spyHospital);
        // Set Thursday
        when(mockDate.getWeekday()).thenReturn(5);
        softwareTesting2021.date = mockDate;

        // 3 students enter class and Hospital shall record their studentid.
        softwareTesting2021.enterClass(st1);
        softwareTesting2021.enterClass(st2);
        softwareTesting2021.enterClass(st3);

        // Verify student id stored patientLog in hospital
        ArrayList patientLog = spyHospital.getLog();
        for (int i = 0;i < studentIds.length;i++) {
            assertEquals(studentIds[i], patientLog.get(i));
        }
    }

    @Test
    public void test_d() {
        int stub_score = 100;
        // mock database
        NYCUDatabase mockNYCUDatabase = mock(NYCUDatabase.class);
        // set getScore() stub method in database
        when(mockNYCUDatabase.getScore(anyString())).thenReturn(stub_score);
        softwareTesting2021.MyDatabase = mockNYCUDatabase;
        // verify stub successfully
        assertEquals(stub_score, softwareTesting2021.getScore(feverStudent.getStudentId()));
    }

    @Test
    public void test_e() {
        String expected_result = "Thank you";
        fakePaypalService m_fakePaypalService = new fakePaypalService();

        assertEquals(expected_result, softwareTesting2021.donate(m_fakePaypalService));
    }

    public class fakePaypalService implements paypalService {
        public String doDonate() {
            return "successed";
        }
    }
}
