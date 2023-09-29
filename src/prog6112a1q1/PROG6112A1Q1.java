/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog6112a1q1;

import java.util.Scanner;
import static prog6112a1q1.Student.kb;
import static prog6112a1q1.Student.studentAge;
import static prog6112a1q1.Student.studentCourse;
import static prog6112a1q1.Student.studentEmail;
import static prog6112a1q1.Student.studentID;
import static prog6112a1q1.Student.studentName;

/**
 *
 * @author Hameed
 */
public class PROG6112A1Q1 {

    /**
     * @param args the command line arguments
     */
    //CREATING A PUBLIC SCANNER OBJECT SO IT CAN BE USED THROUGHTOUT THE PROGRAM 
    //AND NOT NEEDING TO BE CREATED FOR EACH METHOD THAT USESES SCANNER
    public static Scanner kb = new Scanner(System.in);

    public static Student stud = new Student();

    //CREATING A GLOBAL VARIABLE FOR TAKING IN THE USER'S CHOICE ON MENUS TO 
    //MINIMIZE THE AMOUNT OF VARAIBLES CREATED FOR THAT PURPOSE
    public static String userInput;

    //CREATING GLOBAL VARAIBLES FOR PASSING THE VALID INPUT TO THE Student CLASS 
    //TO ADD TO THE ARRAY LISTS FOR STORAGE
    public static String globalStudentID;
    public static String globalName;
    public static String globalAge;
    public static String globalEmail;
    public static String globalCourse;

    public static void main(String[] args) {
        /*
        References:
        https://www.geeksforgeeks.org/system-exit-in-java/
        https://www.youtube.com/watch?v=1XAfapkBQjk&ab_channel=CodingwithJohn
        https://www.tutorialspoint.com/how-do-you-search-for-an-element-in-an-arraylist-in-java#:~:text=Java%20List%20provides%20a%20method,object%20is%20present%20or%20not.
        https://www.tutorialspoint.com/how-to-remove-an-element-from-arraylist-in-java
         */
        displayStartMenu();
        chooseStartMenu();
    }//END OF MAIN

    public static void displayStartMenu() {
        //THIS METHOD JUST DISPLAYS THE TEXT THAT IS SHOWN AT THE VERY BEGINING 
        //OF THE PROGRAM
        System.out.println("""
                           STUDENT MANAGEMENT APPLICATION
                           ***********************************************""");
    }//END OF displayStartMenu

    public static void chooseStartMenu() {
        // THIS METHOD IS USED TO ASK THE USER IF THEY WANT TO DISPLAY THE MENU 
        //OR EXIT THE PROGRAM
        System.out.println("Enter (1) to launch the menu or any other key to exit");
        userInput = kb.next();

        if (userInput.equals("1")) {
            displayMenu();
        } else {
            System.out.println("You have chosen to exit the Program\nTerminating program...");
            stud.ExitStudentApplication();
        }//END OF IF STATEMENT
    }//END OF chooseStartMenu

    public static void displayMenu() {
        int studentUserInput = 0;

        // isValidInput IS USED TO DETERMINE WEITHER THE INPUT THAT THE USER HAS 
        //ENTERED IS A CORRECT MENU OPTION, IF ITS VALID = true IF NOT = false
        //isValidInput IS ALSO INITIALISED TO HAVE true
        boolean isValidInput = true;

        System.out.println("""
                           Please select from the following menu items:
                            (1) Capture a new student.
                            (2) Search for a student.
                            (3) Delete a student.
                            (4) Print student report.
                            (5) Update Student Information.
                            (6) Exit application.""");
        studentUserInput = kb.nextInt();

        if ((studentUserInput != 1) && (studentUserInput != 2) && (studentUserInput != 3) && (studentUserInput != 4) && (studentUserInput != 5) && (studentUserInput != 6)) {
            isValidInput = false;
        }//END OF IF STATEMENT

        //THIS WHILE LOOP IS USED TO REPEATEDLY GET INPUT FROM THE USER WHILE 
        //isValid IS FALSE
        while (isValidInput == false) {
            System.out.println("""
                               Error.... Please choose from the following:
                               (1) Capture a new student.
                               (2) Search for a student.
                               (3) Delete a student.
                               (4) Print student report.
                               (5) Exit application.""");
            studentUserInput = kb.nextInt();

            //THIS IF STATEMENT IS USED TO CHANGE isValid TO TRUE IF CORRECT 
            //INPUT IS ENTERED, EXITING THE WHILE LOOP
            if ((studentUserInput == 1) || (studentUserInput == 2) || (studentUserInput == 3) || (studentUserInput == 4) || (studentUserInput == 5) || (studentUserInput == 6)) {
                isValidInput = true;
            }//END OF IF STATEMENT
        }//END OF WHILE STATEMENT

        //THIS IF STATEMENT EXECUTES IF isValid IS TRUE AND CONTAINS A SWITCH 
        //STATEMENT THAT RUNS THE APPROPRIATE CODE BASED ON THE USER'S INPUT
        if (isValidInput == true) {
            switch (studentUserInput) {
                case 1:
                    System.out.println("You have chosen to create a new Student Profile");
                    captureNewStudent();
                    stud.SaveStudent(globalName, globalEmail, globalCourse, globalAge, userInput);
                    chooseStartMenu();
                    break;
                case 2:
                    System.out.println("You have chosen to Search for a Student");
                    System.out.println(SearchStudent());
                    chooseStartMenu();
                    break;
                case 3:
                    System.out.println("You have chosen to Delete a Student's Profile");
                    deleteStudent();
                    chooseStartMenu();
                    break;
                case 4:
                    System.out.println("You have chosen to Print a Student's Report");
                    stud.StudentReport();
                    chooseStartMenu();
                    break;
                case 5:
                    System.out.println("You have chosen to Update a Student's Information");
                    System.out.println(stud.UpdateStudentInfo());
                    chooseStartMenu();
                    break;
                case 6:
                    System.out.println("You have chosen to exit the Program\nTerminating program...");
                    stud.ExitStudentApplication();
                    break;
                default:
                    throw new AssertionError();
            }//END OF SWITCH CASE
        }//END OF IF STATEMENT
    }//END OF displayMenu

    public static void captureNewStudent() {
        //THIS METHOD FOCUSES ON GETTING DATA FROM THE USER AND SAVING IT IN 
        //THE Student CLASS
        System.out.println("""
                           CAPTURE A NEW STUDENT
                           ************************************
                           Enter the student id: """);
        globalStudentID = kb.next();
        System.out.println("Enter the student name: ");
        globalName = kb.next();
        System.out.println("Enter the student age: ");
        globalAge = kb.next();
        //CHECKING THE VALIDATION OF THE AGE. IF validStudentAge RETURNS FLASE 
        //THEN A WHILE LOOP IS EXECUTED WHICH WILL KEEP ON PRIMMING INPUT FROM 
        //THE USER UNTIL THEY ENTER A VALID AGE
        if (!stud.validStudentAge(globalAge)) {
            while (!stud.validStudentAge(globalAge)) {
                System.out.println("You have entered a incorrect student age!!\nPlease re-enter the student age >>");
                globalAge = kb.next();
                stud.validStudentAge(globalAge);
            }//END OF WHILE LOOP
        }//END OF IF STATEMENT
        System.out.println("Enter the student email: ");
        globalEmail = kb.next();
        System.out.println("Enter the student course: ");
        globalCourse = kb.next();
        //SAVING ALL THE DETAILS IN THE Student CLASS
        stud.SaveStudent(globalName, globalEmail, globalCourse, globalAge, globalStudentID);
        chooseStartMenu();
    }// END OF captureNewStudent

    public static void deleteStudent() {
        //THIS METHOD IS USED TO GET THE STUDENT'S ID WHOS DETAILS THE USER 
        //WANTS TO DELETE AND THE CONFIRMATION IF THEY DO WANT TO DELETE IT
        String deleteID, confirmationInput;
        //GETTING THE ID OF THE STUDENT THE USER WANTS TO DELETE
        System.out.println("Enter the student id to delete: ");
        deleteID = kb.next();
        //GETTING CONFIRMATION FROM THE USER IF THEY WANT TO DELETE A USER
        System.out.println("Are you sure you want to delete student " + deleteID + " from the system? Yes (y) to delete.");
        confirmationInput = kb.next();
        System.out.println("-------------------------------------------------");
        //THIS IF STATEMENT CHCEKS IF THE USER HAS ENTERED 'y' TO DELETE THE 
        //STUDENT'S DETAILS
        if (confirmationInput.equals("y")) {
            //IF THEY ENTER 'y' THEN THE DeleteMethod FROM THE Student CLASS 
            //IS CALLED
            System.out.println(stud.DeleteStudent(deleteID) + "\n-------------------------------------------------");
        } else {
            //IF THEY ENTER ANYTHING ELSE THAN 'y' THE APPROPRITATE MSG IS 
            //DISPLAYED TELL THE USER THAT THEY HAVE ABORTED THE OPERATION
            System.out.println("Deleting Student was Aborted!\n-------------------------------------------------");
        }
    }// END OF deleteStudent

    public static String SearchStudent() {
        //GETTING INPUT FROM THE USER
        String searchID;
        System.out.println("Enter the student id to search: ");
        searchID = kb.next();
        
        String output;
        output = "-------------------------------------------------------------------";
        //THIS IF STATEMENT IS USED TO DETERMINE WHAT OUTPUT WILL BE SHOWN BASED 
        //ON THE BOOLEAN VARIABLE studFound. IF studFound IS TRUE THEN ALL THE 
        //DETAILS OF THE STUDENT WILL BE DISPLAYED. IF stud.SearchStudent IS FALSE THEN 
        //AN APPROPRIATE MESSAGE TELLING THE USER THAT THE STUDENT HAS NOT BEEN 
        //FOUND IS DISPLAYED
        if (stud.SearchStudent(searchID)) {
            int foundIndex = studentID.indexOf(searchID);
            output = output
                    + "\nSTUDENT ID: " + studentID.get(foundIndex)
                    + "\nSTUDENT NAME: " + studentName.get(foundIndex)
                    + "\nSTUDENT AGE: " + studentAge.get(foundIndex)
                    + "\nSTUDENT EMAIL: " + studentEmail.get(foundIndex)
                    + "\nSTUDENT COURSE: " + studentCourse.get(foundIndex)
                    + "\n-------------------------------------------------------------------";

        } else {
            output = output + "\nStudent with Student Id: " + searchID
                    + " was not found!\n-------------------------------------------------------------------";

        }
        //RETURNING AN APPROPRIATE MOUTPUT BASED ON THE IF STATEMENT
        return output;
    }

}//END OF PROG6112A1Q1
