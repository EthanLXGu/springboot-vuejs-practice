package com.ethan.controller;

import com.ethan.domain.Food;
import com.ethan.domain.Result;
import com.ethan.util.ResultFoodUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ethan L X Gu on 30/03/2017.
 */
@RestController
@RequestMapping("/food")
public class FoodController {

    private List<Food> foodList;

    private void initFoodList() {
        Food meat = new Food();
        meat.setProductId(1L);
        meat.setProductName("meat");
        meat.setProductPrice(30.2);

        Food vegetable = new Food();
        vegetable.setProductId(2L);
        vegetable.setProductName("vegetable");
        vegetable.setProductPrice(10.2);

        Food fruit = new Food();
        fruit.setProductId(3L);
        fruit.setProductName("fruit");
        fruit.setProductPrice(20.2);

        List<Food> foods = Arrays.asList(meat, vegetable, fruit);
        this.foodList = new ArrayList<>(foods);
    }

    @GetMapping()
    public Result getAllFood() {
        initFoodList();
        return ResultFoodUtils.success(this.foodList);
    }

    @PostMapping()
    public Result addFood(Long productId, String productName, Double productPrice) {

        initFoodList();
        Food food = new Food(productId, productName, productPrice);
        this.foodList.add(food);
        return ResultFoodUtils.success(this.foodList);
    }

    @GetMapping("/{productId}")
    public Result getAllFoodById(@PathVariable("productId") Long productId) {
        Food food = this.foodList.get(productId.intValue() - 1);
        return ResultFoodUtils.success(Arrays.asList(food));
    }

    @PutMapping("/{productId}")
    public Result updateFood(@PathVariable("productId") Long productId,
                             @RequestParam("productName") String productName,
                             @RequestParam("productPrice") Double productPrice) {
        Food food = this.foodList.get(productId.intValue() - 1);
        food.setProductName(productName);
        food.setProductPrice(productPrice);
        foodList.set(productId.intValue() - 1, food);
        return ResultFoodUtils.success(this.foodList);
    }

    @DeleteMapping("/{productId}")
    public Result deleteFood(@PathVariable("productId") Long productId) {
        initFoodList();
        this.foodList.remove(productId.intValue() - 1);
        return ResultFoodUtils.success(this.foodList);
    }

}
