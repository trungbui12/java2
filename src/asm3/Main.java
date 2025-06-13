package asm3;

import dao.ResultDAO;
import entity.Result;
import factory.DaoFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ResultDAO dao = DaoFactory.createResultDAO();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter mark: ");
        double mark = sc.nextDouble();
        System.out.print("Enter student ID: ");
        int studentId = sc.nextInt();
        System.out.print("Enter subject ID: ");
        int subjectId = sc.nextInt();

        // Create
        Result r = new Result(mark, studentId, subjectId);
        dao.create(r);
        System.out.println("Result added.");

        // Read All
        System.out.println("List of all results:");
        for (Result res : dao.all()) {
            System.out.printf("ID: %d | Mark: %.2f | Student ID: %d | Subject ID: %d\n",
                res.getId(), res.getMark(), res.getStudentId(), res.getSubjectId());
        }
    }
}
