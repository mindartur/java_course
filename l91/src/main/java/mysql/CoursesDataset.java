package mysql;

/**
 * Created by artur on 11/05/17.
 */
public class CoursesDataset {
    private long id;
    private String name, description;

    public CoursesDataset(long id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public long getId() {
        return id;
    }
    public String getDescription() { return description; }
}