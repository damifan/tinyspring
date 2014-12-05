tinyspring
==========
###TinySpring is a set of tools for spring-mvc-JPA projects. It began when I wished to write a practical generic DAO class for my spring-mvc project.

###For now TinySpring contains three parts:

* A generic DAO class with helper methods to create queries more easily.

* Some view models to help organize your view objects.

* Some utilities missing from classic Apache Commons or Google Guava libraries (or I just don't know of, in this case please inform me ;] ). (Have been moved to tinyutils project in case of using it for JavaSE project)


# Usage

## Generic DAO

Assuming you have an Entity called `User` and you wish a DAO class to access `User`'s data from database.
You can simply create a `UserDao` class which extends `AbstractDao<User>` and implements the abastract method `getEntityClass()` in which returns the entity class we'd like to access:

    @Repository
    @Transactional
    public class UserDao extends AbstractDao<User> {
    
      	@Override
      	protected Class<User> getEntityClass() {
    
    		return User.class;
    	}
    }
    
Now we have our first DAO. It has already some out of box methods inherited from AbstractDao like `persist() merge() remove()
findById() findAll() totalCount()` etc.

If you wish to write customized queries, you can use `beginQuery()` to begin a method chain to help you make a JPA query more easily. 
Here's some examples:

If you wish to query from User with username 'bob':

    import static org.trii.tinyspring.dao.TinyPredicate.equal;
    
    User result = userDao.beginQuery().select()
                       .where(equal("username", "bob"))
                       .getFirstResult();

If you wish to authenticate user 'bob' with password '123456':

    boolean authSucess = userDao.beginQuery().select()
                              .where(equal("username","bob"))
                              .and(equal("password","123456"))
                              .hasResult();
                              
      boolean authSucess = userDao.beginQuery().select()
                              .where(and(equal("username", "bob"), equal("password", "123456")))
                              .hasResult();
                              
        boolean authSucess = userDao.beginQuery().select()
                              .where(equal("username", "bob").and(equal("password", "123456")))
                              .hasResult();
                              
All three syntax are valid.


If your query is very complex or you are JPQL export and you wish to write your JPQL directly:

    List<User> resultList = userDao.begeinQuery()
                                   .query("SELECT m FROM User m WHERE m.signInTime BETWEEN :a AND :b")
                                   .param("a", new Date("2014-07-01"))
                                   .param("b", new Date("2014-07-31"))
                                   .getResultList();
                                   

More demonstrations are coming.
