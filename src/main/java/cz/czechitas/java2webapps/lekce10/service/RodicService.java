package cz.czechitas.java2webapps.lekce10.service;

import cz.czechitas.java2webapps.lekce10.entity.Rodic;
import cz.czechitas.java2webapps.lekce10.repository.RodicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RodicService {

    private final RodicRepository rodicRepository;

    @Autowired
    public RodicService(RodicRepository rodicRepository) {
        this.rodicRepository = rodicRepository;
    }

    public Page<Rodic> seznamRodicuByStudentId(int id, Pageable pageable) {
        return rodicRepository.findByDetiIdOrderByPrijmeni(id, pageable);
    }

 //   service:
   // public Page<Rodic> seznamRodicuStudenta(Integer id, Pageable pageable) {
     //   return rodicRepository.findByDetiIdOrderByPrijmeni(id,Pageable.unpaged());
 //   }

 //   repo:
 //   Page<Rodic> findByDetiIdOrderByPrijmeni(Integer id, Pageable pageable);


}
