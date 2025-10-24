# 📝 Textual Note Manager

## 📌 Objective
The **Textual Note Manager** is a simple Java console-based application built to understand **persistent data handling** using file operations.  
It allows users to **create, read, update, delete, and list** text-based notes, all stored persistently on disk using **FileWriter** and **FileReader**.

This project’s main goal is to help learn:
- How to read and write data from files in Java.
- How to maintain persistent data across program runs.
- Basic CRUD (Create, Read, Update, Delete) operations in a real-world context.

---

## ⚙️ Implementation Details

### **1. Core Classes**
- **`Note.java`** – Represents a single note with a title, content, and timestamp.
- **`NoteManager.java`** – Handles all core operations:
    - Create a note and store it as a `.txt` file.
    - Read existing notes using `BufferedReader`.
    - Update or overwrite note content.
    - Delete notes from the directory.
    - List all available notes.
- **`Main.java`** – Provides a text-based user menu for interacting with the Note Manager.

---

### **2. File Handling**
This project uses Java’s **File I/O API**:
- `FileWriter` for writing note data.
- `FileReader` and `BufferedReader` for reading notes.
- `File` class for checking existence, deleting, and listing notes.

All notes are stored in a **`notes/`** directory inside the project root.  
Each note is saved as a separate `.txt` file with its title as the filename.

---

### **3. Features**
| Feature | Description |
|----------|--------------|
| ✏️ Create Note | Add new notes with title and content |
| 📖 Read Note | Display note content from file |
| 🔁 Update Note | Modify and overwrite existing notes |
| ❌ Delete Note | Remove notes permanently |
| 📂 List Notes | View all saved notes |

