/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import co.edu.unipilotoestudiantes.entity.Curso;
import co.edu.unipilotoestudiantes.session.CursoFacadeLocal;
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
@WebServlet(name = "CursoInfo", urlPatterns = {"/CursoInfo"})
public class CursoInfo extends HttpServlet {

    @EJB
    private CursoFacadeLocal cursoFacade;

   
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String action = request.getParameter("action");
           if(action.equals("Add")){
                String codigoStr = request.getParameter("codigoCurso");
                Integer codigo = Integer.parseInt(codigoStr);
                String nombre = request.getParameter("nombre");
                String descripcion = request.getParameter("descripcion");
                

                Curso curso = new Curso(codigo,nombre,descripcion);
                cursoFacade.create(curso);
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CursoInfo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CursoInfo at " + request.getContextPath() + "</h1>");
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
