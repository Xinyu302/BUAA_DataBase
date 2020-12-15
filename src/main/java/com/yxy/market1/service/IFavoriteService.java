package com.yxy.market1.service;

import com.yxy.market1.entity.Favorite;
import org.springframework.stereotype.Service;

@Service
public interface IFavoriteService {
    void createFavorite(Favorite favorite);
}
