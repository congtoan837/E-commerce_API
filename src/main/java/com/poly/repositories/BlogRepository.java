package com.poly.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poly.model.BlogDTO;
import com.poly.model.Blog;

@Repository
public interface BlogRepository extends CrudRepository<Blog, Integer> {

	@Query("select NEW com.poly.model.BlogDTO(b.Id, u.Id, u.Username, b.Title, b.Image, b.Content, b.Description) "
			+ "from Blog as b inner join com.poly.model.Users as u"
			+ " on b.CreateBy = u.Id")
	public List<BlogDTO> innerjoin();
}
