package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisService;


@WebServlet("/ManterPais.do")
public class ManterPaisController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pNome = request.getParameter("nome");
        String pArea = request.getParameter("area");
        String pPop = request.getParameter("populacao");

        Pais pais = new Pais();
        pais.setNome(pNome);
        pais.setArea(pArea);
        pais.setPopulacao(Long.valueOf(pPop));

        PaisService cs = new PaisService();
        cs.incluirPais(pais);
        pais = cs.carregarPais(pais.getId());

        request.setAttribute("pais", pais);

        RequestDispatcher view = request.getRequestDispatcher("Pais.jsp");
        view.forward(request, response);
    }
}