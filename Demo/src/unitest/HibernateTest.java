package unitest;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

import Models.SalesOrder;
import Models.Station;
import Models.Ticket;

public class HibernateTest {

	public static void main(String[] args) {
		Session session = InitSession();
//		Transaction tx = session.beginTransaction();
//		session.save(CreateOrder());
//		tx.commit();

		try {

			// from后面是对象，不是表名
			String hql = "from SalesOrder as SalesOrder where SalesOrder.code=:code";

			Query query = session.createQuery(hql);

			query.setString("code", "TestSalesOrder");

			List<SalesOrder> list = query.list();

			for (SalesOrder so : list) {

				System.out.println(so.getIdCard());
			}

		} finally {

			if (session != null)

				session.close();
		}

	}

	private static SalesOrder CreateOrder() {
		SalesOrder order = new SalesOrder();
		// order.setOrderId(100);
		order.setCode("TestSalesOrder");

		for (int i = 0; i < 100; i++) {
			Ticket ticket = new Ticket();
			ticket.setIdCard("371203");
			order.bookTicket(ticket);
		}
		return order;
	}

	private static Session InitSession() {
		Configuration configuration = new Configuration()
				.addAnnotatedClass(SalesOrder.class)
				.addAnnotatedClass(Ticket.class)
				.addAnnotatedClass(Station.class);

		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		return session;
	}

}
