package de.fhswf.fit.repositories;

import de.fhswf.fit.model.Category;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

@PersistenceUnit
@Stateless
//@Dependent
public class CategoryRepository
//      extends AbstractRepository<Category>
{
    @PersistenceContext
    EntityManager entityManager;

    public Category create(Category entity)
    {
        entityManager.persist(entity);
        return entity;
    }

    
    public Category delete(Category entity)
    {
        entity = entityManager.merge(entity);
        entityManager.remove(entity);
        return entity;
    }

    
    public Category update(Category entity)
    {
        entityManager.merge(entity);
        return entity;
    }

    
    public Category findById(Long id)
    {
        return entityManager.find(Category.class, id);
    }

    
    public List<Category> findAll()
    {

//        return entityManager.createQuery(
//                    "Select t from" + Category.class.getSimpleName() + " t")
//              .getResultList();
                CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
                CriteriaQuery<Category> criteriaQuery = criteriaBuilder.createQuery(Category.class);
                Root<Category> root = criteriaQuery.from(Category.class);
                criteriaQuery.select(root);
                TypedQuery<Category> query = entityManager.createQuery(criteriaQuery);
                return query.getResultList();
    }
}
