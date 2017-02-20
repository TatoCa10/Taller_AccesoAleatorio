package Universidad;

public class Profesores {
    
    private int Id;
    private char[] Nombre=new char[20];
    private char[] Apellido= new char[20];
    private int Ext;
    private boolean Existe;

//    public Profesores() {
//        this.Nombre= new char[20];
//        this.Apellido= new char[20];
//    }
    
    public void CrearProfesor(int id, String nombre, String apellido, int ext){
        this.setId(id);
        this.setNombre(nombre.toCharArray());
        this.setApellido(apellido.toCharArray());
        this.setExt(ext);
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

    public int getExt() {
        return Ext;
    }

    public void setExt(int Ext) {
        this.Ext = Ext;
    }
    
    public boolean getExiste() {
        return Existe;
    }

    public void setExiste(boolean Existe) {
        this.Existe = Existe;
    }
    
    
    
}
