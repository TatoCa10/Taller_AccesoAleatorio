package Universidad;

public class Estudiantes {
    
    private int Id;
    private char[] Nombre= new char[20];
    private char[] Apellido= new char[20];
    private int Telefono;
    private boolean Existe;
    
    public void CrearEstudiante(int id, String nombre, String apellido, int telefono){
        this.setId(id);
        this.setNombre(nombre.toCharArray());
        this.setApellido(apellido.toCharArray());
        this.setTelefono(telefono);
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public char[] getNombre() {
        return Nombre;
    }

    public void setNombre(char[] Nombre) {
        this.Nombre = Nombre;
    }

    public char[] getApellido() {
        return Apellido;
    }

    public void setApellido(char[] Apellido) {
        this.Apellido = Apellido;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }
    
        public boolean getExiste() {
        return Existe;
    }

    public void setExiste(boolean Existe) {
        this.Existe = Existe;
    }
    
    
    
}
