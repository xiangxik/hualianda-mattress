package com.whenling.mattress.web.wap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.whenling.extension.mall.product.model.Product;
import com.whenling.extension.mall.product.model.ProductCategory;
import com.whenling.extension.mall.product.service.ProductService;
import com.whenling.module.web.controller.BaseController;

@Controller
@RequestMapping("/wap/product")
public class ProductController extends BaseController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = { "", "/", "/index", "/category" }, method = RequestMethod.GET)
	public String category() {
		return template("/wap/product/category");
	}

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String list(@RequestParam("category") ProductCategory productCategory, Pageable pageable, Model model) {
		model.addAttribute("productCategory", productCategory);
		model.addAttribute("products", productService.findByProductCategory(productCategory, pageable));
		return template("/wap/product/list");
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam("id") Product product, Model model) {
		model.addAttribute("product", product);
		return template("/wap/product/detail");
	}
}
