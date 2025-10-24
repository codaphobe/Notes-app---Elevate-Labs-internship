import java.io.*;
import java.util.Date;

public class NotesManager {

    final String notesDir = "notes";

    public NotesManager(){
        File dir = new File(notesDir);
        if (!dir.exists()) dir.mkdir();
    }


    //Create notes
    public void createNote(Note note)  {
        try(FileWriter fw = new FileWriter(notesDir+"/"+note.getTitle()+".txt")){
            fw.write("Title : "+note.getTitle()+"\n");
            fw.write("Created at: "+note.getCreatedAt()+"\n");
            fw.write(note.getContent());
            System.out.println("Note Successfully saved");
        }catch(IOException e){
            System.err.println("Unable to create a note "+e.getMessage());
        }
    }

    //Reading notes
    public void readNote(String title){
        File file = new File(notesDir+"/"+title+".txt");
        if(!file.exists()){
            System.err.println("No file found by that name");
            return;
        }
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            System.out.println("---------------Note---------------");
            while((line=br.readLine()) != null){
                System.out.println(line);
            }
            System.out.println("---------------End---------------");
            br.close();
            fr.close();
        }catch (IOException e){
            System.out.println("Error fetching the file "+e.getMessage());
        }
    }

    //Updating notes
    public void updateNote(String title, String newContent){
        File file = new File(notesDir+"/"+title+".txt");
        if(!file.exists()){
            System.err.println("No file found by that name");
            return;
        }
        try(FileWriter fw = new FileWriter(file)){
            fw.write("Title: "+title);
            fw.write("CreatedAt : "+new Date());
            fw.write(newContent);
            System.out.println("Note updated successfully");
        }
        catch (IOException e){
            System.out.println("Error updating the file "+e.getMessage());
        }
    }

    //Delete a note
    public void deleteNote(String title){
        File file = new File(notesDir+"/"+title+".txt");
        if(file.exists() && file.delete()){
            System.out.println("File deleted successfully");
        }else{
            System.err.println("Error deleting the file");
        }
    }

    public void listAllNotes(){
        File folder = new File(notesDir);
        String[] files = folder.list((dir, name)-> name.endsWith(".txt"));


        if (( files == null || files.length==0)){
            System.err.println("No notes found");
            return;
        }
        System.out.println("----------------Saved Notes----------------");
        for(String file : files){
            System.out.println("\t- "+file.replace(".txt",""));
        }
    }
}
