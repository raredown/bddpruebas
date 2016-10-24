/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.aves;

import beans.Aves;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daw2
 */
@WebServlet(name = "AccesoBD", urlPatterns = {"/AccesoBD"})
public class AccesoBD extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexion;
        PreparedStatement preparada;
        ResultSet resultado;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        String cadenaConexion = "jdbc:mysql://localhost:3306/pruebasJAVA";
        try {

            conexion = DriverManager.getConnection(cadenaConexion, "java2017", "2017");

            if (request.getParameter("unanilla") != null) {
                String sql = "select * from aves where anilla =?";
                preparada = conexion.prepareStatement(sql);
                preparada.setString(1, request.getParameter("anillas"));
                resultado = preparada.executeQuery();
                if (resultado.next()) {
                    Aves avecita = new Aves();

                    avecita.setAnilla(resultado.getString("anilla"));
                    avecita.setEspecie(resultado.getString("nombre"));
                    avecita.setFecha(resultado.getString("fecha"));
                    avecita.setLugar(resultado.getString("lugar"));
                    request.setAttribute("aves", avecita);
                    request.getRequestDispatcher("jsp/UnaAve.jsp").forward(request, response);
                } else {
                    request.setAttribute("error", "No ahi niguna q se llame asi en la tabla");
                    request.getRequestDispatcher("jsp/Errores.jsp").forward(request, response);
                }
                preparada.close();
                resultado.close();
            } else if (request.getParameter("toda") != null) {
                String sql = "select * from aves";
                preparada = conexion.prepareStatement(sql);
                resultado = preparada.executeQuery();
                ArrayList<Aves> array = new ArrayList();
                while (resultado.next()) {
                    Aves avecita = new Aves();

                    avecita.setAnilla(resultado.getString("anilla"));
                    avecita.setEspecie(resultado.getString("nombre"));
                    avecita.setFecha(resultado.getString("fecha"));
                    avecita.setLugar(resultado.getString("lugar"));
                    //request.setAttribute("aves", avecita);
                    array.add(avecita);
                }
                request.setAttribute("pollos", array);
                request.getRequestDispatcher("jsp/TodaAve.jsp").forward(request, response);
                preparada.close();
                resultado.close();
            } else if (request.getParameter("aleatorio") != null) {
                String sql = "SELECT * FROM aves ORDER BY RAND() LIMIT " + request.getParameter("numero");
                preparada = conexion.prepareStatement(sql);
                resultado = preparada.executeQuery();
                ArrayList<Aves> array = new ArrayList();
                while (resultado.next()) {
                    Aves avecita = new Aves();

                    avecita.setAnilla(resultado.getString("anilla"));
                    avecita.setEspecie(resultado.getString("nombre"));
                    avecita.setFecha(resultado.getString("fecha"));
                    avecita.setLugar(resultado.getString("lugar"));
                    //request.setAttribute("aves", avecita);
                    array.add(avecita);
                }
                request.setAttribute("pollos", array);
                request.getRequestDispatcher("jsp/TodaAve.jsp").forward(request, response);
                preparada.close();
                resultado.close();
            }

            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
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
