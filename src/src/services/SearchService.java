package src.services;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import src.view.MainView;

public class SearchService implements KeyListener{

	private MainView mainView;
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
		// TODO Auto-generated method stub
		String search = mainView.searchBar.getText();
		TableRowSorter<DefaultTableModel> rowsorter= new TableRowSorter<DefaultTableModel>(mainView.model);
		mainView.stokKartTable.setRowSorter(rowsorter);
		rowsorter.setRowFilter(RowFilter.regexFilter(search));
		//TODO
	}

}
