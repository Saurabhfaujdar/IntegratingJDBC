package org.example.Model;


public class ProblemModel {
    private int id;
    private String problemName;
    private String authorName;

    public ProblemModel() {

    }

    public ProblemModel(int id, String problemName, String authorName) {
        this.id = id;
        this.problemName = problemName;
        this.authorName = authorName;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ProblemModel{" +
                "id=" + id +
                ", problemName='" + problemName + '\'' +
                ", authorName='" + authorName + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProblemName() {
        return problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
