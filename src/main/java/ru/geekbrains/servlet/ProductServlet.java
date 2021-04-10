package ru.geekbrains.servlet;

import ru.geekbrains.Product;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = "/product/*")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String parameterCount = req.getParameter("count");
        int count;
        try {
            count = Integer.parseInt(parameterCount);
        } catch (NumberFormatException e) {
            count = 10;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<h1>");
        for (Product p : Product.generateProduct(count)) {
            sb.append(p).append("<br>");
        }
        sb.append("</h1>");

        resp.getWriter().printf(sb.toString());
    }

}

