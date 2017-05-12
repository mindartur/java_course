package mysql;

/**
 * Created by artur on 11/05/17.
 */

public class UsersDataset {
    private long id;
    private String name;

    public UsersDataset(long id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public long getId() {
        return id;
    }
}

