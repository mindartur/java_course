import datasets.AssessmentDataset;
import datasets.DBService;
import datasets.UserDataset;

import java.util.List;

/**
 * Created by artur on 12/05/17.
 */
public class Main {
    public static void main (String[] args){
        DBService dbService = new DBServiceImpl();

        String status = dbService.getLocalStatus();
        System.out.println("Status: " + status);

        dbService.save(new UserDataset("tully", "tully@gmail.com", true));
        dbService.save(new UserDataset("artur", "mindartyr@gmail.com", false));


        List<UserDataset> dataSets = dbService.readAllUsers();
        for (UserDataset userDataSet : dataSets) {
            System.out.println(userDataSet);
            dbService.save(new AssessmentDataset(userDataSet, 5, AssessmentDataset.Status.OK));
        }

        List<AssessmentDataset> datasets = dbService.readAllAssessments();
        for (AssessmentDataset AssessmentDataSet : datasets) {
            System.out.println(AssessmentDataSet);
        }

        dbService.shutdown();

    }
}
