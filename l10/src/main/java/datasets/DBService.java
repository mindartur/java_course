package datasets;

import java.util.List;

public interface DBService {
    String getLocalStatus();

    void save(AssessmentDataset dataSet);

    void save(UserDataset dataSet);

    UserDataset readUser(long id);

    AssessmentDataset readAssessment(long id);

    UserDataset readUserByName(String name);

    List<UserDataset> readAllUsers();

    List<AssessmentDataset> readAllAssessments();

    void shutdown();
}