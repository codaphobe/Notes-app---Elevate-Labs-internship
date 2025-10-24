import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        NotesManager manager = new NotesManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== TEXTUAL NOTE MANAGER =====");
            System.out.println("1. Create Note");
            System.out.println("2. Read Note");
            System.out.println("3. Update Note");
            System.out.println("4. Delete Note");
            System.out.println("5. List Notes");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 : {
                    System.out.print("Enter note title: ");
                    String title = sc.nextLine();
                    System.out.println("Enter note content (end with a blank line):");
                    StringBuilder content = new StringBuilder();
                    String line;
                    while (!(line = sc.nextLine()).isEmpty()) {
                        content.append(line).append("\n");
                    }
                    manager.createNote(new Note(title, content.toString()));
                    break;
                }
                case 2 : {
                    System.out.print("Enter note title to read: ");
                    manager.readNote(sc.nextLine());
                    break;
                }
                case 3 : {
                    System.out.print("Enter note title to update: ");
                    String title = sc.nextLine();
                    System.out.println("Enter new content (end with a blank line):");
                    StringBuilder newContent = new StringBuilder();
                    String line2;
                    while (!(line2 = sc.nextLine()).isEmpty()) {
                        newContent.append(line2).append("\n");
                    }
                    manager.updateNote(title, newContent.toString());
                    break;
                }
                case 4 : {
                    System.out.print("Enter note title to delete: ");
                    manager.deleteNote(sc.nextLine());
                    break;
                }
                case 5 : manager.listAllNotes(); break;
                case 6 : {
                    System.out.println("👋 Exiting Note Manager. Goodbye!");
                    return;
                }
                default : System.out.println("Invalid choice. Try again!");
            }
        }
    }
}