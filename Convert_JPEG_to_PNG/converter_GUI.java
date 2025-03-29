import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ImageConverter {
    private JFrame frame;
    private BufferedImage image;
    
    public ImageConverter() {
        frame = new JFrame("Converter");
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.ORANGE);
        frame.setLayout(null);
        
        JLabel label = new JLabel("File Converter");
        label.setFont(new Font("Helvetica", Font.BOLD, 20));
        label.setBounds(75, 20, 200, 40);
        label.setOpaque(true);
        label.setBackground(Color.LIGHT_GRAY);
        frame.add(label);
        
        JButton browseButton = new JButton("Import JPEG File");
        browseButton.setBounds(75, 80, 150, 30);
        browseButton.setBackground(Color.BLUE);
        browseButton.setForeground(Color.WHITE);
        frame.add(browseButton);
        
        JButton convertButton = new JButton("Convert JPEG to PNG");
        convertButton.setBounds(75, 130, 150, 30);
        convertButton.setBackground(Color.BLUE);
        convertButton.setForeground(Color.WHITE);
        frame.add(convertButton);
        
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        image = ImageIO.read(selectedFile);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Error loading image", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (image == null) {
                    JOptionPane.showMessageDialog(frame, "No File selected", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showSaveDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    try {
                        ImageIO.write(image, "png", new File(fileToSave.getAbsolutePath() + ".png"));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Error saving image", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new ImageConverter();
    }
}
