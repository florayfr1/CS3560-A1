package com.company;

import java.util.ArrayList;

//A Student object will contain the answer(s) selected and an id fo rthe student
public class Student {
    private long id;
    private ArrayList<String> selectedAnswer;

    public Student()
    {
        id = 0;
        selectedAnswer = new ArrayList<>();
    }

    public Student(long id, ArrayList<String> selectedAnswer)
    {
        this.id = id;
        this.selectedAnswer = selectedAnswer;
    }

    public Student(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<String> getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(ArrayList<String> answer) {
        for (String s : answer) {
            assert false;
            this.selectedAnswer.add(s);
        }
    }

    //This will clear all the answers the student selected
    public void clearSelectiveAnswer()
    {
        selectedAnswer.clear();
    }

}
