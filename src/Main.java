import ds.PatientBST;
import ds.EmergencyQueue;
import ds.TreatmentStack;
import ds.VisitHistoryList;
import models.Patient;
import models.Visit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientBST bst = new PatientBST();
        EmergencyQueue queue = new EmergencyQueue();
        TreatmentStack stack = new TreatmentStack();
        VisitHistoryList history = new VisitHistoryList();

        while (true) {
            System.out.println("\n===== MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM =====");
            System.out.println("1. Insert New Patient (BST)");
            System.out.println("2. Search Patient by ID (BST)");
            System.out.println("3. Delete Patient by ID (BST)");
            System.out.println("4. Display All Patients (BST In-Order)");
            System.out.println("5. Add Patient to Emergency Queue");
            System.out.println("6. Treat Next Patient (Dequeue)");
            System.out.println("7. Display Waiting Queue");
            System.out.println("8. Add Completed Treatment (Stack)");
            System.out.println("9. View Last Treatment (Stack Pop)");
            System.out.println("10. Add Visit to History (Linked List)");
            System.out.println("11. Display Visit History (Linked List)");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");
            
            // இனி எல்லா input-um String-ஆ படிக்கும், பிறகு எண்ணாக மாத்தும்
            String choiceInput = sc.nextLine();
            int choice = 0;
            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number only.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID (Number only): ");
                    int id = Integer.parseInt(sc.nextLine());
                    
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    
                    System.out.print("Enter Age (Number only): ");
                    int age = Integer.parseInt(sc.nextLine());
                    
                    System.out.print("Enter Contact Number: ");
                    String contact = sc.nextLine();
                    
                    System.out.print("Enter Medical Condition: ");
                    String condition = sc.nextLine();
                    
                    bst.insert(new Patient(id, name, age, contact, condition));
                    System.out.println("Patient added successfully!");
                    break;
                case 2:
                    System.out.print("Enter Patient ID to search (Number only): ");
                    int searchId = Integer.parseInt(sc.nextLine());
                    Patient found = bst.search(searchId);
                    if (found != null) System.out.println("Patient Found: " + found);
                    else System.out.println("Patient not found.");
                    break;
                case 3:
                    System.out.print("Enter Patient ID to delete (Number only): ");
                    int deleteId = Integer.parseInt(sc.nextLine());
                    bst.delete(deleteId);
                    System.out.println("Delete operation completed.");
                    break;
                case 4:
                    bst.inOrder();
                    break;
                case 5:
                    System.out.print("Enter Patient ID to add to Queue (Number only): ");
                    int qId = Integer.parseInt(sc.nextLine());
                    Patient qPatient = bst.search(qId);
                    if (qPatient != null) {
                        queue.enqueue(qPatient);
                        System.out.println("Patient added to Emergency Queue.");
                    } else {
                        System.out.println("Patient ID not found in records!");
                    }
                    break;
                case 6:
                    Patient treated = queue.dequeue();
                    if (treated != null) System.out.println("Now treating: " + treated.getName());
                    break;
                case 7:
                    queue.displayQueue();
                    break;
                case 8:
                    System.out.print("Enter Visit ID (Number only): ");
                    int vId = Integer.parseInt(sc.nextLine());
                    
                    System.out.print("Enter Date: ");
                    String date = sc.nextLine();
                    
                    System.out.print("Enter Doctor Name: ");
                    String doc = sc.nextLine();
                    
                    System.out.print("Enter Diagnosis: ");
                    String diag = sc.nextLine();
                    
                    System.out.print("Enter Treatment given: ");
                    String treat = sc.nextLine();
                    
                    stack.push(new Visit(vId, date, doc, diag, treat));
                    System.out.println("Treatment record pushed!");
                    break;
                case 9:
                    Visit lastTreat = stack.pop();
                    if (lastTreat != null) System.out.println("Last Treatment removed: " + lastTreat);
                    break;
                case 10:
                    System.out.print("Enter Visit ID (Number only): ");
                    int hId = Integer.parseInt(sc.nextLine());
                    
                    System.out.print("Enter Date: ");
                    String hDate = sc.nextLine();
                    
                    System.out.print("Enter Doctor Name: ");
                    String hDoc = sc.nextLine();
                    
                    System.out.print("Enter Diagnosis: ");
                    String hDiag = sc.nextLine();
                    
                    System.out.print("Enter Treatment: ");
                    String hTreat = sc.nextLine();
                    
                    history.addVisit(new Visit(hId, hDate, hDoc, hDiag, hTreat));
                    break;
                case 11:
                    history.displayHistory();
                    break;
                case 12:
                    System.out.println("Exiting system. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}