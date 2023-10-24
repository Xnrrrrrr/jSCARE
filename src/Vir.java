import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.ImageIcon; // Import the ImageIcon class for loading images

public class Vir extends java.awt.Dialog {

    Timer timer; // Timer for scheduled actions
    ActionListener action; // ActionListener for timer
    double a = 0.0; // Counter variable

    public Vir(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents(); // Initialize the GUI components
        this.setAlwaysOnTop(true); // Set the dialog to always be on top
        setLocationRelativeTo(null); // Center the dialog on the screen
        setBackground(new java.awt.Color(0, 0, 0, 0)); // Set the background color
        setPP(); // Initialize the ActionListener
        timer = new Timer(200, action); // Create a timer with a 200ms delay that triggers the action
        timer.start(); // Start the timer
    }

    private void initComponents() {
        jLabell = new javax.swing.JLabel(); // Create a JLabel

        setMinimumSize(new java.awt.Dimension(1158, 758)); // Set the minimum size of the dialog
        setUndecorated(true); // Make the dialog undecorated (no title bar)
        setPreferredSize(new java.awt.Dimension(1158, 758)); // Set the preferred size
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt); // Add a window closing event to close the dialog
            }
        });
        setLayout(null); // Use absolute positioning for layout

        jLabell.setFont(new java.awt.Font("Dialog", 1, 72)); // Set the font for the JLabel
        jLabell.setForeground(new java.awt.Color(250, 0, 0)); // Set text color
        jLabell.setBackground(new java.awt.Color(0, 0, 0)); // Set background color
        jLabell.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); // Center-align text
        add(jLabell); // Add the JLabel to the dialog
        jLabell.setBounds(-10, 0, 1160, 750); // Set the position and size of the JLabel

        pack(); // Pack the components
    }

    private void closeDialog(java.awt.event.WindowEvent evt) {
        setVisible(false); // Set the dialog to be invisible
        dispose(); // Dispose of the dialog
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            Vir dialog = new Vir(new java.awt.Frame(), true); // Create an instance of the dialog
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0); // Handle window closing by exiting the application
                }
            });
            dialog.setVisible(true); // Make the dialog visible
        });
    }

    private javax.swing.JLabel jLabell; // JLabel for displaying text and images

    private void setPP() {
        action = (ActionEvent e) -> {
            a = a + 1; // Increment the counter

            if (a % 31 == 0) {
                // When a is a multiple of 31, load an image from resources and set its position and size
                jLabell.setIcon(new ImageIcon(getClass().getResource("resources/momo2.png")));
                jLabell.setText(""); // Clear the text
                jLabell.setLocation(-10, 0); // Set the position
                jLabell.setSize(1160, 750); // Set the size
            }
            if (a % 17 == 0) {
                jLabell.setIcon(null); // Clear the icon (remove the image)
                jLabell.setText("Hi"); // Set text
                jLabell.setLocation(480, 300); // Set the position
                jLabell.setSize(160, 80); // Set the size
            }

            if (a % 23 == 0) {
                jLabell.setIcon(null); // Clear the icon (remove the image)
                jLabell.setText("Will you be my friend"); // Set text
                jLabell.setLocation(250, 300); // Set the position
                jLabell.setSize(750, 80); // Set the size
            }

            if (a % 47 == 0) {
                jLabell.setIcon(null); // Clear the icon (remove the image)
                jLabell.setText("Hope you are happy to see me"); // Set text
                jLabell.setLocation(100, 300); // Set the position
                jLabell.setSize(1050, 80); // Set the size
            }
        };
    }
}
