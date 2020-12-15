package com.yxy.market1.mapper;

import com.yxy.market1.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteMapper extends JpaRepository<Favorite, Integer> {

}
