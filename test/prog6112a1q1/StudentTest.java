/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package prog6112a1q1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hameed
 */
public class StudentTest {

    public StudentTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of SaveStudent method, of class Student.
     */
    @Test
    public void testSaveStudent() {
        System.out.println("SaveStudent");
        String studName = "B.Osas";
        String studEmail = "bosas@gmail.com";
        String studCourse = "BCAD";
        String studAge = "18";
        String studID = "112";
        Student instance = new Student();
        String expResult = "Student details captured successfully!";
        String result = instance.SaveStudent(studName, studEmail, studCourse, studAge, studID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validStudentAge method, of class Student.
     */
    @Test
    public void testStudentAge_StudentAgeValid() {
        System.out.println("validStudentAge_StudentAgeValid");
        String studAge = "16";
        Student instance = new Student();
        boolean expResult = true;
        boolean result = instance.validStudentAge(studAge);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validStudentAge method, of class Student.
     */
    @Test
    public void testStudentAge_StudentAgeInvalid() {
        System.out.println("validStudentAge_StudentAgeInvalid");
        String studAge = "15";
        Student instance = new Student();
        boolean expResult = false;
        boolean result = instance.validStudentAge(studAge);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validStudentAge method, of class Student.
     */
    @Test
    public void testStudentAge_StudentAgeInvalidCharacter() {
        System.out.println("validStudentAge");
        String studAge = "c";
        Student instance = new Student();
        boolean expResult = false;
        boolean result = instance.validStudentAge(studAge);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of SearchStudent method, of class Student.
     */
    @Test
    public void testSearchStudent() {
        System.out.println("SearchStudent");
        String searchID = "";
        Student instance = new Student();
        boolean expResult = false;
        boolean result = instance.SearchStudent(searchID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
        /**
     * Test of SearchStudent method, of class Student.
     */
    @Test
    public void testSearchStudent_NotFound() {
        System.out.println("SearchStudent_NotFound");
        String searchID = "113";
        Student instance = new Student();
        boolean expResult = false;
        boolean result = instance.SearchStudent(searchID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of DeleteStudent method, of class Student.
     */
    @Test
    public void testDeleteStudent() {
        System.out.println("DeleteStudent");
        String studID = "112";
        Student instance = new Student();
        String expResult = "Student with Student id: " + studID + " WAS deleted!";
        String result = instance.DeleteStudent(studID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of DeleteStudent method, of class Student.
     */
    @Test
    public void testDeleteStudent_StudentNotFound() {
        System.out.println("DeleteStudent_StudentNotFound");
        String studID = "113";
        Student instance = new Student();
        String expResult = "Student with Student id: " + studID + " was not found!";
        String result = instance.DeleteStudent(studID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
