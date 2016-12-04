/**
 *
 * @author Harsh Shah
 */
public class EmailControl {    
    private String host = "smtp.gmail.com";
    private String port = "587";
    private String user = "14it120@charusat.edu.in";
    private String pass = "1q!2w@3e#4r$5t%";
    
    EmailControl(){}
    
    EmailControl(String hostname,String portname,String username,String password){
        host = hostname;
        port = portname;
        user = username;
        pass = password;
        System.out.println("---- Send Email -----");
        System.out.println("Hostname "+host);
        System.out.println("\nPortname "+port);
        System.out.println("\nUsername "+user);
        System.out.println("\nPassword "+pass);
    }

    public void sendMail(String recipient,String subject,String content){
        try {
            System.out.println("---- Send Email -----");
            System.out.println("Hostname "+host);
            System.out.println("\nPortname "+port);
            System.out.println("\nUsername "+user);
            System.out.println("\nPassword "+pass);
            EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
                    content);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void sendMailMultiple(String recipient[],String subject,String content,int length){
        try {
            System.out.println("---- Send Email -----");
            System.out.println("Hostname "+host);
            System.out.println("\nPortname "+port);
            System.out.println("\nUsername "+user);
            System.out.println("\nPassword "+pass);
            System.out.println("rrrrrrrrrrr"+recipient.length);
            EmailUtility.sendEmailMultiple(host, port, user, pass, recipient, subject,content,length);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
