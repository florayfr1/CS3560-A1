package com.company;

import java.util.ArrayList;

public class MultipleChoiceQuestion implements Question {

    private String question;
    private String questionType;
    private ArrayList<String> answer = new ArrayList<>();

    public MultipleChoiceQuestion()
    {
        question = null;
        answer = new ArrayList<String>();
        questionType = "Multiple Choice";
    }

    public MultipleChoiceQuestion(String question, ArrayList<String> answer)
    {
        this.question = question;
        questionType = "Multiple Choice";
        for (String s : answer) {
            assert false;
            this.answer.add(s);
        }
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
