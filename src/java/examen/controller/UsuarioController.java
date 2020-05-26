/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.controller;

import com.google.gson.Gson;
import examen.modelo.Usuario;
import examen.modelo.servicio.UsuarioServicio;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
@WebServlet("/usuario")
public class UsuarioController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            UsuarioServicio usuarioServicio = new UsuarioServicio();
            
            String accion = request.getParameter("accion");
            Gson gson = new Gson();
            switch(accion){
                case "getAll": {
                    out.print(gson.toJson(usuarioServicio.getAllUsuario()));
                } break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
