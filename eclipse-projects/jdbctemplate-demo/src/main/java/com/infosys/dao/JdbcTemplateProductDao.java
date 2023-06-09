package com.infosys.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.infosys.entity.Product;

@Repository
public class JdbcTemplateProductDao implements ProductDao {

	// dependency
	@Autowired
	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	// row-mapper (maps one row of the ResultSet to a Product object)

	private RowMapper<Product> prm = (rs, rowNum) -> {
		Product p = new Product();
		p.setProductId(rs.getInt("product_id"));
		p.setProductName(rs.getString("product_name"));
		p.setCategoryId(rs.getInt("category_id"));
		p.setSupplierId(rs.getInt("supplier_id"));
		p.setQuantityPerUnit(rs.getString("quantity_per_unit"));
		p.setUnitPrice(rs.getDouble("unit_price"));
		p.setUnitsInStock(rs.getInt("units_in_stock"));
		p.setUnitsOnOrder(rs.getInt("units_on_order"));
		p.setReorderLevel(rs.getInt("reorder_level"));
		p.setDiscontinued(rs.getInt("discontinued"));
		return p;
	};

	@Override
	public void addProduct(Product p) throws DaoException {
		String sql = "insert into products values (?,?,?,?,?,?,?,?,?,?)";
		template.execute(sql, (PreparedStatement ps) -> {
			ps.setInt(1, p.getProductId());
			ps.setString(2, p.getProductName());
			ps.setInt(3, p.getSupplierId());
			ps.setInt(4, p.getCategoryId());
			ps.setString(5, p.getQuantityPerUnit());
			ps.setDouble(6, p.getUnitPrice());
			ps.setInt(7, p.getUnitsInStock());
			ps.setInt(8, p.getUnitsOnOrder());
			ps.setInt(9, p.getReorderLevel());
			ps.setInt(10, p.getDiscontinued());
			return ps.executeUpdate();
		});
	}

	@Override
	public Product getProductById(int productId) throws DaoException {
		String sql = "select * from products where product_id=?";
		return template.queryForObject(sql, prm, productId);
	}

	@Override
	public void updateProduct(Product product) throws DaoException {

	}

	@Override
	public List<Product> getAllProducts() throws DaoException {
		return template.query("select* from products", prm);
	}

	@Override
	public List<Product> getProductsInPriceRange(double min, double max) throws DaoException {
		String sql = "select* from products where unit_price between ? and ?";
		return template.query(sql, prm, min, max);
	}

	@Override
	public List<Product> getOutOfStockProducts() throws DaoException {
		return template.query("select* from products where units_in_stock=0", prm);
	}

	@Override
	public List<Product> getDiscontinuedProducts() throws DaoException {
		return template.query("select* from products wherettt discontinued=1", prm);
	}

}
