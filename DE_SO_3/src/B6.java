import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class B6 {
    public static void main(String[] args) {
        Path in = Paths.get("src","input.txt");
        Path out = Paths.get("src","output.txt");

        try(BufferedReader br = Files.newBufferedReader(in, StandardCharsets.UTF_8);
        BufferedWriter bw = Files.newBufferedWriter(out, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING)){
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("Python")) {
                    bw.write(line);
                    bw.newLine();
                }
            }
                System.out.println("Done");
        }catch(IOException e){
            System.out.println("I/O error: " + e.getMessage());
        }
    }
}
