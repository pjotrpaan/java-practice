/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.jpa.test.criteria.limitExpression;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.jpa.test.BaseEntityManagerFunctionalTestCase;

import org.hibernate.testing.TestForIssue;
import org.hibernate.testing.transaction.TransactionUtil;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * @author Andrea Boriero
 */

public class LimitExpressionTest extends BaseEntityManagerFunctionalTestCase {

	@Override
	protected Class<?>[] getAnnotatedClasses() {
		return new Class[] {Person.class};
	}

	@Test
	@TestForIssue(jiraKey = "HHH-11278")
	public void testAnEmptyListIsReturnedWhenSetMaxResultsToZero() {
		TransactionUtil.doInJPA( this::entityManagerFactory, (EntityManager entityManager) -> {
			final CriteriaQuery<Person> query = entityManager.getCriteriaBuilder().createQuery( Person.class );
			query.from( Person.class );
			final List list = entityManager.createQuery( query ).setMaxResults( 0 ).getResultList();
			assertTrue( "The list should be empty with setMaxResults 0", list.isEmpty() );
		} );
	}

	@Before
	public void prepareTest() throws Exception {
		TransactionUtil.doInJPA( this::entityManagerFactory, entityManager -> {
			Person p = new Person();
			entityManager.persist( p );
		} );
	}

	@Entity(name = "Person")
	public static class Person {
		@Id
		@GeneratedValue
		private Long id;
	}
}
