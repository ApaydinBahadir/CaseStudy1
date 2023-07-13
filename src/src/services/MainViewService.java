package src.services;

import src.view.MainView;
import src.services.SaveService;

public class MainViewService {
	private ArrayListService arrayListService;
	private MainView mainView;
	public MainViewService() {
		Init();
	}
	
	void Init(){
		mainView = new MainView();
		arrayListService = new ArrayListService(mainView);
		arrayListService.toTable();
		listeners();
		mainView.setVisible(true);
	}

	void listeners() {
		mainView.stokKartTable.addMouseListener(new DataLabelService(mainView));
		mainView.searchBar.addKeyListener(new SearchService(mainView));
		mainView.deleteButton.addActionListener(new DeleteService(mainView));
		mainView.saveButton.addActionListener(new SaveService(mainView));
		mainView.updateButton.addActionListener(new UpdateService(mainView));
		mainView.copyButton.addActionListener(new CopyService(mainView));
	}
}
