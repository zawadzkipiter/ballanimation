package main_package;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Obsluga_Zdarzenia extends JPanel implements BallListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Dimension preferredSize;
	private JTextField poleNazw = null;
	private static final int obszar = 20;
	private String tekst = "";
	private int szerokosc;

	public Obsluga_Zdarzenia(String nazwa, int szerokosc) {
		super(new FlowLayout());
		this.szerokosc = szerokosc;
		preferredSize = new Dimension(szerokosc, 100);
		setPreferredSize(preferredSize);
		poleNazw = new JTextField("fdsfsdf");

		poleNazw.setText("nazwa");
		poleNazw.setEditable(true);

		add(poleNazw);

	}

	@Override
	public void jestTarget(Target t) {
		// TODO Auto-generated method stub
		tekst = t.zwrocnazwe();
		int[] tabelka = t.zwrocParametryObiektu();
		System.out.println(Math.abs(tabelka[0] - tabelka[2]-tabelka[4]/2));
		System.out.println(Math.abs(tabelka[1] - tabelka[3]-tabelka[4]/2));
		System.out.println(Math.sqrt(Math.pow((tabelka[0] - tabelka[2]-tabelka[4]/2), 2)+
				Math.pow((tabelka[1] - tabelka[3]-tabelka[4]/2), 2)));
		System.out.println(Math.abs(tabelka[4])/2);
		
		if (
//				Math.abs(tabelka[0] - tabelka[2])) < obszar
//				&& (Math.abs(tabelka[1] - tabelka[3])) < obszar)
				(Math.sqrt(Math.pow((tabelka[0] - tabelka[2]-tabelka[4]/2), 2)+
						Math.pow((tabelka[1] - tabelka[3]-tabelka[4]/2), 2)))<(tabelka[4]/2))
		
		{
			wypiszNazwe(true);
		} else
			wypiszNazwe(false);

	}

	public void wypiszNazwe(boolean czy) {
		if (czy) {
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {

					poleNazw.setText(tekst);

				}
			});
		} else {
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {

					poleNazw.setText("PUD£O");

				}
			});
		}
	}

}
