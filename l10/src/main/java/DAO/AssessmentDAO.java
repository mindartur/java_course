package DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import datasets.AssessmentDataset;

/**
 * Created by artur on 12/05/17.
 */
public class AssessmentDAO {
    private Session session;

    public AssessmentDAO(Session session) {
        this.session = session;
    }

    public void save(AssessmentDataset dataSet) {
        session.save(dataSet);
        session.close();
    }

    public AssessmentDataset read(long id) {
        return session.load(AssessmentDataset.class, id);
    }

    public AssessmentDataset readById(long id) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<AssessmentDataset> criteria = builder.createQuery(AssessmentDataset.class);
        Root<AssessmentDataset> from = criteria.from(AssessmentDataset.class);
        criteria.where(builder.equal(from.get("id"), id));
        Query<AssessmentDataset> query = session.createQuery(criteria);
        return query.uniqueResult();
    }

    public List<AssessmentDataset> readAll() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<AssessmentDataset> criteria = builder.createQuery(AssessmentDataset.class);
        criteria.from(AssessmentDataset.class);
        return session.createQuery(criteria).list();
    }
}