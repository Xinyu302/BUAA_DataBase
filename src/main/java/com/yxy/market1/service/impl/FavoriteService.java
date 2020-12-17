package com.yxy.market1.service.impl;

import com.yxy.market1.entity.Favorite;
import com.yxy.market1.mapper.FavoriteMapper;
import com.yxy.market1.service.IFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FavoriteService implements IFavoriteService {
    @Autowired
    private FavoriteMapper fMapper;

    @Override
    public void createFavorite(Favorite favorite) {
        fMapper.save(favorite);
    }

    @Override
    public Favorite findFavoriteByUserIdAndProductId(Integer userId, Integer productId) {
        List<Favorite> list = fMapper.findFavoriteByUserIdAndProductId(userId, productId);
        if (list == null || list.size() != 1) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Integer> findProductIdByUserId(Integer userId) {
        return fMapper.findProductIdByUserId(userId);
    }

    @Override
    public void deleteAllProductsByUserId(Integer userId) {
        fMapper.deleteAllProductsByUserId(userId);
    }
}
