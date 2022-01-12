package de.fhswf.fit.repositories;

import de.fhswf.fit.model.Image;
import jakarta.ejb.Stateless;
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
public class ImageRepository
//      extends AbstractRepository<Image>
{
    @PersistenceContext
    EntityManager entityManager;

    public Image create(Image entity)
    {
        entityManager.persist(entity);
        return entity;
    }


    public Image delete(Image entity)
    {
        entity = entityManager.merge(entity);
        entityManager.remove(entity);
        return entity;
    }


    public Image update(Image entity)
    {
        entityManager.merge(entity);
        return entity;
    }


    public Image findById(Long id)
    {
        return entityManager.find(Image.class, id);
    }


    public List<Image> findAll()
    {

//        return entityManager.createQuery(
//                    "Select t from" + Image.class.getSimpleName() + " t")
//              .getResultList();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Image> criteriaQuery = criteriaBuilder.createQuery(Image.class);
        Root<Image> root = criteriaQuery.from(Image.class);
        criteriaQuery.select(root);
        TypedQuery<Image> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
