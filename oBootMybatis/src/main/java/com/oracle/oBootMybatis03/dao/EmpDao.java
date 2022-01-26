package com.oracle.oBootMybatis03.dao;

import java.util.List;

import com.oracle.oBootMybatis03.model.Dept;
import com.oracle.oBootMybatis03.model.Emp;
import com.oracle.oBootMybatis03.model.EmpDept;

public interface EmpDao {
	int       	total();
	// 다형성 오버로딩!
	List<Emp> 	  listEmp(Emp emp);
	List<EmpDept> listEmp(EmpDept empDept);
	//
	Emp 		detail(int empno);
	int 		update(Emp emp);
	List<Emp>   listManager();
	int         insert(Emp emp);
	int         delete(int empno);
	String      deptName(int deptno);

}
