# Library_Management

---

# 📚 Java Library Management System

A simple **console-based Library Management System** built in Java that supports admin and user roles. This project manages books, members, borrowing, and returning features using basic Java OOP concepts and collections.

---

## ✅ Features

### 👩‍💼 Admin

* Login with a default admin username and password
* Add, update, or remove books
* Add or remove members
* View all books and members

### 👤 User

* Login or auto-register with a username
* Borrow and return books (max 5 per user)
* View available books

---

## 🔧 Technologies Used

* Java (Core)
* Collections (ArrayList)
* OOP (Classes, Objects, Methods)
* Scanner for input

---

## 🏁 How to Run

1. Copy all three classes (`Main`, `Book`, and `Member`) into the same package or folder.
2. Compile the code:

   ```bash
   javac Main.java Book.java Member.java
   ```
3. Run the program:

   ```bash
   java Main
   ```

---

## 🔐 Admin Credentials

* **Username**: `admin`
* **Password**: `Password`

---

## 🗂 Project Structure

```
Main.java     --> Main class with all program logic
Book.java     --> Class to represent a book
Member.java   --> Class to represent a library member
```

---

## 🌟 Highlights

* Role-based access (admin vs user)
* Input handled with Java's `Scanner`
* Book availability and borrowing limits enforced
* Dynamic member creation on user login

---

## 📌 To Improve (Optional Ideas)

* Add persistent storage using file or database
* Implement book search/filter by genre or author
* GUI with JavaFX or Swing

---
