package com.trungtamjava.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.CategoryDao;
import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.dao.impl.CategoryDaoImpl;
import com.trungtamjava.dao.impl.ProductDaoImpl;
import com.trungtamjava.model.Category;
import com.trungtamjava.model.Product;

@WebServlet(urlPatterns = "/client/product/search")
public class ClientProductSearchController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// mac dinh lay tat ca san pham
		ProductDao productDao = new ProductDaoImpl();
		List<Product> pList = productDao.search("");
		req.setAttribute("pList", pList);

		CategoryDao categoryDao = new CategoryDaoImpl();
		List<Category> categoryList = categoryDao.search("");
		req.setAttribute("categoryList", categoryList);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/client/product/search-product.jsp");
		dispatcher.forward(req, resp);
	}

}
