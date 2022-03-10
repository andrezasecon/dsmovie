package com.andrezasecon.dsmovie.services;

import com.andrezasecon.dsmovie.dto.MovieDTO;
import com.andrezasecon.dsmovie.dto.ScoreDTO;
import com.andrezasecon.dsmovie.entities.Movie;
import com.andrezasecon.dsmovie.entities.Score;
import com.andrezasecon.dsmovie.entities.User;
import com.andrezasecon.dsmovie.repositories.MovieRepository;
import com.andrezasecon.dsmovie.repositories.ScoreRepository;
import com.andrezasecon.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movierepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO dto){

        User user = userRepository.findByEmail(dto.getEmail());

        if (user == null){
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movierepository.findById(dto.getMovieId()).get();
        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());
        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for (Score s : movie.getScores()){
            sum = sum + s.getValue();
        }

        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movierepository.save(movie);

        return new MovieDTO(movie);
    }
}
