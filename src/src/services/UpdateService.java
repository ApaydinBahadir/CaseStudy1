package src.services;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import src.dataAccess.StokKartDao;
import src.dataAccess.StokKartDaoImpl;
import src.entities.concrete.StokKart;
import src.view.MainView;

public class UpdateService implements ActionListener {
	private MainView mainView;
	private StokKartDao stokKartDao;
	private ArrayListService arrayListService;

	public UpdateService(MainView mainView) {
		this.mainView = mainView;
	}

	public void update() {
		stokKartDao = new StokKartDaoImpl();
		StokKart updateSK = new StokKart();
		updateSK = StokKart.builder()
		.stokKodu(mainView.stokKoduField.getText())
		.stokAdi(mainView.stokAdiField.getText())
		.stokTipi(mainView.stokTipiField.getSelectedIndex())
		.birim(Integer.toString(mainView.birimField.getSelectedIndex()))
		.barkod(mainView.barkodField.getText())
		.kdvTipi(mainView.kdvTipiField.getSelectedIndex())
		.aciklama(mainView.aciklamaField.getText())
		.olusturmaTarihi(mainView.olusTarihField.getDate()).build();
		arrayListService = new ArrayListService(mainView);
		stokKartDao.updateStokKart(updateSK);
		arrayListService.toTable();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		update();
		
	}
}
