package com.du.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class DepartmentDao extends JdbcDaoSupport{

    @Autowired
    public void setDateSource2(DataSource dataSource){
        setDataSource(dataSource);
    }

    public Department get(Integer id){
        String sql = "SELECT id, dept_name deptName FROM tbl_dept WHERE id=?";
        RowMapper<Department> rowMapper = new BeanPropertyRowMapper<>(Department.class);
        Department department = getJdbcTemplate().queryForObject(sql, rowMapper, 1);
        return department;
    }
}
