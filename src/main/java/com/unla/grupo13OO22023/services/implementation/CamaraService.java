package com.unla.grupo13OO22023.services.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo13OO22023.entities.CamaraAula;
import com.unla.grupo13OO22023.entities.Dispositivo;
import com.unla.grupo13OO22023.models.CamaraModel;
import com.unla.grupo13OO22023.repositories.ICamaraRepository;
import com.unla.grupo13OO22023.services.ICamaraService;

@Service("camaraService")
public class CamaraService implements ICamaraService {
	@Autowired
	@Qualifier("dispositivoRepository")
	private ICamaraRepository camaraRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public List<CamaraAula> getAll() {
		return camaraRepository.findAll();
	}

	@Override
	public CamaraModel insertOrUpdate(CamaraAula camara) {
		CamaraAula camaraNew = camaraRepository.save(camara);
		return modelMapper.map(camaraNew, CamaraModel.class);
	}
	
	@Override
	public boolean remove(int id) {
		try {
			camaraRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
