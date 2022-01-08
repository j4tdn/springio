package com.java89.springbootwebappcrud.dao;

import com.java89.springbootwebappcrud.entity.Customer;
import com.java89.springbootwebappcrud.sorting.SortOrder;
import org.hibernate.Session;
import org.hibernate.type.IntegerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
@Primary
public class JpaCustomerDao implements CustomerDao {

	private EntityManager entityManager;

	@Autowired
	public JpaCustomerDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Customer> getAll() {
		System.out.println("hello");
		return entityManager.createNativeQuery("SELECT * FROM customer", Customer.class).getResultList();
	}

	@Override
	public List<Customer> getAll(SortOrder sortOrder) {
		// sortOrder#sortParams{new SortParam(first_name, true), new SortParam(last_name, false)}
		return entityManager.createNativeQuery("SELECT * FROM customer" + sortOrder.getSqlOrder(), Customer.class)
				.getResultList();
	}

	@Override
	public List<Customer> getAll(SortOrder sortOrder, int offset, int recordsPerPage) {
		// JPA has no setParameter(param, value, Type)
		final String sql = "SELECT * FROM customer " + sortOrder.getSqlOrder() + " LIMIT :offset, :rowcount";
		return entityManager.createNativeQuery(sql, Customer.class)
				.setParameter("offset", offset)
				.setParameter("rowcount", recordsPerPage)
				.getResultList();
	}

	@Override
	public int countTotalRecords() {
		System.out.println("JPACustomerDao: >>>>>>> countTotalRecords");
		Session session = entityManager.unwrap(Session.class);
		return (int) session.createNativeQuery("SELECT COUNT(*) counter FROM customer")
				.addScalar("counter", IntegerType.INSTANCE)
				.uniqueResult();
	}

	@Override
	public Customer get(int id) {
		return entityManager.find(Customer.class, id);
	}

	@Override
	public void save(Customer customer) {
		entityManager.merge(customer);
	}

	@Override
	public void delete(int id) {
		entityManager.createQuery("DELETE FROM Customer WHERE id = :id")
				.setParameter("id", id)
				.executeUpdate();
	}

	@Override
	public List<Customer> search(String keyword) {
		// search by firstName || lastName with case insensitive
		Session session = entityManager.unwrap(Session.class);

		// additional: mark insensitive
		String sql = "SELECT * FROM customer \n"
				+ "WHERE first_name LIKE :keyword\n"
				+ "OR last_name LIKE :keyword";

		return entityManager.createNativeQuery(sql, Customer.class)
				.setParameter("keyword", "%" + keyword + "%")
				.getResultList();
	}

}
