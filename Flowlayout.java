import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Flowlayout extends JFrame{
    private JButton button1;
    private JPanel myPanel;
    private JLabel myselections;

    public Flowlayout()
    {
        this.setTitle("Select symptoms");
        this.setContentPane(myPanel);
        this.setSize(600,600);
        this.setVisible(true);

        try {
            Connection conn = DB.connect_DB_MY_SQL();
            ResultSet rs = conn.createStatement().executeQuery("select * from symptoms");

            //ButtonGroup buttonGroup = new ButtonGroup();

            while(rs.next()) {
                JCheckBox chk = new JCheckBox(rs.getString("SymptomName"));
                this.add(chk);
                //buttonGroup.add(chkbox);
            }

        }
        catch (SQLException e) {throw new RuntimeException(e);}


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selections = "";
                for (Component comp : myPanel.getComponents()) {
                    if (comp instanceof JCheckBox) {
                        JCheckBox chkbox = (JCheckBox) comp;
                        if (chkbox.isSelected()) {
                            selections = selections + chkbox.getText() + " , " ;
                            myselections.setText(selections);
                        }
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        new Flowlayout();
    }
}
