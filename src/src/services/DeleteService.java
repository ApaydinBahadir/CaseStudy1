package src.services;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.dataAccess.StokKartDao;
import src.dataAccess.StokKartDaoImpl;
import src.view.MainView;

public class DeleteService implements ActionListener{
	private MainView mainView;
	private StokKartDao stokKartDao;
	private ArrayListService arrayListService;
	
	public DeleteService(MainView mainView) {
		this.mainView = mainView;
	}
	
	public void delete() {
		stokKartDao = new StokKartDaoImpl();
		stokKartDao.deleteStokKart(mainView.stokKoduField.getText());
		arrayListService = new ArrayListService(mainView);
		arrayListService.toTable();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		delete();
	
	}

}
