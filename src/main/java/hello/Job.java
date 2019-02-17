package hello;

public class Job {

    private final long id;
    private final String content;

    public Job(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
