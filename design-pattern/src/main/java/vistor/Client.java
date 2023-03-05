package vistor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huql
 * @Description $
 * @Date $ $
 **/
public class Client {



    public static void main(String[] args) {
        BusinessReport businessReport = new BusinessReport();

        CTOVistor ctoVistor = new CTOVistor();
        businessReport.showReport(ctoVistor);

        CEOVistor ceoVistor = new CEOVistor();
        businessReport.showReport(ceoVistor);
    }
}
