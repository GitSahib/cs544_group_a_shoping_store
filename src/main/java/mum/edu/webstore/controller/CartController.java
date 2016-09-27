package mum.edu.webstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import mum.edu.webstore.model.Cart;
import mum.edu.webstore.model.CartItem;
import mum.edu.webstore.model.Customer;
import mum.edu.webstore.model.Product;
import mum.edu.webstore.service.CartItemService;
import mum.edu.webstore.service.CartService;
import mum.edu.webstore.service.CustomerService;
import mum.edu.webstore.service.ProductService;

@Controller
@RequestMapping("/customer/cart")
public class CartController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private CartService cartService;
	@Autowired
    private ProductService productService;
	@Autowired
    private CartItemService cartItemService;
	@RequestMapping(value = "/removeItem/{cartItemId}", method = RequestMethod.GET)
    public String removeItem(@PathVariable(value = "cartItemId") long cartItemId,HttpServletRequest request){
		String name = request.getUserPrincipal() != null ? request.getUserPrincipal().getName() : "";
		Customer customer = customerService.getByEmail(name);
        Cart cart = customer.getCart();
        cartItemService.removeById(cartItemId);
        return "redirect:/checkout";
    }
	@RequestMapping
	public String getCart(HttpServletRequest request) {
		String name = request.getUserPrincipal() != null ? request.getUserPrincipal().getName() : "";
		Customer customer = customerService.getByEmail(name);
		Long cartId;
		if (customer.getCart() == null) {
			cartId = (long) 0;
		} else {
			cartId = customer.getCart().getId();
		}
		return "redirect:/customer/cart/" + cartId;
	}
	@RequestMapping(value = "/add/{productId}", method = RequestMethod.GET)
    public String addItem (@PathVariable(value = "productId") int productId, 
    		Model model, HttpServletRequest request,HttpSession session){
		String name = request.getUserPrincipal() != null ? request.getUserPrincipal().getName() : "";
		Customer customer = customerService.getByEmail(name);
		if(customer == null)
		{
			return "redirect:/customerinfo";
		}
        Cart cart = customer.getCart();
        if (cart == null) {
			cart = new Cart();
			cart.setCustomer(customer);
			cart.setCartItems(new ArrayList<CartItem>());
			cart.setGrandTotal(0);
			cartService.save(cart);
		} 
        Product product = productService.get(productId);
        List<CartItem> cartItems = cart.getCartItems();

        for (int i=0; i < cartItems.size(); i++){
            if(product.getId() == cartItems.get(i).getProduct().getId()){
                CartItem cartItem = cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartItem.setTotalPrice(product.getPrice()*cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);
                cart.getGrandTotal();
                session.setAttribute("cartItems", cart.getCartItems().size());
                model.addAttribute("cart",cart);
                session.setAttribute("cartsession",cart);
                return "redirect:/index";
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(product.getPrice()*cartItem.getQuantity());
        cartItem.setCart(cart);
        cart.getGrandTotal();
        cartService.save(cart);
        cartItemService.addCartItem(cartItem);
        model.addAttribute("cart",cart);
        session.setAttribute("cartsession",cart);
        session.setAttribute("cartItems", cart.getCartItems().size());
        return "redirect:/index";
    }
	@RequestMapping("/{cartId}")
	public String getCartRedirect(@PathVariable(value = "cartId") long cartId, Model model,HttpSession session) {
		model.addAttribute("cartId", cartId);
		
		Cart cart;
		if (cartId == 0) {
			cart = new Cart();
			cart.setCartItems(new ArrayList<CartItem>());
		} 
		else 
		{
			cart = cartService.getCartById(cartId);
			if(cart.getCartItems() == null)
			{
				cart.setCartItems(new ArrayList<CartItem>());
			}
		}
		session.setAttribute("cartsession",cart);
		session.setAttribute("cartItems", cart.getCartItems().size());
		model.addAttribute("cart",cart);
		return "checkout";
	}

} // The End of Class;