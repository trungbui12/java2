package factory;

import dao.ResultDAO;
import dao.ResultDAOImpl;

public class DaoFactory {
    public static ResultDAO createResultDAO() {
        return new ResultDAOImpl();
    }
}
