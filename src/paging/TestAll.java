package paging;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Test;

public class TestAll {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ProductDao productDao = new ProductDao();
		
		//从页面取得页码  
		int pageCount = 4;  
  
		  
		//取得总记录数，创建Page对象  
		int totalRow = productDao.getProductAmount();//通过select count 取得总记录数  
		Page page = new Page(totalRow, pageCount);  
		List<Product> lists = productDao.list(page); 
		System.out.println(lists);
	}
	@Test
	public void testGetProductAmount(){
		ProductDao productDao = new ProductDao();
		System.out.println(productDao.getProductAmount());
	}

}
