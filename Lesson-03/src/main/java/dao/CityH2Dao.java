package dao;

import entity.City;
import org.hibernate.Session;

import util.HibernateSessionFactoryUtil;

import java.util.List;

public class CityH2Dao implements CityDao {
    @Override
    public List<City> takeAllCities() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("From City", City.class).list();
        }


    }

    @Override
    public void saveCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(city);
            session.getTransaction().commit();
        }
    }

    @Override
    public City findById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(City.class, id);
        }

    }

    @Override
    public List<City> findByName(String request) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            var qr = session.createQuery(" from City as ct where ct.name like :city ", City.class);
            qr.setParameter("city", "%" + request + "%");
            return qr.list();
        }
    }

    @Override
    public void deleteCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.remove(city);
            session.getTransaction().commit();
        }

    }
}
