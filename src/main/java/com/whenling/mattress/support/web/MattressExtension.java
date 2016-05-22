package com.whenling.mattress.support.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.whenling.centralize.Application;
import com.whenling.centralize.Extension;
import com.whenling.extension.mall.product.service.ProductService;

@Component
public class MattressExtension extends Extension {

	@Autowired
	private ProductService productService;

	@Override
	public void init(Application app, boolean isNew, boolean isUpdate, Integer historyVersion) {
		if (isNew) {
			productService.generateQrCode();
		}
	}

	@Override
	public Integer getVersion() {
		return 1;
	}

	@Override
	public String getAuthor() {
		return "ken";
	}

}
