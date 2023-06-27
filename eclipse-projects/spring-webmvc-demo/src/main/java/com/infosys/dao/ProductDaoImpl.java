package com.infosys.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.infosys.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public List<Product> getAll() {
		return template.query("select * from products", prm);
	}
	
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
	public List<Product> getByPriceRange(Double min, Double max) {
		String sql = "select * from products where unit_price between ? and ?";
		return template.query(sql, prm, min, max);
	}

	@Override
	public void addNewProduct(Product product) {
		String sql = "insert into products values (?,?,?,?,?,?,?,?,?,?)";
		template.execute(sql, (PreparedStatement ps) -> {
			ps.setInt(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setInt(3, product.getSupplierId());
			ps.setInt(4, product.getCategoryId());
			ps.setString(5, product.getQuantityPerUnit());
			ps.setDouble(6, product.getUnitPrice());
			ps.setInt(7, product.getUnitsInStock());
			ps.setInt(8, product.getUnitsOnOrder());
			ps.setInt(9, product.getReorderLevel());
			ps.setInt(10, product.getDiscontinued());
			return ps.executeUpdate();
		});
	}

	@Override
	public Product getProduct(Integer id) {
		String sql = "select * from products where product_id=?";
		return template.queryForObject(sql, prm, id);
	}

	@Override
	public void updateProduct(Product product) {
		String sql = "update products set product_name=?, supplier_id=?, category_id=?, "
				+ "quantity_per_unit=?, unit_price=?, units_in_stock=?, units_on_order=?, "
				+ "reorder_level=?, discontinued=? where product_id=?";
		
		template.execute(sql, (PreparedStatement ps) -> {
			ps.setString(1, product.getProductName());
			ps.setInt(2, product.getSupplierId());
			ps.setInt(3, product.getCategoryId());
			ps.setString(4, product.getQuantityPerUnit());
			ps.setDouble(5, product.getUnitPrice());
			ps.setInt(6, product.getUnitsInStock());
			ps.setInt(7, product.getUnitsOnOrder());
			ps.setInt(8, product.getReorderLevel());
			ps.setInt(9, product.getDiscontinued());
			ps.setInt(10, product.getProductId());

			return ps.executeUpdate();
		});
		
	}

	@Override
	public void deleteProduct(Integer productId) {
		String sql = "delete from products where product_id=?";
		template.execute(sql, (PreparedStatement ps) -> {
			ps.setInt(1, productId);
			return ps.executeUpdate();
		});
	}

}













