package com.marvels.controller;

import com.marvels.service.XyqbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消金回调
 * @author jason
 *
 */
@RestController
@RequestMapping
public class HaierCallbackController {
	
	@Autowired
	private XyqbService xyqbService;

	@RequestMapping("/test")
	public void test() {

		System.out.println("controller start");
		xyqbService.test();
		System.out.println("controller end");
	}
}
