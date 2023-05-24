import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DigitalClock extends JFrame {

    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;

    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;
    
    DigitalClock() {
        this.setTitle("Digital Clock");
        this.setLayout(new FlowLayout());
        this.setSize(600, 600);
        this.setResizable(false);

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat=new SimpleDateFormat("EEEE");
        dateFormat=new SimpleDateFormat("dd MMMMM, yyyy");
        
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 59));
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setOpaque(true);
        
        dayLabel=new JLabel();
        dayLabel.setFont(new Font("Times New Roman",Font.BOLD,34));

        dateLabel=new JLabel();
        dateLabel.setFont(new Font("Times new Roman",Font.BOLD,30));


        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);

        setTimer();
    }

    public void setTimer() {
        while (true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new DigitalClock();
    }
}
 