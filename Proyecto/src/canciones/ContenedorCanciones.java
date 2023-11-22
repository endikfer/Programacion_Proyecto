package canciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import ventanasadd.Loggers;

public class ContenedorCanciones {
	public static ArrayList<Cancion> canciones = new ArrayList<>();
	
	@SuppressWarnings("static-access")
	public static void guardarCanciones(File fichero) {
        FileWriter fw = null;
        PrintWriter pw = null;
        try
        {
            fw = new FileWriter(fichero);
            pw = new PrintWriter(fw);
            String linea = "";
        	String sep = ",";
            for (Cancion c : canciones) {
				linea += c.getNombre_Ar() + sep + c.getName_can() + sep + c.getDuration() + sep + c.getAlbum();
                pw.println(linea + "\n");	
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            Loggers.logger.warning("Error al guardar las canciones desde la base de datos");
        } finally {
           try {
	
	           if (null != fichero)
	              fw.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	              Loggers.logger.warning("Error al guardar las canciones desde la base de datos");
	           }
        }
	}
	public static void cargarCanciones(File fichero) throws IOException {
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			String ln = null;
			while ((ln= br.readLine()) != null) {
				String[] campos = ln.split(",");
				if(campos.length == 4) {
				Cancion u = new Cancion(campos[0], campos[1], Integer.parseInt(campos[2]), campos[3]);
				canciones.add(u);
				}
			}
			br.close();
			fr.close();
	}

}

