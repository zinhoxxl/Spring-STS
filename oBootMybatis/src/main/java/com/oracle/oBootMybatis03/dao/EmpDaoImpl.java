package com.oracle.oBootMybatis03.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.oBootMybatis03.model.Dept;
import com.oracle.oBootMybatis03.model.Emp;

@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	private SqlSession	session;
	
	@Override
	public int total() {
		int tot = 0;
		System.out.println("EmpDaoImpl Start total..." );
		
		// Result = > 14
		try {
			tot = session.selectOne("tkEmpTotal");
			System.out.println("EmpDaoImpl total tot->"+tot );
		} catch (Exception e) {
			System.out.println("EmpDaoImpl total Exception->"+e.getMessage());
		}
		return tot;
	}

	@Override
	public List<Emp> listEmp(Emp emp) {
		List<Emp> empList = null;
		System.out.println("EmpDaoImpl listEmp Start...");
		try {
			//  Naming Rule				  Map ID		 parameter
			empList = session.selectList("tkEmpListAll3", emp);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listEmp Exception -> " + e.getMessage());
		}
		return empList;
	}

	@Override
	public Emp detail(int empno) {
		System.out.println("EmpDaoImpl detail Start...");
		Emp emp = new Emp();
		try {
			emp = session.selectOne("tkEmpSelOne", empno);
			System.out.println("EmpDaoImpl detail getEname -> " + emp.getEname());
		} catch (Exception e) {
			System.out.println("EmpDaoImpl detail Exception -> " + e.getMessage());
		}
		return emp;
	}

	@Override
	public int update(Emp emp) {
		System.out.println("EmpDaoImpl update Start...");
		int uptCnt = 0;
		try {
			uptCnt = session.update("TKempUpdate", emp);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl update Exception -> " + e.getMessage());
		}
		return uptCnt;
	}

	@Override
	public List<Emp> listManager() {
		List<Emp> empList = null;
		System.out.println("EmpDaoImpl listManager Start...");
		try {
			// emp 관리자만 Select			 Naming Rule
			empList = session.selectList("tkSelectManager");
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listManager Exception -> " + e.getMessage());
		}
		return empList;
	}

	@Override
	public List<Dept> deptSelect() {
		List<Dept> deptList = null;
		System.out.println("EmpDaoImpl deptSelect Start...");
		try {
			deptList = session.selectList("tkDeptSelectManager");
		} catch (Exception e) {
			System.out.println("EmpDaoImpl deptSelect Exception -> " + e.getMessage());
		}
		return deptList;
	}





}
