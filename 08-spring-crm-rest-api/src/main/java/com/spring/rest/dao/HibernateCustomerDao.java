package com.spring.rest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.IntegerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.rest.entity.Customer;
import com.spring.rest.sorting.SortOrder;

@Repository
public class HibernateCustomerDao implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createNativeQuery("SELECT * FROM customer", Customer.class).getResultList();
	}
	
	@Override
	public List<Customer> getAll(SortOrder sortOrder) {
		// sortOrder#sortParams{new SortParam(first_name, true), new SortParam(last_name, false)}
		Session session = sessionFactory.getCurrentSession();
		
		return session.createNativeQuery("SELECT * FROM customer" + sortOrder.getSqlOrder(),Customer.class)
				.getResultList();
	}
	
	@Override
	public List<Customer> getAll(SortOrder sortOrder, int offset, int recordsPerPage) {
		final String sql = "SELECT * FROM customer " + sortOrder.getSqlOrder() + " LIMIT :offset, :rowcount";
		return sessionFactory.getCurrentSession()
					.createNativeQuery(sql, Customer.class)
					.setParameter("offset", offset, IntegerType.INSTANCE)
					.setParameter("rowcount", recordsPerPage, IntegerType.INSTANCE)
					.getResultList();
	}
	
	@Override
	public int countTotalRecords() {
		Session session = sessionFactory.getCurrentSession();
		// INT >>> BigInteger
		// Number >>> BigDecimal
		return (int)session.createNativeQuery("SELECT COUNT(*) counter FROM customer")
					.addScalar("counter", IntegerType.INSTANCE)
					.uniqueResult();
	}
	
	@Override
	public Customer get(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}
	
	@Override
	public void save(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}
	
	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM Customer WHERE id = :id")
				      .setParameter("id", id)
				      .executeUpdate();
	}
	
	@Override
	public List<Customer> search(String keyword) {
		// search by firstName || lastName with case insensitive
		Session session = sessionFactory.getCurrentSession();
		
		// additional: mark insensitive
		String sql = "SELECT * FROM customer \n"
				+ "WHERE first_name LIKE :keyword\n"
				+ "OR last_name LIKE :keyword";
		
		return session.createNativeQuery(sql, Customer.class)
			   .setParameter("keyword", "%" + keyword + "%")
			   .getResultList();
	}

}
