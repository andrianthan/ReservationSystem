# Airline Reservation System - CS151 Fall 2024

## Overview

This is the **Airline Reservation System** project. The system is designed to handle airplane seat reservations for both **public users** and **administrators**. Users can sign up, sign in, make seat reservations, view their reservations, and cancel bookings. Administrators can view the manifest of all reservations and manage the system.


### Objectives
- Apply software development techniques, including requirement analysis, design, and implementation.
- Use **Use Cases**, **CRC Cards**, **UML Class Diagrams**, and **UML Sequence Diagrams**.
- Implement command-line arguments and file handling.
  
---

## Features

### 1. Program Execution and Command Line Arguments
- The program should be executed with two command-line arguments:
  - Reservation file (e.g., `CL34`)
  - User information file (e.g., `Users`)

- If the files do not exist, the program creates them and informs the user.
- Data from these files will be loaded at the start and saved when the admin exits.

#### Command-Line Example:
```bash
java ReservationSystem CL34 Users
