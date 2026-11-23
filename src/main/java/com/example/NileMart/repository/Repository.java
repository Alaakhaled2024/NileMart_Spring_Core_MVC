package com.example.NileMart.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T,ID > {
    public List<T> findAll();
   public Optional<T> findById(ID id);
    public T save(T entity);
}
