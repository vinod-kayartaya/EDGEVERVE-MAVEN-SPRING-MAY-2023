package com.infosys.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.infosys.dao.ProductDao;
import com.infosys.entity.Category;
import com.infosys.entity.Product;
import com.infosys.entity.Supplier;
import com.infosys.utils.PdfGenerator;
import com.infosys.validators.ProductValidator;
import com.itextpdf.text.DocumentException;

@Controller
public class ProductController {

	@Autowired
	private ProductDao dao;

	@RequestMapping(method = RequestMethod.GET, path = "/delete-product")
	public String handleGetDeleteProduct(@RequestParam Integer productId, Model model) {
		model.addAttribute("p", dao.getProduct(productId));
		return "confirm-delete-product";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/delete-product")
	public String handlePostDeleteProduct(@RequestParam Integer productId) {

		dao.deleteProduct(productId);

		return "redirect:/product-list";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/edit-product")
	public String hanldeGetEditProduct(@RequestParam Integer productId, Model model) {
		model.addAttribute("p", dao.getProduct(productId));

		return "product-form";
	}

	// this a handler for GET request for adding a new product
	// we just need to redirect the user to a JSP form
	@RequestMapping(method = RequestMethod.GET, path = "/add-product")
	public String handleGetAddProduct(Model model) {
		model.addAttribute("p", new Product());

		return "product-form";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/save-product")
	public String handlePostSaveProduct(
			@ModelAttribute("p") Product product, 
			BindingResult errors) {

		new ProductValidator().validate(product, errors);
		if (errors.hasErrors()) {
			return "product-form";
		}
		
		if(product.getProductId()==null) {
			dao.addNewProduct(product);
		}
		else {
			dao.updateProduct(product);
		}
		
		return "redirect:/product-list";
	}

	@RequestMapping(path = "/product-list")
	public String handleGetProductList(Model model) { // spring injects a storage object as a dependency

		// spring stores this list of products with the name "products",
		// which will be made available to the JSP in the "request" scope
		model.addAttribute("products", dao.getAll());
		model.addAttribute("title", "List of all products");

		return "display-products";
	}

	@RequestMapping(path = "/products-by-price-range", method = RequestMethod.GET)
	public String handleGetProductsByPriceRange(@RequestParam("min_price") Double min,
			@RequestParam("max_price") Double max, Model model) {

		model.addAttribute("products", dao.getByPriceRange(min, max));
		model.addAttribute("title", "List of products between $%.1f and $%.1f".formatted(min, max));

		return "display-products";
	}

	@ModelAttribute(name = "categories")
	public List<Category> categories() {
		return dao.getCategories();
	}

	@ModelAttribute(name = "suppliers")
	public List<Supplier> suppliers() {
		return dao.getSuppliers();
	}

	@RequestMapping("/download-report")
    public void downloadReport(HttpServletResponse response) {
		
        String reportHtmlContent = "<html><body><h1>Product list</h1>"
        		+ generateProductTable(dao.getAll())
        		+ "</body></html>";

        try {
            byte[] pdfBytes = PdfGenerator.generatePdfReportFromHtml(reportHtmlContent);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=report.pdf");
            response.setContentLength(pdfBytes.length);

            response.getOutputStream().write(pdfBytes);
            response.getOutputStream().flush();
        } catch (DocumentException | IOException e) {
            // Handle exceptions appropriately
            e.printStackTrace();
        }
    }
	
	private static String generateProductTable(List<Product> products) {
        StringBuilder htmlTable = new StringBuilder();

        // Start the table and add the header row
        htmlTable.append("<table border=\"1\">\n<tr>\n<th>Product ID</th>\n<th>Product Name</th>\n<th>Quantity Per Unit</th>\n<th>Unit Price</th>\n<th>Units In Stock</th>\n</tr>\n");

        // Loop through each product and add a row for each
        for (Product product : products) {
            htmlTable.append("<tr>\n");
            htmlTable.append("<td>").append(product.getProductId()).append("</td>\n");
            htmlTable.append("<td>").append(product.getProductName()).append("</td>\n");
            htmlTable.append("<td>").append(product.getQuantityPerUnit()).append("</td>\n");
            htmlTable.append("<td>").append(product.getUnitPrice()).append("</td>\n");
            htmlTable.append("<td>").append(product.getUnitsInStock()).append("</td>\n");
            htmlTable.append("</tr>\n");
        }

        // Close the table
        htmlTable.append("</table>");

        return htmlTable.toString();
    }
}
