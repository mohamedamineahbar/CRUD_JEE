package Controller;

import Dao.LivreServices;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Livre;

import java.io.IOException;


@WebServlet("/Crud")
public class Crud extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public Crud() {
        super();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ref = (String) request.getParameter("ref");
        Livre l = LivreServices.getLivreByref(ref);
        request.setAttribute("livre", l);
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/aff.jsp");
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ref = (String) request.getParameter("ref");
        String title = (String) request.getParameter("title");
        double prix =  Double.parseDouble(request.getParameter("prix"))  ;
        int qte =  Integer.parseInt(request.getParameter("qte")) ;
        String msg;
        if(ref.isEmpty() || title.isEmpty() || qte ==-1) {
            msg = "veuillez saisir tous les informations";
        }else {
            LivreServices.addLivre(new Livre(ref,title,prix,qte));
            msg = "le livre ajoute avec succes";
        }
        request.setAttribute("msg", msg);
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}
