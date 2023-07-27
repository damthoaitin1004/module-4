package com.example.music.service;

import com.example.music.model.Music;
import com.example.music.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository iMusicRepository;

    @Override
    public List<Music> findAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public void add(Music music) {
        iMusicRepository.save(music);
    }

    @Override
    public Music findById(int id) {
        return iMusicRepository.findById(id).get();
    }
}
