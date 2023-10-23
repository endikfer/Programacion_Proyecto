package Canciones;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;



public class BD_Usuaruis {
	
	public static HashMap<Usuario, ArrayList<Cancion>> Usuarios = new HashMap<>();
	
	

	@SuppressWarnings("static-access")
	public static void guardarUsuarios(String fichero) {

        FileWriter fw = null;
        PrintWriter pw = null;
        try
        {
            fw = new FileWriter(fichero);
            pw = new PrintWriter(fw);

            for (Usuario u : Usuarios.keySet()) {
            	String linea = "";
            	String sep = ",";
            	linea += u.getName_real()+ sep
            			+ u.getName_us() + sep 
            			+ u.getPassword() + sep
            			+ u.getGmail();
            	for(Cancion c: Usuarios.get(u)) {
            		linea+= sep + c.getNombre_Ar();
            		linea += sep + c.getName_can();
            		
            		
            	}
            	
            			
            	
            	pw.println(linea + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
	
	           if (null != fichero)
	              fw.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
        }
	}
	public static void cargarUsuarios(String fichero) throws IOException {
		try {
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			String ln = null;
			while ((ln= br.readLine()) != null) {
				String[] campos = ln.split(",");
				Usuario u = new Usuario();
				u.setName_real(campos[0]);
				u.setName_us(campos[1]);
				u.setPassword(campos[2]);
				u.setGmail(campos[3]);			
				if(!Usuarios.containsKey(u)) {
					Usuarios.put(u,new ArrayList<Cancion>());
				}
				int i = 4;
				while ((campos[i])!= null) {
					Cancion c = new Cancion(campos[i], campos[i+1]);
					if(!Usuarios.get(u).contains(c)) {
						Usuarios.get(u).add(c);
					}
						
					}
					i += 2;
				}
				
				
				
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
