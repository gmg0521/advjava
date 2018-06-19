package game;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class GameInterface {
	
	public Timer timer = new Timer();
	public long delay = 0;
	public long intervalPeriod = 1;
	
	public JLabel timeLabel = new JLabel("30.000");
		
	public TimerTask task = new TimerTask() {

		@Override
		public void run() {
			Double timerMi = Double.parseDouble(timeLabel.getText())-.001;
			Double showTime = Double.parseDouble(String.format("%.3f", timerMi));
			timeLabel.setText(String.valueOf(showTime));
		}
	};
}
