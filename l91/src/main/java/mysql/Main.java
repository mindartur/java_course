package mysql;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by artur on 11/05/17.
 */
// SET GLOBAL time_zone = '+1:00';

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conn = ConnectionHelper.getConnection("test", "artur", "artur");
        SimpleExecutor exec = new SimpleExecutor(conn);

        try {
            exec.execUpdate("create table users1 (id bigint auto_increment, user_name varchar(256), primary key (id))");
        } catch (Exception e) {
            System.out.println("Tables already exists");
        }

        try {
            exec.execUpdate("create table courses (id bigint auto_increment, course_name varchar(256), " +
                    "course_desc varchar(256), primary key (id));");
        } catch (Exception e) {
            System.out.println("Tables already exists");
        }

        exec.execUpdate("insert into users1 (user_name) values ('tully')");
        exec.execUpdate("insert into users1 (user_name) values ('artur')");
        exec.execUpdate("insert into users1 (user_name) values ('vova')");

        exec.execUpdate("insert into courses (course_name, course_desc) values ('Java', 'Java course')");
        exec.execUpdate("insert into courses (course_name, course_desc) values ('SQL', 'SQL course')");

        exec.execQuery("select * from users1", new ResultHandler() {

            public void handle(ResultSet result) throws SQLException {
                while (true) {
                    result.next();
                    System.out.println(new UsersDataset(result.getInt(1),
                            result.getString("user_name")));
                    if (result.isLast())
                        break;
                }
            }
        });

        exec.execUpdate("drop table users1");
        exec.execUpdate("drop table courses");

        System.out.println("Done!");

        conn.close();




    }
}
