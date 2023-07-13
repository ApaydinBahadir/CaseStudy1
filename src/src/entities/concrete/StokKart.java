package src.entities.concrete;

import java.sql.Timestamp;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class StokKart {

	private String stokKodu;
	private String stokAdi;
	private int stokTipi;
	private String birim;
	private String barkod;
	private double kdvTipi;
	private String aciklama;
	private Date olusturmaTarihi;

}
