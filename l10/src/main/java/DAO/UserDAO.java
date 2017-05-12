package DAO;

import datasets.UserDataset;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by artur on 12/05/17.
 */
public class UserDAO {
    private Session session;

    public UserDAO(Session session) {
        this.session = session;
    }

    public void save(UserDataset dataSet) {
        session.save(dataSet);
        session.close();
    }

    public UserDataset read(long id) {
        return session.load(UserDataset.class, id);
    }

    public UserDataset readByName(String name) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserDataset> criteria = builder.createQuery(UserDataset.class);
        Root<UserDataset> from = criteria.from(UserDataset.class);
        criteria.where(builder.equal(from.get("name"), name));
        Query<UserDataset> query = session.createQuery(criteria);
        return query.uniqueResult();
    }

    public UserDataset readById(long id) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserDataset> criteria = builder.createQuery(UserDataset.class);
        Root<UserDataset> from = criteria.from(UserDataset.class);
        criteria.where(builder.equal(from.get("id"), id));
        Query<UserDataset> query = session.createQuery(criteria);
        return query.uniqueResult();
    }

    public List<UserDataset> readAll() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserDataset> criteria = builder.createQuery(UserDataset.class);
        criteria.from(UserDataset.class);
        return session.createQuery(criteria).list();
    }
}
