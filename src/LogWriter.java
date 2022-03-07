import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;

public class LogWriter {
    private File outputFile;
    private String fileName;
    private Instant now;

    private FileWriter fw;

    public LogWriter(String[] text){
        fileName = getTime() + ".txt";
        outputFile = new File(fileName);
        System.err.println(fileName);
        try{
            outputFile.createNewFile();
            fw = new FileWriter(fileName, true);
            for(String line : text){
                fw.write(line+"\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LogWriter(String text){
        new LogWriter(text.split("\n"));
    }

    private String getTime(){
        String time = LocalDateTime.now().toString();
        System.out.println(time);
        time = time.substring(0, time.indexOf('.'));
        time = time.replace("T"," ");
        time = time.replaceAll(":","-");
        time = time.replaceAll("[^\\d-T ]","");
        return time;
    }
}
