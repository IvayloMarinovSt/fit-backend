package de.fhswf.fit.repositories;

import de.fhswf.fit.model.Product;
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
public class ProductRepository
//      extends AbstractRepository<Product>
{
    @PersistenceContext
    EntityManager entityManager;

    public Product create(Product entity)
    {
        entityManager.persist(entity);
        return entity;
    }


    public Product delete(Product entity)
    {
        entity = entityManager.merge(entity);
        entityManager.remove(entity);
        return entity;
    }


    public Product update(Product entity)
    {
        entityManager.merge(entity);
        return entity;
    }


    public Product findById(Long id)
    {
        return entityManager.find(Product.class, id);
    }


    public List<Product> findAll()
    {

//        return entityManager.createQuery(
//                    "Select t from" + Product.class.getSimpleName() + " t")
//              .getResultList();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);
        criteriaQuery.select(root);
        TypedQuery<Product> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
