package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Product;
import mybatis.config.DBService;

public class ProductDao {

	private SqlSessionFactory factory;
	
	private static ProductDao instance;
	private ProductDao() {
		factory = DBService.getInstance().getFactory();
	}
	public static ProductDao getInstance() {
		if (instance == null) {
			instance = new ProductDao();
		}
		return instance;
	}
	
	// 1. 제품 목록
	public List<Product> selectList() {
		SqlSession ss = factory.openSession();
		List<Product> list = ss.selectList("dao.product.selectList");
		ss.close();
		return list;
	}
	
	
	
	
	
	
	
	
	
}
