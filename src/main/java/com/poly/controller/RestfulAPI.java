package com.poly.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.poly.dto.*;
import com.poly.model.*;
import com.poly.repositories.*;
import com.poly.services.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
//@CrossOrigin(origins = {"http://localhost:8080", "https://webdemodoan.herokuapp.com"})
@RequestMapping("/api")
public class RestfulAPI {
    @Autowired
    ResponseUtils responseUtils;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private PromotionRepository promotionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderSesionRepository orderSesionRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    // API CUSTOMER //
    @PostMapping("/listcustomer")
    public ResponseEntity<?> getAlluser() {
        try {
            List<Users> usersList = (List<Users>) userRepository.findAll();
            return responseUtils.getResponseEntity(usersList, "1", "Get user success!", HttpStatus.OK);
        } catch (Exception e) {
            return responseUtils.getResponseEntity(null, "-1", "Get user fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/newcustomer")
    public ResponseEntity<?> newProduct(@RequestBody Users user) {
        if (user.getName() == "" || user.getUsername() == "" || user.getPassword() == "" || user.getStatus() == "" || user.getPhone() == "") {
            return responseUtils.getResponseEntity(null, "-1", "Create user fail!", HttpStatus.BAD_REQUEST);
        }
        try {
            if (userRepository.getByUser(user.getUsername()) != null) {
                return responseUtils.getResponseEntity(null, "-1", "Username is already exists!", HttpStatus.BAD_REQUEST);
            }
            if (user.getPassword().length() < 6) {
                return responseUtils.getResponseEntity(null, "-1", "Password must be at 11 digit!", HttpStatus.BAD_REQUEST);
            }
            if (user.getPhone().length() < 11) {
                return responseUtils.getResponseEntity(null, "-1", "Number phone must be at least 6 characters!", HttpStatus.BAD_REQUEST);
            } else {
                Users usersList = userRepository.save(user);
                return responseUtils.getResponseEntity(usersList, "1", "Get user success!", HttpStatus.OK);
            }
        } catch (Exception e) {
            return responseUtils.getResponseEntity(null, "-1", "Get user fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/findcustomer")
    public ResponseEntity<?> one(@RequestBody Users user) throws Exception {
        try {
            Integer id = user.getId();
            Optional<Users> usersList = userRepository.findById(id);
            if (usersList.get() != null) {
                return responseUtils.getResponseEntity(usersList, "1", "Get user success!", HttpStatus.OK);
            } else {
                return responseUtils.getResponseEntity(null, "-1", "Get user fail!", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return responseUtils.getResponseEntity(null, "-1", "Get user fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/editcustomer")
    public ResponseEntity<?> replaceCustomer(@RequestBody Users user) {
        try {
            Integer id = user.getId();
            Optional<Users> usersList = userRepository.findById(id).<Users>map(myuser -> {
                myuser.setName(user.getName());
                myuser.setEmail(user.getEmail());
                myuser.setPhone(user.getPhone());
                myuser.setPassword(user.getPassword());
                myuser.setAddress(user.getAddress());
                myuser.setStatus(user.getStatus());
                myuser.setUsername(user.getUsername());
                myuser.setRole(user.getRole());
                if (user.getImage() != "") {
                    myuser.setImage(user.getImage());
                }
                return userRepository.save(myuser);
            });
            if (usersList.get() == null) {
                return responseUtils.getResponseEntity(null, "-1", "Update user fail!", HttpStatus.BAD_REQUEST);
            }
            return responseUtils.getResponseEntity(usersList, "1", "Update user success!", HttpStatus.OK);
        } catch (Exception e) {
            return responseUtils.getResponseEntity(null, "-1", "Update user fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/deletecustomer")
    public ResponseEntity<?> deleteCustomer(@RequestBody Users user) {
        try {
            Integer id = user.getId();
            userRepository.deleteById(id);
            return responseUtils.getResponseEntity(user, "1", "Delete user success!", HttpStatus.OK);
        } catch (Exception e) {
            return responseUtils.getResponseEntity(null, "-1", "Delete user fail!", HttpStatus.BAD_REQUEST);
        }
    }
    // API CUSTOMER //

    // API PRODUCT //
    @PostMapping("/listproduct")
    public ResponseEntity<?> allproduct() {
        try {
            List<Product> productList = (List<Product>) productRepository.findAll();
            return responseUtils.getResponseEntity(productList, "1", "Get all product success!", HttpStatus.OK);
        } catch (Exception e) {
            return responseUtils.getResponseEntity(null, "-1", "Get all product fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/newproduct")
    public ResponseEntity<?> newProduct(@RequestBody Product product) {
        try {
            if (product.getPrice() < 100000) {
                return responseUtils.getResponseEntity(null, "-1", "Price must be greater than 100000 cost!", HttpStatus.BAD_REQUEST);
            }
            if (brandRepository.findById(product.getBrand().getId()) == null) {
                return responseUtils.getResponseEntity(null, "-1", "Brand is not exists!", HttpStatus.BAD_REQUEST);
            }
            if (categoryRepository.findById(product.getCategory().getId()) == null) {
                return responseUtils.getResponseEntity(null, "-1", "Category is not exists!", HttpStatus.BAD_REQUEST);
            }
            if (product.getStatus() == "") {
                return responseUtils.getResponseEntity(null, "-1", "Status cannot null!", HttpStatus.BAD_REQUEST);
            }
            if (product.getQuantity() < 0) {
                return responseUtils.getResponseEntity(null, "-1", "Quantity Password must be greater than 0 !", HttpStatus.BAD_REQUEST);
            } else {
                Product productList = productRepository.save(product);
                return responseUtils.getResponseEntity(productList, "1", "Create product success!", HttpStatus.OK);
            }
        } catch (Exception e) {
            return responseUtils.getResponseEntity(null, "-1", "Create product fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findproduct")
    public ResponseEntity<?> one(@RequestParam(value = "id",defaultValue = "") Integer id) {
        try {
            Optional<Product> productList = productRepository.findById(id);
            if (productList.get() != null) {
                return responseUtils.getResponseEntity(productList, "1", "Get product success!", HttpStatus.OK);
            } else {
                return responseUtils.getResponseEntity(null, "-1", "Get product fail!", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return responseUtils.getResponseEntity(null, "-1", "Get product fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/searchproduct")
    public ResponseEntity<?> Search(@RequestParam(value = "search",defaultValue = "") String search) {
        try {
            List<Product> productList = (List<Product>) productRepository.getBySearch(search);
            if (productList != null) {
                return responseUtils.getResponseEntity(productList, "1", "Get product success!", HttpStatus.OK);
            } else {
                return responseUtils.getResponseEntity(null, "-1", "Get product fail!", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return responseUtils.getResponseEntity(null, "-1", "Get product fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/filterproduct")
    public ResponseEntity<?> Filter(@RequestParam(value = "lower") int lower, @RequestParam(value = "higher") int higher) {
        try {
            List<Product> productList = (List<Product>) productRepository.getByPrice(lower,higher);
            if (productList != null) {
                return responseUtils.getResponseEntity(productList, "1", "Get product success!", HttpStatus.OK);
            } else {
                return responseUtils.getResponseEntity(null, "-1", "Get product fail!", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return responseUtils.getResponseEntity(null, "-1", "Get product fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/editproduct")
    public ResponseEntity<?> replaceEmployee(@RequestBody Product newProduct) {
        try {
            Integer id = newProduct.getId();
            Optional<Object> productList = productRepository.findById(id).map(product -> {
                product.setName(newProduct.getName());
                product.setPrice(newProduct.getPrice());
                product.setDescription(newProduct.getDescription());
                product.setStatus(newProduct.getStatus());
                product.setBrand(newProduct.getBrand());
                product.setQuantity(newProduct.getQuantity());
                product.setCategory(newProduct.getCategory());
                if (product.getImage() != "") {
                    product.setImage(newProduct.getImage());
                }
                return productRepository.save(product);
            });
            if (productList.get() != null) {
                return responseUtils.getResponseEntity(productList, "1", "Update product success!", HttpStatus.OK);
            }else {
                return responseUtils.getResponseEntity(null, "-1", "Update product fail!", HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Update product fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/deleteproduct")
    public ResponseEntity<?> deleteProduct(@RequestBody Product product) {
        try {
            Integer id = product.getId();
            productRepository.deleteById(id);
            return responseUtils.getResponseEntity(product, "1", "Delete product success!", HttpStatus.OK);
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Delete product fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/ProductByBrand")
    public ResponseEntity<?> ProductByBrand(@RequestParam(value = "id",defaultValue = "") Integer id) {
//        try {
            List<Product> productList = productRepository.getByBrand(id);
            return responseUtils.getResponseEntity(productList, "1", "Get product success!", HttpStatus.OK);
//        }catch (Exception e){
//            return responseUtils.getResponseEntity(null, "-1", "Get product fail!", HttpStatus.BAD_REQUEST);
//        }
    }

    @GetMapping("/ProductByCategory")
    public ResponseEntity<?> ProductByCategory(@RequestParam(value = "id",defaultValue = "") Integer id) {
        try {
            List<Product> productList = productRepository.getByCategory(id);
            return responseUtils.getResponseEntity(productList, "1", "Get product success!", HttpStatus.OK);
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Get product fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/countProductByBrand/{id}")
    int countProductByBrand(@PathVariable("id") Integer id) {
        return productRepository.countProductByBrand(id);
    }

    // API PRODUCT //

    // API BRAND //
    @PostMapping("/listbrand")
    public ResponseEntity<?> listbrand() {
        try {
            List<Brand> brandList = (List<Brand>) brandRepository.findAll();
            return responseUtils.getResponseEntity(brandList, "1", "Get all brand success!", HttpStatus.OK);
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Get brand fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/newbrand")
    public ResponseEntity<?> newBrand(@RequestBody Brand brand) {
        try {
            Brand brandList = brandRepository.save(brand);
            return responseUtils.getResponseEntity(brandList, "1", "Create brand success!", HttpStatus.OK);
        }catch (Exception E){
            return responseUtils.getResponseEntity(null, "-1", "Create brand fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/deletebrand")
    public ResponseEntity<?> deleteBrand(@RequestBody Brand brand) {
        try {
            brandRepository.deleteById(brand.getId());
            return responseUtils.getResponseEntity(brand, "1", "Delete brand success!", HttpStatus.OK);
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Delete brand fail!", HttpStatus.BAD_REQUEST);
        }
    }
    // API BRAND //

    // API CATEGORY //
    @GetMapping("/listcategory")
    public ResponseEntity<?> listcategory() {
        try {
            List<Category> categoryList = (List<Category>) categoryRepository.findAll();
            return responseUtils.getResponseEntity(categoryList, "1", "Get all category success!", HttpStatus.OK);
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Get category fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/newcategory")
    public ResponseEntity<?> newCategory(@RequestBody Category newCategory) {
        try {
            Category categoryList = categoryRepository.save(newCategory);
            return responseUtils.getResponseEntity(categoryList, "1", "Create category success!", HttpStatus.OK);
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Create category fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/deletecategory")
    public ResponseEntity<?> deleteCategory(@RequestBody Category newCategory) {
        try {
            categoryRepository.deleteById(newCategory.getId());
            return responseUtils.getResponseEntity(newCategory, "1", "Create category success!", HttpStatus.OK);
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Detele category fail!", HttpStatus.BAD_REQUEST);
        }
    }
    // API CATEGORY //

    // API BLOG //
    @PostMapping("/listblog")
    public ResponseEntity<?> listblog() {
//        try {
            List<Blog> blogList = (List<Blog>) blogRepository.findAll();
            return responseUtils.getResponseEntity(blogList, "1", "Get all blog success!", HttpStatus.OK);
//        }catch (Exception e){
//            return responseUtils.getResponseEntity(null, "-1", "Get all blog fail!", HttpStatus.BAD_REQUEST);
//        }
    }

    @PostMapping("/newblog")
    public ResponseEntity<?> newblog(@RequestBody Blog blog) {
//        try {
            Blog blogList = blogRepository.save(blog);
            return responseUtils.getResponseEntity(blogList, "1", "Create blog success!", HttpStatus.OK);
//        }catch (Exception e){
//            return responseUtils.getResponseEntity(null, "-1", "Create blog fail!", HttpStatus.BAD_REQUEST);
//        }
    }

    @PostMapping("/findblog")
    public ResponseEntity<?> one(@RequestBody Blog blog) {
        try {
            Integer id = blog.getId();
            Optional<Blog> blogList = blogRepository.findById(id);
            return responseUtils.getResponseEntity(blogList, "1", "Create blog success!", HttpStatus.OK);
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Get blog fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/editblog")
    public ResponseEntity<?> replaceBlog(@RequestBody Blog blog, @RequestParam(value = "file", required = false) MultipartFile file) {
        try {
            Integer id = blog.getId();
            Optional<Blog> blogList = blogRepository.findById(id).<Blog>map(myblog -> {
                    myblog.setTitle(blog.getTitle());
                    myblog.setDescription(blog.getDescription());
                    myblog.setContent(blog.getContent());
                    myblog.setUser(blog.getUser());
                    if(blog.getImage() != ""){
                        String nameImage = "app";
                        try {
                            byte[] bytes = file.getBytes();
                            BufferedOutputStream stream =
                                    new BufferedOutputStream(new FileOutputStream(new File(nameImage + "-uploaded")));
                            stream.write(bytes);
                            stream.close();
                        } catch (Exception e) {

                        }
                        myblog.setImage(blog.getImage());
                    }
                    return blogRepository.save(myblog);
                });
            if(blogList.get() != null) {
                return responseUtils.getResponseEntity(blogList, "1", "Update blog success!", HttpStatus.OK);
            }else {
                return responseUtils.getResponseEntity(null, "-1", "Update blog fail!", HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Update blog fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/deleteblog")
    public ResponseEntity<?> deleteBlog(@RequestBody Blog blog) {
        try {
            Integer id = blog.getId();
            blogRepository.deleteById(id);
            return responseUtils.getResponseEntity(blog, "1", "Delete blog success!", HttpStatus.OK);
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Delete blog fail!", HttpStatus.BAD_REQUEST);
        }
    }

    // API BLOG //

    // API PROMOTION //
    @PostMapping("/listpromo")
    public ResponseEntity<?> listPromo() {
        try {
            List<Promotion> promotionList = (List<Promotion>) promotionRepository.findAll();
            return responseUtils.getResponseEntity(promotionList, "1", "Get all promotion success!", HttpStatus.OK);
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Get all promotion fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/newpromo")
    public ResponseEntity<?> newpromo(@RequestBody Promotion promotion) {
        try {
            Promotion promotionList = promotionRepository.save(promotion);
            return responseUtils.getResponseEntity(promotionList, "1", "Create promotion success!", HttpStatus.OK);
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Create promotion fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/editpromo")
    public ResponseEntity<?> editpromo(@RequestBody Promotion promotion) throws Exception {
        try {
        Integer id = promotion.getId();
        Optional<Promotion> promotionList = promotionRepository.findById(id).<Promotion>map(mypromo -> {
                mypromo.setPercents(promotion.getPercents());
                mypromo.setCoupon(promotion.getCoupon());
                mypromo.setTimeStart(promotion.getTimeStart());
                mypromo.setTimeEnd(promotion.getTimeEnd());
                mypromo.setDescription(promotion.getDescription());
                if(promotion.getImage() != null){
                    mypromo.setImage(promotion.getImage());
                }
                return promotionRepository.save(mypromo);
            });
            if(promotionList.get() != null) {
                return responseUtils.getResponseEntity(promotionList, "1", "Update promotion success!", HttpStatus.OK);
            }else {
                return responseUtils.getResponseEntity(null, "-1", "Create promotion fail!", HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Create promotion fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/findpromo")
    Promotion findpromo(@RequestBody Promotion promotion) {
        return promotionRepository.getByCoupon(promotion.getCoupon());
    }

    @PostMapping("/deletepromo")
    void deletepromote(@RequestBody Promotion promotion) {
        Integer id = promotion.getId();
        promotionRepository.deleteById(id);
    }

    // API BLOG //

    // API CART //
    @PostMapping("cartSession")
    public List<SessionItem> cartItem(HttpSession session) {
        return (List<SessionItem>) session.getAttribute("item");
    }

    @PostMapping("buy")
    public List<SessionItem> buy(@RequestBody SessionItem item, HttpSession session) {
        Product product = productRepository.getbyId(item.getProduct().getId());
        if (session.getAttribute("item") == null) {
            List<SessionItem> cart = new ArrayList<SessionItem>();
            cart.add(new SessionItem(product, item.getQuantity()));
            session.setAttribute("item", cart);
            return cart;
        } else {
            List<SessionItem> cart = (List<SessionItem>) session.getAttribute("item");
            int index = this.exists(item.getProduct().getId(), cart);
            if (index == -1) {
                cart.add(new SessionItem(product, item.getQuantity()));
            } else {
                int quantity = cart.get(index).getQuantity() + item.getQuantity();
                cart.get(index).setQuantity(quantity);
            }
            session.setAttribute("item", cart);
            return cart;
        }
    }

    @PostMapping("remove/{id}")
    public List<SessionItem> remove(@PathVariable("id") Integer id, HttpSession session) {
        List<SessionItem> cart = (List<SessionItem>) session.getAttribute("item");
        int index = this.exists(id, cart);
        cart.remove(index);
        session.setAttribute("item", cart);
        return cart;
    }

    private int exists(Integer id, List<SessionItem> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @GetMapping("/listcart")
    public ResponseEntity<?> findcart(Authentication authentication) {
        try {
            UserService u = (UserService) authentication.getPrincipal();
            Cart cartList = cartRepository.getCartByCustomerId(u.getId());
            return responseUtils.getResponseEntity(cartList, "1", "Get cart success!", HttpStatus.OK);
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Get cart fail!", HttpStatus.BAD_REQUEST);
        }
    }

    // API CART //

    // API CART ITEM //
    @PostMapping("/newitem")
    public ResponseEntity<?> newitem(@RequestBody CartItem cartItem, Authentication authentication) throws Exception {
        try {
            UserService u = (UserService) authentication.getPrincipal();
            Cart cartList = cartRepository.getCartByCustomerId(u.getId());
            if (cartItem.getQuantity() != 0) {
                Optional<CartItem> items = itemRepository.findByProductIdAndCartId(cartItem.getProduct().getId(), cartList.getId());
                if (!items.isPresent()) {
                    cartItem.setCart(cartList);
                    CartItem itemList = itemRepository.save(cartItem);
                    return responseUtils.getResponseEntity(itemList, "1", "Get item success!", HttpStatus.OK);
                } else {
                    Optional<CartItem> itemList = itemRepository.findByProductIdAndCartId(cartItem.getProduct().getId(), cartList.getId()).<CartItem>map(a -> {
                        a.setQuantity(a.getQuantity() + cartItem.getQuantity());
                        return itemRepository.save(a);
                    });
                    if(itemList.get() != null) {
                        return responseUtils.getResponseEntity(itemList, "1", "Get item success!", HttpStatus.OK);
                    }else {
                        return responseUtils.getResponseEntity(null, "-1", "Get item fail!", HttpStatus.BAD_REQUEST);
                    }
                }
            } else {
                return responseUtils.getResponseEntity(null, "-1", "Get item fail!", HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Get item fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listitem")
    public ResponseEntity<?> listitem(Authentication authentication) {
        try {
            UserService u = (UserService) authentication.getPrincipal();
            Cart cart = cartRepository.getCartByCustomerId(u.getId());
            List<CartItem> itemList = itemRepository.getByCartId(cart.getId());
            return responseUtils.getResponseEntity(itemList, "1", "Get item success!", HttpStatus.OK);
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Get item fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/removeitem")
    public ResponseEntity<?> removeitem(@RequestBody CartItem cartItem) {
        try {
            itemRepository.deleteById(cartItem.getId());
            return responseUtils.getResponseEntity(cartItem, "1", "Delete item success!", HttpStatus.OK);
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Delete item fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/removeall")
    public ResponseEntity<?> removeall(CartItem cartItem, Authentication authentication) {
        try {
            UserService u = (UserService) authentication.getPrincipal();
            Cart cart = cartRepository.getCartByCustomerId(u.getId());
            itemRepository.deleteByCartId(cart.getId());
            return responseUtils.getResponseEntity(cartItem, "1", "Delete item success!", HttpStatus.OK);
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Delete item fail!", HttpStatus.BAD_REQUEST);
        }
    }
    // API CART ITEM //

    // API ORDER //
    @PostMapping("/listorderbyadmin")
    public ResponseEntity<?> listorderbyadmin() {
        try {
            List<OrderDTO> orderDTOList = orderRepository.getall();
            return responseUtils.getResponseEntity(orderDTOList, "1", "Get order success!", HttpStatus.OK);
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Get order fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listorder")
    public ResponseEntity<?> listorder(Authentication authentication) {
        try {
            UserService u = (UserService) authentication.getPrincipal();
            List<OrderDTO> orderDTOList = orderRepository.getOrderByCustomerId(u.getId());
            return responseUtils.getResponseEntity(orderDTOList, "1", "Get order success!", HttpStatus.OK);
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Get order fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/neworder")
    public ResponseEntity<?> neworder(@RequestBody Orders orders, Authentication authentication) {
        try {
            UserService u = (UserService) authentication.getPrincipal();
            Users users = userRepository.getByUser(u.getUsername());
            orders.setUsers(users);
            orders.setDelete(true);
            Orders orderList = orderRepository.save(orders);
            return responseUtils.getResponseEntity(orderList, "1", "Create order success!", HttpStatus.OK);
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Create order fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/newordersession")
    Orders_Sesion newordersession(@RequestBody Orders_Sesion orders_sesion) {
        return orderSesionRepository.save(orders_sesion);
    }

    @PostMapping("/editorder")
    public ResponseEntity<?> editorder(@RequestBody Orders orders) {
        try {
            Optional<Orders> orderList = orderRepository.findById(orders.getId()).<Orders>map(myorder -> {
                myorder.setStatus(orders.getStatus());
                return orderRepository.save(myorder);
            });
            if(orderList.get() != null) {
                return responseUtils.getResponseEntity(orderList, "1", "Update order success!", HttpStatus.OK);
            }else {
                return responseUtils.getResponseEntity(null, "-1", "Update order fail!", HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Update order fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/deleteorder")
    public ResponseEntity<?> deleteorder(@RequestBody Orders orders) throws Exception {
        try {
            Optional<Orders> orderList = orderRepository.findById(orders.getId()).<Orders>map(myorder -> {
                myorder.setStatus("Canceled");
                myorder.setDelete(orders.isDelete());
                return orderRepository.save(myorder);
        });
            if(orderList.get() != null) {
                return responseUtils.getResponseEntity(orderList, "1", "Update order success!", HttpStatus.OK);
            }else {
                return responseUtils.getResponseEntity(null, "-1", "Update order fail!", HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Update order fail!", HttpStatus.BAD_REQUEST);
        }
    }
    // API ORDER //

    // API ORDER DETAIL//
    @GetMapping("/listorderdetail")
    public ResponseEntity<?> listorderdetail(@RequestParam(value = "id",defaultValue = "") Integer id) {
        try {
            List<OrderDetails> detailsList = orderDetailRepository.getByOrderId(id);
            return responseUtils.getResponseEntity(detailsList, "1", "Get order detail success!", HttpStatus.OK);
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Get order detail fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/neworderdetail")
    public ResponseEntity<?> neworderdetail(@RequestBody OrderDetails orderDetails) {
//        try {
            OrderDetails detailList = orderDetailRepository.save(orderDetails);
            return responseUtils.getResponseEntity(detailList, "1", "Create order detail success!", HttpStatus.OK);
//        }catch (Exception e){
//            return responseUtils.getResponseEntity(null, "-1", "Create order detail fail!", HttpStatus.BAD_REQUEST);
//        }
    }
    // API ORDER DETAIL//

    // API PAYMENT //
    @PostMapping("/listpayment")
    public ResponseEntity<?> listpayment() {
        try {
            List<Payment> paymentList = (List<Payment>) paymentRepository.findAll();
            return responseUtils.getResponseEntity(paymentList, "1", "Get payment success!", HttpStatus.OK);
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Get payment fail!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/newpayment")
    public ResponseEntity<?> listpayment(@RequestBody Payment payment) {
        try {
            Payment paymentList = paymentRepository.save(payment);
            return responseUtils.getResponseEntity(paymentList, "1", "Create payment success!", HttpStatus.OK);
        }catch (Exception e){
            return responseUtils.getResponseEntity(null, "-1", "Create payment fail!", HttpStatus.BAD_REQUEST);
        }
    }
    // API PAYMENT //

    // API CHART //
    @PostMapping("/count")
    int count(@RequestBody Time time) {
        try {
            return orderRepository.countByTime(time.getTimeStart(), time.getTimeEnd(), time.getCategory());
        } catch (Exception e) {
            return 0;
        }
    }

}

