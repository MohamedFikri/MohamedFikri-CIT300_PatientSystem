package ds;

import models.Patient;

public class PatientBST {
    
    // Node class for BST
    private class Node {
        Patient patient;
        Node left, right;

        public Node(Patient patient) {
            this.patient = patient;
            left = right = null;
        }
    }

    private Node root;

    public PatientBST() {
        root = null;
    }

    // Insert a new patient
    public void insert(Patient patient) {
        root = insertRec(root, patient);
    }

    private Node insertRec(Node root, Patient patient) {
        if (root == null) {
            root = new Node(patient);
            return root;
        }
        if (patient.getPatientId() < root.patient.getPatientId())
            root.left = insertRec(root.left, patient);
        else if (patient.getPatientId() > root.patient.getPatientId())
            root.right = insertRec(root.right, patient);

        return root;
    }

    // Search for a patient using ID
    public Patient search(int id) {
        return searchRec(root, id);
    }

    private Patient searchRec(Node root, int id) {
        if (root == null || root.patient.getPatientId() == id)
            return (root != null) ? root.patient : null;

        if (id < root.patient.getPatientId())
            return searchRec(root.left, id);

        return searchRec(root.right, id);
    }

    // Delete a patient using ID
    public void delete(int id) {
        root = deleteRec(root, id);
    }

    private Node deleteRec(Node root, int id) {
        if (root == null) return root;

        if (id < root.patient.getPatientId())
            root.left = deleteRec(root.left, id);
        else if (id > root.patient.getPatientId())
            root.right = deleteRec(root.right, id);
        else {
            // node with only one child or no child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // node with two children: Get the inorder successor (smallest in the right subtree)
            root.patient = minValue(root.right);
            root.right = deleteRec(root.right, root.patient.getPatientId());
        }
        return root;
    }

    private Patient minValue(Node root) {
        Patient minv = root.patient;
        while (root.left != null) {
            minv = root.left.patient;
            root = root.left;
        }
        return minv;
    }

    // Perform in-order traversal to display patients in ascending order of ID
    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.patient.toString());
            inOrderRec(root.right);
        }
    }
}