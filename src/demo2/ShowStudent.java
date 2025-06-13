package demo2;

import dao.StudentDAOImpl;
import entity.Student;

import java.util.Scanner;

public class ShowStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAOImpl dao = new StudentDAOImpl();

        while (true) {
            System.out.println("\n=== STUDENT MANAGER ===");
            System.out.println("1. Update student");
            System.out.println("2. Delete student");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    // Sửa sinh viên
                    System.out.print("Enter student ID to update: ");
                    int idUpdate = Integer.parseInt(sc.nextLine());
                    Student sUpdate = dao.findById(idUpdate);
                    if (sUpdate == null) {
                        System.out.println("Student not found!");
                        break;
                    }
                    System.out.println("Current info: " + sUpdate);

                    System.out.print("Enter new name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter new age: ");
                    int age = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter new telephone: ");
                    String tel = sc.nextLine();

                    sUpdate.setName(name);
                    sUpdate.setAge(age);
                    sUpdate.setTelephone(tel);

                    if (dao.update(sUpdate)) {
                        System.out.println("Update successful.");
                    } else {
                        System.out.println("Update failed.");
                    }
                    break;

                case 2:
                    // Xoá sinh viên
                    System.out.print("Enter student ID to delete: ");
                    int idDelete = Integer.parseInt(sc.nextLine());
                    Student sDelete = dao.findById(idDelete);
                    if (sDelete == null) {
                        System.out.println("Student not found!");
                        break;
                    }
                    System.out.println("Student found: " + sDelete);
                    System.out.print("Type 'OK' to confirm deletion: ");
                    String confirm = sc.nextLine();
                    if (confirm.equalsIgnoreCase("OK")) {
                        if (dao.delete(idDelete)) {
                            System.out.println("Deleted successfully.");
                        } else {
                            System.out.println("Deletion failed.");
                        }
                    } else {
                        System.out.println("Deletion cancelled.");
                    }
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
