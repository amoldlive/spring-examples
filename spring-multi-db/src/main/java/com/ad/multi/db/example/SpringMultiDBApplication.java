package com.ad.multi.db.example;

import com.ad.multi.db.example.controller.MultiDBController;
import com.ad.multi.db.example.entity.product.Product;
import com.ad.multi.db.example.entity.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.SmartLifecycle;

import java.util.List;

@Slf4j
@SpringBootApplication
public class SpringMultiDBApplication implements SmartLifecycle {

	private final MultiDBController multiDBController;


	public SpringMultiDBApplication(MultiDBController multiDBController) {
		this.multiDBController = multiDBController;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringMultiDBApplication.class, args);
	}



	@Override
	public void start() {
		List<User> users= List.of(new User(1,"Amol",29),new User(2,"Dipalini",29));
		for(User user:users)
			multiDBController.saveUser(user);

		List<Product> products= List.of(new Product(1,"Amul Milk",27),new Product(2,"Tata Rock Salt",120));
		for(Product product:products)
			multiDBController.saveProduct(product);

		log.info("users " + multiDBController.getAllUser());
		log.info("products " + multiDBController.getAllProducts());

	}

	@Override
	public void stop() {

	}

	@Override
	public boolean isRunning() {
		return false;
	}
}
