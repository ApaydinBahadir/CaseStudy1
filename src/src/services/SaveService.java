package src.services;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import src.dataAccess.StokKartDaoImpl;
import src.entities.concrete.StokKart;
import src.view.MainView;

public class SaveService implements ActionListener {
	private MainView mainView;
	private ArrayListService arrayListService;
	private StokKartDaoImpl stokKartDao;

	public SaveService(MainView mainView) {
		this.mainView = mainView;
	}

	public void save() {
		arrayListService = new ArrayListService(mainView);
		stokKartDao = new StokKartDaoImpl();
	
		
		stokKartDao.saveStokKart(StokKart.builder().stokKodu(mainView.stokKoduField.getText())
				.stokAdi(mainView.stokAdiField.getText()).stokTipi(mainView.stokTipiField.getSelectedIndex())
				.birim(Integer.toString(mainView.birimField.getSelectedIndex())).barkod(mainView.barkodField.getText())
				.kdvTipi(mainView.kdvTipiField.getSelectedIndex()).aciklama(mainView.aciklamaField.getText())
				.olusturmaTarihi(mainView.olusTarihField.getDate())
				.aciklama(mainView.aciklamaField.getText())
				.build()
				);

		arrayListService.toTable();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		save();
	}

}
