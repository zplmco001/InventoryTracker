package web.programming;

import Model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class MainClass extends HttpServlet {
    private ArrayList<Product> products = new ArrayList<>();

    @Override
    public void init(){
        products.add(
                new Product(1,
                        "A very good phone with 10 cameras",1000, 25,"casper V5"));
        products.add(new Product(2,
                "A very good laptop with solid state disk",4000, 12,"HP LifeBook"));
        products.add(
                new Product(3,
                        "A very nice looking purse",1000, 125,"Zara Purse"));
        products.add(new Product(4,
                "A very good quality thermos",200, 45,"Sinbat 1Lt"));

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("id");
        int id = Integer.parseInt(productId);
        request.setAttribute("product", products.get(id-1));
        RequestDispatcher rd =
                request.getRequestDispatcher("show_product.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("prods",products);

        RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
        rd.forward(req,resp);
    }
}
