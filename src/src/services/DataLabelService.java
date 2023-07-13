package src.services;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import src.view.MainView;
import src.services.ArrayListService;

public class DataLabelService implements MouseListener {

	private ArrayListService arrayListService;
	private MainView mainView;

	public DataLabelService(MainView mainView) {
		this.mainView = mainView;
	}

	
	void getItem(int index) {
		arrayListService = new ArrayListService(mainView);
		mainView.stokKoduField.setText(arrayListService.getStokKartData().get(index).getStokKodu());
		mainView.stokAdiField.setText(arrayListService.getStokKartData().get(index).getStokAdi());
		mainView.stokTipiField.setSelectedItem(arrayListService.getStokKartData().get(index).getStokTipi());
		mainView.birimField.setSelectedItem(arrayListService.getStokKartData().get(index).getBirim());
		mainView.barkodField.setText(arrayListService.getStokKartData().get(index).getBarkod());
		mainView.kdvTipiField.setSelectedItem(arrayListService.getStokKartData().get(index).getKdvTipi());
		mainView.aciklamaField.setText(arrayListService.getStokKartData().get(index).getAciklama());
		mainView.olusTarihField.setDate(arrayListService.getStokKartData().get(index).getOlusturmaTarihi());
	}
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		getItem(mainView.stokKartTable.getSelectedRow());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
