package com.mreapps.diceit.engine.dao.impl;

import com.mreapps.diceit.engine.entity.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class AbstractDao<T extends BaseEntity>
{
    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<T> entityClass;

    protected AbstractDao(Class<T> entityClass)
    {
        this.entityClass = entityClass;
    }

    protected void save(T entity)
    {
        if (entity.getId() == null)
        {
            entityManager.persist(entity);
        } else
        {
            entityManager.merge(entity);
        }
    }

    protected List<T> listAll()
    {
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        final CriteriaQuery<T> cq = cb.createQuery(entityClass);
        final Root<T> root = cq.from(entityClass);
        cq.select(root);

        return entityManager.createQuery(cq).getResultList();
    }

    protected void delete(Integer id)
    {
        T entity = entityManager.find(entityClass, id);
        if (entity != null)
        {
            entityManager.remove(entity);
        }
    }
}
