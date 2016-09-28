package mum.edu.webstore.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.CreditCard;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.Transaction.Status;
import com.braintreegateway.TransactionRequest;
import com.braintreegateway.ValidationError;

import mum.edu.webstore.WebStoreAppCtxHolder;
import mum.edu.webstore.model.Cart;
import mum.edu.webstore.model.CartItem;
import mum.edu.webstore.model.Customer;
import mum.edu.webstore.model.Order;
import mum.edu.webstore.model.OrderItem;
import mum.edu.webstore.model.PaymentType;
import mum.edu.webstore.service.CartItemService;
import mum.edu.webstore.service.CustomerService;
import mum.edu.webstore.service.OrderService;
@RequestMapping(value = "/gateway/")
@Controller
public class BCheckoutController {
	@Autowired
 	private CustomerService customerService;
 	@Autowired
 	private CartItemService cartItemService;
 	@Autowired
 	private OrderService orderService;
 	
 	private BraintreeGateway gateway = WebStoreAppCtxHolder.gateway;

     private Status[] TRANSACTION_SUCCESS_STATUSES = new Status[] {
        Transaction.Status.AUTHORIZED,
        Transaction.Status.AUTHORIZING,
        Transaction.Status.SETTLED,
        Transaction.Status.SETTLEMENT_CONFIRMED,
        Transaction.Status.SETTLEMENT_PENDING,
        Transaction.Status.SETTLING,
        Transaction.Status.SUBMITTED_FOR_SETTLEMENT
     };
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root(Model model) {
        return "redirect:/gateway/checkouts";
    }

    @RequestMapping(value = "/checkouts", method = RequestMethod.GET)
    public String checkout(Model model,HttpServletRequest request) {
        String clientToken = gateway.clientToken().generate();
        model.addAttribute("clientToken", clientToken);
        String name = request.getUserPrincipal() != null ? request.getUserPrincipal().getName() : "";
		Customer customer = customerService.getByEmail(name.toString());
		Cart cart = customer.getCart();
		if(cart.getCartItems().size() <= 0)
		{
			return "redirect:/checkout";
		}
		model.addAttribute("order",new Order());
		model.addAttribute("amount",cart.getGrandTotal());
        return "checkouts/new";
    }
    
    @RequestMapping(value = "/checkout/{order_id}", method = RequestMethod.GET)
    public String checkoutOrder(@PathVariable long order_id, Model model,HttpServletRequest request) {
    	Order order = orderService.get(order_id);
    	
        String clientToken = gateway.clientToken().generate();
        model.addAttribute("clientToken", clientToken);
        
        
        
        /*
        String name = request.getUserPrincipal() != null ? request.getUserPrincipal().getName() : "";
		Customer customer = customerService.getByEmail(name.toString());
		Cart cart = customer.getCart();
		if(cart.getCartItems().size() <= 0)
		{
			return "redirect:/checkout";
		}
		*/
        
		model.addAttribute("order", order);
		model.addAttribute("amount",order.getTotal());
        return "checkouts/new";
    }
    
    @RequestMapping(value = "/checkouts", method = RequestMethod.POST)
    public String postForm(@Valid Order order,
    		@RequestParam("amount") String amount, 
    		@RequestParam("payment_method_nonce") String nonce, 
    		Model model, final RedirectAttributes redirectAttributes,HttpServletRequest req) {
        BigDecimal decimalAmount;
        try {
            decimalAmount = new BigDecimal(amount);
        } catch (NumberFormatException e) {
            redirectAttributes.addFlashAttribute("errorDetails", "Error: 81503: Amount is an invalid format.");
            return "redirect:/gateway/checkouts";
        }

        TransactionRequest request = new TransactionRequest()
            .amount(decimalAmount)
            .paymentMethodNonce(nonce)
            .options()
                .submitForSettlement(true)
                .done();

        Result<Transaction> result = gateway.transaction().sale(request);

        if (result.isSuccess()) {
            Transaction transaction = result.getTarget();
            String name = req.getUserPrincipal() != null ? req.getUserPrincipal().getName() : "";
    		Customer customer = customerService.getByEmail(name.toString());
    		Cart cart = customer.getCart();
    		

            return "redirect:/gateway/checkouts/" + transaction.getId();
            
        } else if (result.getTransaction() != null) {
            Transaction transaction = result.getTransaction();
            return "redirect:/gateway/checkouts/" + transaction.getId();
        } else {
            String errorString = "";
            for (ValidationError error : result.getErrors().getAllDeepValidationErrors()) {
               errorString += "Error: " + error.getCode() + ": " + error.getMessage() + "\n";
            }
            redirectAttributes.addFlashAttribute("errorDetails", errorString);
            return "redirect:/gateway/checkouts";
        }
    }
    
    @RequestMapping(value = "/checkoutorder/{order_id}", method = RequestMethod.POST)
    public String checkoutOrder(@PathVariable long order_id,
    		@RequestParam("amount") String amount, 
    		@RequestParam("payment_method_nonce") String nonce, 
    		Model model, final RedirectAttributes redirectAttributes,HttpServletRequest req) {
    	Order order = orderService.get(order_id);
        BigDecimal decimalAmount;
        try {
            decimalAmount = new BigDecimal(amount);
        } catch (NumberFormatException e) {
            redirectAttributes.addFlashAttribute("errorDetails", "Error: 81503: Amount is an invalid format.");
            return "redirect:/gateway/checkouts";
        }

        TransactionRequest request = new TransactionRequest()
            .amount(decimalAmount)
            .orderId(""+order.getId())
            .paymentMethodNonce(nonce)
            .options()
                .submitForSettlement(true)
                .done();

        Result<Transaction> result = gateway.transaction().sale(request);

        if (result.isSuccess()) {
            Transaction transaction = result.getTarget();
            String name = req.getUserPrincipal() != null ? req.getUserPrincipal().getName() : "";
    		Customer customer = customerService.getByEmail(name.toString());
    		Cart cart = customer.getCart();
    		
    		order.setPaid(true);
    		orderService.save(order);
    		
    		
    		//cartItemService.removeAllCartItems(cart);
    		
            return "redirect:/gateway/checkouts/" + transaction.getId();
            
        } else if (result.getTransaction() != null) {
            Transaction transaction = result.getTransaction();
            return "redirect:/gateway/checkouts/" + transaction.getId();
        } else {
            String errorString = "";
            for (ValidationError error : result.getErrors().getAllDeepValidationErrors()) {
               errorString += "Error: " + error.getCode() + ": " + error.getMessage() + "\n";
            }
            redirectAttributes.addFlashAttribute("errorDetails", errorString);
            return "redirect:/gateway/checkouts";
        }
    }

    @RequestMapping(value = "/checkouts/{transactionId}")
    public String getTransaction(Order order, @PathVariable String transactionId, Model model) {
        Transaction transaction;
        CreditCard creditCard;
        com.braintreegateway.Customer customer;

        try {
            transaction = gateway.transaction().find(transactionId);
            creditCard = transaction.getCreditCard();
            customer = transaction.getCustomer();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            return "redirect:/gateway/checkouts";
        }

        model.addAttribute("order", order);
        model.addAttribute("isSuccess", Arrays.asList(TRANSACTION_SUCCESS_STATUSES).contains(transaction.getStatus()));
        model.addAttribute("transaction", transaction);
        model.addAttribute("creditCard", creditCard);
        model.addAttribute("customer", customer);

        return "checkouts/show";
    }
}