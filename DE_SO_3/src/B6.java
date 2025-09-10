import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Console program that reads an input text file and writes all lines
 * containing the word "Python" to an output text file.
 */
public class B6 {
    /**
     * Entry poit of the program
     * Read "src/input.txt" line by line, check each line,
     * and write only line containing the keyword "Python" into "output.txt"
     * Print "Done" when finished, or an error message if an I/O exception occur.
     *
     * @param args (not used)
     */
    public static void main(String[] args) {
        Path in = Paths.get("src","input.txt");
        Path out = Paths.get("src","output.txt");

        try(BufferedReader br = Files.newBufferedReader(in, StandardCharsets.UTF_8);
        BufferedWriter bw = Files.newBufferedWriter(out, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING)){
            String line;
            while ((line = br.readLine()) != null) {
                //Keep only lines that contain the keyword "Python"
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
