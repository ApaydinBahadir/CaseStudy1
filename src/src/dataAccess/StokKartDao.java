package src.dataAccess;

import java.util.List;

import src.entities.concrete.StokKart;

public interface StokKartDao {
	void saveStokKart(StokKart stokKart);
	
	void deleteStokKart(String stokKodu);
	
	void updateStokKart(StokKart stokKart);
	
	List<StokKart> listStokKart();
	
	List<StokKart> searchStokKart(String stokKodu);
	
	List<String> getColumnNames();
	
	void copyStokKart(StokKart stokKart);
	
}
