package ShoppingCartProject.Database;

import ShoppingCartProject.ShoppingCart.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class DatabaseConnection {

    public SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Customer.class);
            SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }
    public void storeData(Customer customer, SessionFactory sessionFactory) {
        Customer customer1 = new Customer(customer.getCustId(), customer.getCustName(),
                customer.getCustEmail(), customer.getCustMobile(), customer.getProductId(),
                customer.getProductName(), customer.getProductQuantity(),customer.getTotalCostOfProducts());


        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(customer);
                   session.getTransaction().commit();

        } catch(Exception e) {
            System.err.println("Error details ::" +e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    public void displayStoredData(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();

        try {
            String hql = "FROM Customer";
            Query query = session.createQuery(hql);
            List<Customer> customers = query.list();
            System.out.println(customers);


        } catch(Exception e) {
            System.err.println("Error details ::" +e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
