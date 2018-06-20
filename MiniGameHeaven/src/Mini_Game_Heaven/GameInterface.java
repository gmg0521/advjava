package Mini_Game_Heaven;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameInterface extends BackGround{
	
	public Timer timer;
	
	public long delay = 0;
	public long intervalPeriod = 1;
	
	public JLabel timeLabel = new JLabel("30.000");
	
	public GameInterface(String string, String s2) {
		super(string, s2);
	}

	public void tictic() {
		timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				if(Double.parseDouble(timeLabel.getText()) < 0) {
					try {
						timer.cancel();
						timeLabel.setText("0.000");
					} catch(Exception e) {
						e.printStackTrace();
					}
				}else {
					Double timerMi = Double.parseDouble(timeLabel.getText())-.001;
					Double showTime = Double.parseDouble(String.format("%.3f", timerMi));
					timeLabel.setText(String.valueOf(showTime));
				}
			}
		};
		timer.scheduleAtFixedRate(task, delay, intervalPeriod);
	}
	
	public void ticticForGame3() {
		TimerTask taskForGame3 = new TimerTask() {

			@Override
			public void run() {
					Double timerMi = Double.parseDouble(timeLabel.getText())+.001;
					Double showTime = Double.parseDouble(String.format("%.3f", timerMi));
					timeLabel.setText(String.valueOf(showTime));
					}
			};
			
		timer = new Timer();
		timer.scheduleAtFixedRate(taskForGame3, delay, intervalPeriod);
	}
	
}
