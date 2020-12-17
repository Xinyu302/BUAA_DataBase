package com.yxy.market1.service;

import com.yxy.market1.entity.Favorite;
import org.springframework.stereotype.Service;


public interface IFavoriteService {
    void createFavorite(Favorite favorite);

    Favorite findFavoriteByUserIdAndProductId(Integer userId, Integer productId);
}
