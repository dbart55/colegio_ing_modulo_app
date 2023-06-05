/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consejodepartamental.entity;

/**
 *
 * @author Diego
 */
public class Usuario {

    private int userId;
    private String nombres;
    private String apellidos;
    private String userName;
    private String password;

    public Usuario() {
    }

    public Usuario(int userId, String nombres, String apellidos, String userName, String password) {
        this.userId = userId;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.userName = userName;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "userId=" + userId + ", nombres=" + nombres + ", apellidos=" + apellidos + ", userName=" + userName + '}';
    }
    
    
}
