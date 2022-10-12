package controller;

import model.Category;
import model.Product;
import service.ICategoryService;
import service.IProductService;
import service.impl.CategoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/house")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ICategoryService iCategoryService = new CategoryService();
    private CategoryService productService = new CategoryService();
    private IProductService iProductService = new service.impl.ProductService();
    private service.impl.ProductService categoryService = new service.impl.ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                shownewHouse(request, response);
                break;
            case "delete":
                deleteHouse(request, response);
                break;
            case "edit":
                showEditHouse(request, response);
                break;
            case "search":
                searchHouse(request, response);
                break;
            default:
                selectAllCustomer(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                newHouse(request, response);
                break;
            case "edit":
                editHouse(request, response);
                break;
            default:
                selectAllCustomer(request, response);
        }
    }

    private void selectAllCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Category> listcategory = iCategoryService.seclectAll();
        List<Product> listProduct = iProductService.selectAll();
        request.setAttribute("listProduct",listProduct);
        request.setAttribute("listcategory", listcategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void searchHouse(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showEditHouse(HttpServletRequest request, HttpServletResponse response) {
    }

    private void deleteHouse(HttpServletRequest request, HttpServletResponse response) {
    }

    private void shownewHouse(HttpServletRequest request, HttpServletResponse response) {
    }


    private void editHouse(HttpServletRequest request, HttpServletResponse response) {
    }

    private void newHouse(HttpServletRequest request, HttpServletResponse response) {
    }
}
