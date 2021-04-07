package com.poly.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.poly.model.*;
import com.poly.repositories.*;

@RestController
//@CrossOrigin(origins = {"http://localhost:8080", "https://webdemodoan.herokuapp.com"})
@RequestMapping("/api")
public class RestfulAPI {
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
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CartRepository cartRepository;

    // API CUSTOMER //
    @PostMapping("/listcustomer")
    List<Users> alluser() {
        return (List<Users>) userRepository.findAll();
    }

    @PostMapping("/newcustomer")
    Users newProduct(@RequestBody Users user) {
        return user;
    }

    @PostMapping("/findcustomer")
    Users one(@RequestBody Users user) throws Exception {
        Integer id = user.getId();
        return userRepository.findById(id).orElseThrow(() -> new Exception("User " + id + " not found"));
    }

    @PostMapping("/editcustomer")
    Users replaceCustomer(@RequestBody Users user) throws Exception {
        Integer id = user.getId();
        if (user.getImage() == ("")) {
            return userRepository.findById(id).<Users>map(myuser -> {
                myuser.setName(user.getName());
                myuser.setEmail(user.getEmail());
                myuser.setPhone(user.getPhone());
                myuser.setPassword(user.getPassword());
                myuser.setAddress(user.getAddress());
                myuser.setStatus(user.getStatus());
                myuser.setUsername(user.getUsername());
                myuser.setRole(user.getRole());
                return userRepository.save(myuser);
            }).orElseThrow(() -> new Exception("User " + id + " not found"));
        } else {
            return userRepository.findById(id).<Users>map(myuser -> {
                myuser.setImage(user.getImage());
                myuser.setName(user.getName());
                myuser.setEmail(user.getEmail());
                myuser.setPhone(user.getPhone());
                myuser.setPassword(user.getPassword());
                myuser.setAddress(user.getAddress());
                myuser.setStatus(user.getStatus());
                myuser.setUsername(user.getUsername());
                myuser.setRole(user.getRole());
                return userRepository.save(myuser);
            }).orElseThrow(() -> new Exception("User " + id + " not found"));
        }
    }

    @PostMapping("/deletecustomer")
    void deleteCustomer(@RequestBody Users user) {
        Integer id = user.getId();
        userRepository.deleteById(id);
    }
    // API CUSTOMER //

    // API PRODUCT //
    @PostMapping("/listproduct")
    List<ProductDTO> allproduct() {
        return (List<ProductDTO>) productRepository.innerjoin();
    }

    @PostMapping("/newproduct")
    Product newProduct(@RequestBody Product newProduct) {
        return productRepository.save(newProduct);
    }

    @PostMapping("/findproduct")
    Product one(@RequestBody Product newProduct) throws Exception {
        Integer id = newProduct.getId();
        return productRepository.findById(id).orElseThrow(() -> new Exception("Product " + id + " not found"));
    }

    @PostMapping("/editproduct")
    Product replaceEmployee(@RequestBody Product newProduct) throws Exception {
        Integer id = newProduct.getId();
        if (newProduct.getImage() == ("")) {
            return productRepository.findById(id).map(product -> {
                product.setName(newProduct.getName());
                product.setPrice(newProduct.getPrice());
                product.setDescription(newProduct.getDescription());
                product.setStatus(newProduct.getStatus());
                product.setBrand(newProduct.getBrand());
                product.setQuantity(newProduct.getQuantity());
                product.setCategory(newProduct.getCategory());
                return productRepository.save(product);
            }).orElseThrow(() -> new Exception("Product " + id + " not found"));
        } else {
            return productRepository.findById(id).map(product -> {
                product.setName(newProduct.getName());
                product.setPrice(newProduct.getPrice());
                product.setImage(newProduct.getImage());
                product.setDescription(newProduct.getDescription());
                product.setStatus(newProduct.getStatus());
                product.setBrand(newProduct.getBrand());
                product.setQuantity(newProduct.getQuantity());
                product.setCategory(newProduct.getCategory());
                return productRepository.save(product);
            }).orElseThrow(() -> new Exception("Product " + id + " not found"));
        }
    }

    @PostMapping("/deleteproduct")
    void deleteProduct(@RequestBody Product product) {
        Integer id = product.getId();
        productRepository.deleteById(id);
    }

    @PostMapping("/ProductByBrand/{id}")
    List<Product> ProductByBrand(@PathVariable("id") Integer id) {
        return (List<Product>) productRepository.findProductByBrand(id);
    }

    @PostMapping("/countProductByBrand/{id}")
    int countProductByBrand(@PathVariable("id") Integer id) {
        return productRepository.countProductByBrand(id);
    }

    // API PRODUCT //

    // API BRAND //
    @PostMapping("/listbrand")
    List<Brand> listbrand() {
        return (List<Brand>) brandRepository.findAll();
    }

    @PostMapping("/newbrand")
    Brand newBrand(@RequestBody Brand brand) {
        return brandRepository.save(brand);
    }

    @PostMapping("/deletebrand")
    void deleteBrand(@RequestBody Brand brand) {
        brandRepository.deleteById(brand.getId());
    }
    // API BRAND //

    // API CATEGORY //
    @PostMapping("/listcategory")
    List<Category> listcategory() {
        return (List<Category>) categoryRepository.findAll();
    }

    @PostMapping("/newcategory")
    Category newCategory(@RequestBody Category newCategory) {
        return categoryRepository.save(newCategory);
    }

    @PostMapping("/deletecategory")
    void deleteCategory(@RequestBody Category newCategory) {
        categoryRepository.deleteById(newCategory.getId());
    }
    // API CATEGORY //

    // API BLOG //
    @PostMapping("/listblog")
    List<BlogDTO> listblog() {
        return (List<BlogDTO>) blogRepository.innerjoin();
    }

    @PostMapping("/newblog")
    Blog newblog(@RequestBody Blog blog) {
        return blogRepository.save(blog);
    }

    @PostMapping("/findblog")
    Blog one(@RequestBody Blog blog) throws Exception {
        Integer id = blog.getId();
        return blogRepository.findById(id).orElseThrow(() -> new Exception("Product " + id + " not found"));
    }

    @PostMapping("/editblog")
    Blog replaceBlog(@RequestBody Blog blog) throws Exception {
        Integer id = blog.getId();
        if (blog.getImage() == ("")) {
            return blogRepository.findById(id).<Blog>map(myblog -> {
                myblog.setTitle(blog.getTitle());
                myblog.setDescription(blog.getDescription());
                myblog.setContent(blog.getContent());
                myblog.setCreateBy(blog.getCreateBy());
                return blogRepository.save(myblog);
            }).orElseThrow(() -> new Exception("Blog " + blog.getTitle() + " not found"));
        } else {
            return blogRepository.findById(id).<Blog>map(myblog -> {
                myblog.setTitle(blog.getTitle());
                myblog.setImage(blog.getImage());
                myblog.setDescription(blog.getDescription());
                myblog.setContent(blog.getContent());
                myblog.setCreateBy(blog.getCreateBy());
                return blogRepository.save(myblog);
            }).orElseThrow(() -> new Exception("Blog " + id + " not found"));
        }
    }

    @PostMapping("/deleteblog")
    void deleteBlog(@RequestBody Blog blog) {
        Integer id = blog.getId();
        blogRepository.deleteById(id);
    }

    // API BLOG //

    // API PROMOTION //
    @PostMapping("/listpromo")
    List<Promotion> listPromo() {
        return (List<Promotion>) promotionRepository.findAll();
    }

    @PostMapping("/newpromo")
    Promotion newpromo(@RequestBody Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    @PostMapping("/editpromo")
    Promotion editpromo(@RequestBody Promotion promotion) throws Exception {
        Integer id = promotion.getId();
        if (promotion.getImage() == ("")) {
            return promotionRepository.findById(id).<Promotion>map(mypromo -> {
                mypromo.setPercents(promotion.getPercents());
                mypromo.setCoupon(promotion.getCoupon());
                mypromo.setTimeStart(promotion.getTimeStart());
                mypromo.setTimeEnd(promotion.getTimeEnd());
                mypromo.setDescription(promotion.getDescription());
                return promotionRepository.save(mypromo);
            }).orElseThrow(() -> new Exception("promotion " + id + " not found"));
        } else {
            return promotionRepository.findById(id).<Promotion>map(mypromo -> {
                mypromo.setPercents(promotion.getPercents());
                mypromo.setCoupon(promotion.getCoupon());
                mypromo.setImage(promotion.getImage());
                mypromo.setTimeStart(promotion.getTimeStart());
                mypromo.setTimeEnd(promotion.getTimeEnd());
                mypromo.setDescription(promotion.getDescription());
                return promotionRepository.save(mypromo);
            }).orElseThrow(() -> new Exception("promotion " + id + " not found"));
        }
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

    @PostMapping("/newcart")
    Cart findcart(@RequestBody Cart cart) {
        Cart c = cartRepository.getCartByCustomerId(cart.getCustomerId());
        if(c == null){
            cartRepository.save(cart);
        }
        return cartRepository.getCartByCustomerId(cart.getCustomerId());
    }
    // API CART //

    // API CART ITEM //
    @PostMapping("/newitem")
    Object newitem(@RequestBody CartItem cartItem) throws Exception {
        if (cartItem.getQuantity() != 0) {
            Optional<CartItem> items = itemRepository.findByProductIdAndCartId(cartItem.getProductId(), cartItem.getCartId());
            if(!items.isPresent()) {
                return itemRepository.save(cartItem);
            } else {
                return itemRepository.findByProductIdAndCartId(cartItem.getProductId(), cartItem.getCartId()).<CartItem>map(a ->{
                    a.setQuantity(a.getQuantity()+cartItem.getQuantity());
                    return itemRepository.save(a);
                });
            }
        } else {
            return null;
        }
    }

    @PostMapping("/listitem")
    List<CartDTO> listitem(@RequestBody CartItem cartItem) {
        return (List<CartDTO>) itemRepository.getByCartId(cartItem.getCartId());
    }

    @PostMapping("/removeitem")
    String removeitem(@RequestBody CartItem cartItem) {
        itemRepository.deleteById(cartItem.getId());
        return "Delete Success";
    }
    // API CART ITEM //

    // API ORDER //
    @PostMapping("/listorder")
    List<OrderDetailsDTO> listorder(@RequestBody OrderDetails orderDetails) {
        return (List<OrderDetailsDTO>) orderDetailRepository.getByOrderId(orderDetails.getOrderId());
    }

    @PostMapping("/neworder")
    List<OrderDetails> neworder() {
        return (List<OrderDetails>) orderDetailRepository.findAll();
    }
    // API ORDER //

}
