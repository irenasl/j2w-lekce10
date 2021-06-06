package cz.czechitas.java2webapps.lekce10.service;

import cz.czechitas.java2webapps.lekce10.entity.Trida;
import cz.czechitas.java2webapps.lekce10.repository.TridaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TridaService {

    private final TridaRepository tridaRepository;

    @Autowired
    public TridaService(TridaRepository tridaRepository) {
        this.tridaRepository = tridaRepository;
    }

    public Page<Trida> seznamTrid(Pageable pageable) {
        return tridaRepository.findAll(pageable);
    }

    public Optional<Trida> tridaById(short id) {
        return tridaRepository.findById(id);
    }

}
