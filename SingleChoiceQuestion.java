package com.company;

import java.util.ArrayList;

//This question will only accept one answer from student
public class SingleChoiceQuestion implements Question {

    private String question;
    private String questionType;
    private ArrayList<String> answer = new ArrayList<>();

    public void setQuestionType() {
        this.question = null;
        this.answer = null;
        questionType = "Single Choice";
    }

    public SingleChoiceQuestion(String question, ArrayList<String> answer) {
        this.question = question;
        for (String s : answer) {
            assert false;
            this.answer.add(s);
        }
        questionType = "Single Choice";
    }

    @Override
    public String getQuestionType() {
        return questionType;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public void setQuestion(String str) {
        question = str;
    }

    public ArrayList<String> getAnswer() {
        return answer;
    }

    public void setAnswer(ArrayList<String> answer) {
        for (String s : answer) {
            assert false;
            this.answer.add(s);
        }
    }
}
