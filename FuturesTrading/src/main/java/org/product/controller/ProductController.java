package org.product.controller;

import org.product.domain.Product;
import org.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.product.service.TypesService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    private static final String PRODUCT_INFO_PATH_NAME = "productInfo";
    private static final String PRODUCT_LIST_PATH_NAME = "productList";
//    private static final String REDIRECT_TO_BOOK_URL = "redirect:/book";

    @Autowired(required=true)
    ProductService productService;
    @Autowired
    TypesService typesService;
    /**
     * 获取 Book 列表
     * 处理 "/book" 的 GET 请求，用来获取 Book 列表
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getBookList(ModelMap map) {
        List list=typesService.selectName();
        map.addAttribute("listName",list);
        map.addAttribute("productList",productService.selectProductFindAll());
        return PRODUCT_LIST_PATH_NAME;
    }

    @RequestMapping(value = "/types")
    public String selectSeTypes(@RequestParam(value = "name") String type, ModelMap map){
        long id=typesService.selectNameid(type);
       List list =typesService.selectSeName(id);
       List<Product> productList = new ArrayList<Product>();
        map.addAttribute("listName",list);
        long[] listId=typesService.selectSeid(id);
        System.out.println(listId.length);
        if (listId.length>0){
            for (long i:listId){
                if (productService.selectProductByTypeId(i) != null){
                    List<Product> list1=productService.selectProductByTypeId(i);
                    for(Product product:list1){
                        productList.add(product);
                    }
                }

                map.addAttribute("productList",productList);
            }
        }else {
            map.addAttribute("productList",productService.selectProductByTypeId(id));
        }

        return PRODUCT_LIST_PATH_NAME;
    }

    @RequestMapping(value = "/select")
    public String selectProductByName(@RequestParam String name,ModelMap map){
        List list=typesService.selectName();
        map.addAttribute("listName",list);
        map.addAttribute(("productList"),productService.selectProductByName("%"+name+"%"));
        return PRODUCT_LIST_PATH_NAME;
    }

    @RequestMapping(value = "/productInfo")
    public String productInfo(@RequestParam long id,ModelMap map){
        Product product=productService.selectProductById(id);
        map.addAttribute("product",product);
        return "productInfo";
    }

    /**
     * 获取创建 Book 表单
     */
//    @RequestMapping(value = "/create", method = RequestMethod.GET)
//    public String createBookForm(ModelMap map) {
//        map.addAttribute("book", new Product());
//        map.addAttribute("action", "create");
//        return BOOK_FORM_PATH_NAME;
//    }

    /**
     * 创建 Book
     * 处理 "/book/create" 的 POST 请求，用来新建 Book 信息
     * 通过 @ModelAttribute 绑定表单实体参数，也通过 @RequestParam 传递参数
     */
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public String postBook(@ModelAttribute Book book) {
//        bookService.insertByBook(book);
//        return REDIRECT_TO_BOOK_URL;
//    }

    /**
     * 获取更新 Book 表单
     *    处理 "/book/update/{id}" 的 GET 请求，通过 URL 中的 id 值获取 Book 信息
     *    URL 中的 id ，通过 @PathVariable 绑定参数
     */
//    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
//    public String getUser(@PathVariable Long id, ModelMap map) {
//        map.addAttribute("book", bookService.findById(id));
//        map.addAttribute("action", "update");
//        return BOOK_FORM_PATH_NAME;
//    }

    /**
     * 更新 Book
     * 处理 "/update" 的 PUT 请求，用来更新 Book 信息
     */
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public String putBook(@ModelAttribute Book book) {
//        bookService.update(book);
//        return REDIRECT_TO_BOOK_URL;
//    }

    /**
     * 删除 Book
     * 处理 "/book/{id}" 的 GET 请求，用来删除 Book 信息
     */
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    public String deleteBook(@PathVariable Long id) {
//        bookService.delete(id);
//        return REDIRECT_TO_BOOK_URL;
//    }
}
