package edu.miu.lab2.prob2A;

public class Student {
    private GradeReport report;

    public Student() {
        report = new GradeReport(this); // create GradeReport at the time of Student creation
    }

    public GradeReport getReport() {
        return report;
    }

    @Override
    public String toString() {
        return "Student@" + Integer.toHexString(hashCode());
    }
}
