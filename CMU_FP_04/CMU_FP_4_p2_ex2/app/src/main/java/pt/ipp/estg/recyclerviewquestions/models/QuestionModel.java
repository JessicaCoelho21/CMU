package pt.ipp.estg.recyclerviewquestions.models;

import java.io.Serializable;

public class QuestionModel implements Serializable {
    private String title;
    private String description;
    private String answer;
    private String status;

    public QuestionModel(String title, String description, String answer, String status) {
        this.title = title;
        this.description = description;
        this.answer = answer;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
