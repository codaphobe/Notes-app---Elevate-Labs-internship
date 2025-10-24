import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Note {

    private String title;
    private String content;
    private String createdAt;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("hh:mm dd/MM/yyyy"));
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
