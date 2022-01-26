package com.oracle.oBootMybatis03.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.oBootMybatis03.dao.DeptDao;
import com.oracle.oBootMybatis03.dao.EmpDao;
import com.oracle.oBootMybatis03.dao.EmpDeptDao;
import com.oracle.oBootMybatis03.dao.Member1Dao;
import com.oracle.oBootMybatis03.model.Dept;
import com.oracle.oBootMybatis03.model.DeptVO;
import com.oracle.oBootMybatis03.model.Emp;
import com.oracle.oBootMybatis03.model.EmpDept;
import com.oracle.oBootMybatis03.model.Member3;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDao ed;
	@Autowired
	private DeptDao dd;
	@Autowired
	private EmpDeptDao emd;
	@Autowired
	private Member1Dao md;
	
	@Override
	public int total() {
		System.out.println("EmpServiceImpl Start total...");
		int totCnt = ed.total();
		System.out.println("EmpServiceImpl total totCnt -> " + totCnt);
		return totCnt;
	}

	@Override
	public List<Emp> listEmp(Emp emp) {
		List<Emp> empList = null;
		System.out.println("EmpServiceImpl listEmp Start...");
		empList = ed.listEmp(emp);
		System.out.println("EmpServiceImpl listEmp empList.size() -> " + empList.size());
		return empList;
	}

	@Override
	public Emp detail(int empno) {
		System.out.println("EmpServiceImpl detail Start...");
		Emp emp = null;
		emp = ed.detail(empno);
		return emp;
	}

	@Override
	public int update(Emp emp) {
		System.out.println("EmpServiceImpl update Start...");
		int uptCnt = 0;
		uptCnt = ed.update(emp);
		return uptCnt;
	}

	@Override
	public List<Emp> listManager() {
		// empList = ed.listManager();
		// Dao ---> empList = session.selectList("tkSelectManager");
		//					    관리자만 Get
		List<Emp> empList = null;
		System.out.println("EmpServiceImpl listManager Start...");
		empList = ed.listManager();
		System.out.println("EmpServiceImpl listManager empList.size()->" + empList.size());
		return empList;
	}

	@Override
	public List<Dept> deptSelect() {
		List<Dept> deptList = null;
		System.out.println("EmpServiceImpl deptSelect Start...");
		deptList = dd.deptSelect();
		return deptList;
	}

	@Override
	public int insert(Emp emp) {
		System.out.println("EmpServiceImpl insert Start...");
		int result = 0;
		result = ed.insert(emp);
		return result;
	}

	@Override
	public int delete(int empno) {
		System.out.println("EmpServiceImpl delete Start...");
		int deleteResult = 0;
		deleteResult = ed.delete(empno);
		return deleteResult;
	
	}

	@Override
	public List<EmpDept> listEmpDept() {
		List<EmpDept> EmpDeptList = null;
		System.out.println("EmpServiceImpl listEmpDept Start...");
		EmpDeptList = emd.listEmpDept();
		return EmpDeptList;
	}

	@Override
	public void insertDept(DeptVO deptVO) {
		System.out.println("EmpServiceImpl insertDept Start...");
		dd.insertDept(deptVO); 
		
	}

	@Override
	public void selListDept(HashMap<String, Object> map) {
		System.out.println("EmpSerivceImpl selListDept Start...");
		dd.selListDept(map); 
		
	}

	@Override
	public int memCount(String id) {
		System.out.println("EmpServiceImpl memCount id -> " + id);
		return md.memCount(id);
	}

	@Override
	public List<Member3> listMem(Member3 member3) {
		System.out.println("EmpServiceImpl listMem Start...");
		return md.listMem(member3);
	}

	@Override
	public List<EmpDept> listEmp(EmpDept empDept) {
		System.out.println("EmpServiceImpl listEmp Start...");
		return ed.listEmp(empDept);
	}

	
	@Override
	public String deptName(int deptno) {
		System.out.println("EmpServiceImpl deptName Start...");
		return ed.deptName(deptno);
	}




}
