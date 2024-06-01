package controllers.human;

import entities.Human;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.HumanService;
import services.HumanTypeService;

@WebServlet(name = "CreateHumanController", urlPatterns = {"/create"})
public class CreateHumanController extends HttpServlet {

    private final HumanService humanService = new HumanService();

    private final HumanTypeService humanTypeService = new HumanTypeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("humanTypes", humanTypeService.all());

        req.getRequestDispatcher("edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String humanname = req.getParameter("humanname");
        String humandob = req.getParameter("humandob");
        boolean humangender = req.getParameter("humangender").equals("true");
        int typeid = Integer.parseInt(req.getParameter("typeid"));

        humanService.createHuman(humanname, humandob, humangender, typeid);

        resp.sendRedirect("./");
    }

}
