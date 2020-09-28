package com.company;

import java.util.ArrayList;
import java.util.Hashtable;

//This class calculate the vote and output the result
public class VotingService {
    private String questionType;
    private ArrayList<String> answers;
    private Question question;
    private ArrayList<Integer> freq = new ArrayList<>();

    public VotingService(String type, ArrayList<String> answers, Question question)
    {
        questionType = type;
        this.answers = answers;
        this.question = question;
    }

    //This method will count the number of student voted for each candidate answers
    public void submit(ArrayList<Student> s){
        if(questionType.equals("Multiple Choice")) {

            //initialize array, so later instead of add we can use set
            freq.add(0);
            freq.add(0);
            freq.add(0);
            freq.add(0);
            int a = 0, b = 0, c=0, d=0;
            for (int i = 0; i < s.size(); i++) //get Student
            {
                for (int j = 0; j < s.get(i).getSelectedAnswer().size(); j++) //get ArrayList<String> answers
                {
                    String str = s.get(i).getSelectedAnswer().get(j); //getting individual values from the answers
                    if (str.equals("Choice A"))
                        a++;
                    if (str.equals("Choice B"))
                        b++;
                    if (str.equals("Choice C"))
                        c++;
                    if (str.equals("Choice D"))
                        d++;
                }
            }
            //Using set, when student resubmit, changes will be added
            freq.set(0,a);
            freq.set(1,b);
            freq.set(2,c);
            freq.set(3,d);
        }

        if(questionType.equals("Single Choice"))
        {
            //initialize array, so later instead of add we can use set
            freq.add(0);
            freq.add(0);
            int t=0, f=0;
            for (int i = 0; i < s.size(); i++) //get Student
            {
                for (int j = 0; j < s.get(i).getSelectedAnswer().size(); j++) //get ArrayList<String> answers
                {
                    String str = s.get(i).getSelectedAnswer().get(j); //getting individual values from the answers
                    if (str.equals("1. True"))
                        t++;
                    if (str.equals("2. False"))
                        f++;
                }
            }
            //Using set, when student resubmit, changes will be added
            freq.set(0,t);
            freq.set(1,f);
        }
    }

    //Print out the result/headcount for each candidate answers
    public void printStat()
    {
       for (int i = 0; i < answers.size(); i++) //get Student
           System.out.println(answers.get(i) +": "+ freq.get(i));

    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }
}
