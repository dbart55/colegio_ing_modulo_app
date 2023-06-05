/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consejodepartamental.entity;

/**
 *
 * @author Diego
 */
public class EventoModalidad {

    private int cod_modalidad;
    private String modalidad;
    private String descripcion;

    public int getCod_modalidad() {
        return cod_modalidad;
    }

    public void setCod_modalidad(int cod_modalidad) {
        this.cod_modalidad = cod_modalidad;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EventoModalidad(int cod_modalidad, String modalidad, String descripcion) {
        this.cod_modalidad = cod_modalidad;
        this.modalidad = modalidad;
        this.descripcion = descripcion;
    }

    public EventoModalidad() {
    }

    public EventoModalidad(int cod_modalidad, String modalidad) {
        this.cod_modalidad = cod_modalidad;
        this.modalidad = modalidad;
    }

    @Override
    public String toString() {
        return this.modalidad;
    }
}
