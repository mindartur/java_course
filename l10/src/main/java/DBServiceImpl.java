import DAO.AssessmentDAO;
import DAO.UserDAO;
import datasets.AssessmentDataset;
import datasets.DBService;
import datasets.UserDataset;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;
import java.util.function.Function;

/**
 * Created by artur on 12/05/17.
 */
public class DBServiceImpl  implements DBService {
    private SessionFactory sessionFactory;

    public DBServiceImpl() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(UserDataset.class);
        configuration.addAnnotatedClass(AssessmentDataset.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");
        configuration.setProperty("hibernate.connection.username", "artur");
        configuration.setProperty("hibernate.connection.password", "artur");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");
        configuration.setProperty("hibernate.connection.useSSL", "false");
        configuration.setProperty("hibernate.enable_lazy_load_no_trans", "true");

        sessionFactory = createSessionFactory(configuration);
    }

    public String getLocalStatus() {
        return runInSession(session -> {
            return session.getTransaction().getStatus().name();
        });
    }

    public void save(UserDataset dataSet) {
        try (Session session = sessionFactory.openSession()) {
            UserDAO dao = new UserDAO(session);
            dao.save(dataSet);
        }
    }

    public void save(AssessmentDataset dataSet) {
        try (Session session = sessionFactory.openSession()) {
            AssessmentDAO dao = new AssessmentDAO(session);
            dao.save(dataSet);
        }
    }


    public UserDataset readUser(long id) {
        return runInSession(session -> {
            UserDAO dao = new UserDAO(session);
            return dao.read(id);
        });
    }

    public AssessmentDataset readAssessment(long id) {
        return runInSession(session -> {
            AssessmentDAO dao = new AssessmentDAO(session);
            return dao.read(id);
        });
    }

    public UserDataset readUserByName(String name) {
        return runInSession(session -> {
            UserDAO dao = new UserDAO(session);
            return dao.readByName(name);
        });
    }

    public List<UserDataset> readAllUsers() {
        return runInSession(session -> {
            UserDAO dao = new UserDAO(session);
            return dao.readAll();
        });
    }

    public List<AssessmentDataset> readAllAssessments() {
        return runInSession(session -> {
            AssessmentDAO dao = new AssessmentDAO(session);
            return dao.readAll();
        });
    }

    public void shutdown() {
        sessionFactory.close();
    }

    private <R> R runInSession(Function<Session, R> function) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            R result = function.apply(session);
            transaction.commit();
            return result;
        }
    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
