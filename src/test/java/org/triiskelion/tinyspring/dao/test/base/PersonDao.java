package org.triiskelion.tinyspring.dao.test.base;

import org.triiskelion.tinyspring.dao.AbstractDao;

/**
 * @author Sebastian MA
 */
public class PersonDao extends AbstractDao<Person> {

	@Override
	protected Class<Person> getEntityClass() {

		return Person.class;
	}

}
