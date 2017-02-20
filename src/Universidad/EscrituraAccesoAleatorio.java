package Universidad;

import Arbol.AdministradorArboles;
import Arbol.NodoArbol;
import java.io.*;
import org.fluttercode.datafactory.*;
import org.fluttercode.datafactory.impl.DataFactory;

public class EscrituraAccesoAleatorio {
  
    RandomAccessFile raf;
    RandomAccessFile raf2;
    DataFactory data;
    
    
    Arbol.AdministradorArboles ArbolAdm = new AdministradorArboles();
    Arbol.AdministradorArboles ArbolAdm2 = new AdministradorArboles();
    NodoArbol arbol = null;
    NodoArbol arbol2 = null;
    
    public void CrearArchivoEstudiantes(File nombreArchivo, int numero) throws FileNotFoundException, IOException{

            this.raf = new RandomAccessFile(nombreArchivo, "rw");
            this.data = new DataFactory();
            
            for(int x=0; x<numero; x++){
                
                long pos = raf.getFilePointer();
                int id = data.getNumberBetween(1, 100);
                
                ArbolAdm.insertarNodo(id, pos);//Insertar ID y Pos Al arbol
                
                raf.writeInt(id); //Agrega el ID al profesor
                
                String NombreString=data.getFirstName();
                char[] NombreMedido= NombreString.toCharArray();
                int TamañoNombre= NombreMedido.length*2;
                
                if(TamañoNombre<40){
                    raf.writeUTF(NombreString);      //Agrega el Nombre al profesor
                    raf.seek(raf.getFilePointer()+(40-TamañoNombre));
                }else{
                    char[] NombreCortado = null;
                    for(int i=0; i<20;i++){
                        NombreCortado[i]=NombreMedido[i];  // Agrega solo los bytes posibles en el campo de Nombre del profesor
                    }
                    String NombreStringCortado= new String(NombreCortado);
                    int TamañoNombreCortado= NombreCortado.length*2;
                    raf.writeChars(NombreStringCortado);
                    raf.seek(raf.getFilePointer()+(40-TamañoNombreCortado));
                }
                
                String ApellidoString=data.getLastName();
                char[] ApellidoMedido= ApellidoString.toCharArray();
                int TamañoApellido= ApellidoMedido.length*2;
                
                if(TamañoApellido<40){
                    raf.writeChars(ApellidoString);  //Agrega el Apellido al profesor
                    raf.seek(raf.getFilePointer()+(40-TamañoApellido));
                }else{
                    char[] ApellidoCortado = null;
                    for(int i=0; i<20;i++){
                        ApellidoCortado[i]=ApellidoMedido[i];  // Agrega solo los bytes posibles en el campo de Apellido del profesor
                    }
                    String ApellidoStringCortado= new String(ApellidoCortado);
                    int TamañoApellidoCortado= ApellidoCortado.length*2;
                    raf.writeChars(ApellidoStringCortado);
                    raf.seek(raf.getFilePointer()+(40-TamañoApellidoCortado));
                }
                
                raf.writeInt(data.getNumberBetween(100, 500)); //Agrega Extension al profesor
                raf.writeBoolean(true);
                System.out.println("Agregado con exito: "+(x+1));
            }

    }
    
    public void CrearArchivoProfes(File nombreArchivo, int numero) throws FileNotFoundException, IOException{
        
         this.raf2 = new RandomAccessFile(nombreArchivo, "rw");
            this.data = new DataFactory();
            
            for(int x=0; x<numero; x++){
                
                long pos = raf2.getFilePointer();
                int id = data.getNumberBetween(1, 100);
                
                ArbolAdm2.insertarNodo(id, pos);//Insertar ID y Pos Al arbol
                
                raf2.writeInt(id); //Agrega el ID al Est
                String NombreString=data.getFirstName();
                char[] NombreMedido= NombreString.toCharArray();
                int TamañoNombre= NombreMedido.length*2;
                
                if(TamañoNombre<40){
                    raf2.writeChars(NombreString);      //Agrega el Nombre al Est
                    raf2.seek(raf2.getFilePointer()+(40-TamañoNombre));
                }else{
                    char[] NombreCortado = null;
                    for(int i=0; i<20;i++){
                        NombreCortado[i]=NombreMedido[i];  // Agrega solo los bytes posibles en el campo de Nombre del Est
                    }
                    String NombreStringCortado= new String(NombreCortado);
                    int TamañoNombreCortado= NombreCortado.length*2;
                    raf2.writeChars(NombreStringCortado);
                    raf2.seek(raf2.getFilePointer()+(40-TamañoNombreCortado));
                }
                
                String ApellidoString=data.getLastName();
                char[] ApellidoMedido= ApellidoString.toCharArray();
                int TamañoApellido= ApellidoMedido.length*2;
                
                if(TamañoApellido<40){
                    raf2.writeChars(ApellidoString);  //Agrega el Apellido al profesor
                    raf2.seek(raf2.getFilePointer()+(40-TamañoApellido));
                }else{
                    char[] ApellidoCortado = null;
                    for(int i=0; i<20;i++){
                        ApellidoCortado[i]=ApellidoMedido[i];  // Agrega solo los bytes posibles en el campo de Apellido del profesor
                    }
                    String ApellidoStringCortado= new String(ApellidoCortado);
                    int TamañoApellidoCortado= ApellidoCortado.length*2;
                    raf2.writeChars(ApellidoStringCortado);
                    raf2.seek(raf2.getFilePointer()+(40-TamañoApellidoCortado));
                }
                
                raf2.writeInt(data.getNumberBetween(8000000, 8000000+numero)); //Agrega Ext al profesor
                raf2.writeBoolean(true);
            }
        
        
}
    
    public void LeerArchivoEstudiantes(int id) throws IOException{
        
        long pos= ArbolAdm.buscar(id);
        
        raf.seek(pos);
        raf.readInt(); //Lee ID
        raf.seek(pos+4);
        raf.readLine(); //Lee Nombre
        raf.seek(pos+4+40);
        raf.readLine(); //Lee Apellido
        raf.seek(pos+4+40+40);
        raf.readInt(); //Lee Ext
        raf.seek(pos+4+40+40+4);
        raf.readBoolean(); //Lee Existencia
    }
    
        public void LeerArchivoProfesores(int id) throws IOException{
       
            
            long pos= ArbolAdm2.buscar(id);
        raf2.seek(pos+88);
        boolean existe=raf2.readBoolean();
        if(existe){
        
        raf2.seek(pos);
            System.out.println(raf2.getFilePointer());
            System.out.println(raf2.readInt()); //Lee ID
        raf2.seek(pos+4);
            System.out.println(raf2.readUTF()); //Lee Nombre
        raf2.seek(pos+4+40);
            System.out.println(raf2.readUTF()); //Lee Apellido
        raf2.seek(pos+4+40+40);
            System.out.println(raf2.readInt()); //Lee Ext
//        raf2.skipBytes(ValorBytesPosInicial+4+40+40+4);
//            System.out.println(raf2.readBoolean()); //Lee Existencia
        }else{
            System.out.println("No Existe el registro");
        
        }
    }
    
    public void ActualizarArchivoEstudiantes(int ValorBytesPosInicialActualizar, int Id, String Nombre, String Apellido, int Ext, boolean Existe) throws IOException{
        raf.skipBytes(ValorBytesPosInicialActualizar+4+40+40+4);
        boolean check=raf.readBoolean();
        
        if(check==true){
        raf.skipBytes(ValorBytesPosInicialActualizar);
        raf.writeInt(Id);

                char[] NombreActMedido= Nombre.toCharArray();
                int TamañoNombreAct= NombreActMedido.length*2;
                
                if(TamañoNombreAct<40){
                    raf.writeChars(Nombre);  //Agrega el Apellido al profesor
                    raf.seek(raf.getFilePointer()+(40-TamañoNombreAct));
                }else{
                    char[] NombreActCortado = null;
                    for(int i=0; i<20;i++){
                        NombreActCortado[i]=NombreActMedido[i];  // Agrega solo los bytes posibles en el campo de Apellido del profesor
                    }
                    String NombreActStringCortado= new String(NombreActCortado);
                    int TamañoNombreActCortado= NombreActCortado.length*2;
                    raf.writeChars(NombreActStringCortado);
                    raf.seek(raf.getFilePointer()+(40-TamañoNombreActCortado));
                }
                
                char[] ApellidoActMedido= Apellido.toCharArray();
                int TamañoApellidoAct= ApellidoActMedido.length*2;
                
                if(TamañoApellidoAct<40){
                    raf.writeChars(Apellido);  //Agrega el Apellido al profesor
                    raf.seek(raf.getFilePointer()+(40-TamañoApellidoAct));
                }else{
                    char[] ApellidoActCortado = null;
                    for(int i=0; i<20;i++){
                        ApellidoActCortado[i]=ApellidoActMedido[i];  // Agrega solo los bytes posibles en el campo de Apellido del profesor
                    }
                    String ApellidoActStringCortado= new String(ApellidoActCortado);
                    int TamañoApellidoActCortado= ApellidoActCortado.length*2;
                    raf.writeChars(ApellidoActStringCortado);
                    raf.seek(raf.getFilePointer()+(40-TamañoApellidoActCortado));
                }
        raf.writeInt(Ext);
        raf.writeBoolean(Existe);
    } else{
            System.out.println("El dato no se puede actaulizar, No existe.");
        }
    }
    
    public void ActualizarArchivoProfesores(int id, int New_Id, String Nombre, String Apellido, int Telefono, boolean Existe) throws IOException{
        
        long pos= ArbolAdm2.buscar(id);
        raf2.seek(pos+4+40+40+4);
        boolean check=raf2.readBoolean();
        if(check==true){
        raf2.seek(pos);
        raf2.writeInt(New_Id);

                char[] NombreActMedido= Nombre.toCharArray();
                int TamañoNombreAct= NombreActMedido.length*2;
                
                if(TamañoNombreAct<40){
                    raf2.writeChars(Nombre);  //Agrega el Apellido al profesor
                    raf2.seek(raf2.getFilePointer()+(40-TamañoNombreAct));
                }else{
                    char[] NombreActCortado = null;
                    for(int i=0; i<20;i++){
                        NombreActCortado[i]=NombreActMedido[i];  // Agrega solo los bytes posibles en el campo de Apellido del profesor
                    }
                    String NombreActStringCortado= new String(NombreActCortado);
                    int TamañoNombreActCortado= NombreActCortado.length*2;
                    raf2.writeChars(NombreActStringCortado);
                    raf2.seek(raf2.getFilePointer()+(40-TamañoNombreActCortado));
                }
                
                char[] ApellidoActMedido= Apellido.toCharArray();
                int TamañoApellidoAct= ApellidoActMedido.length*2;
                
                if(TamañoApellidoAct<40){
                    raf2.writeChars(Apellido);  //Agrega el Apellido al profesor
                    raf2.seek(raf2.getFilePointer()+(40-TamañoApellidoAct));
                }else{
                    char[] ApellidoActCortado = null;
                    for(int i=0; i<20;i++){
                        ApellidoActCortado[i]=ApellidoActMedido[i];  // Agrega solo los bytes posibles en el campo de Apellido del profesor
                    }
                    String ApellidoActStringCortado= new String(ApellidoActCortado);
                    int TamañoApellidoActCortado= ApellidoActCortado.length*2;
                    raf2.writeChars(ApellidoActStringCortado);
                    raf2.seek(raf2.getFilePointer()+(40-TamañoApellidoActCortado));
                }
        raf2.writeInt(Telefono);
        raf2.writeBoolean(Existe);
    
    }else{
            System.out.println("El dato no se puede actualizar, No existe.");
        }
    }
    
    public void EliminarEstudiante(int ValorBytes) throws IOException{
        
        raf.seek(ValorBytes+1);
        System.out.println("Persona Eliminada ID:"+raf.readInt());
        raf.skipBytes(ValorBytes+4+40+40+4);
        raf.writeBoolean(false);
        
    }
    
    public void EliminarProfesor(int id) throws IOException{
        
        long pos= ArbolAdm2.buscar(id);
        raf2.seek(pos);
        System.out.println("Persona Eliminada ID:"+raf2.readInt());
        raf2.seek(pos+4+40+40+4);
        raf2.writeBoolean(false);
        
    }
    public void RecuperarProfesor(int id) throws IOException{
        
        long pos= ArbolAdm2.buscar(id);
        raf2.seek(pos);
        System.out.println("Persona Recuperada ID:"+raf2.readInt());
        raf2.seek(pos+4+40+40+4);
        raf2.writeBoolean(true);
        
    }
    
    public void RecorrerEstudiantes() throws IOException{
        raf.seek(0);
        int Numero=1;
        int corredor=0;
        int Id;
        Long Pos;
        
        while(corredor<raf.length()){
            Pos=raf.getFilePointer();
            Id=raf.readInt();
            raf.seek(85*Numero);
            //ArbolAdm.insertarNodo( Id, Pos);
            System.out.println(Id + " ->" + Pos);
            corredor=corredor+89;
            Numero++;
        }
       System.out.println("------------------------|||||||||||||||||||-----------------------------");
       ArbolAdm.inOrder();
    }
    
    public void RecorrerProfesores() throws IOException{
//        int corredor=0;
//        while(corredor<raf.length()){
//        raf2.seek(corredor);
//            System.out.println(raf2.readLine());
//        corredor=corredor+90;
//        }

        raf2.seek(0);
        int Numero=1;
        int corredor=0;
        int Id;
        Long Pos;
        
        while(corredor<raf2.length()){
            Pos=raf2.getFilePointer();
            Id=raf2.readInt();
            raf2.seek(85*Numero);
            //ArbolAdm2.insertarNodo( Id, Pos);
            System.out.println(Id + " ->" + Pos);
            corredor=corredor+89;
            Numero++;
        }
       System.out.println("------------------------|||||||||||||||||||-----------------------------");
       ArbolAdm2.inOrder();

    }
    
}

