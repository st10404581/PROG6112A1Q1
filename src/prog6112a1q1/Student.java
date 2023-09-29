/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog6112a1q1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hameed
 */
public class Student {

    //DECLAIRING ARRALISTS TO HOLD ALL OF THE STUDENT INFORMATION. ARRAYLISTS 
    //ARE USED AS WE DO NOT KNOW HOW MANY STUDENTS THE USER WILL BE ADDING 
    public static ArrayList<String> studentName = new ArrayList<>();
    public static ArrayList<String> studentEmail = new ArrayList<>();
    public static ArrayList<String> studentCourse = new ArrayList<>();
    public static ArrayList<String> studentAge = new ArrayList<>();
    public static ArrayList<String> studentID = new ArrayList<>();

    public static Scanner kb = new Scanner(System.in);

    //THIS METHOD IS USED TO EXIT THE PROGRAM
    public void ExitStudentApplication() {
        System.exit(0);
    }

    //THIS METHOD IS USED TO SAVE THE DATA IT GETS FROM THE MAIN CLASS IN 
    //ITS RESPECTIVE ARRAYS
    public String SaveStudent(String studName, String studEmail, String studCourse, String studAge, String studID) {
        studentName.add(studName);
        studentEmail.add(studEmail);
        studentCourse.add(studCourse);
        studentAge.add(studAge);
        studentID.add(studID);
        //SHOWS THE USER THAT THE DATA HAS BEEN SUCCESSFULLY CAPTURESDD
        String output = "Student details captured successfully!";
        return output;
    }

    //THIS METHOD IS USED TO VALIDATE AN AGE THAT HAS BEEN PASSED INTO IT. THIS 
    //METHOD RETURNS A BOOLEAN VALUE, TRUE IS ITS A VLAID AGE AND FALSE IF IT 
    //ISNT A VLAID AGE
    public boolean validStudentAge(String studAge) {
        //DETERMINES THE OVERALL VALIDITY OF THE AGE
        boolean overallValid = false;
        //CHECKS IF THE AGE IS ONLY NUMBERS
        boolean charCheck = false;
        //CHECKS THE RANGE OF THE CHECK
        boolean ageRangeCheck = false;
        //THIS TRY AND CATCH STATEMENT TRIES TO MAKE THE STRING INTO AN INTEGER, 
        //IF IT DOES SO THEN THE charCheck IS TRUE ELSE ITS FALSE
        try {
            Integer.parseInt(studAge);
            charCheck = true;

        } catch (Exception e) {
            charCheck = false;
        }

        //THIS NESTED IF STATEMENT FIRST CHECKS IF charCheck iD TRUE THEN IT 
        //PROCEEDS TO THE OTHER IF STATEMETN WHICH TURNS THE AGE INTO AN INTEGER 
        //AND CHECKS IF ITS EQUAL TOO OR GRATED THAN 16. IF IT IS THEN 
        //ageRangeCheck IS TRUE ELSE IT IS FALSE
        if (charCheck) {
            if (Integer.parseInt(studAge) >= 16) {
                ageRangeCheck = true;
            }
        }

        //THIS IF STATEMENT CHECKS IF BOTH ageRangeCheck AND charCheck ARE TURE 
        //THEN overallValid BECOMES TRUE ELSE IT REMAINS FLASE
        if (ageRangeCheck && charCheck) {
            overallValid = true;
        }
        //RETURNING A BOOLEAN VALUE
        return overallValid;
    }
    
    //THIS METHOD GETS A VALUE PASSED INTO IT called searchID
    //IT THEN USES THIS VARAIBLE TO SEARCH FOR THE CONTENTS OF THE VARAIBLE IN THE ARRAYLIST studentID
    //IT THEN RETURNS A BOOLEAN VALUE, true IF THE ARRAYLIST CONTAINS THE VARIABLE AND false IF IT DOESNT
    public boolean SearchStudent(String searchID){
        boolean studFound = studentID.contains(searchID);
        return studFound;
    }

    //THIS METHOD IS USED TO UPDATE THE INFORMATION ON THE SPECIFIC STUDENT 
    //WHOS STUDENT ID THE USER HAS ENTERED
    public String UpdateStudentInfo() {
        String returnMsg, searchUpdateID;
        System.out.println("Enter in the Student's ID to update: ");
        searchUpdateID = kb.next();

        System.out.println("-------------------------------------------------------------------");
        returnMsg = "-------------------------------------------------------------------";

        //THIS IF STATEMNET CHCEKS IF THE STUDENT ID THAT THE USER HAS ENTERED 
        //IS STORED. IF IT IS FOUND THEN IT PROMPTS THE USER TO ENTER THE 
        //UPDATED INFORMATION ON THE STUDENT. IF IT IS FALSE THEN IT OUTPUTS 
        //AN APPROPRITAE MSG
        if (studentID.contains(searchUpdateID)) {
            String updateName, updateAge, updateEmail, updateCourse;

            int indexFound = studentID.indexOf(searchUpdateID);

            System.out.println("Enter Updated Name: ");
            updateName = kb.next();
            studentName.set(indexFound, updateName);

            System.out.println("Enter Updated Age: ");
            updateAge = kb.next();

            //WHIS IF STATEMENT TESTS IF THE AGE IS VALID IF THE AGE IS INVALID 
            //THEN A WHILE LOOP IS EXECUTED WHICH KEEPS ON LOOPING INPUT FROM 
            //THE UNER UNTIL THEY ENTER A VALID AGE
            if (!validStudentAge(updateAge)) {
                while (!validStudentAge(updateAge)) {
                    System.out.println("You have entered a incorrect student age!!\nPlease re-enter the student age >>");
                    updateAge = kb.next();
                    validStudentAge(updateAge);
                }//END OF WHILE LOOP
            }//END OF IF STATEMENT
            studentAge.set(indexFound, updateAge);

            System.out.println("Enter Updated Email: ");
            updateEmail = kb.next();
            studentEmail.set(indexFound, updateEmail);

            System.out.println("Enter Updated Course: ");
            updateCourse = kb.next();
            studentCourse.set(indexFound, updateCourse);

            returnMsg = returnMsg + "\nUpdates applied successfully!\n-------------------------------------------------------------------";
        } else {
            returnMsg = returnMsg + "\nStudent with Student ID " + searchUpdateID + " was not found!\n-------------------------------------------------------------------";
        }//END OF IF STATEMENT
        //RETURNING AN APPROPRIATE MESSAGE BASED ON THE IF STATEMENT
        return returnMsg;
    }

    //THIS METHOD GETS INPUT FROM THE MAIN CLASS AND THEN EXECUTES THE 
    //APPROPRIATE CODE BASED ON THE DATA PASSED INTO IT
    public String DeleteStudent(String studID) {
        //deleteFound IS USED TO TEST IF THE ID THAT THE USER ENTERED EXISTS 
        //IN THE ARRAY
        boolean deleteFound = studentID.contains(studID);
        String displayMsg;
        //THIS IF STATEMENT DETERMINES WEITHER STUDENT DETAILS SHOULD BE DELETED 
        //IF deleteFound IS TRUE OR IF A MESAGE TELLING THE USER THAT THE STUDENT 
        //WITH THE ID THEY ENTERED DOES NOT EXIST IF deleteFound = false
        if (deleteFound) {
            int foundIndex = studentID.indexOf(studID);
            studentAge.remove(foundIndex);
            studentCourse.remove(foundIndex);
            studentEmail.remove(foundIndex);
            studentID.remove(foundIndex);
            studentName.remove(foundIndex);
            displayMsg = "Student with Student id: " + studID + " WAS deleted!";
        } else {
            displayMsg = "Student with Student id: " + studID + " was not found!";
        }
        //RETURNING AN APPROPRIATE MESSAGE BASED ON THE IF STATEMENT
        return displayMsg;
    }

    //THIS METHOD IS USED TO GENERATE A REPORT WHICH DISPLAYS ALL OF THE 
    //STUDENTS DETIALS
    public void StudentReport() {
        int studCount = 1;
        System.out.println("-------------------------------------------------");
        //THIS FOR LOOP LOOPS OUTPUT AND
        for (int i = 0; i < studentID.size(); i++) {
            System.out.println("STUDENT " + studCount);
            System.out.println("-------------------------------------------------");
            System.out.println("STUDENT ID: " + studentID.get(i)
                    + "\nSTUDENT NAME: " + studentName.get(i)
                    + "\nSTUDENT AGE: " + studentAge.get(i)
                    + "\nSTUDENT EMAIL: " + studentEmail.get(i)
                    + "\nSTUDENT COURSE: " + studentCourse.get(i));
            System.out.println("-------------------------------------------------");
            //INCREMENTING studCount FOR EACH TIME THIS FOR LOOP ITTERATES
            studCount++;
        }//END OF FOR LOOP
    }// END OF StudentReport
}
