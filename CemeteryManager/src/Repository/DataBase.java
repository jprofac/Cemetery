package Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Cemetery;
import Model.Complainer;
import Model.Observation;
import Model.Data;
import Model.Deceased;
import Model.Grave;
import Model.Request;
import Model.Contract;
import Model.Parcel;
import Model.User;

import com.mysql.jdbc.Statement;

public class DataBase {
    // you work with these types as the dataType parameter in the methods
    // set the correct value for the type of object you're passing
    public static final int CEMETERY = 0;

    public static final int COMPLAINER = 1;

    public static final int CONTRACT = 2;

    public static final int DECEASED = 3;

    public static final int GRAVE = 4;

    public static final int OBSERVATION = 5;

    public static final int OWNER = 6;

    public static final int PARCEL = 7;

    public static final int REQUEST = 8;

    public static final int USER = 9;

    public static final int USER_ADMIN = 0;

    public static final int USER_INSPECTOR = 1;

    public static final int USER_RELATII = 2;

    public static final int USER_REGISTRATURA = 3;

    private Connection connect = null;

    private Statement statement = null;

    private PreparedStatement preparedStatement = null;

    private ResultSet resultSet = null;

    public static DataBase instance;

    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    public DataBase() {
        connectToDB();
    }

    private void connectToDB() {
        // this will load the MySQL driver, each DB has its own driver
        try {
            Class.forName("com.mysql.jdbc.Driver");

            // setup the connection with the DB.
            connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost/proiectcolectiv", "root", "");

            // statements allow to issue SQL queries to the database
            statement = (Statement) connect.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addData(Data data) {
        try {
            if (data instanceof Cemetery) {
                if (((Cemetery) data).isValid()) {
                    preparedStatement = connect
                            .prepareStatement("insert into  cemetery values (?, ?)");
                    preparedStatement.setString(2, ((Cemetery) data).getName());
                    preparedStatement.setString(3,
                            ((Cemetery) data).getAddress());

                }
            } else if (data instanceof Grave) {
                if (((Grave) data).isValid()) {
                    preparedStatement = connect
                            .prepareStatement("insert into  grave values (?, ?, ?, ?)");
                    preparedStatement.setInt(2, ((Grave) data).getParcelId());
                    preparedStatement.setInt(3, ((Grave) data).getSurface());
                    preparedStatement.setInt(4,
                            ((Grave) data).getObservationId());
                    preparedStatement.setInt(5, ((Grave) data).getIsMonument() ? 1 : 0);
                }

            } else if (data instanceof Request) {
                if (((Request) data).isValid()) {
                    preparedStatement = connect
                            .prepareStatement("insert into  request values (?, ?, ?)");
                    preparedStatement.setDate(2,
                            (Date) ((Request) data).getDate());
                    preparedStatement.setInt(3, ((Request) data).getInfocet());
                    preparedStatement.setBoolean(4,
                            ((Request) data).isCompleted());
                }
            } else if (data instanceof Deceased) {
            	if (((Deceased) data).isValid()) {
                    preparedStatement = connect
                            .prepareStatement("insert into deceased values ( ?, ?, ?, ?, ?, ?, ?)");
                    preparedStatement.setInt(1,
                            ((Deceased) data).getId());
                    preparedStatement.setString(2,
                            ((Deceased) data).getFirstName());
                    preparedStatement.setString(3,
                            ((Deceased) data).getLastName());
                    preparedStatement.setString(4,
                            ((Deceased) data).getReligion());
                    preparedStatement.setInt(5, ((Deceased) data).getGrave());
                    preparedStatement.setDate(6,
                            (Date) ((Deceased) data).getBurialDate());
                    preparedStatement.setInt(7,
                            ((Deceased) data).getValid());
                }
            } else if (data instanceof Contract) {
                if (((Contract) data).isValid()) {
                    preparedStatement = connect
                            .prepareStatement("insert into contract values (?, ?, ?, ?, ?)");
                    preparedStatement.setInt(2, ((Contract) data).getOwnerId());
                    preparedStatement.setInt(3, ((Contract) data).getGraveId());
                    preparedStatement.setDate(4,
                            (Date) ((Contract) data).getDate());
                    preparedStatement.setInt(5, ((Contract) data).getPeriod());
                    preparedStatement.setInt(6, ((Contract) data).getReceipt());
                }
            } else if (data instanceof Complainer) {
                if (((Complainer) data).isValid()) {
                    preparedStatement = connect
                            .prepareStatement("insert into complainer values (?, ?, ?)");
                    preparedStatement.setString(2,
                            ((Complainer) data).getFirstName());
                    preparedStatement.setString(3,
                            ((Complainer) data).getLastName());
                    preparedStatement.setString(3,
                            ((Complainer) data).getReason());
                }
            } else if (data instanceof Observation) {
                if (((Observation) data).isValid()) {
                    preparedStatement = connect
                            .prepareStatement("insert into observation values (?, ?, ?)");
                    preparedStatement.setBoolean(2,
                            ((Observation) data).isTomb());
                    preparedStatement.setInt(3,
                            ((Observation) data).getModificationNr());
                    preparedStatement.setString(4,
                            (((Observation) data).getPhotography()));
                }
            } else if (data instanceof Parcel) {
                if (((Parcel) data).isValid()) {
                    preparedStatement = connect
                            .prepareStatement("insert into  parcel values (?, ?)");
                    preparedStatement.setString(2, ((Parcel) data).getCode());
                    preparedStatement.setInt(3, ((Parcel) data).getCemeteryId());

                }
            } else if (data instanceof User) {
                if (data.isValid()) {
                    preparedStatement = connect
                            .prepareStatement("insert into  user (`firstname`, `lastname`, `username`, `password`, " +
                                    "`type`) values (?, ?, ?, ?, ?)");
                    preparedStatement.setString(1, ((User) data).getFirstName());
                    preparedStatement.setString(2, ((User) data).getLastName());
                    preparedStatement.setString(3, ((User) data).getUsername());
                    preparedStatement.setString(4, ((User) data).getPassword());
                    preparedStatement.setInt(5, Integer.parseInt(((User) data).getType()));
                }
            }

            // else if (){...} ... treating every data type the same way

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
    }

    public Data getDataById(int id, int dataType) {
        Data data = null;
        try {
            switch (dataType) {
                case CEMETERY:
                    resultSet = statement
                            .executeQuery("select * from cemetery where id = " + id);
                    while (resultSet.next()) {
                        String name = resultSet.getString("name");
                        String address = resultSet.getString("address");
                        data = new Cemetery(id, name, address);
                    }
                    break;
                case REQUEST:
                    resultSet = statement
                            .executeQuery("select * from request where id = " + id);
                    while (resultSet.next()) {
                        Date date = resultSet.getDate("date");
                        int infocet = resultSet.getInt("infocet");
                        boolean completed = resultSet.getBoolean("completed");
                        data = new Request(id, date, infocet, completed);
                    }
                    break;
                case DECEASED:
                    resultSet = statement
                            .executeQuery("select * from deceased where id = " + id);
                    while (resultSet.next()) {
                        String firstName = resultSet.getString("firstName");
                        String lastName = resultSet.getString("lastName");
                        String religion = resultSet.getString("religion");
                        int graveId = resultSet.getInt("graveId");
                        Date burialDate = resultSet.getDate("burialDate");
                        data = new Deceased(id, firstName, lastName, religion,
                                graveId, burialDate);
                    }
                    break;
                case GRAVE:
                    resultSet = statement
                            .executeQuery("select * from grave where id = " + id);
                    while (resultSet.next()) {
                        int graveId = resultSet.getInt("id");
                        int parcelId = resultSet.getInt("parcelId");
                        int surface = resultSet.getInt("surface");
                        int observationId = resultSet.getInt("observationId");
                        boolean type = resultSet.getBoolean("type");
                        data = new Grave(graveId, parcelId, surface, observationId,
                                type);
                    }
                    break;
                case CONTRACT:
                    resultSet = statement
                            .executeQuery("select * from contract where id = " + id);
                    while (resultSet.next()) {
                        int ownerId = resultSet.getInt("ownerId");
                        int graveId = resultSet.getInt("graveId");
                        Date date = resultSet.getDate("date");
                        int period = resultSet.getInt("period");
                        int receipt = resultSet.getInt("receipt");
                        data = new Contract(id, ownerId, graveId, date, period,
                                receipt);
                    }
                    break;
                case COMPLAINER:
                    resultSet = statement
                            .executeQuery("select * from complainer where id = "
                                    + id);
                    while (resultSet.next()) {
                        String firstName = resultSet.getString("firstName");
                        String lastName = resultSet.getString("lastName");
                        String reason = resultSet.getString("reason");
                        data = new Complainer(id, firstName, lastName, reason);
                    }
                    break;
                case OBSERVATION:
                    resultSet = statement
                            .executeQuery("select * from observation where id = "
                                    + id);
                    while (resultSet.next()) {
                        boolean tomb = resultSet.getBoolean("tomb");
                        int modificationNr = resultSet.getInt("modificationNr");
                        String photography = resultSet.getString("photography");
                        data = new Observation(id, tomb, modificationNr,
                                photography);
                    }
                    break;
                case PARCEL:
                    resultSet = statement
                            .executeQuery("select * from parcel where id = " + id);
                    while (resultSet.next()) {
                        String code = resultSet.getString("code");
                        int cemeteryId = resultSet.getInt("cemeteryId");
                        data = new Parcel(id, code, cemeteryId);
                    }
                    break;
                case USER:
                    resultSet = statement
                            .executeQuery("select * from user where id = " + id);
                    while (resultSet.next()) {
                        String firstname = resultSet.getString("firstname");
                        String lastname = resultSet.getString("lastname");
                        String username = resultSet.getString("username");
                        String type = "" + resultSet.getInt("type");
                        data = new User(id, firstname, lastname, username, "", type);
                    }
                    break;

                // etc

                default:
                    break;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return data;
    }

    public ArrayList<Data> getAll(int dataType) {
        ArrayList<Data> dataList = null;
        try {
            switch (dataType) {
                case CEMETERY:
                    dataList = new ArrayList<Data>();
                    resultSet = statement.executeQuery("select * from cemetery");
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String address = resultSet.getString("address");
                        Cemetery newCemetery = new Cemetery(id, name, address);
                        dataList.add(newCemetery);
                    }
                    break;
                case REQUEST:
                    dataList = new ArrayList<Data>();
                    resultSet = statement.executeQuery("select * from request");
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        Date date = resultSet.getDate("date");
                        int infocet = resultSet.getInt("infocet");
                        boolean completed = resultSet.getBoolean("completed");
                        Request newRequest = new Request(id, date, infocet,
                                completed);
                        dataList.add(newRequest);
                    }
                    break;
                case DECEASED:
                    dataList = new ArrayList<Data>();
                    resultSet = statement.executeQuery("select * from deceased");
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String firstName = resultSet.getString("firstName");
                        String lastName = resultSet.getString("lastName");
                        String religion = resultSet.getString("religion");
                        int graveId = resultSet.getInt("graveId");
                        Date burialDate = resultSet.getDate("burialDate");
                        Deceased newDeceased = new Deceased(id, firstName,
                                lastName, religion, graveId, burialDate);
                        dataList.add(newDeceased);
                    }
                    break;
                case GRAVE:
                    dataList = new ArrayList<Data>();
                    resultSet = statement.executeQuery("select * from grave");
                    while (resultSet.next()) {
                        int graveId = resultSet.getInt("id");
                        int parcelId = resultSet.getInt("parcelId");
                        int surface = resultSet.getInt("surface");
                        int observationId = resultSet.getInt("observationId");
                        boolean type = resultSet.getBoolean("type");
                        Grave newGrave = new Grave(graveId, parcelId, surface,
                                observationId, type);
                        dataList.add(newGrave);
                    }
                    break;
                case CONTRACT:
                    dataList = new ArrayList<Data>();
                    resultSet = statement.executeQuery("select * from contract");
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        int ownerId = resultSet.getInt("ownerId");
                        int graveId = resultSet.getInt("graveId");
                        Date date = resultSet.getDate("date");
                        int period = resultSet.getInt("period");
                        int receipt = resultSet.getInt("receipt");
                        Contract newContract = new Contract(id, ownerId, graveId,
                                date, period, receipt);
                        dataList.add(newContract);
                    }
                    break;
                case COMPLAINER:
                    dataList = new ArrayList<Data>();
                    resultSet = statement.executeQuery("select * from complainer");
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String firstName = resultSet.getString("firstName");
                        String lastName = resultSet.getString("lastName");
                        String reason = resultSet.getString("reason");
                        Complainer newComplainer = new Complainer(id, firstName,
                                lastName, reason);
                        dataList.add(newComplainer);
                    }
                    break;
                case OBSERVATION:
                    dataList = new ArrayList<Data>();
                    resultSet = statement.executeQuery("select * from observation");
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        boolean tomb = resultSet.getBoolean("tomb");
                        int modificationNr = resultSet.getInt("modificationNr");
                        String photography = resultSet.getString("photography");
                        Observation newObservation = new Observation(id, tomb,
                                modificationNr, photography);
                        dataList.add(newObservation);
                    }
                    break;
                case PARCEL:
                    dataList = new ArrayList<Data>();
                    resultSet = statement.executeQuery("select * from parcel");
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        int cemeteryId = resultSet.getInt("cemeteryId");
                        String code = resultSet.getString("code");
                        Parcel newParcel = new Parcel(id, code, cemeteryId);
                        dataList.add(newParcel);
                    }
                    break;
                case USER:
                    dataList = new ArrayList<Data>();
                    resultSet = statement.executeQuery("select * from user");
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("firstname");
                        String surname = resultSet.getString("lastname");
                        String username = resultSet.getString("username");
                        String type = "" + resultSet.getInt("type");
                        User user = new User(id, name, surname, username, "", type);
                        dataList.add(user);
                    }
                    break;
                // etc
                default:
                    break;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return dataList;
    }

    public void updateData(Data data) {
        try {
            if (data instanceof Cemetery) {
                if (data.isValid()) {
                    preparedStatement = connect
                            .prepareStatement("update cemetery set name = ?, address = ? where id = ?");
                    preparedStatement.setString(1, ((Cemetery) data).getName());
                    preparedStatement.setString(2,
                            ((Cemetery) data).getAddress());
                    preparedStatement.setInt(3, ((Cemetery) data).getId());
                    preparedStatement.executeUpdate();

                    for (Data cemetery : getAll(CEMETERY)) {
                        if (((Cemetery) cemetery).getId() == ((Cemetery) data)
                                .getId()) {
                            ((Cemetery) cemetery).setName(((Cemetery) data)
                                    .getName());
                            ((Cemetery) cemetery).setAddress(((Cemetery) data)
                                    .getAddress());
                        }
                    }
                }
            } else if (data instanceof Request) {
                if (data.isValid()) {
                    preparedStatement = connect
                            .prepareStatement("update request set date = ?, infocet = ?, completed = ? where id = ?");
                    preparedStatement.setDate(1,
                            (Date) ((Request) data).getDate());
                    preparedStatement.setInt(2, ((Request) data).getInfocet());
                    preparedStatement.setBoolean(3,
                            ((Request) data).isCompleted());
                    preparedStatement.setInt(4, ((Request) data).getId());
                    preparedStatement.executeUpdate();

                    for (Data request : getAll(REQUEST)) {
                        if (((Request) request).getId() == ((Request) data)
                                .getId()) {
                            ((Request) request).setDate(((Request) data)
                                    .getDate());
                            ((Request) request).setInfocet(((Request) data)
                                    .getInfocet());
                            ((Request) request).setCompleted(((Request) data)
                                    .isCompleted());
                        }
                    }
                }
            } else if (data instanceof Grave) {
                if (data.isValid()) {
                    preparedStatement = connect
                            .prepareStatement("update grave set parcelId = ?, surface = ?, observationId = ?, type = " +
                                    "? where id = ?");
                    preparedStatement.setInt(1, ((Grave) data).getId());
                    preparedStatement.setInt(2, ((Grave) data).getParcelId());
                    preparedStatement.setInt(3, ((Grave) data).getSurface());
                    preparedStatement.setInt(4,
                            ((Grave) data).getObservationId());
                    preparedStatement.setInt(5, ((Grave) data).getIsMonument() ? 1 : 0);
                    preparedStatement.executeUpdate();

                    for (Data grave : getAll(GRAVE)) {
                        if (((Grave) grave).getId() == ((Grave) data).getId()) {
                            ((Grave) grave).setParcelId(((Grave) data)
                                    .getParcelId());
                            ((Grave) grave).setSurface(((Grave) data)
                                    .getSurface());
                            ((Grave) grave).setObservationId(((Grave) data)
                                    .getObservationId());
                            ((Grave) grave).setIsMonument(((Grave) data).getIsMonument());
                        }
                    }
                }
            } else if (data instanceof Deceased) {
                if (data.isValid()) {
                    preparedStatement = connect
                            .prepareStatement("update deceased set firstName = ?, lastName = ?, religion = ?, graveId" +
                                    " = ?, burialDate = ? where id = ?");
                    preparedStatement.setString(1,
                            ((Deceased) data).getFirstName());
                    preparedStatement.setString(2,
                            ((Deceased) data).getLastName());
                    preparedStatement.setString(3,
                            ((Deceased) data).getReligion());
                    preparedStatement.setInt(4, ((Deceased) data).getGrave());
                    preparedStatement.setDate(5,
                            (Date) ((Deceased) data).getBurialDate());
                    preparedStatement.setInt(6, ((Deceased) data).getId());
                    preparedStatement.executeUpdate();

                    for (Data deceased : getAll(DECEASED)) {
                        if (((Deceased) deceased).getId() == ((Deceased) data)
                                .getId()) {
                            ((Deceased) deceased)
                                    .setFirstName(((Deceased) data)
                                            .getFirstName());
                            ((Deceased) deceased).setLastName(((Deceased) data)
                                    .getLastName());
                            ((Deceased) deceased).setReligion(((Deceased) data)
                                    .getReligion());
                            ((Deceased) deceased).setGrave(((Deceased) data)
                                    .getGrave());
                            ((Deceased) deceased)
                                    .setBurialDate(((Deceased) data)
                                            .getBurialDate());
                        }
                    }
                }
            } else if (data instanceof Contract) {
                if (data.isValid()) {
                    preparedStatement = connect
                            .prepareStatement("update contract set ownerId = ?, graveId = ?, date = ?, receipt = ?, " +
                                    "period = ? where id = ?");
                    preparedStatement.setInt(1, ((Contract) data).getOwnerId());
                    preparedStatement.setInt(2, ((Contract) data).getGraveId());
                    preparedStatement.setDate(3,
                            (Date) ((Contract) data).getDate());
                    preparedStatement.setInt(4, ((Contract) data).getPeriod());
                    preparedStatement.setInt(5, ((Contract) data).getReceipt());
                    preparedStatement.setInt(6, ((Contract) data).getId());
                    preparedStatement.executeUpdate();

                    for (Data contract : getAll(CONTRACT)) {
                        if (((Contract) contract).getId() == ((Contract) data)
                                .getId()) {
                            ((Contract) contract).setOwnerId(((Contract) data)
                                    .getOwnerId());
                            ((Contract) contract).setGraveId(((Contract) data)
                                    .getGraveId());
                            ((Contract) contract).setDate(((Contract) data)
                                    .getDate());
                            ((Contract) contract).setPeriod(((Contract) data)
                                    .getPeriod());
                            ((Contract) contract).setReceipt(((Contract) data)
                                    .getReceipt());
                        }
                    }
                }
            } else if (data instanceof Complainer) {
                if (data.isValid()) {
                    preparedStatement = connect
                            .prepareStatement("update complainer set firstName = ?, lastName = ?, reason = ?");
                    preparedStatement.setString(1,
                            ((Complainer) data).getFirstName());
                    preparedStatement.setString(2,
                            ((Complainer) data).getLastName());
                    preparedStatement.setString(3,
                            ((Complainer) data).getReason());
                    preparedStatement.setInt(4, ((Complainer) data).getId());
                    preparedStatement.executeUpdate();

                    for (Data complainer : getAll(COMPLAINER)) {
                        if (((Complainer) complainer).getId() == ((Complainer) data)
                                .getId()) {
                            ((Complainer) complainer)
                                    .setFirstName(((Complainer) data)
                                            .getFirstName());
                            ((Complainer) complainer)
                                    .setLastName(((Complainer) data)
                                            .getLastName());
                            ((Complainer) complainer)
                                    .setReason(((Complainer) data).getReason());
                        }
                    }
                }
            } else if (data instanceof Observation) {
                if (data.isValid()) {
                    preparedStatement = connect
                            .prepareStatement("update observation set tomn = ?, modificationNr = ?, photography = ?");
                    preparedStatement.setBoolean(1,
                            ((Observation) data).isTomb());
                    preparedStatement.setInt(2,
                            ((Observation) data).getModificationNr());
                    preparedStatement.setString(3,
                            ((Observation) data).getPhotography());
                    preparedStatement.setInt(4, ((Observation) data).getId());
                    preparedStatement.executeUpdate();

                    for (Data observation : getAll(OBSERVATION)) {
                        if (((Observation) observation).getId() == ((Observation) data)
                                .getId()) {
                            ((Observation) observation)
                                    .setTomb(((Observation) data).isTomb());
                            ((Observation) observation)
                                    .setModificationNr(((Observation) data)
                                            .getModificationNr());
                            ((Observation) observation)
                                    .setPhotography(((Observation) data)
                                            .getPhotography());
                        }
                    }
                }
            } else if (data instanceof Parcel) {
                if (data.isValid()) {
                    preparedStatement = connect
                            .prepareStatement("update parcel set code = ?, cemeteryId = ? where id = ?");
                    preparedStatement.setString(1, ((Parcel) data).getCode());
                    preparedStatement
                            .setInt(2, ((Parcel) data).getCemeteryId());
                    preparedStatement.setInt(3, ((Parcel) data).getId());
                    preparedStatement.executeUpdate();

                    for (Data parcel : getAll(PARCEL)) {
                        if (((Parcel) parcel).getId() == ((Parcel) data)
                                .getId()) {
                            ((Parcel) parcel)
                                    .setCode(((Parcel) data).getCode());
                            ((Parcel) parcel).setCemeteryId(((Parcel) data)
                                    .getCemeteryId());
                        }
                    }
                }
            }
            if (data instanceof User) {
                if (data.isValid()) {
                    preparedStatement = connect
                            .prepareStatement("update user set firstName = ?, lastName = ?, username = ?, type = ?  " +
                                    "where id = ?");
                    preparedStatement.setString(1, ((User) data).getFirstName());
                    preparedStatement.setString(2, ((User) data).getLastName());
                    preparedStatement.setString(3, ((User) data).getUsername());
                    preparedStatement.setInt(4, Integer.parseInt(((User) data).getType()));
                    preparedStatement.executeUpdate();
                }
            }

            // else if (){...} ... treating every data type the same way

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void deleteData(Data data) {
        try {
            if (data instanceof Cemetery) {
                if (getDataById(((Cemetery) data).getId(), CEMETERY) != null) {
                    preparedStatement = connect
                            .prepareStatement("delete from cemetery where id = ?");
                    preparedStatement.setInt(1, ((Cemetery) data).getId());
                    preparedStatement.executeUpdate();
                }
            } else if (data instanceof Request) {
                if (getDataById(((Request) data).getId(), REQUEST) != null) {
                    preparedStatement = connect
                            .prepareStatement("delete from request where id = ?");
                    preparedStatement.setInt(1, ((Request) data).getId());
                    preparedStatement.executeUpdate();
                }
            } else if (data instanceof Grave) {
                if (getDataById(((Grave) data).getId(), GRAVE) != null) {
                    preparedStatement = connect
                            .prepareStatement("delete from grave where id = ?");
                    preparedStatement.setInt(1, ((Grave) data).getId());
                    preparedStatement.executeUpdate();
                }

            } else if (data instanceof Deceased) {
                if (getDataById(((Deceased) data).getId(), DECEASED) != null) {
                    preparedStatement = connect
                            .prepareStatement("delete from deceased where id = ?");
                    preparedStatement.setInt(1, ((Deceased) data).getId());
                    preparedStatement.executeUpdate();
                }
            } else if (data instanceof Contract) {
                if (getDataById(((Contract) data).getId(), CONTRACT) != null) {
                    preparedStatement = connect
                            .prepareStatement("delete from contract where id = ?");
                    preparedStatement.setInt(1, ((Contract) data).getId());
                    preparedStatement.executeUpdate();

                }
            } else if (data instanceof Complainer) {
                if (getDataById(((Complainer) data).getId(), COMPLAINER) != null) {
                    preparedStatement = connect
                            .prepareStatement("delete from complainer where id = ?");
                    preparedStatement.setInt(1, ((Complainer) data).getId());
                    preparedStatement.executeUpdate();
                }
            } else if (data instanceof Observation) {
                if (getDataById(((Observation) data).getId(), OBSERVATION) != null) {
                    preparedStatement = connect
                            .prepareStatement("delete from observation where id = ?");
                    preparedStatement.setInt(1, ((Observation) data).getId());
                    preparedStatement.executeUpdate();
                }
            } else if (data instanceof Parcel) {
                if (getDataById(((Parcel) data).getId(), PARCEL) != null) {
                    preparedStatement = connect
                            .prepareStatement("delete from parcel where id = ?");
                    preparedStatement.setInt(1, ((Parcel) data).getId());
                    preparedStatement.executeUpdate();
                }
            } else if (data instanceof User) {
                if (getDataById(((User) data).getId(), USER) != null) {
                    preparedStatement = connect
                            .prepareStatement("delete from user where id = ?");
                    preparedStatement.setInt(1, ((User) data).getId());
                    preparedStatement.executeUpdate();
                }
            }

            // else if (){...} ... treating every data type the same way

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public Deceased getDeceasedById(int id) {
        try {
            resultSet = statement
                    .executeQuery("select * from deceased where graveId = "
                            + id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            while (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String religion = resultSet.getString("religion");
                int graveId = resultSet.getInt("graveId");
                Date burialDate = resultSet.getDate("burialDate");
                return new Deceased(id, firstName, lastName, religion, graveId,
                        burialDate);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Data> getDeceasedByYear(int year) {
        ArrayList<Data> dataList = new ArrayList<Data>();
        try {
            resultSet = statement
                    .executeQuery("select * from deceased where YEAR(burialDate) = "
                            + year);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String religion = resultSet.getString("religion");
                int graveId = resultSet.getInt("graveId");
                Date burialDate = resultSet.getDate("burialDate");
                Deceased newDeceased = new Deceased(id, firstName, lastName,
                        religion, graveId, burialDate);
                dataList.add(newDeceased);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dataList;
    }

    public ArrayList<Data> getContractsByYear(int year) {
        ArrayList<Data> dataList = new ArrayList<Data>();
        try {
            resultSet = statement.executeQuery("select * from contract where YEAR(date) =" + year);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int ownerId = resultSet.getInt("ownerId");
                int graveId = resultSet.getInt("graveId");
                Date date = resultSet.getDate("date");
                int period = resultSet.getInt("period");
                int receipt = resultSet.getInt("receipt");
                Contract newContract = new Contract(id, ownerId, graveId, date,
                        period, receipt);
                dataList.add(newContract);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dataList;
    }

    public ArrayList<Data> getExpiringGraves(int year) {
        ArrayList<Data> dataList = new ArrayList<Data>();
        try {
            resultSet = statement.executeQuery("select g.id, g.parcelId, g.surface, g.observationId, g.type from " +
                    "grave G join contract C on G.id=C.graveId where year(c.date)+c.period=" + year);
            while (resultSet.next()) {
                int graveId = resultSet.getInt("id");
                int parcelId = resultSet.getInt("parcelId");
                int surface = resultSet.getInt("surface");
                int observationId = resultSet.getInt("observationId");
                boolean type = resultSet.getBoolean("type");
                Grave newGrave = new Grave(graveId, parcelId, surface,
                        observationId, type);
                dataList.add(newGrave);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dataList;
    }

    public Data getContractByGrave(int grave2) {
        Data data = null;
        try {
            resultSet = statement.executeQuery("select * from contract where graveId = " + grave2);
            while (resultSet.next()) {
                int ownerId = resultSet.getInt("ownerId");
                int id = resultSet.getInt("id");
                Date date = resultSet.getDate("date");
                int period = resultSet.getInt("period");
                int receipt = resultSet.getInt("receipt");
                data = new Contract(id, ownerId, grave2, date, period,
                        receipt);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return data;
    }


    public ArrayList<Data> getPaidGraves() {
        ArrayList<Data> dataList = new ArrayList<Data>();
        try {
            resultSet = statement.executeQuery("select g.id, g.parcelId, g.surface, g.observationId, g.type from " +
                    "grave G join contract C on G.id=C.graveId where year(c.date)+c.period>" + 2014);
            while (resultSet.next()) {
                int graveId = resultSet.getInt("id");
                int parcelId = resultSet.getInt("parcelId");
                int surface = resultSet.getInt("surface");
                int observationId = resultSet.getInt("observationId");
                boolean type = resultSet.getBoolean("type");
                Grave newGrave = new Grave(graveId, parcelId, surface,
                        observationId, type);
                dataList.add(newGrave);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dataList;
    }

    public int logIn(String user, String password) {
        int type = -1;
        try {
            resultSet = statement.executeQuery("select type from user where username='" + user + "' and password='" +
                    password + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (resultSet.next()) {
                type = resultSet.getInt("type");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }
}
