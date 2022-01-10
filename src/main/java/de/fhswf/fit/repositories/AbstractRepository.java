package de.fhswf.fit.repositories;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;


import java.lang.reflect.ParameterizedType;
import java.util.List;

@PersistenceUnit
@Stateless
public class AbstractRepository<T> implements Repository<T>
{
    private final Class<T> persistedClass;

    @PersistenceContext
    EntityManager entityManager;

    public AbstractRepository()
    {
        this.persistedClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T create(T entity)
    {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public T delete(T entity)
    {
        entity = entityManager.merge(entity);
        entityManager.remove(entity);
        return entity;
    }

    @Override
    public T update(T entity)
    {
        entityManager.merge(entity);
        return entity;
    }

    @Override
    public T findById(Long id)
    {
        return entityManager.find(persistedClass, id);
    }

    @Override
    public List<T> findAll()
    {

        return entityManager.createQuery(
                    "Select t from" + persistedClass.getSimpleName() + " t")
              .getResultList();
        //        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        //        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(T.class);
        //        Root<T> root = criteriaQuery.from(T.class);
        //        criteriaQuery.select(root);
        //        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        //        return query.getResultList();
    }
}
