package com.company;

import java.util.ArrayList;

public class Student {
    private long id;
    private ArrayList<String> selectedAnswer;
    private boolean hasAnswered;

    public Student()
    {
        id = 0;
        selectedAnswer = new ArrayList<>();
        hasAnswered = false;
    }

    public Student(long id, ArrayList<String> selectedAnswer)
    {
        this.id = id;
        this.selectedAnswer = selectedAnswer;
        hasAnswered = true;

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

    public void setHasAnswered(boolean val)
    {
        hasAnswered = val;
    }

    public boolean isHasAnswered() {
        return hasAnswered;
    }

    public void clearSelectiveAnswer()
    {
        selectedAnswer.clear();
    }

}
