//package gapp.model.dao;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
//import org.testng.annotations.Test;
//
//import gapp.model.dao.DepartmentDao;
//
//@Test(groups = "DepartmentDaoTest")
//@ContextConfiguration(locations = "classpath:applicationContext.xml")
//public class DepartmentDaoTest extends AbstractTransactionalTestNGSpringContextTests {
//
//	@Autowired
//	DepartmentDao departmentDao;
//
//	// Test case to check if two departments exist in system
//	@Test
//	public void twoDepartmentsexists() {
//
//		assert departmentDao.getDepartments().size() == 2;
//
//	}
//
//}