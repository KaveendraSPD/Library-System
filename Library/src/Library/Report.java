package Library;

public class Report extends javax.swing.JFrame {

    public Report(String fileName) {
        this(fileName, null);
    }

    public Report(String fileName, java.util.HashMap parameter) {
        super("View Report");

        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            net.sf.jasperreports.engine.JasperPrint jp = net.sf.jasperreports.engine.JasperFillManager.fillReport(fileName, parameter, con);
            net.sf.jasperreports.view.JRViewer jrv = new net.sf.jasperreports.view.JRViewer(jp);
            if (jp.getPages().isEmpty()) {
                return;
            } else {
                getContentPane().add(jrv);
                setVisible(true);
            }
        } catch (java.sql.SQLException | net.sf.jasperreports.engine.JRException e) {
        }
        super.setSize(1366, 1024);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}