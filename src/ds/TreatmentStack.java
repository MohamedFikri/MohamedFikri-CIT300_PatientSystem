package ds;

import models.Visit;

public class TreatmentStack {
    
    // Node class for Stack
    private class Node {
        Visit visit;
        Node next;

        public Node(Visit visit) {
            this.visit = visit;
            this.next = null;
        }
    }

    private Node top;

    public TreatmentStack() {
        this.top = null;
    }

    // Push - add a completed treatment record
    public void push(Visit visit) {
        Node newNode = new Node(visit);
        newNode.next = top;
        top = newNode;
    }

    // Pop - remove the most recently completed treatment record
    public Visit pop() {
        // Appropriate handling of an empty stack
        if (top == null) {
            System.out.println("Stack is empty. No treatments completed yet.");
            return null;
        }

        Visit visit = top.visit;
        top = top.next;
        return visit;
    }

    // Display treatment records
    public void displayStack() {
        // Appropriate handling of an empty stack
        if (top == null) {
            System.out.println("Stack is empty. No treatments completed yet.");
            return;
        }

        Node current = top;
        System.out.println("--- Completed Treatments (LIFO) ---");
        while (current != null) {
            System.out.println(current.visit.toString());
            current = current.next;
        }
    }
}