package controllers.human;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.HumanService;
import services.HumanTypeService;

@WebServlet(name = "EditHumanController", urlPatterns = {"/edit"})
public class EditHumanController extends HttpServlet {

    private final HumanService humanService = new HumanService();
    private final HumanTypeService humanTypeService = new HumanTypeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int humanid = Integer.parseInt(req.getParameter("id"));

        req.setAttribute("human", humanService.find(humanid));
        req.setAttribute("humanTypes", humanTypeService.all());

        req.getRequestDispatcher("edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int humanid = Integer.parseInt(req.getParameter("humanid"));
        String humanname = req.getParameter("humanname");
        String humandob = req.getParameter("humandob");
        boolean humangender = req.getParameter("humangender").equals("true");
        int typeid = Integer.parseInt(req.getParameter("typeid"));

        humanService.updateHuman(humanid, humanname, humandob, humangender, typeid);

        resp.sendRedirect("./");
    }

}
