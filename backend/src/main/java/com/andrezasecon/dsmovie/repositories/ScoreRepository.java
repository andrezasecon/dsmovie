package com.andrezasecon.dsmovie.repositories;

import com.andrezasecon.dsmovie.entities.Score;
import com.andrezasecon.dsmovie.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}
