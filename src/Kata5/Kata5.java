
package Kata5;

/**
 *
 * @author Guillermo
 */
import view.*;
import java.io.IOException;
import java.util.List;
import model.*;


public class Kata5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       MailListReaderBD database = new MailListReaderBD();
       MailHistogramBuilder.build(database.read());
       HistogramDisplay display = new HistogramDisplay(MailHistogramBuilder.build(database.read()));
        display.execute();
    }
}
