/*
 * Feng Ru Yang
 * Professor Sun Yu
 * CS 3560. 01
 * 29 September 2020
 */

package com.company;

import java.util.ArrayList;
import java.util.Random;

//This driver program will perform a hard code example on the two type of question
public class SimulationDriver {

    public static void main(String[] args) {

        System.out.println("\nThis is iVote Simulator\n");

        System.out.println("Multiple Choice Question\n");

        //hardcode candidate answers
        ArrayList<String> multAnswers = new ArrayList<>();

        multAnswers.add("Choice A");
        multAnswers.add("Choice B");
        multAnswers.add("Choice C");
        multAnswers.add("Choice D");

        //hardcode question
        MultipleChoiceQuestion question1 = new MultipleChoiceQuestion("This is a multiple choice question", multAnswers);

        //creating voting service for the multiple choice question
        VotingService mult = new VotingService("Multiple Choice", multAnswers, question1);


        //Creating random number of students
        Random random = new Random();

        //Generate at most 50 students
        int random1 = random.nextInt(50);

        System.out.println("Number of Students: " + random1 +"\n");
        ArrayList<Student> students = new ArrayList<>(random1);


        //student id will be the index number, and random answer generated
        for(int i=0; i<random1; i++) {
            Student a = new Student(i, generateMulAnswer());
            students.add(a);
        }
        //submit to Voting Service
        mult.submit(students);

        System.out.println("\nBefore resubmit\n");
        for(int i=0; i<students.size(); i++) {
            Student a = students.get(i);
            System.out.println("Student "+a.getId() + ": " + a.getSelectedAnswer().toString());
        }

        //randomly select 2 student to resubmit.
        System.out.println();
        int count1 = 0;
        while(count1<2) {
            int random2 = random.nextInt(students.size());

            Student a = students.get(random2);
            System.out.println("Student "+a.getId() + " resubmitted.");

            //once selected, clear the previous answers and senerate new one.
            a.clearSelectiveAnswer();
            a.setSelectedAnswer(generateMulAnswer());
            count1++;
        }
        System.out.println();

        //resubmit
        mult.submit(students);

        System.out.println("After resubmit\n");
        for(int i=0; i<students.size(); i++) {
            Student a = students.get(i);
            System.out.println("Student "+a.getId() + ": " + a.getSelectedAnswer().toString());
        }

        //output the result
        System.out.println("Total for Multiple Choice: \n");
        mult.printStat();

//------------ SINGLE CHOICE QUESTION TEST---------------

        //hardcode question ans answers
        System.out.println("\nSingle Choice Question\n");
        ArrayList<String> sigAnswers = new ArrayList<>();

        sigAnswers.add("1. True");
        sigAnswers.add("2. False");

        SingleChoiceQuestion question2 = new SingleChoiceQuestion("This is a single choice question", sigAnswers);

        //create new VotingService for the question type
        VotingService sig = new VotingService("Single Choice", sigAnswers, question2);

        //Clear all the answers the student selected from the previous question
        //then, select new answer.
        for(int j=0; j<students.size(); j++) {
            students.get(j).clearSelectiveAnswer();
            students.get(j).setSelectedAnswer(generateSigAnswer());
        }

        //submit answer to teh VotingService
        sig.submit(students);

        System.out.println("Before resubmit\n");
        for(int i=0; i<students.size(); i++) {
            Student a = students.get(i);
            System.out.println("Student "+a.getId() + ": " + a.getSelectedAnswer().toString());
        }

        //Sekect random student for resubmission
        System.out.println();
        int count2 = 0;
        while(count2<2) {
            int random3 = random.nextInt(students.size());

            Student a = students.get(random3);
            System.out.println("Student "+a.getId() + " resubmitted.");

            a.clearSelectiveAnswer();
            a.setSelectedAnswer(generateSigAnswer());
            count2++;
        }
        System.out.println();

        //submit answer to teh VotingService
        sig.submit(students);

        System.out.println("After resubmit\n");
        for(int i=0; i<students.size(); i++) {
            Student a = students.get(i);
            System.out.println("Student "+a.getId() + ": " + a.getSelectedAnswer().toString());
        }

        //Displace result
        System.out.println("Total for Single Choice: \n");
        sig.printStat();
    }

    //This will generate random answer once
    private static ArrayList<String> generateSigAnswer()
    {
        Random random = new Random();
        ArrayList<String> selectedAnswers = new ArrayList<>();
        int random1 = random.nextInt(2);
        if(random1 == 0)
            selectedAnswers.add("1. True");
        else
            selectedAnswers.add("2. False");
        return selectedAnswers;
    }

    //This will generate random answer, and by chance generate mutiple answers for a student
    private static ArrayList<String> generateMulAnswer(){
        Random random = new Random();
        ArrayList<String> selectedAnswers = new ArrayList<>();
        addAnswer(selectedAnswers);
        int random1 = random.nextInt(2);
        int count = 0;

        // 50% chance the student will select another answer for the mutiple choice question
        while(count < 3) {
            if (random1 == 1) {
                addAnswer(selectedAnswers);
            }
            count++;
            random1 = random.nextInt(2);
        }
        return selectedAnswers;
    }

    //This method will randomly add a answer that are not chosen before
    private static void addAnswer(ArrayList<String> selectedAnswers){
        Random random = new Random();
        int random1 = random.nextInt(4);
        if(random1 == 0 && noDuplicate(selectedAnswers, "Choice A"))
            selectedAnswers.add("Choice A");
        else if(random1 == 1 && noDuplicate(selectedAnswers, "Choice B"))
            selectedAnswers.add("Choice B");
        else if(random1 == 2 && noDuplicate(selectedAnswers, "Choice C"))
            selectedAnswers.add("Choice C");
        else if(random1 == 3 && noDuplicate(selectedAnswers, "Choice D"))
            selectedAnswers.add("Choice D");
    }

    //check if the answers array contains the given string
    private static boolean noDuplicate(ArrayList<String> selectedAnswer, String str)
    {
        boolean noRepeat = true;
        for(int i=0; i<selectedAnswer.size();i++)
        {
            if(selectedAnswer.get(i).equals(str))
                noRepeat = false;
        }
        return noRepeat;
    }
}
