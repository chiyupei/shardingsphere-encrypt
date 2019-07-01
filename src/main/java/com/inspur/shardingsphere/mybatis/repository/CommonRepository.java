package com.inspur.shardingsphere.mybatis.repository;

import java.util.List;

public interface CommonRepository<T, P> {
    
    /**
     * Create table if not exist.
     */
    void createTableIfNotExists();
    
    /**
     * Drop table.
     */
    void dropTable();
    
    /**
     * Truncate table.
     */
    void truncateTable();
    
    /**
     * insert one entity.
     * @param entity entity
     * @return count or primary key
     */
    Long insert(T entity);
    
    /**
     * Do delete.
     * @param key key
     */
    void delete(P key);
    
    /**
     * select all.
     * @return list of entity
     */
    List<T> selectAll();
}
