package my;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;


public class CV {
    private JPanel panel1;
    private JPanel cvPanel;
    private JButton SELECTIMAGEButton;
    private JTextField name;
    private JTextField contact;
    private JTextField address;
    private JTextField email;
    private JTextField location;
    private JTextField skills1;
    private JTextField skills2;
    private JTextField qualiA;
    private JComboBox work;
    private JTextField college;
    private JButton GENERATERESUMEButton;
    private JTextField qualiB;
    private JTextField skills3;
    private JTextField skills4;
    private JTextField college1;
    private JTextField post1;
    private JTextField workplace1;
    private JTextField workplace2;
    private JTextField post2;
    private JLabel img;

    JFrame frame = new JFrame();

    public CV() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(cvPanel);
        frame.pack();
        // Image iconImage = frame.getIconImage(C:\\Users\\Dell\\IdeaProjects\\Builder\\src\\img.jpg);
        frame.setSize(1300, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        SELECTIMAGEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "png");
                fileChooser.addChoosableFileFilter(filter);
                int rs = fileChooser.showSaveDialog(null);
                if (rs == JFileChooser.APPROVE_OPTION) {
                    File selectedImage = fileChooser.getSelectedFile();
                    location.setText(selectedImage.getAbsolutePath());
                    img.setIcon(resize(location.getText()));
                }
            }
        });
        GENERATERESUMEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (name.getText() == null || contact.getText() == null || address.getText() == null || email.getText() == null) {
                    JOptionPane.showMessageDialog(null, "PLEASE ENTER ALL DETAILS TO GENERATE CV");
                } else {
                    try {
                        String nameOfFile = "C:\\Users\\Dell\\OneDrive\\Desktop\\RESUME\\myresume.pdf";
                        Document myDocument = new Document();
                        PdfWriter.getInstance(myDocument, new FileOutputStream(nameOfFile));
                        myDocument.open();
                        com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance(location.getText());
                        img.setAbsolutePosition(473f, 750f);
                        img.scaleAbsolute(80f, 70f);
                        PdfPTable table = new PdfPTable(2);
                        myDocument.add(img);
                        myDocument.add(new Paragraph(name.getText(), FontFactory.getFont(FontFactory.COURIER_BOLD, 30, com.itextpdf.text.Font.BOLD, BaseColor.BLACK)));
                        myDocument.add(new Paragraph("", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, BaseColor.BLACK)));
                        myDocument.add(new Paragraph("", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, BaseColor.BLACK)));
                        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                        myDocument.add(new Paragraph("CONTACT DETAILS", FontFactory.getFont(FontFactory.COURIER_BOLD, 16, com.itextpdf.text.Font.BOLD, BaseColor.BLACK)));
                        myDocument.add(new Paragraph("Email-ID: " + email.getText(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph("Mobile No: " + contact.getText(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph("Address: " + address.getText(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                        myDocument.add(new Paragraph("SKILLS", FontFactory.getFont(FontFactory.COURIER_BOLD, 15, com.itextpdf.text.Font.BOLD, BaseColor.BLACK)));
                        myDocument.add(new Paragraph("\n"));
                        table.setHeaderRows(1);
                        table.addCell(skills1.getText());
                        table.addCell(skills2.getText());
                        table.addCell(skills3.getText());
                        table.addCell(skills4.getText());
                        myDocument.add(table);
                        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                        myDocument.add(new Paragraph("QUALIFICATIONS", FontFactory.getFont(FontFactory.COURIER_BOLD, 15, com.itextpdf.text.Font.BOLD, BaseColor.BLACK)));
                        myDocument.add(new Paragraph("1) " + qualiA.getText(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph("                     from\n"));
                        myDocument.add(new Paragraph("  " + college.getText(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph("\n"));
                        myDocument.add(new Paragraph("2) " + qualiB.getText(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph("                     from\n"));
                        myDocument.add(new Paragraph("  " + college1.getText(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                        myDocument.add(new Paragraph("WORK EXPERIENCE", FontFactory.getFont(FontFactory.COURIER_BOLD, 15, com.itextpdf.text.Font.BOLD, BaseColor.BLACK)));
                        myDocument.add(new Paragraph("" + work.getSelectedItem(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                        myDocument.add(new Paragraph("EX-WORKPLACE", FontFactory.getFont(FontFactory.COURIER_BOLD, 15, com.itextpdf.text.Font.BOLD, BaseColor.BLACK)));
                        myDocument.add(new Paragraph("1) " + workplace1.getText(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph("2) " + workplace2.getText(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                        myDocument.add(new Paragraph("POSTS HANDLED", FontFactory.getFont(FontFactory.COURIER_BOLD, 15, com.itextpdf.text.Font.BOLD, BaseColor.BLACK)));
                        myDocument.add(new Paragraph("1) " + post1.getText(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, BaseColor.DARK_GRAY)));
                        myDocument.add(new Paragraph("2) " + post2.getText(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, BaseColor.DARK_GRAY)));
                        myDocument.close();
                        JOptionPane.showMessageDialog(null, "CV was successfully generated");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }
        });
    }

    public ImageIcon resize(String path) {
        ImageIcon myImg = new ImageIcon(path);
        Image image = myImg.getImage();
        Image newImage = image.getScaledInstance(100, 300, Image.SCALE_SMOOTH);
        ImageIcon finalImage = new ImageIcon(newImage);
        return finalImage;
    }



    public void setVisible() {

    }
}






