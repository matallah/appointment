package sbs.service;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import sbs.model.AbstractModel;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractService<T extends AbstractModel<Long>, Long extends Serializable> {

    static final int PAGE_SIZE = 5;

    protected abstract JpaRepository<T, Long> getRepository();

    public Page<T> getListPage(Integer pageNumber) {
        PageRequest pageRequest =
                new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "id");

        return getRepository().findAll(pageRequest);
    }

    public List<T> getListOfSchools() {
        List<T> all = getRepository().findAll();
        return all;
    }

    public List<T> getList() {
        List<T> all = getRepository().findAll();
//        all.stream().filter(t -> SCHOOL != null).filter(t -> t.getSchoolId().getId() != SCHOOL.getId()).forEach(all::remove);
        return all;
    }

    public T save(T entity) {
        return getRepository().save(entity);
    }

    public T get(Long id) {
        T entity = getRepository().findOne(id);
        return entity;
    }

    public void delete(Long id) {
        try {
            getRepository().delete(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

    public void update(T entity) {
        T getEntity = getRepository().findOne(entity.getId());
        getRepository().save(entity);
    }

}