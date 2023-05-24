// Producer Consumer
// Bryson Davis
// 4/16/2023
// CS-2463-TW01S

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ProducerConsumer {

	private static int avgProduction;
	private static int avgConsumption;
	private static boolean canRun; 
	private static JLabel resource; 
	private static JTextArea textarea; 
	private static String text; 
	
	private static int theBuffer;
	private static Semaphore semaphore = new Semaphore(1);
	
	public static void mySleep() {
		try {
			Thread.sleep((int)(Math.random()*1000));
		} catch(InterruptedException e){}
	} 
	
	public static void main(String [] args){
		createGUI();
	}
	
	
	private static void createGUI() {
		JFrame frame = new JFrame("Producer-Consumer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setResizable(false); 
		
		JLabel numOfProducer = new JLabel("Number of Producer(s):");
		JLabel numOfConsumer = new JLabel("Number of Consumer(s):");
		JLabel avg_production = new JLabel("Average value Produced:");
		JLabel avg_consumption = new JLabel("Average value Consumed:");
		JLabel labelResource = new JLabel("Resource:");
		resource = new JLabel("0");
		
		JTextField value_numOfProducer = new JTextField(5);
		JTextField value_numOfConsumer = new JTextField(5);
		JTextField value_avg_production = new JTextField(5);
		JTextField value_avg_consumption = new JTextField(5);
		
		JButton start = new JButton("Start");
		JButton stop = new JButton("Stop");

		start.addActionListener(new ActionListener() {
		@Override
			public void actionPerformed(ActionEvent e) {
				int numProducers = Integer.parseInt(value_numOfProducer.getText());
				int numConsumers = Integer.parseInt(value_numOfConsumer.getText());
	
				avgProduction = Integer.parseInt(value_avg_production.getText());
				avgConsumption = Integer.parseInt(value_avg_consumption.getText());
	
				Producer[] p = new Producer[numProducers];
	
				Consumer[] c = new Consumer[numConsumers];
	
				canRun = true;
				text = "Started.";
	
				for(int i=0; i<numProducers; i++) {
					p[i] = new Producer(i);
					p[i].start();
				}
				
				for(int i=0; i<numConsumers; i++) {
					c[i] = new Consumer(i);
					c[i].start();
				}
			}
		});
		stop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canRun = false;
			}
		});
		
		textarea = new JTextArea();

		JScrollPane scroll = new JScrollPane(textarea,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		Container container = frame.getContentPane();
		GroupLayout layout = new GroupLayout(container);
		container.setLayout(layout);

		layout.setHorizontalGroup(layout.createParallelGroup()

		.addGroup(layout.createSequentialGroup()
		.addContainerGap()
		.addComponent(numOfProducer)
		.addGap(20)
		.addComponent(value_numOfProducer)
		.addGap(50)
		.addComponent(avg_production)
		.addGap(20)
		.addComponent(value_avg_production)
		.addContainerGap())

		.addGroup(layout.createSequentialGroup()
		.addContainerGap()
		.addComponent(numOfConsumer)
		.addGap(20)
		.addComponent(value_numOfConsumer)
		.addGap(50)
		.addComponent(avg_consumption)
		.addGap(20)
		.addComponent(value_avg_consumption)
		.addContainerGap())

		.addGroup(layout.createSequentialGroup()
		.addContainerGap()
		.addComponent(start)
		.addGap(50)
		.addComponent(stop)
		.addGap(50)
		.addComponent(labelResource)
		.addGap(20)
		.addComponent(resource)
		.addContainerGap())

		.addGroup(layout.createSequentialGroup()
		.addContainerGap()
		.addComponent(scroll)
		.addContainerGap()));
		
		layout.setVerticalGroup(layout.createSequentialGroup()
		.addContainerGap()

		.addGroup(layout.createParallelGroup(Alignment.BASELINE)
		.addComponent(numOfProducer)
		.addComponent(value_numOfProducer)
		.addComponent(avg_production)
		.addComponent(value_avg_production))
		.addGap(20)

		.addGroup(layout.createParallelGroup(Alignment.BASELINE)
		.addComponent(numOfConsumer)
		.addComponent(value_numOfConsumer)
		.addComponent(avg_consumption)
		.addComponent(value_avg_consumption))
		.addGap(20)

		.addGroup(layout.createParallelGroup(Alignment.BASELINE)
		.addComponent(start)
		.addComponent(stop)
		.addComponent(labelResource)
		.addComponent(resource))

		.addGap(20)
		.addComponent(scroll)
		.addContainerGap());
		
		frame.setVisible(true);
	}
	
	private static class Producer extends Thread {
		private int id;
		
		public Producer(int id) {
			super();
			this.id = id;
		}
		
		public void run() {
			while(canRun) {
				mySleep();
				text = text + "\n Producer " + id + ": attempting to acquire";
				textarea.setText(text);
				try{
					semaphore.acquire();
					text = text + "\n Producer " + id + ": resource acquired!";
					textarea.setText(text);
					mySleep();
					text = text + "\n Producer " + id + ": theBuffer (pre) is " + theBuffer;
					textarea.setText(text);
					theBuffer += (int) (Math.random() * avgProduction);
					text = text + "\n Producer " + id + ": theBuffer (post) is " + theBuffer;
					textarea.setText(text);
					resource.setText("" + theBuffer);
					text = text + "\n Producer " + id + ": resource released";
					textarea.setText(text);
					semaphore.release();
				} catch(InterruptedException e){}
			}
		}
	}
	
	private static class Consumer extends Thread {
		private int id;
		
		public Consumer(int id) {
			super();
			this.id = id;
		}
		
		public void run() {
			while(canRun) {
				mySleep();
				text = text + "\n Consumer " + id + ": attempting to acquire";
				textarea.setText(text);
				try{
					semaphore.acquire();
					text = text + "\n Consumer " + id + ": resource acquired!";
					textarea.setText(text);
					mySleep();
					text = text + "\n Consumer " + id + ": theBuffer is " + theBuffer;
					textarea.setText(text);
					int need = (int) (1 + Math.random() * avgConsumption);
					text = text + "\n Consumer " + id + ": my need is " + need;
					textarea.setText(text);
					
					if (theBuffer >= need) {
						theBuffer -= need;
						text = text + "\n Consumer " + id + ": got what I needed!";
						text = text + "\n Consumer " + id + ": theBuffer is now " + theBuffer;
						textarea.setText(text);
						resource.setText("" + theBuffer);
					}
					else {
						text = text + "\n Consumer " + id + ": resource unavailable";
						textarea.setText(text);
					}
					
					text = text +"\n Consumer " + id + ": resource released";
					textarea.setText(text);
					semaphore.release();
				}
				catch(InterruptedException e){}
			}
		}
	}
}
