/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.controller;

import examen.modelo.Usuario;
import examen.modelo.servicio.UsuarioServicio;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Elesban Antonio Gallardo Hernandez
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
            String textUsuario = request.getParameter("textUsuario");
            String textPassword = request.getParameter("textPassword");
            String accion = request.getParameter("accion");
            
            switch(accion){
                case "iniciarSesion": {
                    UsuarioServicio usuarioServicio = new UsuarioServicio();
                    Usuario u = usuarioServicio.getUsuarioByUsuarioPassword(textUsuario, textPassword);

                    if (u != null) {
                        HttpSession sesion = request.getSession(true);
                        sesion.setAttribute("idUsuario", u.getIdUsuario());
                        sesion.setAttribute("nombre", u.getUsuario());
                        sesion.setAttribute("esValida", true);
                        out.print("Usuario encontrado");
                    } else {
                        out.print("Usuario no encontrado");
                    }
                } break;
                case "cerrarSesion": {
                    HttpSession sesion = request.getSession(true);
                    sesion.removeAttribute("esValida");
                    sesion.invalidate();
                } break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
