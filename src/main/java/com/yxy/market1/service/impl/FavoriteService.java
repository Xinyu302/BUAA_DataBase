package com.yxy.market1.service.impl;

import com.yxy.market1.entity.Favorite;
import com.yxy.market1.mapper.FavoriteMapper;
import com.yxy.market1.service.IFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;

public class FavoriteService implements IFavoriteService {
    @Autowired
    private FavoriteMapper fMapper;

    @Override
    public void createFavorite(Favorite favorite) {
        fMapper.save(favorite);
    }
}
