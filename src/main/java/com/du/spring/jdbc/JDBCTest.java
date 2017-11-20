package com.du.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {

    private ApplicationContext ctx = null;
    private JdbcTemplate jdbcTemplate;
    private EmployeeDao employeeDao;
    private DepartmentDao departmentDao;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    {
        ctx = new ClassPathXmlApplicationContext("applicationJDBC.XML");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        employeeDao = ctx.getBean(EmployeeDao.class);
        departmentDao = ctx.getBean(DepartmentDao.class);
        namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
    }

    /**
     * 使用具名参数时，可以使用update(String sql, SqlParameterSource paramSource) 方法进行操作
     * 1.Sql语句中的参数名和类的属性一致
     * 2.使用BeanPropertySqlParameterSource作为参数
     */
    @Test
    public void testNamedParameterJdbcTemplate2(){
        String sql = "INSERT INTO tbl_employee (last_name,gender,email,dept_id) VALUES(:lastName, :gender, :email, :deptId)";
        Employee employee = new Employee();
        employee.setLastName("XYZ");
        employee.setGender(0);
        employee.setEmail("XYZ@qq.com");
        employee.setDeptId(2);

        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(employee);
        namedParameterJdbcTemplate.update(sql, parameterSource);
    }

    /**
     * 可以为参数起名字，由 ？变成了 :name
     * 好处：若有多个参数，则不用再去对于位置，直接对应参数名即可，便于维护
     * 缺点：较为麻烦
     */
    @Test
    public void testNamedParameterJdbcTemplate(){
        String sql = "INSERT INTO tbl_employee (last_name,gender,email,dept_id) VALUES(:lastname, :gender, :email, :deptid)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("lastname","CC");
        paramMap.put("gender", 1);
        paramMap.put("email", "CC@163.com");
        paramMap.put("deptid", 2);
        namedParameterJdbcTemplate.update(sql, paramMap);

    }

    @Test
    public void testDepartmentDao(){
        Department department = departmentDao.get(1);
        System.out.println(department);
    }

    @Test
    public void testEmployeeDao(){
        Employee emp = employeeDao.getEmpById(1);
        System.out.println(emp);
    }

    /**
     * 获取单个列的值，或统计查询
     */
    @Test
    public void testQueryForObject2(){
        String sql = "SELECT count(id) FROM tbl_employee";
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);

    }

    /**
     * 查询实体类集合
     */
    @Test
    public void testQueryForList(){
        String sql = "SELECT id, last_name lastName, gender, email FROM tbl_employee WHERE id > ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        List<Employee> employees = jdbcTemplate.query(sql, rowMapper, 5);
        for(Employee employee:employees){
            System.out.println(employee);
        }
    }

    /**
     * 从数据库中获取一条记录，实际得到对应的一个对象
     * 1、RowMapper指定如何去映射结果集，常用的实现类为BeanPropertyRowMapper
     * 2、通过使用SQL列的别名，来实现列名与类的属性名的映射，例如last_name lastName
     * 3、不支持级联属性。
     */
    @Test
    public void testQueryForObject(){
        String sql = "SELECT id, last_name lastName, gender, email FROM tbl_employee WHERE id=?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);
        System.out.println(employee);

    }

    /**
     * 执行批量更新：insert，update，delete
     */
    @Test
    public void testBatchUpdate(){
        String sql = "INSERT INTO tbl_employee (last_name,gender,email,dept_id) VALUES(?,?,?,?)";
        List<Object[]> batchArgs = new ArrayList<>();

        batchArgs.add(new Object[]{"AA","0","AA@126.COM",1});
        batchArgs.add(new Object[]{"BB","1","BB@126.COM",2});

        jdbcTemplate.batchUpdate(sql,batchArgs);
    }


    /**
     * 执行insert，update，delete
     */
    @Test
    public void testUpdate(){
        String sql = "UPDATE tbl_employee SET last_name=? WHERE id=?";
        jdbcTemplate.update(sql, "lixue22", 6);
    }


    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
