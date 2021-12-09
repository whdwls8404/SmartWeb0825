package com.koreait.ex12.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.ex12.domain.Gallery;
import com.koreait.ex12.repository.GalleryRepository;

public class GalleryServiceImpl implements GalleryService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<Gallery> selectGalleryList() {
		GalleryRepository repository = sqlSession.getMapper(GalleryRepository.class);
		return repository.selectGalleryList();
	}

	@Override
	public Gallery selectGalleryByNo(Long no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertGallery(Gallery gallery) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateGallery(Gallery gallery) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteGallery(Long no) {
		// TODO Auto-generated method stub
		return 0;
	}

}
