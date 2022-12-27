package view;

import java.util.List;
import model.Mail;
import model.Histogram;

public class MailHistogramBuilder {
    
    public static Histogram<String> build(List<Mail> lista){
        Histogram<String> histogram = new Histogram<>();
     
        for (Mail mail : lista) {
            histogram.increment(mail.getDomain());
        }
        
        return histogram;
    }
}
