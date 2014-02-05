package Prooviaretus;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class lihtneTaimer extends JFrame
{
    
	private JLabel label,label1,label2,label3,label4,label5;
    private JPanel peapaneel;
    private Timer timer;
    public static int counter = 1,vealugeja=0; // the duration
    public static int delay = 1000; // every 1 second
    private static final long serialVersionUID = 1L;
    public static String labelisuurus="",veateade1="",veateade2="",veateade3="";
    public static String hetkeseis="",eelmineseis="",x1="",x2="";
    public static boolean FailToOk=false,tiktak=false;
    public JPanel lihtnetaimer()
    {
        JPanel contentPane = (JPanel) getContentPane();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        
        peapaneel = new JPanel();
        peapaneel.setLayout(null);
        peapaneel.setLocation(10, 10);
        peapaneel.setBackground(Color.white);
        peapaneel.setSize(250, 30);
        contentPane.add(peapaneel);

        
        
        
        label = new JLabel("Start!");
        label.setLocation(0, 0);
        label.setSize(120, 30);
        label.setHorizontalAlignment(0);
        label.setForeground(Color.black);
        peapaneel.add(label);
        
        label1 = new JLabel(labelisuurus);
        label1.setLocation(130, 0);
        label1.setSize(120, 30);
        label1.setHorizontalAlignment(0);
        label1.setForeground(Color.blue);
        peapaneel.add(label1);
        
        label2 = new JLabel("");
        label2.setLocation(50, 70);
        label2.setSize(120, 30);
        label2.setHorizontalAlignment(0);
        label2.setForeground(Color.red);
        peapaneel.add(label2);
        
        label3 = new JLabel(veateade2);
        label3.setLocation(50, 100);
        label3.setSize(120, 30);
        label3.setHorizontalAlignment(0);
        label3.setForeground(Color.red);
        peapaneel.add(label3);
        
        label4 = new JLabel(veateade3);
        label4.setLocation(50, 130);
        label4.setSize(120, 30);
        label4.setHorizontalAlignment(0);
        label4.setForeground(Color.red);
        peapaneel.add(label4);
        
        label5 = new JLabel(veateade3);
        label5.setLocation(50, 40);
        label5.setSize(120, 30);
        label5.setHorizontalAlignment(0);
        label5.setForeground(Color.black);
        peapaneel.add(label5);
       
      
        ActionListener action = new ActionListener()
        {   
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if(counter == 0)
                {
                    if(!hetkeseis.equalsIgnoreCase("FAIL!")){
                    Date date = new Date();SimpleDateFormat ft = new SimpleDateFormat ("hh:mm:ss");
                    x1=(ft.format(date));
                    }
                	eelmineseis=hetkeseis;
                	
                	
                	try {url_ping.start("http://www.google.com", 1000);} catch (Exception e) {e.printStackTrace();}
                	
                	if(hetkeseis.equalsIgnoreCase("FAIL!")){
                		label1.setForeground(Color.red);
                		if(!eelmineseis.equalsIgnoreCase("FAIL!")){
                			System.out.print("Yhenduse katke nr: "+(vealugeja+1)+". Ajavahemik: "+x1+" - ");
                			label2.setForeground(Color.red);
                			label5.setForeground(Color.BLUE);
                			label5.setText("Katke nr, ajavahemik");
                			label2.setText((vealugeja+1)+". "+x1+" - ");
                		}
                	}else{
                		label1.setForeground(Color.DARK_GRAY);
                	}
                	label1.setText("HETKESEIS: "+hetkeseis);
                	
                	
                	if ((eelmineseis.equalsIgnoreCase("FAIL!"))&&(!hetkeseis.equalsIgnoreCase("FAIL!"))){
                		FailToOk=true;
                		
                	}
                	Date date2 = new Date();SimpleDateFormat ft2 = new SimpleDateFormat ("hh:mm:ss");
                    x2=(ft2.format(date2));
                    
                	   			if((hetkeseis.equalsIgnoreCase("OK")&&(FailToOk))){
                	   				label2.setForeground(Color.black);
                	   				label2.setText("Ühendus taastunud");
                	   				vealugeja++;
                	   				System.out.println(x2);
                	   				x1=x1+" - "+x2;
                				if(lihtneTaimer.veateade3.equalsIgnoreCase("")){
                					veateade3=vealugeja+". "+x1;
                					label4.setText(veateade3);
                					
                					
                				}else{
                				
                				if(lihtneTaimer.veateade2.equalsIgnoreCase("")){
                					veateade2=vealugeja+". "+x1;
                					label3.setText(veateade2);
                					
                					;
                				}else{
                					
                					veateade1=vealugeja+". "+x1;
                					label3.setText(veateade1);
              						
                					
                					}}
                				
                				FailToOk=false;
                			}
                		
                    
                    
                    
                    
                    
                    
                	
                	
                    lihtneTaimer.counter=1;
                    
                    if (tiktak){
                    label.setText("@@@");
                    tiktak=false;
                    }else{
                    label.setText("###");
                    tiktak=true;
                    }
                   
                    
                    
                    counter--;           
                }
                else
                {
                    counter--;
                }
            }
        };

        timer = new Timer(delay, action);
        timer.setInitialDelay(0);
        timer.start();

        
        contentPane.setOpaque(true);
		return contentPane;
    }
    
    
    private static void createAndShowGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Pele Neti test");

        lihtneTaimer demo = new lihtneTaimer();
        frame.setContentPane(demo.lihtnetaimer());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        
       
        
        frame.setVisible(true);
    }
    
    





public static void start(String[] args) {
    //Schedule a job for the event-dispatching thread:
    //creating and showing this application's GUI.
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            createAndShowGUI();
        }
    });
}
}

