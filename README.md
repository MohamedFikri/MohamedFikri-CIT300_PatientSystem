# CIT300 Patient Management System

## Student Information
- **Name:** Fikry
- **Student ID:** 23da2-0681
- **Module:** CIT300 - Data Structures and Algorithms

## Project Overview
This is a Java-based Patient Management System developed for the CIT300 assignment. The system efficiently manages hospital patient data by implementing four core data structures:

- **Binary Search Tree (BST)** - Maintains patient records sorted by Patient ID for fast search, insert, and delete operations.
- **Queue (FIFO)** - Manages the emergency patient waiting list, ensuring patients are treated on a first-come, first-served basis.
- **Stack (LIFO)** - Stores completed treatment histories, allowing quick access to the most recent records.
- **Singly Linked List** - Tracks each patient's previous hospital visits, enabling dynamic addition and removal of visit records.

## How to Run the Program
1. Clone this repository to your local machine.
2. Open the project in VS Code or any Java IDE.
3. Navigate to the `src` folder and open `Main.java`.
4. Compile and run the `Main.java` file.
5. Follow the console menu prompts to interact with the system.

## Features Implemented
### 1. Patient Records (BST)
- Insert a new patient
- Search for a patient using Patient ID
- Delete a patient
- Display all patients in ascending order of ID (In-order Traversal)

### 2. Emergency Queue
- Enqueue patients to the waiting list
- Dequeue patients for treatment (FIFO)
- Display current waiting list
- Handles empty queue gracefully

### 3. Treatment History (Stack)
- Push completed treatment records
- Pop the most recent treatment record (LIFO)
- Display all treatment records
- Handles empty stack gracefully

### 4. Visit History (Singly Linked List)
- Add a new visit to a patient's history
- Remove a specific visit using Visit ID
- Search for a visit by ID
- Display full visit history for a patient

## Project Structure