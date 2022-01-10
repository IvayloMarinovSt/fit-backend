package de.fhswf.fit.repositories;

import jakarta.ejb.Local;
import jakarta.ejb.Remote;

import java.util.List;

public interface Repository<T>
{
    T create(T entity);

    T delete(T entity);

    T update(T entity);

    T findById(Long id);

    List<T> findAll();
}
