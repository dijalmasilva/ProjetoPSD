package factory;

public class DAOFactory {

    public static DAOFactoryPSD createFactory() {
        return new DAOFactoryBD();
    }
}
