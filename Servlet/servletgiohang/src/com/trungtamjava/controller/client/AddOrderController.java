package com.trungtamjava.controller.client;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.dao.BillDao;
import com.trungtamjava.dao.BillProductDao;
import com.trungtamjava.dao.impl.BillDaoImpl;
import com.trungtamjava.dao.impl.BillProductDaoImpl;
import com.trungtamjava.model.Bill;
import com.trungtamjava.model.BillProduct;
import com.trungtamjava.model.User;

@WebServlet(urlPatterns = "/member/add-order") // bat dang nhap thanh vien truoc
public class AddOrderController extends HttpServlet {
	BillDao billDao = new BillDaoImpl();
	BillProductDao billProductDao = new BillProductDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//DOC TU SESSION RA GIO HANG TRUOC
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("cart");// luu tam vao session

		if (obj != null) {//KIEM TRA XEM CO SP TRONG GIO HANG KO?
			Map<String, BillProduct> map = (Map<String, BillProduct>) obj;

			//TAO HOA DON TRUOC, DE LAY DUOC ID BILL
			Bill bill = new Bill();

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			bill.setBuyDate(sdf.format(new Date()));

			// lay dang nhap
			User buyer = (User) session.getAttribute("loginUser");
			bill.setBuyer(buyer);
			//XEM THEM O LOP BILLDAO, CACH TRA VE ID TU GEN O SQL
			billDao.create(bill);// save bill trc de lay id
			// Tim mat hang
			long total = 0;//tinh tong gia
			
			//lap cac phan tu trong map
			for (Entry<String, BillProduct> entry : map.entrySet()) {
				BillProduct billProduct = entry.getValue();
				
				billProduct.setBill(bill);// set bill id vao day
				//luu lai cac mat hang
				billProductDao.create(billProduct);
				// tinh tong gia
				total += billProduct.getQuantity() * billProduct.getUnitPrice();
			}
			
			///cap nhat lai bill de co tong gia tien
			bill.setPriceTotal(total);
			billDao.update(bill);

			// chuyen ve trang thanh cong
			// xoa session gio hang vi da tao don hang thanh cong, giai phong bo nho
			session.removeAttribute("cart");
			resp.sendRedirect(req.getContextPath() + "/member/bills");
		} else {
			// tra ve trang chu neu gio hang rong
			resp.sendRedirect(req.getContextPath() + "/client/product/search");
		}

	}
}
