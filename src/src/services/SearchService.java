package src.services;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JViewport;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import src.dataAccess.StokKartDaoImpl;
import src.entities.concrete.StokKart;
import src.view.MainView;

public class SearchService implements KeyListener{

	private StokKartDaoImpl stokKartDao;
	private MainView mainView;
	private ArrayListService arrayListService;
	private DataLabelService dataLabelService;
	
	public SearchService(MainView mainView) {
		this.mainView = mainView;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		arrayListService = new ArrayListService(mainView);
		stokKartDao = new StokKartDaoImpl();
		String search = mainView.searchBar.getText();
		List<StokKart> list = stokKartDao.searchStokKart(search);
		arrayListService.toTableSearch(list);
		dataLabelService = new DataLabelService(mainView);
		
		
//		// TODO Auto-generated method stub
//		String search = mainView.searchBar.getText();
//		TableRowSorter<DefaultTableModel> rowsorter= new TableRowSorter<DefaultTableModel>(mainView.model);
//		mainView.stokKartTable.setRowSorter(rowsorter);
//		rowsorter.setRowFilter(RowFilter.regexFilter(search));
//		//TODO
	}

}
