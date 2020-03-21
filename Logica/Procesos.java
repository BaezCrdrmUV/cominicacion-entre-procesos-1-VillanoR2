package Logica;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.Map;
import com.sun.management.UnixOperatingSystemMXBean;
import java.util.Set;

public class Procesos {

    public static String LeerArchivo(String file){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try{
            archivo = new File(file);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            String linea;
            while ((linea = br.readLine()) != null)
               file = linea;
         } catch (IOException ex) {
            ex.printStackTrace();
         } finally {
            try {
               if (null != fr) {
                  fr.close();
               }
            } catch (IOException ex) {
               ex.printStackTrace();
            }
        }
      return file;
    }

    public void AbrirArchivo(String archivo){

        try{
            File nuevoArchivo = new File(archivo);
            Desktop.getDesktop().open(nuevoArchivo);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
    public static String NumArchivosDescriptivos(String archivos) {
        OperatingSystemMXBean os = ManagementFactory.getOperatingSystemMXBean();
        if (os instanceof UnixOperatingSystemMXBean) {
           archivos = "El número máximo de archivos descriptores es: " + ((UnixOperatingSystemMXBean) os).getMaxFileDescriptorCount();
        }
        return archivos;
     }
  
     public static void VariablesEntorno() {
        Map<String, String> env = System.getenv();
        Set<String> keys = env.keySet();
        for (String key : keys) {
           System.out.println(key + " = " + env.get(key));
        }
     }
  
     public static void CrearProceso() throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("/opt/google/chrome/chrome");
        Process process1 = processBuilder.start();
        long pid1 = process1.pid();
        System.out.println(pid1);
  
        Process process2 = Runtime.getRuntime().exec("/opt/google/chrome/chrome");
        long pid2 = process2.pid();
        System.out.println(pid2);
  
        
        process2.destroy();
        process2.waitFor();
  
     }
}