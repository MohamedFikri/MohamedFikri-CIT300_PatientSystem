package ds;

import models.Visit;

public class VisitHistoryList {
    
    // Node class for Singly Linked List
    private class Node {
        Visit visit;
        Node next;

        public Node(Visit visit) {
            this.visit = visit;
            this.next = null;
        }
    }

    private Node head;

    public VisitHistoryList() {
        this.head = null;
    }

    // Adding a new visit to the patient's history
    public void addVisit(Visit visit) {
        Node newNode = new Node(visit);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Visit added successfully.");
    }

    // Removing a visit
    public void removeVisit(int visitId) {
        if (head == null) {
            System.out.println("No visit history to remove.");
            return;
        }

        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            System.out.println("Visit removed successfully.");
            return;
        }

        Node current = head;
        while (current.next != null && current.next.visit.getVisitId() != visitId) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Visit removed successfully.");
        } else {
            System.out.println("Visit ID not found.");
        }
    }

    // Searching for a visit
    public void searchVisit(int visitId) {
        Node current = head;
        while (current != null) {
            if (current.visit.getVisitId() == visitId) {
                System.out.println("Visit found: " + current.visit.toString());
                return;
            }
            current = current.next;
        }
        System.out.println("Visit ID not found.");
    }

    // Displaying the patient's visit history
    public void displayHistory() {
        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }

        Node current = head;
        System.out.println("--- Patient Visit History ---");
        while (current != null) {
            System.out.println(current.visit.toString());
            current = current.next;
        }
    }
}