/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.modelo.servicio;

import examen.modelo.Usuario;
import examen.util.ConexionMySQL;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Elesban Antonio Gallardo Hernandez
 */
public class UsuarioServicio extends ConexionMySQL {

    private final String tabla = "usuario";
    private Connection conexion;
    private PreparedStatement consulta;

    public Usuario getUsuarioByUsuarioPassword(String textUsuario, String textPassword) throws Exception {
        Usuario usuario = null;
        try {
            conexion = conectar();
            consulta = conexion.prepareStatement("SELECT idUsuario, nombre, usuario, password FROM " + this.tabla + " WHERE usuario = ? AND password = MD5(?)");
            consulta.setString(1, textUsuario);
            consulta.setString(2, textPassword);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                usuario = new Usuario(resultado.getInt("idUsuario"), resultado.getString("nombre"), resultado.getString("usuario"), resultado.getString("password"));
            }
            desconectar();
        } catch (Exception ex) {
            throw new Exception(ex);
        }

        return usuario;
    }

    public List<Usuario> getAllUsuario() throws Exception {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            conexion = conectar();
            consulta = conexion.prepareStatement("SELECT idUsuario, nombre, usuario, password FROM " + this.tabla + " ORDER BY idUsuario");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                usuarios.add(new Usuario(resultado.getInt("idUsuario"), resultado.getString("nombre"), resultado.getString("usuario"), resultado.getString("password")));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex);
        }
        return usuarios;
    }

    public void guardar(Usuario usuario) throws Exception {
        try {
            conexion = conectar();
            if (usuario.getIdUsuario() == 0) {
                consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(nombre, usuario, password) VALUES(?, ?, MD5(?))");
                consulta.setString(1, usuario.getNombre());
                consulta.setString(2, usuario.getUsuario());
                consulta.setString(3, usuario.getPassword());
            } else {
                consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET nombre = ?, usuario = ?, password = MD5(?) WHERE idUsuario = ?");
                consulta.setString(1, usuario.getNombre());
                consulta.setString(2, usuario.getUsuario());
                consulta.setString(3, usuario.getPassword());
                consulta.setInt(4, usuario.getIdUsuario());
            }
            consulta.executeUpdate();
            desconectar();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void eliminar(Usuario usuario) throws Exception {
        try {
            conexion = conectar();
            consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE idUsuario = ?");
            consulta.setInt(1, usuario.getIdUsuario());
            consulta.executeUpdate();
            desconectar();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

}
