package paging;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class ProductDao {
	
	
	public List<Product> list(Page page) {  
	    
		List<Product> productList = new ArrayList<Product>();  
		Connection conn = null;
        try {  
        	String sql = "SELECT * FROM product";  
			conn = ConnectionUtil.getConnection();
            Statement st = conn.createStatement();  
            st.setMaxRows(page.getEndIndex());//关键代码，设置最大记录数为当前页记录的截止下标  
            ResultSet rs = st.executeQuery(sql);  
            if (page.getBeginIndex() > 0) {  
                rs.absolute(page.getBeginIndex());//关键代码，直接移动游标为当前页起始记录处  
            }  
            while (rs.next()) {  
                Product product = new Product();  
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                productList.add(product);  
            }  
            rs.close();  
            st.close();  
        }catch (Exception e) {  
	        // TODO Auto-generated catch block  
	        e.printStackTrace();  
	    } finally {  
            if (conn != null) {  
                try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}  
            }  
        }  
	       
	    return productList;  
	}

	public int getProductAmount() {
		int result = -1;
		Connection conn = null;
        try {  
        	conn = ConnectionUtil.getConnection();
        	String sql = "SELECT count(*) FROM product";  
            Statement st = conn.createStatement();  
            ResultSet rs = st.executeQuery(sql);  
            while (rs.next()) {  
                result = rs.getInt(1);
            }  
            rs.close();  
            st.close();  
        }catch (Exception e) {  
        	// TODO Auto-generated catch block  
        	e.printStackTrace();  
        }finally {  
            if (conn != null) {  
                try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}  
            }  
        }  
	    return result; 
	}  
}
