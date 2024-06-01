package services;

import dao.HumanDao;
import entities.Human;
import entities.HumanType;
import java.util.List;
import java.sql.*;

public class HumanService {

    private final HumanDao humanDao = new HumanDao();

    private final HumanTypeService humanTypeService = new HumanTypeService();

    public List<Human> all() {
        List<Human> humans = humanDao.all();
        List<HumanType> humanTypes = humanTypeService.all();

        for (int i = 0; i < humans.size(); i++) {
            String typeName = humanTypeService.getHumanTypeById(
                    humanTypes,
                    humans.get(i).getTypeid()
            ).getTypename();

            humans.get(i).setTypename(typeName);
        }

        return humans;
    }

    public Human find(int id) {
        return humanDao.find(id);
    }

    public void createHuman(String humanname, String humandob, boolean humangender, int typeid) {
        Date dob = Date.valueOf(humandob);

        Human human = new Human(humanname, dob, humangender, typeid);
        
        humanDao.createHuman(human);
    }

    public void updateHuman(int humanid, String humanname, String humandob, boolean humangender, int typeid) {
        Date dob = Date.valueOf(humandob);

        Human human = new Human(humanid, humanname, dob, humangender, typeid);

        humanDao.updateHuman(human);
    }
}
