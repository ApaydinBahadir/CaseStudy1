package src.dataAccess;

import org.hibernate.Session;
import org.hibernate.Transaction;

import src.entities.concrete.StokKart;

import static src.dataAccess.HibernateUtil.getSessionFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class StokKartDaoImpl implements StokKartDao {

	private Transaction transaction = null;

	public StokKartDaoImpl() {
	}

	@Override
	public void saveStokKart(StokKart stokKart) {
		Session session = getSessionFactory().openSession();

		if (session.get(StokKart.class, stokKart.getStokKodu()) != null) {
			return;
		}

		try {
			session.save(stokKart);
			session.beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();

			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null)
				session.close();
		}

	}

	@Override
	public void deleteStokKart(String stokKodu) {

		Session session = getSessionFactory().openSession();

		if (session.get(StokKart.class, stokKodu) == null) {
			return;
		}

		try {
			transaction = session.beginTransaction();
			StokKart deleteStokkart = (StokKart) session.load(StokKart.class, stokKodu);
			session.delete(deleteStokkart);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();

			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null)
				session.close();
		}

	}

	@Override
	public void updateStokKart(StokKart stokKart) {
		Session session = getSessionFactory().openSession();

		if (session.get(StokKart.class, stokKart.getStokKodu()) == null) {
			return;
		}

		try {
			transaction = session.beginTransaction();
			session.clear();
			session.update(stokKart);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();

			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null)
				session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StokKart> listStokKart() {

		Session session = getSessionFactory().openSession();

		try {

			return (List<StokKart>) session.createQuery("SELECT a FROM StokKart a").list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StokKart> searchStokKart(String stokKodu) {

		Session session = getSessionFactory().openSession();

		try {
			org.hibernate.query.Query query = session
					.createQuery("Select a FROM StokKart a WHERE a.stokKodu Like :stokKodu");
			query.setParameter("stokKodu", stokKodu + "%");
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return null;
	}

	@Override
	public List<String> getColumnNames() {
		Session session = getSessionFactory().openSession();
		List<String> Columns = new ArrayList<String>();
		try {
			for (Field field : StokKart.class.getDeclaredFields()) {
				field.setAccessible(true);
				String name = field.getName();
				Columns.add(name);
			}
			return Columns;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return null;
	}

	@Override
	public void copyStokKart(StokKart stokKart) {
		Session session = getSessionFactory().openSession();

		if (session.get(StokKart.class, stokKart.getStokKodu()) == null) {
			return;
		}

		try {
			transaction = session.beginTransaction();
			session.clear();
			session.save(StokKart.builder()
					.stokKodu(stokKart.getStokKodu()+"c")
					.stokAdi(stokKart.getStokAdi())
					.stokTipi(stokKart.getStokTipi())
					.barkod(stokKart.getBarkod())
					.birim(stokKart.getBirim())
					.aciklama(stokKart.getAciklama())
					.kdvTipi(stokKart.getKdvTipi())
					.olusturmaTarihi(stokKart.getOlusturmaTarihi())
					.build()
					);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();

			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null)
				session.close();
		}

	}

}
