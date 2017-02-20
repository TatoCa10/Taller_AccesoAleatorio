package Universidad;

import Arbol.AdministradorArboles;
import java.io.File;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {

        File FicheroProfesores = new File("profesores2.txt");
        File FicheroEstudiantes = new File("estudiantes2.txt");
        EscrituraAccesoAleatorio EaA = new EscrituraAccesoAleatorio();
        Arbol.AdministradorArboles ArbolAdm = new AdministradorArboles();

        EaA.CrearArchivoProfes(FicheroProfesores, 100);
        EaA.RecorrerProfesores();
//       EaA.RecuperarProfesor(68);
        EaA.ActualizarArchivoProfesores(68, 68, "Carlos", "Correa", 800012, true);

        EaA.LeerArchivoProfesores(68);
    }

}
