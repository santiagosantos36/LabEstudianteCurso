/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import co.edu.unipilotoestudiantes.entity.Curso;
import co.edu.unipilotoestudiantes.entity.Estudiante;
import co.edu.unipilotoestudiantes.session.CursoFacadeLocal;
import co.edu.unipilotoestudiantes.session.EstudianteFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author santi
 */
@WebServlet(name = "EstudianteInfo", urlPatterns = {"/EstudianteInfo"})
public class EstudianteInfo extends HttpServlet {

    @EJB
    private CursoFacadeLocal cursoFacade;

    @EJB
    private EstudianteFacadeLocal estudianteFacade;
    private Curso curso;

    public Collection<Estudiante>getEstudiantes(){
    return estudianteFacade.findAll();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
           if(action.equals("Add")){
               
               
                  String studentIdStr = request.getParameter("studentId");
                Integer studentId = Integer.parseInt(studentIdStr);
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String yearLevelStr = request.getParameter("yearLevel");
                Integer yearLevel = Integer.parseInt(yearLevelStr);
                String codigocursoStr = request.getParameter("codigoCurso");
                 Integer codigocurso = Integer.parseInt(codigocursoStr);
                   curso.setCodigoCurso(codigocurso); 
                Estudiante estudiante = new Estudiante(studentId, firstName, lastName, yearLevel,cursoFacade.find(curso.getCodigoCurso()) );
                estudianteFacade.create(estudiante);

            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EstudianteInfo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EstudianteInfo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
