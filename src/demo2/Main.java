package demo2;

import dao.SubjectDAO;
import dao.SubjectDAOImpl;
import entity.Subject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SubjectDAO dao = new SubjectDAOImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. View all\n2. Add new\n3. Update\n4. Delete\n5. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    for (Subject s : dao.all()) {
                        System.out.println(s);
                    }
                    break;
                case 2:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Hours: ");
                    int hours = sc.nextInt();
                    System.out.print("Cost: ");
                    double cost = sc.nextDouble();
                    dao.create(new Subject(name, hours, cost));
                    break;
                case 3:
                    System.out.print("Enter ID to update: ");
                    int idUpdate = sc.nextInt();
                    sc.nextLine();
                    Subject su = dao.findById(idUpdate);
                    if (su != null) {
                        System.out.print("New name: ");
                        su.setName(sc.nextLine());
                        System.out.print("New hours: ");
                        su.setHours(sc.nextInt());
                        System.out.print("New cost: ");
                        su.setCost(sc.nextDouble());
                        dao.update(su);
                    } else {
                        System.out.println("Not found");
                    }
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int idDelete = sc.nextInt();
                    Subject sd = dao.findById(idDelete);
                    if (sd != null) {
                        System.out.println("Confirm delete " + sd.getName() + "? (yes/no)");
                        sc.nextLine();
                        if (sc.nextLine().equalsIgnoreCase("yes")) {
                            dao.delete(idDelete);
                        }
                    } else {
                        System.out.println("Not found");
                    }
                    break;
                case 5:
                    return;
            }
        }
    }
}
