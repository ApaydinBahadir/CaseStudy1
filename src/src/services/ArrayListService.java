package src.services;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import src.dataAccess.StokKartDao;
import src.dataAccess.StokKartDaoImpl;
import src.entities.concrete.StokKart;
import src.view.MainView;

public class ArrayListService {
	
	MainView mainView;
	StokKartDao stokKartDao;
	
	public ArrayListService(MainView mainView) {
		this.stokKartDao = new StokKartDaoImpl();
		this.mainView = mainView;
	}
	
	public List<StokKart> getStokKartData() {
		return stokKartDao.listStokKart();
	}
	
	public void toTable() {
		mainView.model = (DefaultTableModel) mainView.stokKartTable.getModel();
		mainView.model.setRowCount(0);
		for(StokKart stokKart: getStokKartData()) {
			Object[] rows = {stokKart.getStokKodu(), stokKart.getStokAdi(), stokKart.getStokTipi(), stokKart.getBirim(), stokKart.getBarkod(), stokKart.getKdvTipi(), stokKart.getAciklama(), stokKart.getOlusturmaTarihi()};
		    mainView.model.addRow(rows);
		}
	}
}
