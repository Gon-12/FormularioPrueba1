package model;

import java.util.ArrayList;

public class Escuela {

    private String nombre;

    private ArrayList<Estudiante> listaEstudiante;


    public Escuela(String nombre) {
        this.nombre = nombre;
        listaEstudiante = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {

        listaEstudiante.add(estudiante);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Estudiante> getListaEstudiante() {
        return listaEstudiante;
    }

    public void setListaEstudiante(ArrayList<Estudiante> listaEstudiante) {
        this.listaEstudiante = listaEstudiante;
    }

    public void eliminarEstudiante(Estudiante estudiante) {
        listaEstudiante.remove(estudiante);
    }

    public void actualizarEstudiante(Estudiante estudiante) {

        for (Estudiante aux:listaEstudiante){

            if(aux.getNumeroMatricula().equals(estudiante.getNumeroMatricula())){

                aux.setTelefono(estudiante.getTelefono());
                aux.setApellido(estudiante.getApellido());
                aux.setNombre(estudiante.getNombre());
            }
        }
    }
}
