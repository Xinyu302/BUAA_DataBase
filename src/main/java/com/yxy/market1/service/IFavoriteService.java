package com.yxy.market1.service;

import com.yxy.market1.entity.Favorite;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IFavoriteService {
    void createFavorite(Favorite favorite);

    Favorite findFavoriteByUserIdAndProductId(Integer userId, Integer productId);

    List<Integer> findProductIdByUserId(Integer userId);

    void deleteAllProductsByUserId(Integer userId);
}
