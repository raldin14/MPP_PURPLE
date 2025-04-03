package edu.miu.lab2.prob2A;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Haining Song");
        GradeReport report = student.getReport();

        System.out.println(report);
        System.out.println("Report's student: " + report.getStudent());
    }
}
