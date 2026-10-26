package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Escuela;
import model.Estudiante;

public class CrudEstudianteCrontoller {

    @FXML
    private TableColumn<Estudiante, String> colApellido;

    @FXML
    private TableColumn<Estudiante, String> colNombnre;

    @FXML
    private TableColumn<Estudiante, String> colNumeroMatricula;

    @FXML
    private TableColumn<Estudiante, String> colTelefono;

    @FXML
    private TableView<Estudiante> tblEstudiantes;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtMatricula;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;


    private Escuela escuela;

    @FXML
    void actualizarEstudiante(ActionEvent event) {

        Estudiante estudiante = new Estudiante();
        estudiante.setNumeroMatricula(txtMatricula.getText());
        estudiante.setNombre(txtNombre.getText());
        estudiante.setTelefono(txtTelefono.getText());
        estudiante.setApellido(txtApellido.getText());

        escuela.actualizarEstudiante(estudiante);

        limpiarCampos();
        actualizarTabla();
    }

    @FXML
    void eliminarEstudiante(ActionEvent event) {
        eliminarEstudiante();
    }

    public void eliminarEstudiante(){
        Estudiante estudiante = tblEstudiantes.getSelectionModel().getSelectedItem();

        escuela.eliminarEstudiante(estudiante);

        actualizarTabla();

    }

    @FXML
    void guardarEstudiante(ActionEvent event) {

        guardarEstudiantes();

    }

    public void guardarEstudiantes(){
        Estudiante estudiante = new Estudiante();

        estudiante.setNombre(txtNombre.getText());
        estudiante.setApellido(txtApellido.getText());
        estudiante.setTelefono(txtTelefono.getText());
        estudiante.setNumeroMatricula(txtMatricula.getText());

        escuela.agregarEstudiante(estudiante);

        actualizarTabla();

        limpiarCampos();
    }

    private void actualizarTabla(){

        tblEstudiantes.getItems().clear();
        tblEstudiantes.getItems().addAll(escuela.getListaEstudiante());
        tblEstudiantes.refresh();


    }

    private void limpiarCampos(){

        txtApellido.setText("");
        txtNombre.setText("");
        txtMatricula.setText("");
        txtTelefono.setText("");

        txtMatricula.setEditable(true);

    }


    @FXML
    void initialize(){

        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colNombnre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colNumeroMatricula.setCellValueFactory(new PropertyValueFactory<>("numeroMatricula"));


        tblEstudiantes.setOnMouseClicked( mouseEvent ->{

            if(tblEstudiantes.getSelectionModel().getSelectedItem()!= null) cargarCampos();

        });

    }

    private void cargarCampos() {

        Estudiante estudiante = tblEstudiantes.getSelectionModel().getSelectedItem();


        txtNombre.setText(estudiante.getNombre());
        txtTelefono.setText(estudiante.getTelefono());
        txtMatricula.setText(estudiante.getNumeroMatricula());
        txtApellido.setText(estudiante.getApellido());

        txtMatricula.setEditable(false);

    }

    public Escuela getEscuela() {
        return escuela;
    }

    public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }
}




