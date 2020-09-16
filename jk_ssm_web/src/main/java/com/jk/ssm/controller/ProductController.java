package com.jk.ssm.controller;


import com.github.pagehelper.PageInfo;
import com.jk.ssm.domain.Product;
import com.jk.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * @outhor Mr.JK
 * @create 2020-05-01  12:52
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;


    //产品添加
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }

    /*
    查询全部产品 -- 未分页
     */
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() throws Exception {
//        ModelAndView mv = new ModelAndView();
//        List<Product> ps = productService.findAll();
//        mv.addObject("productList",ps);
//        mv.setViewName("product-list1");
//        return mv;
//    }

    /*
    查询全部产品 -- 分页
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAllPage(@RequestParam(name="page",required = true,defaultValue = "1") Integer page,@RequestParam(name = "size",required = true,defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        //找不到service层代码
        List<Product> products = productService.findAllPage(page, size);
        //状态转换

        //PageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(products);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-page-list");
        return mv;
    }

}
