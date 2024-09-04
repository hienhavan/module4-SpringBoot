package org.example.springboot.services.minitest;

import org.example.springboot.model.dto.ProvinceDTO;
import org.example.springboot.model.minitest.Province;
import org.example.springboot.repository.mititest.MinitestProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiniTestProvinceService {
    @Autowired
    private MinitestProvinceRepository provinceRepository;
    public List<Province> provinceDTOs(){
        return provinceRepository.findAll();
    }
    public Province findById(int id){
        return provinceRepository.findById(id).orElse(null);
    }
    public void removeById(int id){
        provinceRepository.deleteProvinceById(id);
    }
    public List<ProvinceDTO> listProvinceDTOs(){
        return provinceRepository.getTourProvinceNumber();
    }
}