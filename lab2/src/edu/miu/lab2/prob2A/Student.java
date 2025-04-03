package edu.miu.lab2.prob2A;

public class Student {

    private String name;

    private GradeReport report;

    public Student(String name) {
        this.name = name;
        this.report = new GradeReport(this);
    }

    public String getName() {
        return name;
    }

    public GradeReport getReport() {
        return report;
    }

    @Override
    public String toString() {
        return "Student: " + name;
    }
}
