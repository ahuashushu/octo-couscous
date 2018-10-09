package org.product.service;

import org.product.dao.TypesDao;
import org.product.domain.Types;
import org.product.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TypesServiceimpl implements TypesService {
    @Autowired
    private TypesDao typesDao;


    @Override
    public Types selectfindAll() {
        return typesDao.selectfindAll();
    }

    @Override
    public long selectNameid(String name) {
        return typesDao.selectNameid(name);
    }
    @Override
    public List<String> selectSeName(long id) {
        return typesDao.selectSeName(id);
    }

    @Override
    public List selectName() {
        return typesDao.selectName();
    }

    @Override
    public long [] selectSeid(long id) {
        return typesDao.selectSeid(id);
    }
}
