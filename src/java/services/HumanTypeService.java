package services;

import dao.HumanTypeDao;
import entities.HumanType;
import java.util.List;

public class HumanTypeService {

    private final HumanTypeDao humanTypeDao = new HumanTypeDao();

    public List<HumanType> all() {
        return humanTypeDao.all();
    }

    public HumanType getHumanTypeById(List<HumanType> humanTypes, int typeid) {
        for (HumanType humanType : humanTypes) {
            if (humanType.getTypeid() == typeid) {
                return humanType;
            }
        }
        return null;
    }
}
