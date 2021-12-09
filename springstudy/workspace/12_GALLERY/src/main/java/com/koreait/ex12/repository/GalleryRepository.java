package com.koreait.ex12.repository;

import java.util.List;

import com.koreait.ex12.domain.Gallery;

// GalleryRepository는 gallery.xml과 직결됨.
// 메소드명 = 태그id
// 반환타입 = resultType
// 매개변수 = parameterType

public interface GalleryRepository {
	public List<Gallery> selectGalleryList();
	public Gallery selectGalleryByNo(Long no);
	public int insertGallery(Gallery gallery);
	public int updateGallery(Gallery gallery);
	public int deleteGallery(Long no);
}
