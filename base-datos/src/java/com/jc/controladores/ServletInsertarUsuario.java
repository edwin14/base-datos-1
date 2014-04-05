/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jc.controladores;

import com.jc.model.DAOUsuario;
import com.jc.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author campitos
 */
public class ServletInsertarUsuario extends HttpServlet {

  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String mensaje="no insertado";
        //Pedimos los valores
        
    int id=   Integer.parseInt(request.getParameter("id"));
    String login=    request.getParameter("login");
    String password=    request.getParameter("password");
    
    
    Usuario u=new Usuario(id,login,password);
    u.setId(id);
    u.setLogin(login);
    u.setPassword(password);
   
    DAOUsuario dao=new DAOUsuario();
        try {
            dao.insertar(u);
            mensaje="Tu usuario se guardo con exito :)";
        } catch (Exception ex) {
   mensaje=ex.getMessage();
        }
              out.println(mensaje);    
    }
}