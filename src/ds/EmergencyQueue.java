package ds;

import models.Patient;

public class EmergencyQueue {
    
    // Node class for Queue
    private class Node {
        Patient patient;
        Node next;

        public Node(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private Node front, rear;

    public EmergencyQueue() {
        this.front = this.rear = null;
    }

    // Enqueue - add a patient to the waiting queue
    public void enqueue(Patient patient) {
        Node newNode = new Node(patient);

        // Queue is empty
        if (this.rear == null) {
            this.front = this.rear = newNode;
            return;
        }

        this.rear.next = newNode;
        this.rear = newNode;
    }

    // Dequeue - remove the next patient for treatment
    public Patient dequeue() {
        // Appropriate handling of an empty queue
        if (this.front == null) {
            System.out.println("Queue is empty. No patients waiting.");
            return null;
        }

        Patient patient = this.front.patient;
        this.front = this.front.next;

        if (this.front == null) {
            this.rear = null;
        }

        return patient;
    }

    // Display all patients currently waiting
    public void displayQueue() {
        if (this.front == null) {
            System.out.println("Queue is empty. No patients waiting.");
            return;
        }

        Node current = this.front;
        System.out.println("--- Waiting Patients (FIFO) ---");
        while (current != null) {
            System.out.println(current.patient.toString());
            current = current.next;
        }
    }
}