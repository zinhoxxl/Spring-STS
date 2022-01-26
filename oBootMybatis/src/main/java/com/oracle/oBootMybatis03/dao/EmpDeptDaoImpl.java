package com.oracle.oBootMybatis03.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.oBootMybatis03.model.Dept;
import com.oracle.oBootMybatis03.model.EmpDept;


@Repository
public class EmpDeptDaoImpl implements EmpDeptDao {
	@Autowired
	private SqlSession session;

	@Override
	public List<EmpDept> listEmpDept() {
		List<EmpDept> EmpDeptList = null;
		System.out.println("EmpDeptDaoImpl listEmpDept Start...");
		try {
			EmpDeptList = session.selectList("TKlistEmpDept");
		} catch (Exception e) {
			System.out.println("EmpDeptDaoImpl listEmpDept Exception -> " + e.getMessage());
		}
		System.out.println("EmpDeptDaoImpl listEmpDept EmpDeptList.size()->" + EmpDeptList.size());
		return EmpDeptList;
	}



}
