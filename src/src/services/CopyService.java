package src.services;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import src.dataAccess.StokKartDaoImpl;
import src.entities.concrete.StokKart;
import src.view.MainView;

public class CopyService implements ActionListener {

	private ArrayListService arrayListService;
	private StokKartDaoImpl stokKartDao;

	private MainView mainView;

	public CopyService(MainView mainView) {
		this.mainView = mainView;
	}

	void copy() {
		arrayListService = new ArrayListService(mainView);
		stokKartDao = new StokKartDaoImpl();
		
		System.out.println(mainView.stokKoduField.getText().getClass());
		
		stokKartDao.copyStokKart(StokKart.builder().stokKodu(mainView.stokKoduField.getText())
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
		copy();
	}

	

}
