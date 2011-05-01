import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Loader implements ActionListener {
	private JFrame parent;

	public Loader(JFrame parent) {
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		if (chooser.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION) {
			try {
				File file = chooser.getSelectedFile();
				String filename = file.getAbsolutePath();
				DataInputStream stream = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));
				Level.getInstance().load(stream);
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}